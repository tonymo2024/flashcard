package com.flashcardkids.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flashcardkids.data.local.entity.ProgressEntity
import com.flashcardkids.data.repository.CardRepository
import com.flashcardkids.data.repository.DeckRepository
import com.flashcardkids.data.repository.ProgressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DeckProgress(
    val deckName: String,
    val totalCards: Int,
    val masteredCards: Int,
    val percentage: Float
)

@HiltViewModel
class ProgressViewModel @Inject constructor(
    private val progressRepository: ProgressRepository,
    private val deckRepository: DeckRepository,
    private val cardRepository: CardRepository
) : ViewModel() {

    private val _deckProgressList = MutableStateFlow<List<DeckProgress>>(emptyList())
    val deckProgressList: StateFlow<List<DeckProgress>> = _deckProgressList.asStateFlow()

    private val _totalMastered = MutableStateFlow(0)
    val totalMastered: StateFlow<Int> = _totalMastered.asStateFlow()

    init {
        loadProgress()
    }

    fun loadProgress() {
        viewModelScope.launch {
            val decks = deckRepository.getAllDecks().first()
            val progressList = mutableListOf<DeckProgress>()

            for (deck in decks) {
                val totalCards = cardRepository.getCardCountByDeckId(deck.id)
                val deckProgressEntities = progressRepository.getProgressByDeckId(deck.id).first()
                val masteredCards = deckProgressEntities.count { it.mastered }

                progressList.add(
                    DeckProgress(
                        deckName = deck.name,
                        totalCards = totalCards,
                        masteredCards = masteredCards,
                        percentage = if (totalCards > 0) (masteredCards.toFloat() / totalCards) * 100 else 0f
                    )
                )
            }

            _deckProgressList.value = progressList
            _totalMastered.value = progressRepository.getMasteredCount()
        }
    }
}
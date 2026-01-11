package com.flashcardkids.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flashcardkids.data.local.entity.DeckEntity
import com.flashcardkids.data.repository.CardRepository
import com.flashcardkids.data.repository.DeckRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DeckWithCount(
    val deck: DeckEntity,
    val cardCount: Int
)

@HiltViewModel
class DeckViewModel @Inject constructor(
    private val deckRepository: DeckRepository,
    private val cardRepository: CardRepository
) : ViewModel() {

    private val _decks = MutableStateFlow<List<DeckWithCount>>(emptyList())
    val decks: StateFlow<List<DeckWithCount>> = _decks.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadDecks()
    }

    fun loadDecks() {
        viewModelScope.launch {
            _isLoading.value = true
            deckRepository.getAllDecks().collect { deckList ->
                val decksWithCount = deckList.map { deck ->
                    DeckWithCount(
                        deck = deck,
                        cardCount = cardRepository.getCardCountByDeckId(deck.id)
                    )
                }
                _decks.value = decksWithCount
                _isLoading.value = false
            }
        }
    }

    fun addDeck(name: String, description: String?) {
        viewModelScope.launch {
            val deck = DeckEntity(
                name = name,
                description = description
            )
            deckRepository.insertDeck(deck)
        }
    }

    fun deleteDeck(deck: DeckEntity) {
        viewModelScope.launch {
            deckRepository.deleteDeck(deck)
        }
    }

    suspend fun getDeckById(deckId: Long): DeckEntity? {
        return deckRepository.getDeckById(deckId)
    }
}
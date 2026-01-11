package com.flashcardkids.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flashcardkids.data.local.entity.CardEntity
import com.flashcardkids.data.repository.CardRepository
import com.flashcardkids.data.repository.ProgressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val cardRepository: CardRepository,
    private val progressRepository: ProgressRepository
) : ViewModel() {

    private val _cards = MutableStateFlow<List<CardEntity>>(emptyList())
    val cards: StateFlow<List<CardEntity>> = _cards.asStateFlow()

    private val _currentDeckId = MutableStateFlow<Long?>(null)
    val currentDeckId: StateFlow<Long?> = _currentDeckId.asStateFlow()

    fun loadCards(deckId: Long) {
        _currentDeckId.value = deckId
        viewModelScope.launch {
            cardRepository.getCardsByDeckId(deckId).collect { cardList ->
                _cards.value = cardList
            }
        }
    }

    fun addCard(word: String, imageUri: String?, deckId: Long) {
        viewModelScope.launch {
            val card = CardEntity(
                word = word,
                imageUri = imageUri,
                deckId = deckId
            )
            cardRepository.insertCard(card)
        }
    }

    fun updateCard(card: CardEntity) {
        viewModelScope.launch {
            cardRepository.updateCard(card)
        }
    }

    fun deleteCard(card: CardEntity) {
        viewModelScope.launch {
            cardRepository.deleteCard(card)
        }
    }

    fun recordAnswer(cardId: Long, isCorrect: Boolean) {
        viewModelScope.launch {
            progressRepository.recordAnswer(cardId, isCorrect)
        }
    }
}
package com.flashcardkids.data.repository

import com.flashcardkids.data.local.dao.DeckDao
import com.flashcardkids.data.local.entity.DeckEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeckRepository @Inject constructor(private val deckDao: DeckDao) {

    fun getAllDecks(): Flow<List<DeckEntity>> = deckDao.getAllDecks()

    suspend fun getDeckById(deckId: Long): DeckEntity? = deckDao.getDeckById(deckId)

    suspend fun insertDeck(deck: DeckEntity): Long = deckDao.insertDeck(deck)

    suspend fun updateDeck(deck: DeckEntity) = deckDao.updateDeck(deck)

    suspend fun deleteDeck(deck: DeckEntity) = deckDao.deleteDeck(deck)

    suspend fun getDefaultDeck(): DeckEntity? = deckDao.getDefaultDeck()
}
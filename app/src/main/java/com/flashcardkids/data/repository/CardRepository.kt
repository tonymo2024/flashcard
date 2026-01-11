package com.flashcardkids.data.repository

import com.flashcardkids.data.local.dao.CardDao
import com.flashcardkids.data.local.entity.CardEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepository @Inject constructor(private val cardDao: CardDao) {

    fun getAllCards(): Flow<List<CardEntity>> = cardDao.getAllCards()

    fun getCardsByDeckId(deckId: Long): Flow<List<CardEntity>> = cardDao.getCardsByDeckId(deckId)

    suspend fun getCardById(cardId: Long): CardEntity? = cardDao.getCardById(cardId)

    suspend fun insertCard(card: CardEntity): Long = cardDao.insertCard(card)

    suspend fun updateCard(card: CardEntity) = cardDao.updateCard(card)

    suspend fun deleteCard(card: CardEntity) = cardDao.deleteCard(card)

    suspend fun getCardCountByDeckId(deckId: Long): Int = cardDao.getCardCountByDeckId(deckId)
}
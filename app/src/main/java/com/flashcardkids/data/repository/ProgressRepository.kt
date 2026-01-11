package com.flashcardkids.data.repository

import com.flashcardkids.data.local.dao.ProgressDao
import com.flashcardkids.data.local.entity.ProgressEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProgressRepository @Inject constructor(private val progressDao: ProgressDao) {

    fun getAllProgress(): Flow<List<ProgressEntity>> = progressDao.getAllProgress()

    fun getProgressByDeckId(deckId: Long): Flow<List<ProgressEntity>> = 
        progressDao.getProgressByDeckId(deckId)

    suspend fun getProgressByCardId(cardId: Long): ProgressEntity? = 
        progressDao.getProgressByCardId(cardId)

    suspend fun insertProgress(progress: ProgressEntity): Long = 
        progressDao.insertProgress(progress)

    suspend fun updateProgress(progress: ProgressEntity) = 
        progressDao.updateProgress(progress)

    suspend fun recordAnswer(cardId: Long, isCorrect: Boolean) {
        val existing = progressDao.getProgressByCardId(cardId)
        if (existing != null) {
            val updated = existing.copy(
                correctCount = if (isCorrect) existing.correctCount + 1 else existing.correctCount,
                incorrectCount = if (!isCorrect) existing.incorrectCount + 1 else existing.incorrectCount,
                lastStudied = System.currentTimeMillis(),
                mastered = isCorrect && existing.correctCount >= 2
            )
            progressDao.updateProgress(updated)
        } else {
            progressDao.insertProgress(
                ProgressEntity(
                    cardId = cardId,
                    correctCount = if (isCorrect) 1 else 0,
                    incorrectCount = if (!isCorrect) 1 else 0
                )
            )
        }
    }

    suspend fun getMasteredCount(): Int = progressDao.getMasteredCount()
}
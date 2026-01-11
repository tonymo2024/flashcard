package com.flashcardkids.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.flashcardkids.data.local.entity.ProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgress(progress: ProgressEntity): Long

    @Update
    suspend fun updateProgress(progress: ProgressEntity)

    @Query("SELECT * FROM progress WHERE cardId = :cardId")
    suspend fun getProgressByCardId(cardId: Long): ProgressEntity?

    @Query("SELECT * FROM progress")
    fun getAllProgress(): Flow<List<ProgressEntity>>

    @Query("""
        SELECT p.* FROM progress p 
        INNER JOIN cards c ON p.cardId = c.id 
        WHERE c.deckId = :deckId
    """)
    fun getProgressByDeckId(deckId: Long): Flow<List<ProgressEntity>>

    @Query("DELETE FROM progress WHERE cardId = :cardId")
    suspend fun deleteProgressByCardId(cardId: Long)

    @Query("SELECT COUNT(*) FROM progress WHERE mastered = 1")
    suspend fun getMasteredCount(): Int
}
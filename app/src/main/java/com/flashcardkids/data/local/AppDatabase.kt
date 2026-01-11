package com.flashcardkids.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flashcardkids.data.local.dao.CardDao
import com.flashcardkids.data.local.dao.DeckDao
import com.flashcardkids.data.local.dao.ProgressDao
import com.flashcardkids.data.local.entity.CardEntity
import com.flashcardkids.data.local.entity.DeckEntity
import com.flashcardkids.data.local.entity.ProgressEntity

@Database(
    entities = [CardEntity::class, DeckEntity::class, ProgressEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun deckDao(): DeckDao
    abstract fun progressDao(): ProgressDao
}
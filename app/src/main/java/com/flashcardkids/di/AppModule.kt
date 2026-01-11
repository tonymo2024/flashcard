package com.flashcardkids.di

import android.content.Context
import androidx.room.Room
import com.flashcardkids.data.local.AppDatabase
import com.flashcardkids.data.local.dao.CardDao
import com.flashcardkids.data.local.dao.DeckDao
import com.flashcardkids.data.local.dao.ProgressDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "flashcard_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCardDao(database: AppDatabase): CardDao = database.cardDao()

    @Provides
    @Singleton
    fun provideDeckDao(database: AppDatabase): DeckDao = database.deckDao()

    @Provides
    @Singleton
    fun provideProgressDao(database: AppDatabase): ProgressDao = database.progressDao()
}
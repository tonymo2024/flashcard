package com.flashcardkids.di;

import com.flashcardkids.data.local.AppDatabase;
import com.flashcardkids.data.local.dao.CardDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideCardDaoFactory implements Factory<CardDao> {
  private final Provider<AppDatabase> databaseProvider;

  public AppModule_ProvideCardDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public CardDao get() {
    return provideCardDao(databaseProvider.get());
  }

  public static AppModule_ProvideCardDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new AppModule_ProvideCardDaoFactory(databaseProvider);
  }

  public static CardDao provideCardDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCardDao(database));
  }
}

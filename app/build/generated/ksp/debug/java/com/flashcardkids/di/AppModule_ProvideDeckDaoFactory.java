package com.flashcardkids.di;

import com.flashcardkids.data.local.AppDatabase;
import com.flashcardkids.data.local.dao.DeckDao;
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
public final class AppModule_ProvideDeckDaoFactory implements Factory<DeckDao> {
  private final Provider<AppDatabase> databaseProvider;

  public AppModule_ProvideDeckDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public DeckDao get() {
    return provideDeckDao(databaseProvider.get());
  }

  public static AppModule_ProvideDeckDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new AppModule_ProvideDeckDaoFactory(databaseProvider);
  }

  public static DeckDao provideDeckDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDeckDao(database));
  }
}

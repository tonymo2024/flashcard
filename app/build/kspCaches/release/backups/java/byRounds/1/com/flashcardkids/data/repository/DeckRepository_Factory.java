package com.flashcardkids.data.repository;

import com.flashcardkids.data.local.dao.DeckDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DeckRepository_Factory implements Factory<DeckRepository> {
  private final Provider<DeckDao> deckDaoProvider;

  public DeckRepository_Factory(Provider<DeckDao> deckDaoProvider) {
    this.deckDaoProvider = deckDaoProvider;
  }

  @Override
  public DeckRepository get() {
    return newInstance(deckDaoProvider.get());
  }

  public static DeckRepository_Factory create(Provider<DeckDao> deckDaoProvider) {
    return new DeckRepository_Factory(deckDaoProvider);
  }

  public static DeckRepository newInstance(DeckDao deckDao) {
    return new DeckRepository(deckDao);
  }
}

package com.flashcardkids.viewmodel;

import com.flashcardkids.data.repository.CardRepository;
import com.flashcardkids.data.repository.DeckRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class DeckViewModel_Factory implements Factory<DeckViewModel> {
  private final Provider<DeckRepository> deckRepositoryProvider;

  private final Provider<CardRepository> cardRepositoryProvider;

  public DeckViewModel_Factory(Provider<DeckRepository> deckRepositoryProvider,
      Provider<CardRepository> cardRepositoryProvider) {
    this.deckRepositoryProvider = deckRepositoryProvider;
    this.cardRepositoryProvider = cardRepositoryProvider;
  }

  @Override
  public DeckViewModel get() {
    return newInstance(deckRepositoryProvider.get(), cardRepositoryProvider.get());
  }

  public static DeckViewModel_Factory create(Provider<DeckRepository> deckRepositoryProvider,
      Provider<CardRepository> cardRepositoryProvider) {
    return new DeckViewModel_Factory(deckRepositoryProvider, cardRepositoryProvider);
  }

  public static DeckViewModel newInstance(DeckRepository deckRepository,
      CardRepository cardRepository) {
    return new DeckViewModel(deckRepository, cardRepository);
  }
}

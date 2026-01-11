package com.flashcardkids.viewmodel;

import com.flashcardkids.data.repository.CardRepository;
import com.flashcardkids.data.repository.DeckRepository;
import com.flashcardkids.data.repository.ProgressRepository;
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
public final class ProgressViewModel_Factory implements Factory<ProgressViewModel> {
  private final Provider<ProgressRepository> progressRepositoryProvider;

  private final Provider<DeckRepository> deckRepositoryProvider;

  private final Provider<CardRepository> cardRepositoryProvider;

  public ProgressViewModel_Factory(Provider<ProgressRepository> progressRepositoryProvider,
      Provider<DeckRepository> deckRepositoryProvider,
      Provider<CardRepository> cardRepositoryProvider) {
    this.progressRepositoryProvider = progressRepositoryProvider;
    this.deckRepositoryProvider = deckRepositoryProvider;
    this.cardRepositoryProvider = cardRepositoryProvider;
  }

  @Override
  public ProgressViewModel get() {
    return newInstance(progressRepositoryProvider.get(), deckRepositoryProvider.get(), cardRepositoryProvider.get());
  }

  public static ProgressViewModel_Factory create(
      Provider<ProgressRepository> progressRepositoryProvider,
      Provider<DeckRepository> deckRepositoryProvider,
      Provider<CardRepository> cardRepositoryProvider) {
    return new ProgressViewModel_Factory(progressRepositoryProvider, deckRepositoryProvider, cardRepositoryProvider);
  }

  public static ProgressViewModel newInstance(ProgressRepository progressRepository,
      DeckRepository deckRepository, CardRepository cardRepository) {
    return new ProgressViewModel(progressRepository, deckRepository, cardRepository);
  }
}

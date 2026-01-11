package com.flashcardkids.viewmodel;

import com.flashcardkids.data.repository.CardRepository;
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
public final class CardViewModel_Factory implements Factory<CardViewModel> {
  private final Provider<CardRepository> cardRepositoryProvider;

  private final Provider<ProgressRepository> progressRepositoryProvider;

  public CardViewModel_Factory(Provider<CardRepository> cardRepositoryProvider,
      Provider<ProgressRepository> progressRepositoryProvider) {
    this.cardRepositoryProvider = cardRepositoryProvider;
    this.progressRepositoryProvider = progressRepositoryProvider;
  }

  @Override
  public CardViewModel get() {
    return newInstance(cardRepositoryProvider.get(), progressRepositoryProvider.get());
  }

  public static CardViewModel_Factory create(Provider<CardRepository> cardRepositoryProvider,
      Provider<ProgressRepository> progressRepositoryProvider) {
    return new CardViewModel_Factory(cardRepositoryProvider, progressRepositoryProvider);
  }

  public static CardViewModel newInstance(CardRepository cardRepository,
      ProgressRepository progressRepository) {
    return new CardViewModel(cardRepository, progressRepository);
  }
}

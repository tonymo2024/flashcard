package com.flashcardkids.data.repository;

import com.flashcardkids.data.local.dao.ProgressDao;
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
public final class ProgressRepository_Factory implements Factory<ProgressRepository> {
  private final Provider<ProgressDao> progressDaoProvider;

  public ProgressRepository_Factory(Provider<ProgressDao> progressDaoProvider) {
    this.progressDaoProvider = progressDaoProvider;
  }

  @Override
  public ProgressRepository get() {
    return newInstance(progressDaoProvider.get());
  }

  public static ProgressRepository_Factory create(Provider<ProgressDao> progressDaoProvider) {
    return new ProgressRepository_Factory(progressDaoProvider);
  }

  public static ProgressRepository newInstance(ProgressDao progressDao) {
    return new ProgressRepository(progressDao);
  }
}

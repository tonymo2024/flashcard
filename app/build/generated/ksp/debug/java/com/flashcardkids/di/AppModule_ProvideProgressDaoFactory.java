package com.flashcardkids.di;

import com.flashcardkids.data.local.AppDatabase;
import com.flashcardkids.data.local.dao.ProgressDao;
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
public final class AppModule_ProvideProgressDaoFactory implements Factory<ProgressDao> {
  private final Provider<AppDatabase> databaseProvider;

  public AppModule_ProvideProgressDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ProgressDao get() {
    return provideProgressDao(databaseProvider.get());
  }

  public static AppModule_ProvideProgressDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new AppModule_ProvideProgressDaoFactory(databaseProvider);
  }

  public static ProgressDao provideProgressDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideProgressDao(database));
  }
}

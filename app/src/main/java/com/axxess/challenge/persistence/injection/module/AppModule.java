package com.axxess.challenge.persistence.injection.module;

import android.content.Context;

import com.axxess.challenge.core.repositoris.ImageRepository;
import com.axxess.challenge.core.services.ImgurApiService;
import com.axxess.challenge.persistence.repository.ImageRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    ImageRepository provideImgurRepository(ImgurApiService serviceApi, Context context) {
        return new ImageRepositoryImpl(serviceApi, context);
    }

}

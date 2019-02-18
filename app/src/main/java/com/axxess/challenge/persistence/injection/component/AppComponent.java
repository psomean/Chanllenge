package com.axxess.challenge.persistence.injection.component;


import android.content.Context;

import com.axxess.challenge.ImgurSearchApp;
import com.axxess.challenge.core.repositoris.ImageRepository;
import com.axxess.challenge.core.services.ImgurApiService;
import com.axxess.challenge.persistence.injection.module.AppModule;
import com.axxess.challenge.persistence.injection.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(ImgurSearchApp app);

    ImgurApiService exposeImgurServiceApi();
    ImageRepository exposeImageRepository();
    Context exposeAppContext();
}

package com.axxess.challenge.persistence.injection.component;


import com.axxess.challenge.persistence.injection.module.AppModule;
import com.axxess.challenge.persistence.injection.module.NetworkModule;
import com.axxess.challenge.view.SearchImgurActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(SearchImgurActivity searchImgurActivity);
}

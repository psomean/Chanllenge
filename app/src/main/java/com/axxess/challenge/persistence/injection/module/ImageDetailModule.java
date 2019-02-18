package com.axxess.challenge.persistence.injection.module;

import com.axxess.challenge.persistence.injection.scope.PerActivity;
import com.axxess.challenge.view.imagedetail.ImageDetailView;

import dagger.Module;
import dagger.Provides;

@Module
public class ImageDetailModule {

    private final ImageDetailView view;

    public ImageDetailModule(ImageDetailView view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    ImageDetailView  provideLoginView() {
        return this.view;
    }
}

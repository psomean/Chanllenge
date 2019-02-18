package com.axxess.challenge.persistence.injection.module;


import com.axxess.challenge.persistence.injection.scope.PerActivity;
import com.axxess.challenge.view.searchimage.SearchImgurView;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchImgurModule {

    private final SearchImgurView view;

    public SearchImgurModule(SearchImgurView view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    SearchImgurView  provideLoginView() {
        return this.view;
    }

}

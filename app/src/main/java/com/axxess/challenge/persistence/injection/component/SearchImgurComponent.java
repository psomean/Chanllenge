package com.axxess.challenge.persistence.injection.component;

import com.axxess.challenge.persistence.injection.scope.PerActivity;
import com.axxess.challenge.persistence.injection.module.SearchImgurModule;
import com.axxess.challenge.view.searchimage.SearchImgurActivity;

import dagger.Component;

@PerActivity
@Component(modules = {SearchImgurModule.class}, dependencies = {AppComponent.class})
public interface SearchImgurComponent {
    void inject (SearchImgurActivity searchImgurActivity);
}

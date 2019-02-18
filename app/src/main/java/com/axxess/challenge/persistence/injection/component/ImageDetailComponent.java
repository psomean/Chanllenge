package com.axxess.challenge.persistence.injection.component;


import com.axxess.challenge.persistence.injection.module.ImageDetailModule;
import com.axxess.challenge.persistence.injection.scope.PerActivity;
import com.axxess.challenge.view.imagedetail.ImageDetails;

import dagger.Component;

@PerActivity
@Component(modules = {ImageDetailModule.class}, dependencies = {AppComponent.class})
public interface ImageDetailComponent {
    void inject(ImageDetails imageDetails);
}

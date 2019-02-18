package com.axxess.challenge;

import android.app.Application;

import com.axxess.challenge.persistence.injection.component.AppComponent;
import com.axxess.challenge.persistence.injection.component.DaggerAppComponent;
import com.axxess.challenge.persistence.injection.module.AppModule;

public class ImgurSearchApp extends Application {

    private AppComponent mAppComponent;
    private static ImgurSearchApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        mAppComponent.inject(this);
    }

    public static synchronized ImgurSearchApp getInstance() {
        return mInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}

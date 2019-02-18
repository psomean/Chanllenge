package com.axxess.challenge.persistence.injection;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ImgurInterceptor implements Interceptor {

//    @Inject
//    @Singleton
//    DbSpActiveUser token;

    @Inject public ImgurInterceptor() {}

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
                .header("Authorization", "Client-ID 137cda6b5008a7c")
                .build();

        return chain.proceed(request);
    }
}
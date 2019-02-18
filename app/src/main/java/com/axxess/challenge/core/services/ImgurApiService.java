package com.axxess.challenge.core.services;

import com.axxess.challenge.core.response.GalleryResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImgurApiService {
    @GET("search/1")
    Observable<Response<GalleryResponse>> getImgurGallery(@Query("q") String query);
}

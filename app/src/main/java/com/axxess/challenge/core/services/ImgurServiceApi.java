package com.axxess.challenge.core.services;

import com.axxess.challenge.core.response.GalleryReponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImgurServiceApi {
    @GET("//search/1")
    Observable<Response<GalleryReponse>> getImgurGallery(@Query("q") String query);
}

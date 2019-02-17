package com.axxess.challenge.persistence;

import com.axxess.challenge.core.repositoris.ImgurRepository;
import com.axxess.challenge.core.response.GalleryReponse;
import com.axxess.challenge.core.services.ImgurServiceApi;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ImgurRepositoryImpl implements ImgurRepository {

    ImgurServiceApi serviceApi;

    protected <T> void subscribe(Observable<Response<T>> observable, Observer<Response<T>> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void getImageGallery(@NotNull String query, @NotNull ImgurGalleryCallBack imgurGalleryCallBack) {
        Observable<Response<GalleryReponse>> imgurGallery = serviceApi.getImgurGallery(query);

        subscribe(imgurGallery, new Observer<Response<GalleryReponse>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<GalleryReponse> galleryReponseResponse) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}

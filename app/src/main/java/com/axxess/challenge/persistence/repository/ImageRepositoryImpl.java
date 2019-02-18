package com.axxess.challenge.persistence.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.axxess.challenge.core.services.ImgurApiService;
import com.axxess.challenge.persistence.localdatabase.ImageDao;
import com.axxess.challenge.persistence.localdatabase.ImageEntity;
import com.axxess.challenge.persistence.localdatabase.ImageRoomDatabase;
import com.axxess.challenge.core.repositoris.ImageRepository;
import com.axxess.challenge.core.response.GalleryResponse;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ImageRepositoryImpl implements ImageRepository {
    private ImgurApiService mServiceApi;
    private ImageDao mImageDao;

    private AsyncTask<String, Void, Void> mReadAsyncTask;
    DisposableObserver<Response<GalleryResponse>> observer;

    public ImageRepositoryImpl(ImgurApiService service, Context context) {
        this.mServiceApi = service;

        ImageRoomDatabase db = ImageRoomDatabase.getDatabase(context);
        mImageDao = db.imageDao();
    }

    @Override
    public void getImageGallery(@NotNull String query, @NotNull ImgurGalleryCallBack imgurGalleryCallBack) {
        observer = new DisposableObserver<Response<GalleryResponse>>() {
            @Override
            public void onNext(Response<GalleryResponse> response) {
                imgurGalleryCallBack.onGalleryLoaded(Arrays.asList(response.body().getGalleries()));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        subscribe(mServiceApi.getImgurGallery(query), observer);
    }

    @Override
    public void getImage(String id, ImageEntityCallBack imageEntityCallBack) {
        mReadAsyncTask = new readAsyncTask(mImageDao, imageEntityCallBack).execute(id);
    }

    @Override
    public void onDestroy() {
        if(mReadAsyncTask != null) mReadAsyncTask.cancel(true);
        if(observer != null) observer.dispose();
    }

    @Override
    public void insert (ImageEntity imageEntity) {
        new insertAsyncTask(mImageDao).execute(imageEntity);
    }

    private static class insertAsyncTask extends AsyncTask<ImageEntity, Void, Void> {

        private ImageDao mAsyncTaskDao;

        insertAsyncTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ImageEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class readAsyncTask extends AsyncTask<String, Void, Void> {

        private ImageDao mAsyncTaskDao;
        private ImageEntityCallBack mCallBack;

        private

        readAsyncTask(ImageDao dao, ImageEntityCallBack callBack) {
            mAsyncTaskDao = dao;
            mCallBack = callBack;
        }

        @Override
        protected Void doInBackground(final String... params) {
            ImageEntity image = mAsyncTaskDao.getImage(params[0]);

            if (isCancelled())
                return null;

            mCallBack.onImageLoaded(image);
            return null;
        }
    }

    private  <T> void subscribe(Observable<Response<T>> observable, Observer<Response<T>> observer) {
        observable.debounce(250, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


}

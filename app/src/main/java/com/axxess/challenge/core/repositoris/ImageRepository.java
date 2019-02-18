package com.axxess.challenge.core.repositoris;

import com.axxess.challenge.persistence.localdatabase.ImageEntity;
import com.axxess.challenge.core.response.Gallery;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ImageRepository {

    void getImageGallery(@NotNull String query, @NotNull ImgurGalleryCallBack imgurGalleryCallBack);
    void insert (ImageEntity imageEntity);

    void getImage(String id, ImageEntityCallBack imageEntityCallBack);

    void onDestroy();

    interface ImgurGalleryCallBack {
        void onGalleryLoaded(List<Gallery> galleries);
    }

    interface  ImageEntityCallBack {
        void onImageLoaded(ImageEntity imageEntity);
    }
}

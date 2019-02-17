package com.axxess.challenge.core.repositoris;

import com.axxess.challenge.core.response.ImgurImage;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ImgurRepository {

    void getImageGallery(@NotNull String query, @NotNull ImgurGalleryCallBack imgurGalleryCallBack);

    interface ImgurGalleryCallBack {
        void onGalleryLoaded(List<ImgurImage> images);
    }
}

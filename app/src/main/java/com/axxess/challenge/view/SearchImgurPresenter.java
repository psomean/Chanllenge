package com.axxess.challenge.view;

import com.axxess.challenge.core.repositoris.ImgurRepository;
import com.axxess.challenge.core.response.ImgurImage;

import java.util.List;

public class SearchImgurPresenter implements SearchImgurContractor.UserActionsListener {

    ImgurRepository imgurRepository;

    @Override
    public void onQuerySubmit(String query) {
        imgurRepository.getImageGallery(query, new ImgurRepository.ImgurGalleryCallBack(){

            @Override
            public void onGalleryLoaded(List<ImgurImage> images) {

            }
        });
    }
}

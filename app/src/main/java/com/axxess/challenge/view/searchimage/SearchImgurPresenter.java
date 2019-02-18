package com.axxess.challenge.view.searchimage;

import com.axxess.challenge.core.repositoris.ImageRepository;
import com.axxess.challenge.core.response.Gallery;
import com.axxess.challenge.core.response.ImgurImage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SearchImgurPresenter  {

    @Inject ImageRepository mImageRepository;
    @Inject SearchImgurView mView;

    public SearchImgurPresenter(ImageRepository repository, SearchImgurView view) {
        this.mImageRepository = repository;
        this.mView = view;
    }

    @Inject
    public SearchImgurPresenter(){}

    public void onQuerySubmit(String query) {
        mImageRepository.getImageGallery(query, e -> {
            List<ImgurImage> imageList = new ArrayList<>();
            for (Gallery gallery : e) {
                if (gallery.getImages() != null) {
                    for (ImgurImage image : gallery.getImages()) {
                        if (image.isImage()) {
                            imageList.add(image);
                        }
                    }
                }
            }

            mView.displayImage(imageList);
        });
    }

    public void onDestroy() {
        mImageRepository.onDestroy();
    }
}

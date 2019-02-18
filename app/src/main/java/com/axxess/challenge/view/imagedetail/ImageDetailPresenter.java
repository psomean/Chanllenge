package com.axxess.challenge.view.imagedetail;

import com.axxess.challenge.persistence.localdatabase.ImageEntity;
import com.axxess.challenge.core.repositoris.ImageRepository;

import javax.inject.Inject;

public class ImageDetailPresenter {
    private ImageRepository mImageRepository;
    private ImageDetailView mView;

    @Inject
    public ImageDetailPresenter(ImageRepository repository, ImageDetailView view) {
        this.mImageRepository = repository;
        this.mView = view;
    }

    public void onSubmit(String comment, String id) {
        if (comment.isEmpty()) {
            mView.showErrorComment();
            return;
        }

        if (id.isEmpty()) {
            return;
        }

        mImageRepository.insert(new ImageEntity(id, comment));

        mView.showInsertCompletion();
    }

    public void onCreate(String id) {
        if (id.isEmpty()) {
            return;
        }

        mImageRepository.getImage(id, e -> {
            if (e != null)
            if (!e.getComment().isEmpty()) {
                mView.showComment(e.getComment());
            }
        });
    }

    public void onViewDestroy() {
        mImageRepository.onDestroy();
    }
}

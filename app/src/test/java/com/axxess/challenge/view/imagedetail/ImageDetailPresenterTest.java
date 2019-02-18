package com.axxess.challenge.view.imagedetail;

import com.axxess.challenge.persistence.localdatabase.ImageEntity;
import com.axxess.challenge.core.repositoris.ImageRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

public class ImageDetailPresenterTest {
    ImageDetailPresenter mImageDetailPresenter;

    @Mock ImageDetailView mImageDetailView;

    @Mock ImageRepository mImageRepository;

    @Captor
    ArgumentCaptor<ImageRepository.ImageEntityCallBack> imageCallBackCaptor;

    @Before
    public void setupAddNotePresenter() {
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mImageDetailPresenter = new ImageDetailPresenter(mImageRepository, mImageDetailView);
    }

    @Test public void onSubmit_emptyComment_showErrorComment() {
        mImageDetailPresenter.onSubmit("", "123");
        verify(mImageDetailView).showErrorComment();
    }

    @Test public void onSubmit_insertData() {
        mImageDetailPresenter.onSubmit("comment", "123");
        verify(mImageRepository).insert(any(ImageEntity.class));
    }

    @Test public void onSubmit_showInsertCompletion() {
        mImageDetailPresenter.onSubmit("comment", "123");
        verify(mImageDetailView).showInsertCompletion();
    }

    @Test public void onCreate_commentExist_showComment() {
        String comment = "anyKey";
        mImageDetailPresenter.onCreate(comment);
        verify(mImageRepository).getImage(anyString(), imageCallBackCaptor.capture());
        ImageEntity image = new ImageEntity(anyString(), comment);
        imageCallBackCaptor.getValue().onImageLoaded(image);
        verify(mImageDetailView).showComment(comment);
    }


}
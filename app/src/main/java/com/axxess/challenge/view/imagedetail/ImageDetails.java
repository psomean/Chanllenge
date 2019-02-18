package com.axxess.challenge.view.imagedetail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.axxess.challenge.ImgurSearchApp;
import com.axxess.challenge.R;
import com.axxess.challenge.core.response.ImgurImage;
import com.axxess.challenge.persistence.injection.component.DaggerImageDetailComponent;
import com.axxess.challenge.persistence.injection.module.ImageDetailModule;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageDetails extends AppCompatActivity implements ImageDetailView{

    @BindView(R.id.txt_comment) TextView mComment;
    @BindView(R.id.imgur_image) ImageView mImageView;

    @OnClick(R.id.btn_submit) void onClockIn() {
        mPresenter.onSubmit(mComment.getText().toString(), mImage.getId());
    }

    @Inject ImageDetailPresenter mPresenter;

    private ImgurImage mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgur_details);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DaggerImageDetailComponent.builder()
                .appComponent(ImgurSearchApp.getInstance().getAppComponent())
                .imageDetailModule(new ImageDetailModule( this))
                .build()
                .inject(this);

        mImage = new ImgurImage();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            mImage.setLink(bundle.getString(getString(R.string.key_img_link)));
            mImage.setId(bundle.getString(getString(R.string.key_img_id)));
        }

        Glide.with(this)
                .load(mImage.getLink())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .centerCrop()
                        .dontAnimate()
                        .dontTransform())
                .into(mImageView);

        mPresenter.onCreate(mImage.getId());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showErrorComment() {
        mComment.setError(getString(R.string.err_empty_comment));
    }

    @Override
    public void showComment(String comment) {
        mComment.setText(comment);
    }

    @Override
    public void showInsertCompletion() {
        Toast.makeText(this, "Comment has been saved",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onViewDestroy();
    }
}

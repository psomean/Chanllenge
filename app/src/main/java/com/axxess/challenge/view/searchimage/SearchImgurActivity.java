package com.axxess.challenge.view.searchimage;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.axxess.challenge.ImgurSearchApp;
import com.axxess.challenge.R;
import com.axxess.challenge.core.response.ImgurImage;
import com.axxess.challenge.persistence.injection.component.DaggerSearchImgurComponent;
import com.axxess.challenge.persistence.injection.module.SearchImgurModule;
import com.axxess.challenge.view.imagedetail.ImageDetails;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SearchImgurActivity extends AppCompatActivity implements SearchImgurView {

    @BindView(R.id.rcl_messages) RecyclerView recyclerView;
    Unbinder unbinder;

    @Inject
    SearchImgurPresenter mSearchImagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        DaggerSearchImgurComponent.builder()
                .appComponent(ImgurSearchApp.getInstance().getAppComponent())
                .searchImgurModule(new SearchImgurModule( this))
                .build()
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView == null) return false;

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mSearchImagePresenter.onQuerySubmit(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void displayImage(List<ImgurImage> imageList) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        ImgurImageAdapter adapter = new ImgurImageAdapter(imageList);
        adapter.setOnItemClickListener(new ImgurImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ImgurImage imgurImage) {
                Intent imageDetails = new Intent(SearchImgurActivity.this, ImageDetails.class);
                imageDetails.putExtra(getString(R.string.key_img_id), imgurImage.getId());
                imageDetails.putExtra(getString(R.string.key_img_link), imgurImage.getLink());
                startActivity(imageDetails);
            }
        });

        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        mSearchImagePresenter.onDestroy();
        super.onDestroy();

    }
}

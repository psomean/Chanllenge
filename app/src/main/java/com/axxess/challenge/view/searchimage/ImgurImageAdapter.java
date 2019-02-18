package com.axxess.challenge.view.searchimage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.axxess.challenge.R;
import com.axxess.challenge.core.response.ImgurImage;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImgurImageAdapter extends RecyclerView.Adapter<ImgurImageAdapter.ViewHolder> {

    private  List<ImgurImage> imageList = new ArrayList<>();
    public ImgurImageAdapter(List<ImgurImage> images) {
        this.imageList = images;
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        ImgurImage imgurImage = imageList.get(position);

        Glide.with(imageView.getContext())
                .load(imgurImage.getLink())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .centerCrop()
                        .dontAnimate()
                        .dontTransform())
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public void setShiftList(List<ImgurImage> images) {
        this.imageList = images;
        super.notifyDataSetChanged();
    }
    public void addShift(ImgurImage imgurImage) {
        this.imageList.add(imgurImage);
        super.notifyDataSetChanged();
    }

    public void clearShift() {
        if (!imageList.isEmpty())
            imageList.clear();
        super.notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view) ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(imageList.get(getAdapterPosition()));
                }
            });
        }
    }

    public static abstract class OnItemClickListener {
        public abstract void onItemClick(ImgurImage imgurImage);
    }
}

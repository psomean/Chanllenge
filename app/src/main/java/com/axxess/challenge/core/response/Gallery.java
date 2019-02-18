package com.axxess.challenge.core.response;

import java.util.Arrays;

public class Gallery {
    @Override
    public String toString() {
        return "Gallery{" +
                "id='" + id + '\'' +
                ", datetime=" + datetime +
                ", images=" + Arrays.toString(images) +
                '}';
    }

    private String id;
    private int datetime;
    private ImgurImage[] images;


    public int getDatetime() {
        return this.datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public ImgurImage[] getImages() {
        return this.images;
    }

    public void setImages(ImgurImage[] images) {
        this.images = images;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

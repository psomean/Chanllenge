package com.axxess.challenge.core.response;

public class Gallery {
    private int datetime;
    private ImgurImage[] images;
    private String id;

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

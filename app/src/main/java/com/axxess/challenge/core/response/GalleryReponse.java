package com.axxess.challenge.core.response;

public class GalleryReponse {
    private Gallery[] galleries;
    private boolean success;
    private int status;

    public Gallery[] getGalleries() {
        return this.galleries;
    }

    public void setData(Gallery[] galleries) {
        this.galleries = galleries;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

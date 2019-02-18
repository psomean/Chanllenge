package com.axxess.challenge.core.response;

import java.util.Arrays;

public class GalleryResponse {
    private Gallery[] data;
    private boolean success;

    private int status;

    public Gallery[] getGalleries() {
        return this.data;
    }

    public void setData(Gallery[] galleries) {
        this.data = galleries;
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

    @Override
    public String toString() {
        return "GalleryResponse{" +
                "galleries=" + Arrays.toString(data) +
                ", success=" + success +
                ", status=" + status +
                '}';
    }
}

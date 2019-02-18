package com.axxess.challenge.core.response;

public class ImgurImage {
    private String link;

    @Override
    public String toString() {
        return "ImgurImage{" +
                "link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String description;
    private String id;
    private String type;

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isImage() {
        return type.equals("image/jpeg") || type.equals("image/png");
    }
}

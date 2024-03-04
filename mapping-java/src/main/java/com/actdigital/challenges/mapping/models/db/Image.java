package com.actdigital.challenges.mapping.models.db;

public class Image extends DBEntity {

    private String url;

    private ImageSize imageSize;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public void setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj != null && obj.getClass() != this.getClass()) return false;
        Image temp = (Image)obj;
        return(temp.getId().equals(this.getId()) &&
                temp.getUrl().equals(this.getUrl()) &&
                this.getImageSize().equals(temp.getImageSize()));
    }
}
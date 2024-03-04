package com.actdigital.challenges.mapping.models.db.blocks;

import com.actdigital.challenges.mapping.models.db.Image;

import java.util.List;
import java.util.Objects;

public class GalleryBlock extends ArticleBlock {

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}

package com.du.a36kr.model.bean;

import java.io.Serializable;

/**
 * Created by dllo on 16/9/21.
 */
public class RotateImageBean implements Serializable {
    private int imgId;
    private String imgUrl;

    public RotateImageBean() {
        super();
    }

    public RotateImageBean(int imgId) {
        this.imgId = imgId;
    }

    public RotateImageBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public RotateImageBean(int imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
    }

    public int getImgId() {
        return imgId;
    }

    public RotateImageBean setImgId(int imgId) {
        this.imgId = imgId;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public RotateImageBean setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}

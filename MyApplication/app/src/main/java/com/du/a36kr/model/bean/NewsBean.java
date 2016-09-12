package com.du.a36kr.model.bean;

/**
 * Created by dllo on 16/9/8.
 * 新闻的实体类
 */
public class NewsBean {
    private String titleTv,authorTv,timeTv,positionTv;
    private int img;

    public NewsBean() {
        super();
    }

    public NewsBean(String titleTv, String authorTv, String timeTv, String positionTv, int img) {
        this.titleTv = titleTv;
        this.authorTv = authorTv;
        this.timeTv = timeTv;
        this.positionTv = positionTv;
        this.img = img;
    }

    public String getTitleTv() {
        return titleTv;
    }

    public NewsBean setTitleTv(String titleTv) {
        this.titleTv = titleTv;
        return this;
    }

    public String getAuthorTv() {
        return authorTv;
    }

    public NewsBean setAuthorTv(String authorTv) {
        this.authorTv = authorTv;
        return this;
    }

    public String getTimeTv() {
        return timeTv;
    }

    public NewsBean setTimeTv(String timeTv) {
        this.timeTv = timeTv;
        return this;
    }

    public String getPositionTv() {
        return positionTv;
    }

    public NewsBean setPositionTv(String positionTv) {
        this.positionTv = positionTv;
        return this;
    }

    public int getImg() {
        return img;
    }

    public NewsBean setImg(int img) {
        this.img = img;
        return this;
    }
}

package com.du.a36kr.model.bean;

/**
 * Created by dllo on 16/9/28.
 */
public class StartupActivityBean {
    private int img;
    private String title;
    private String type;
    private String content;

    public StartupActivityBean() {
        super();
    }

    public StartupActivityBean(int img, String title, String type, String content) {
        this.img = img;
        this.title = title;
        this.type = type;
        this.content = content;
    }

    public int getImg() {
        return img;
    }

    public StartupActivityBean setImg(int img) {
        this.img = img;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public StartupActivityBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public StartupActivityBean setType(String type) {
        this.type = type;
        return this;
    }

    public String getContent() {
        return content;
    }

    public StartupActivityBean setContent(String content) {
        this.content = content;
        return this;
    }
}

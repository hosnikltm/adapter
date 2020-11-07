package com.example.mytestme;

import java.io.Serializable;

public class Note implements Serializable {
    private String title , subTitle;

    public Note(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public Note() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}

package com.example.mytestme;

import java.io.Serializable;

public class NoteContent implements Serializable {
    private String title , subTitle, content;

    public NoteContent(String title, String subTitle,String content) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
    }

    public NoteContent() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

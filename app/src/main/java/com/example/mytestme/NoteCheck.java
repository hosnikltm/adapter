package com.example.mytestme;

import java.io.Serializable;

public class NoteCheck implements Serializable {
    private String title;

    public NoteCheck(String title) {
        this.title = title;
    }

    public NoteCheck() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

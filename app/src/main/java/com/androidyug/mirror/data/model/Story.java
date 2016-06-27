package com.androidyug.mirror.data.model;

import java.io.Serializable;

/**
 * Created by Nicheminds on 6/26/2016.
 */
public class Story implements Serializable {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

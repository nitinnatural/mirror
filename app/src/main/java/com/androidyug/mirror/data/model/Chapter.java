package com.androidyug.mirror.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicheminds on 6/26/2016.
 */
public class Chapter implements Serializable {
    private String name;
    private List<Story> story = new ArrayList<Story>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Story> getStory() {
        return story;
    }

    public void setStory(List<Story> story) {
        this.story = story;
    }
}

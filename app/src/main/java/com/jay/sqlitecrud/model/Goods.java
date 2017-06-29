package com.jay.sqlitecrud.model;

import java.util.List;

/**
 * Created by jayli on 2017/6/29 0029.
 */

public class Goods {
    private int id;
    private String name;
    private List<String> images;

    public Goods() {
    }

    public Goods(int id, String name, List<String> images) {
        this.id = id;
        this.name = name;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}

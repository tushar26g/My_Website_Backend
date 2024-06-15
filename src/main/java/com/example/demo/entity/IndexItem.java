package com.example.demo.entity;

public class IndexItem {

    private String key;
    private String title;

    public IndexItem() {
    }

    public IndexItem(String key, String title) {
        this.key = key;
        this.title = title;
    }

    // Getters and setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


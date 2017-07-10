package com.fivefivelike.basemvp.entity;

/**
 * Created by liugongce on 2017/7/3.
 */
public class MainEntity{
    private String text;

    public MainEntity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.example.administrator.myapplication.node;

import java.io.Serializable;

/**
 * @author xupangen on 2018/1/31.
 */

public class RecyclerViewBean implements Serializable {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

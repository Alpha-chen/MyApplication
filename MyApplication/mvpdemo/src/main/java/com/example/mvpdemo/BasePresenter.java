package com.example.mvpdemo;

import android.content.Context;

/**
 * @author xupangen on 2018/2/8.
 */

public class BasePresenter<T> {

    protected T mView;

    protected Context mContext;

    public void attach(T t, Context context) {
        this.mView = t;
        this.mContext = context;
    }

    public void detach() {
        this.mView = null;
        this.mContext = null;
    }

    public void startWork() {

    }
}

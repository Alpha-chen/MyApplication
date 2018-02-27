package com.example.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author xupangen on 2018/2/8.
 */

public abstract class BaseMvpActivity<V extends  BaseView, P extends BasePresenter<V>>
        extends AppCompatActivity {
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach(this,(V) this);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    public abstract P initPresenter();
}

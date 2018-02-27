package com.example.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 统一的一个fragment
 * Created by xupangen on 2018/2/22.
 */

public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment {
    protected P presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(layoutId(),container,false);
        return  view;

    }

    protected abstract int layoutId();
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    public void onResume() {
        presenter.attach(getActivity(), (V) this);
        super.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    public abstract P initPresenter();
}

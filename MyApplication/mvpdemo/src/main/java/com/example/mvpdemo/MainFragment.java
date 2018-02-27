package com.example.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpdemo.login.LoginContract;
import com.example.mvpdemo.login.LoginPresenter;

/**
 * @author xupangen
 * @date 2018/2/22
 */

public class MainFragment extends BaseMvpFragment<LoginContract.View, LoginPresenter>
        implements LoginContract.View {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        textView = view.findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("fragment success")) {
                    presenter.login("2", "1");
                } else if (textView.getText().equals("fragment failure")) {
                    presenter.login("1", "2");
                } else {
                    presenter.login("1", "2");
                }
            }
        });
        return view;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void loginSuccess() {
        textView.setText("fragment success");

    }

    @Override
    public void loginFailure() {
        textView.setText("fragment failure");
    }

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter();
    }
}

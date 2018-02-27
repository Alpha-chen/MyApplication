package com.example.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.mvpdemo.login.LoginContract;
import com.example.mvpdemo.login.LoginPresenter;

public class MainActivity extends BaseMvpActivity<LoginContract.View, LoginPresenter>
        implements LoginContract.View {

    TextView textView;
    MainFragment mainFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("success")) {
                    presenter.login("2", "1");
                } else if (textView.getText().equals("failure")) {
                    presenter.login("1", "2");
                } else {
                    presenter.login("1", "2");
                }
            }
        });
    }

    @Override
    public void loginSuccess() {textView.setText("success");}

    @Override
    public void loginFailure() {textView.setText("failure");}

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

}

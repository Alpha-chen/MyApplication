package com.example.mvpdemo.login;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.mvpdemo.BasePresenter;

/**
 * @author xupangen on 2018/2/8.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter{

    @Override
    public void login(@NonNull String name, @NonNull String pwd) {

        if ("1".equals(name) && "2".equals(pwd)) {
            Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
            getMvpView().loginSuccess();
        } else {
            Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
            getMvpView().loginFailure();
        }
    }
}

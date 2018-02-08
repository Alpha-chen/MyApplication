package com.example.mvpdemo.login;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.mvpdemo.BasePresenter;

/**
 * @author xupangen on 2018/2/8.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> {

    public void login(@NonNull String name, @NonNull String pwd) {
        if ("1".equals(name) && "2".equals(pwd)) {
            Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();
            mView.loginSuccess();
        } else {
            Toast.makeText(mContext, "failure", Toast.LENGTH_SHORT).show();
            mView.loginFailure();
        }
    }
}

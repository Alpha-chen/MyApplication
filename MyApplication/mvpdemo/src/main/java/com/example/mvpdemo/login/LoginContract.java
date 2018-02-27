package com.example.mvpdemo.login;

import android.support.annotation.NonNull;

import com.example.mvpdemo.BaseView;

/**
 * @author xupangen on 2018/2/8.
 */

public interface LoginContract {

    /**
     * 声明需要实现的业务逻辑
     */
    public interface Presenter {
        /***
         * 登录逻辑
         * @param name 用户名
         * @param pwd 密码
         */
        public void login(@NonNull String name, @NonNull String pwd);
    }

    /***
     * 界面显示
     */
    public interface View extends BaseView {
        public void loginSuccess();

        public void loginFailure();
    }
}

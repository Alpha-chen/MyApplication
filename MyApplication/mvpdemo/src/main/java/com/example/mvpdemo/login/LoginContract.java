package com.example.mvpdemo.login;

import com.example.mvpdemo.BaseView;

/**
 * @author xupangen on 2018/2/8.
 */

public interface LoginContract {
    public interface View extends BaseView {
        public void loginSuccess();
        public void loginFailure();
    }
}

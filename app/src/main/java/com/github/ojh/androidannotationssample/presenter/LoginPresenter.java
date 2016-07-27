package com.github.ojh.androidannotationssample.presenter;

import android.content.Context;

import com.github.ojh.androidannotationssample.model.UserModel;

/**
 * Created by 01071724654 on 2016-07-27.
 */
public interface LoginPresenter {
    void setView(LoginView view);
    void login(UserModel userModel);

    interface LoginView {
        void moveToMainActivity();
        void showFailMessage(Context context);
    }
}

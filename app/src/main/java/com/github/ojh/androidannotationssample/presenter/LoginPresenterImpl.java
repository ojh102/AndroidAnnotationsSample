package com.github.ojh.androidannotationssample.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.github.ojh.androidannotationssample.model.UserModel;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by 01071724654 on 2016-07-27.
 */
@EBean
public class LoginPresenterImpl implements LoginPresenter {

    @RootContext
    Context context;
    private LoginPresenter.LoginView loginView;

    @Override
    public void setView(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(UserModel userModel) {
        if(TextUtils.isEmpty(userModel.getId()) || TextUtils.isEmpty(userModel.getPassword())) {
            loginView.showFailMessage(context);
        } else {
            loginView.moveToMainActivity();
        }
    }
}

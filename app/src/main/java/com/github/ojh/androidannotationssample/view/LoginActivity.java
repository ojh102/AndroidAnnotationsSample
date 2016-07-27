package com.github.ojh.androidannotationssample.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.github.ojh.androidannotationssample.MyApplication;
import com.github.ojh.androidannotationssample.R;
import com.github.ojh.androidannotationssample.model.UserModel;
import com.github.ojh.androidannotationssample.presenter.LoginPresenter;
import com.github.ojh.androidannotationssample.presenter.LoginPresenterImpl;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginView {

    @App
    MyApplication myApplication;

    @ViewById(R.id.edtId)
    EditText edtId;

    @ViewById(R.id.edtPasswd)
    EditText edtPasswd;

    @Bean(LoginPresenterImpl.class)
    LoginPresenter presenter;

    @AfterInject
    public void initObject() {
        presenter.setView(this);
    }

    @Click(R.id.btnLogin)
    void onClickBtnLogin() {
        String id = edtId.getText().toString();
        String pw = edtPasswd.getText().toString();

        presenter.login(new UserModel(id, pw));
    }

    @UiThread
    @Override
    public void moveToMainActivity() {
        MainActivity_.intent(this).start();
        finish();
    }

    @UiThread
    @Override
    public void showFailMessage(Context context) {
        Toast.makeText(myApplication, "Login Fail @App", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "Login Fail @RootContext", Toast.LENGTH_SHORT).show();
    }
}

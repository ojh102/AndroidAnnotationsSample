package com.github.ojh.androidannotationssample.model;

/**
 * Created by 01071724654 on 2016-07-27.
 */

public class UserModel {
    private String id;
    private String password;

    public UserModel(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

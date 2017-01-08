package com.zing.ablue.testhttp.entities;

import android.text.TextUtils;

import com.google.gson.Gson;


/**
 * Created by zing on 2017/1/8.
 */

public class LoginRequestEntity {
    private String userName;
    private String userPwd;
    private String loginType = "android";
    private String loginIp;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String checkSelf() {
        if (TextUtils.isEmpty(userName.trim())) {
            return "姓名不能为空";
        } else if (TextUtils.isEmpty(userPwd)) {
            return "登录密码不能为空";
        }
        return null;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);

    }
}

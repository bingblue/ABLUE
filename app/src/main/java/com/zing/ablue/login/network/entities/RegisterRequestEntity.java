package com.zing.ablue.login.network.entities;

import android.text.TextUtils;

/**
 * Created by pengle on 2017/1/11.
 */

public class RegisterRequestEntity {
    private String userName;
    private String userPwd;
    private String nickName;
    private String userPhone;
    private String userSex;
    private String userEmail;
    private String invitationCode;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String checkSelf() {
        if (TextUtils.isEmpty(userName)) {
            return "！";
        } else if (TextUtils.isEmpty(userPwd)){
            return "！";
        } else if (TextUtils.isEmpty(nickName)){
            return "！";
        } else if (TextUtils.isEmpty(userPhone)){
            return "！";
        } else if (TextUtils.isEmpty(userSex)){
            return "！";
        } else if (TextUtils.isEmpty(userEmail)){
            return "！";
        } else if (TextUtils.isEmpty(invitationCode)){
            return "请输入邀请码！";
        }else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "RegisterRequestEntity{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", invitationCode='" + invitationCode + '\'' +
                '}';
    }
}

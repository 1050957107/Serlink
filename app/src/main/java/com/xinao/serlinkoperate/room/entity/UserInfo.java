package com.xinao.serlinkoperate.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_info", indices = {@Index(value = {"userid"},
        unique = true)})
public class UserInfo {
    @PrimaryKey
    @ColumnInfo(name = "userid")
    @NonNull
    public String userid;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "token")
    public String token;

    @ColumnInfo(name = "headurl")
    public String headurl;

    @ColumnInfo(name = "loginstate")
    public int loginstate;

    @NonNull
    public String getUserid() {
        return userid;
    }

    public void setUserid(@NonNull String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLoginstate() {
        return loginstate;
    }

    public void setLoginstate(int loginstate) {
        this.loginstate = loginstate;
    }
}

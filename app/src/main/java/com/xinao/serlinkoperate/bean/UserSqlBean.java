package com.xinao.serlinkoperate.bean;

import com.xinao.serlinkoperate.util.IHelper;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

/**
 * 用户本地数据缓存实体类
 * 继承 LitePalSupport 相对于用户数据表
 */
public class UserSqlBean extends LitePalSupport implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private String user_name;
    private String user_id;
    private String user_password;
    private String userPhone;
    private String created_at;
    private String userUrl;
    private String login_status= IHelper.LOGIN_DEFAULT;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getLogin_status() {
        return login_status;
    }

    public void setLogin_status(String login_status) {
        this.login_status = login_status;
    }

    @Override
    public String toString() {
        return "UserSqlBean{" +
                "user_name='" + user_name + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", created_at='" + created_at + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", login_status='" + login_status + '\'' +
                '}';
    }
}

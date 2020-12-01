package com.xinao.serlinkoperate.bean;

/**
 * @date：2020/12/1
 * @describe：
 * @author：DanDan
 */
public class AlarmInfoBean {
    private String imgUrl;
    private String tile;
    private String context;
    private String behavior;
    private String time;

    public String getImgUrl() {
        return imgUrl;
    }

    public AlarmInfoBean setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getTile() {
        return tile;
    }

    public AlarmInfoBean setTile(String tile) {
        this.tile = tile;
        return this;
    }

    public String getContext() {
        return context;
    }

    public AlarmInfoBean setContext(String context) {
        this.context = context;
        return this;
    }

    public String getBehavior() {
        return behavior;
    }

    public AlarmInfoBean setBehavior(String behavior) {
        this.behavior = behavior;
        return this;
    }

    public String getTime() {
        return time;
    }

    public AlarmInfoBean setTime(String time) {
        this.time = time;
        return this;
    }
}

package com.xinao.serlinkoperate.net.manager;

/**
 * 数据接收基类 根据服务端返回数据封装
 * @param <T>
 */
public class Response<T> {
    public int code;//状态码
    public String msg;//返回消息
    public T data;//返回数据实体

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

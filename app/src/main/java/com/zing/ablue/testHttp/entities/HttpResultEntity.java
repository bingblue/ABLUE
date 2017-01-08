package com.zing.ablue.testhttp.entities;

/**
 * Created by zing on 2017/1/8.
 */

public class HttpResultEntity<T> {
    private String code;
    private String msg;
    private T body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HttpResultEntity{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                '}';
    }
}

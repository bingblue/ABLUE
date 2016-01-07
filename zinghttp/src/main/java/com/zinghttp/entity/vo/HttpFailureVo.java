package com.zinghttp.entity.vo;

import com.squareup.okhttp.Request;

import java.io.IOException;

/**
 * Created by zing on 15/12/2.
 */
public class HttpFailureVo {
    Request request;
    IOException e;

    public HttpFailureVo(Request request, IOException e) {
        this.request = request;
        this.e = e;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public IOException getE() {
        return e;
    }

    public void setE(IOException e) {
        this.e = e;
    }
}

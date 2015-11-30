package com.zinghttp;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by zing on 15/11/6.
 */
public class ZCallback<T> implements Callback {

    private Callback callback = new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {
            ZCallback.this.onFailure(request, e);
        }

        @Override
        public void onResponse(Response response) throws IOException {
            ZCallback.this.onResponse(response);
        }
    };
    private String jsonStr;

    public void onStart() {

    }

    public void onProgress(long currentBytes, long contentLength, boolean done) {
    }

    public void onResponse(Response response) {
        try {
            onResponse(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onResponse(String responseStr) {
        this.jsonStr = responseStr;
    }

    public T getBean(Class<T> returnType) {
        return JSON.parseObject(jsonStr, returnType);
    }


    public void onFailure(Request request, IOException e) {

    }

    public Callback getCallback() {
        return callback;
    }

}

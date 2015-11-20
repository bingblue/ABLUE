package com.bingblue.group.utils.http;

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

    public void onStart() {

    }

    public void onProgress(long currentBytes, long contentLength, boolean done) {

    }

    public void onResponse(Response response) {

    }

    public void onFailure(Request request, IOException e) {

    }

    public Callback getCallback() {
        return callback;
    }

}

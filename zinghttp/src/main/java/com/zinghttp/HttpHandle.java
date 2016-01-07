package com.zinghttp;

import android.os.Message;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zinghttp.entity.vo.HttpFailureVo;
import com.zinghttp.entity.vo.ProgressVo;
import com.zinghttp.handler.HttpHandler;
import com.zinghttp.handler.HttpHandleMessage;

import java.io.IOException;

/**
 * Created by zing on 15/11/6.
 */
public class HttpHandle {
    private final ZCallback zcallback;
    private Callback okCallback = new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {
            HttpHandle.this.onFailure(request, e);
        }

        @Override
        public void onResponse(Response response) {
            Log.i("HttpHandle:onResponse->", response.toString());
            HttpHandle.this.onResponse(response);
        }
    };

    private HttpHandler handler;

    public HttpHandle(ZCallback callback) {
        this.zcallback = callback;
        this.handler = HttpHandler.newInstance(callback);
    }

    public void onStart() {
        Message m = HttpHandleMessage.buildMessage(HttpHandler.ON_START, null);
        handler.sendMessage(m);
    }

    public void onFailure(Request request, IOException e) {
        Message m = HttpHandleMessage.buildMessage(HttpHandler.ON_FAILURE, new HttpFailureVo(request, e));
        handler.sendMessage(m);
    }

    public void onResponse(Response response) {
        Message m = HttpHandleMessage.buildMessage(HttpHandler.ON_SUCCESS, response);
        handler.sendMessage(m);
    }

    public void onProgress(long currentBytes, long contentLength, boolean done) {
        Message m = HttpHandleMessage.buildMessage(HttpHandler.ON_PROGRESS, new ProgressVo(currentBytes, contentLength, done));
        handler.sendMessage(m);
    }

    public Callback getOkCallback() {
        return okCallback;
    }

    public void setOkCallback(Callback okCallback) {
        this.okCallback = okCallback;
    }
}



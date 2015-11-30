package com.zinghttp;

import android.util.Log;

import com.zinghttp.entity.ProgressResponseBody;
import com.zinghttp.listener.UIProgressListener;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by zing on 15/11/17.
 */
public class HttpClientBuilder {

    private static HttpClientBuilder builder;

    private RequestBody requestBody;
    private OkHttpClient client;
    private Call call;
    private ZCallback callback = null;
    private String url;

    private HttpClientBuilder() {
    }

    public static HttpClientBuilder newInstance(OkHttpClient client) {
        builder = new HttpClientBuilder();
        builder.client = client;
        return builder;
    }

    public HttpClientBuilder addPostParam(String jsonStr) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        requestBody = RequestBody.create(JSON, jsonStr);
        return builder;
    }

    public HttpClientBuilder addPostUrl(String url) {
        this.url = url;
        return builder;
    }

    public HttpClientBuilder addCallBack(final ZCallback callback) {
        this.callback = callback;
        final UIProgressListener uiProgressListener = new UIProgressListener() {
            @Override
            public void onUIProgress(long currentBytes, long contentLength, boolean done) {
                callback.onProgress(currentBytes, contentLength, done);
            }
        };
        client.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截
                Response originalResponse = chain.proceed(chain.request());
                //包装响应体并返回
                return originalResponse.newBuilder()
                        .body(new ProgressResponseBody(originalResponse.body(), uiProgressListener))
                        .build();
            }
        });
        if (null != requestBody) {
            call = client.newCall(new Request.Builder().url(url).post(requestBody).build());
        } else {
            call = client.newCall(new Request.Builder().url(url).build());
        }
        return builder;
    }

    public void sendRequest() {
        Log.i("sendRequest", "sendRequest");
        builder.call.enqueue(callback);
    }

    public HttpClientBuilder addGetUrl(String url) {
        this.url = url;
        return builder;
    }
}



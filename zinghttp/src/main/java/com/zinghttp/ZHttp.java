package com.zinghttp;


import com.squareup.okhttp.OkHttpClient;

/**
 * Created by zing on 15/11/6.
 */
public class ZHttp {
    private static final OkHttpClient client = new OkHttpClient();

    public static void post(String Url, String jsonStr, ZCallback callback) {
        callback.onStart();
        HttpClientBuilder.newInstance(client).addPostParam(jsonStr).addPostUrl(Url).addCallBack(callback).sendRequest();
    }

    public static void get(String Url, ZCallback callback) {
        HttpClientBuilder.newInstance(client).addGetUrl(Url).addCallBack(callback).sendRequest();
    }

    public static OkHttpClient getClient() {
        return client;
    }

}

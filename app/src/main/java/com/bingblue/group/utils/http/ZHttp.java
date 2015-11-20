package com.bingblue.group.utils.http;


import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

/**
 * Created by zing on 15/11/6.
 */
public class ZHttp {
    private static final OkHttpClient client = new OkHttpClient();

    public static void post(String Url, String jsonStr, ZCallback callback) {
        callback.onStart();
        HttpClientBuilder.newInstance(client).addPostParam(jsonStr).addUrl(Url).addCallBack(callback).sendRequest();
    }

    public static void get(String Url, ZCallback callback) {

    }

    public static OkHttpClient getClient() {
        return client;
    }


}

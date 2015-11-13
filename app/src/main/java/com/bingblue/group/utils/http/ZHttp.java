package com.bingblue.group.utils.http;


import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by zing on 15/11/6.
 */
public class ZHttp {
    private static final OkHttpClient client = new OkHttpClient();

    public static <T> T post(String Url, String jsonStr, ZCallback callback, Class<T> returnType) throws IOException {
        Request request = new Request.Builder().url(Url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return JSON.parseObject(response.body().string(), returnType);
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public static void get(String Url, ZCallback callback) {

    }


}

package com.bingblue.group.utils.http;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by zing on 15/11/6.
 */
public abstract class ZCallback implements Callback {
    public void beforeRequest() {
    }

    ;

    @Override
    public void onFailure(Request request, IOException e) {

    }

    @Override
    public void onResponse(Response response) throws IOException {

    }
}

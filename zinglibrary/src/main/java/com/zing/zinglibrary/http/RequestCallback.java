package com.zing.zinglibrary.http;

/**
 * Created by zing on 2016/12/4.
 */

public interface  RequestCallback <T> {

    void onStart();
    void onResponse(T o);
    void onError(Throwable e);
    void onCompleted();
}

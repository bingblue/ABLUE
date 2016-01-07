package com.zinghttp.handler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.squareup.okhttp.Response;
import com.zinghttp.HttpHandle;
import com.zinghttp.ZCallback;
import com.zinghttp.entity.vo.HttpFailureVo;
import com.zinghttp.entity.vo.ProgressVo;

/**
 * Created by zing on 15/11/30.
 */
public class HttpHandler extends Handler {
    public static final int ON_START = 0x0;
    public static final int ON_PROGRESS = 0x1;
    public static final int ON_SUCCESS = 0x2;
    public static final int ON_FAILURE = 0x3;
    private final ZCallback callback;

    private HttpHandler(ZCallback callback) {
        this.callback = callback;
    }

    public static HttpHandler newInstance(ZCallback callback) {
        return new HttpHandler(callback);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case ON_START:
                callback.onStart();
                break;
            case ON_PROGRESS:
                ProgressVo progressVo = (ProgressVo) msg.obj;
                callback.onProgress(progressVo);
                break;
            case ON_SUCCESS:
                Response response = (Response) msg.obj;
                Log.i("HttpHandler:onSuccess->", response.toString());
                callback.onSuccess(response);
                break;
            case ON_FAILURE:
                HttpFailureVo failureVo = (HttpFailureVo) msg.obj;
                callback.onFailure(failureVo);
                break;
        }
    }
}

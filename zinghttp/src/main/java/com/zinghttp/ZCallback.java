package com.zinghttp;

import com.squareup.okhttp.Response;
import com.zinghttp.entity.vo.HttpFailureVo;
import com.zinghttp.entity.vo.ProgressVo;

/**
 * Created by zing on 15/12/2.
 */
public class ZCallback {
    public void onStart() {

    }

    public void onProgress(ProgressVo progressVo) {
    }

    public void onSuccess(Response response) {
    }

    public void onFailure(HttpFailureVo failureVo) {
    }


}

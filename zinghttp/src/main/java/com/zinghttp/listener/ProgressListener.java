package com.zinghttp.listener;

public interface ProgressListener {
    void onProgress(long currentBytes, long contentLength, boolean done);
}

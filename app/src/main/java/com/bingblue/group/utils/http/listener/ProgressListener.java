package com.bingblue.group.utils.http.listener;

public interface ProgressListener {
    void onProgress(long currentBytes, long contentLength, boolean done);
}

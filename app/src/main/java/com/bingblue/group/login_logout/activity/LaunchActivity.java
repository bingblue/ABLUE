package com.bingblue.group.login_logout.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bingblue.group.R;
import com.bingblue.group.common.activity.BaseActivity;
import com.bingblue.group.utils.http.ZCallback;
import com.bingblue.group.utils.http.ZHttp;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class LaunchActivity extends BaseActivity {

    ImageView cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_launch);
        findViews();
        init();
    }

    private void init() {
        String url = "http://news.at.zhihu.com/api/1.2/news/before/20151114";
        ZCallback callback = new ZCallback() {
            @Override
            public void onStart() {
                super.onStart();
                Log.i("onStart", "start");
            }

            @Override
            public void onProgress(long currentBytes, long contentLength, boolean done) {
                super.onProgress(currentBytes, contentLength, done);
                Log.i("onProgress", "start" + contentLength);
            }

            @Override
            public void onFailure(Request request, IOException e) {
                super.onFailure(request, e);
                Log.e("onFailure", e.toString());
            }

            @Override
            public void onResponse(Response response) {
                super.onResponse(response);
                try {
                    Log.i("onResponse", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        ZHttp.post(url, "", callback);
    }

    private void findViews() {
        cover = (ImageView) findViewById(R.id.img_cover);
    }

}

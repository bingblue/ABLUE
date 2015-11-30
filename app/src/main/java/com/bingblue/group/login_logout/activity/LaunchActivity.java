package com.bingblue.group.login_logout.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bingblue.group.R;
import com.bingblue.group.common.activity.BaseActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.okhttp.Request;
import com.zinghttp.ZCallback;
import com.zinghttp.ZHttp;

import java.io.IOException;


public class LaunchActivity extends BaseActivity {

    ImageView cover;
    TextView testText;

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
                Toast.makeText(LaunchActivity.this, "onProgress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Request request, IOException e) {
                super.onFailure(request, e);
                Log.e("onFailure", e.toString());

            }

            @Override
            public void onResponse(String responseStr) {
                super.onResponse(responseStr);
                Log.i("onResponse", "start" + responseStr);
                testText.setText(responseStr);
//                Toast.makeText(LaunchActivity.this,responseStr,Toast.LENGTH_SHORT).show();

            }

        };
        ZHttp.post(url, "", callback);
//        ZHttp.get(url, callback);
    }

    private void findViews() {
        cover = (ImageView) findViewById(R.id.img_cover);
        testText = (TextView) findViewById(R.id.test_text);
    }

}

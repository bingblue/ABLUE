package com.bingblue.group.login_logout.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bingblue.group.R;
import com.bingblue.group.common.activity.BaseActivity;
import com.bingblue.group.utils.http.ZHttp;
import com.facebook.drawee.backends.pipeline.Fresco;

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
        try {
            Log.i("", ZHttp.post(url, null, null, String.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findViews() {
        cover = (ImageView) findViewById(R.id.img_cover);
    }

}

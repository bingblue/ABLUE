package com.bingblue.group.activities.login;

import android.os.Bundle;
import android.widget.ImageView;

import com.bingblue.group.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import com.bingblue.group.activities.BaseActivity;


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

    }

    private void findViews() {
        cover = (ImageView) findViewById(R.id.img_cover);
    }

}

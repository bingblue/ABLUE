package com.zing.ablue.common.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.zing.ablue.ZApplication;
import com.zing.ablue.common.utils.ActivityUtil;

import butterknife.ButterKnife;

/**
 * Created by zing on 2016/12/24.
 */

public class BaseAppCompatActivity extends AppCompatActivity {
    protected ZApplication application;

    public String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (ZApplication) getApplication();
        TAG = this.getLocalClassName();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityUtil.add(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityUtil.remove(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtil.remove(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
    }

    public void showTip(String content) {
        ActivityUtil.showTip(content);
    }

}

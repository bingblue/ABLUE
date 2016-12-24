package com.zing.ablue.common.activity;

import android.app.Activity;
import android.os.Bundle;

import com.zing.ablue.ZApplication;
import com.zing.ablue.common.utils.ActivityUtil;

import butterknife.ButterKnife;

/**
 * Created by zing on 2016/12/8.
 */

public abstract class BaseActivity extends Activity {
    protected ZApplication application;

    private String TAG;

    protected abstract int initContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            application = (ZApplication) getApplication();
            TAG = this.getLocalClassName();

            setContentView(initContentView());
            ButterKnife.bind(this);

            initData();
        } catch (Exception e) {
            e.printStackTrace();
            showTip("初始化异常！");
        }
    }

    protected abstract void initData();

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

    public void showTip(String content) {
        ActivityUtil.showTip(content);
    }


}

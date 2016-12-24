package com.zing.ablue.common.activity;

import android.app.Activity;
import android.os.Bundle;

import com.zing.ablue.ZApplication;
import com.zing.ablue.common.utils.ActivityUtil;

/**
 * Created by zing on 2016/12/8.
 */

public abstract class BaseActivity extends Activity {
    protected ZApplication application;

    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (ZApplication) getApplication();
        TAG = this.getLocalClassName();
        try {
            setContent();
            initView();
            initData();
            initListener();
        } catch (Exception e) {
            e.printStackTrace();
            showTip("初始化异常！");
        }
    }

    public abstract void setContent();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();


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

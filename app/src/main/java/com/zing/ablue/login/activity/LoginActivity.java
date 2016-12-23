package com.zing.ablue.login.activity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zing.ablue.R;
import com.zing.ablue.common.activity.BaseActivity;

/**
 * Created by zing on 2016/12/8.
 */

public class LoginActivity extends BaseActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.login_login_aty);
        init();

    }

    private void init() {
        findViews();
        addViewAction();
    }

    private void addViewAction() {
    setUpWebView();

    }

    private void setUpWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/webpage/login_canvas_wbv.html");
		Log.i(">>>>>>>",">>>>>test222222>>>>>");

    }

    private void findViews() {
        webView = (WebView) findViewById(R.id.login_bg_view);
    }
}

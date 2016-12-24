package com.zing.ablue.login.activity;

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
    public void setContent() {
        Fresco.initialize(this);
        setContentView(R.layout.login_login_aty);
    }

    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.login_bg_view);
    }

    @Override
    public void initData() {
        setUpWebView();
    }

    @Override
    public void initListener() {

    }

    private void setUpWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/webpage/login_canvas_wbv.html");
    }

}

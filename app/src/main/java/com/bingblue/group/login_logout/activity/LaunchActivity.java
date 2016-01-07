package com.bingblue.group.login_logout.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bingblue.group.R;
import com.bingblue.group.common.activity.BaseActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.okhttp.Response;
import com.zinghttp.ZCallback;
import com.zinghttp.ZHttp;
import com.zinghttp.entity.vo.HttpFailureVo;
import com.zinghttp.entity.vo.ProgressVo;

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
//        String url = "http://news.at.zhihu.com/api/1.2/news/before/20151114";
        String url = "http://www.baidu.com";
        ZCallback callback = new ZCallback() {
            @Override
            public void onStart() {
                super.onStart();
                Log.i("onStart", "onStart");
            }

            @Override
            public void onProgress(ProgressVo progressVo) {
                super.onProgress(progressVo);
                showTip("onProgress");
                Log.i("onProgress", "onProgress");

            }

            @Override
            public void onSuccess(Response response) {
                super.onSuccess(response);
                try {
                    Log.i("onSuccess", response.body().string());
                    testText.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(HttpFailureVo failureVo) {
                super.onFailure(failureVo);
                showTip("onFailure");
                Log.i("onFailure", "onFailure");

            }
        };

        ZHttp.post(url, null, callback);
//        ZHttp.get(url, callback);
    }
    private void findViews() {
        cover = (ImageView) findViewById(R.id.img_cover);
        testText = (TextView) findViewById(R.id.test_text);
    }

    private void showTip(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}

package com.zing.ablue.testhttp.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.zing.ablue.R;
import com.zing.ablue.common.activity.BaseAppCompatActivity;
import com.zing.ablue.testhttp.entities.HttpResultEntity;
import com.zing.ablue.testhttp.entities.LoginRequestEntity;
import com.zing.ablue.testhttp.servicies.DemoRequest;
import com.zing.zinglibrary.http.HttpUtil;
import com.zing.zinglibrary.http.RequestCallback;
import com.zing.zinglibrary.http.http_client.DefaultOkHttpClient;


import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;

public class TestPageActivity extends BaseAppCompatActivity {
    public static final String BASE_URL = "http://www.bingblue.com/";
    @BindView(R.id.main_page_http_btn)
    Button requestBtn;

    @BindView(R.id.main_page_text)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page_aty);
    }

    @OnClick(R.id.main_page_http_btn)
    public void sendHttpRequest(){

        requestBtn.setText("正在请求……");
        LoginRequestEntity loginRequestEntity = new LoginRequestEntity();
        loginRequestEntity.setLoginIp("192.168.1.33");
        loginRequestEntity.setUserName("pengle609");
        loginRequestEntity.setUserPwd("123456");
        String msg = loginRequestEntity.checkSelf();

        if(!TextUtils.isEmpty(msg)){
            showTip(msg);
            return;
        }


//        RequestCallback<HttpResultEntity<String>> callback = createCallBack();
        RequestCallback<HttpResultEntity<String>> callback = createCallBack();

        CookieJar cookieJar = DefaultOkHttpClient.getDefaultCookieJar(this);

        HttpUtil httpUtil = HttpUtil.getInstance();

        OkHttpClient client = DefaultOkHttpClient.getOkHttpClient(true, this, null, cookieJar);

        DemoRequest hahahaha = httpUtil.buildJSONRequest(BASE_URL, DemoRequest.class, client);

         httpUtil.sendRequest(hahahaha.login(loginRequestEntity), callback);
    }

    private RequestCallback<HttpResultEntity<String>> createCallBack() {
        return new RequestCallback<HttpResultEntity<String>>(){

            @Override
            public void onStart() {
                Log.i("LoginActivity", "onStart: ");
            }

            @Override
            public void onResponse(HttpResultEntity<String> o) {
                    Log.i(TAG,o.toString());
                result.setText(o.getBody());

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
            }

            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted:");
                requestBtn.setText("重新请求");
            }
        };
    }

}

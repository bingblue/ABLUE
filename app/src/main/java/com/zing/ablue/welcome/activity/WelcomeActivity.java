package com.zing.ablue.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zing.ablue.R;
import com.zing.ablue.common.activity.BaseActivity;
import com.zing.ablue.login.activity.LoginActivity;

public class WelcomeActivity extends BaseActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        init();

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private ImageView icon;
    private boolean isWebWorkOver = false;
    private boolean isAnimationWorkOver = false;


    private void init() {
        findViews();
        startAnimation();
        startPrepareBeforeMainActivityStart();
    }

    private void startPrepareBeforeMainActivityStart() {
        isWebWorkOver = true;
        startAppMainUiActivity();
    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.icon_fade_in);
        animation.setAnimationListener(new MyAnimationListener());
        icon.startAnimation(animation);
    }

    private void findViews() {
        icon = (ImageView) findViewById(R.id.app_icon);
    }

    private void startAppMainUiActivity() {
        if (isWebWorkOver && isAnimationWorkOver) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            isAnimationWorkOver = true;
            startAppMainUiActivity();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}

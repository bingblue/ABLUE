package com.zing.ablue.mainpage.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zing on 2017/1/19.
 */

public final class NativeIconTextView extends TextView {
    public NativeIconTextView(Context context) {
        super(context);
        setFontFile(context);
    }

    public NativeIconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFontFile(context);
    }

    public NativeIconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontFile(context);
    }

    public NativeIconTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFontFile(context);
    }

    public void setFontFile(Context context) {
        AssetManager assetManager = context.getAssets();
        Typeface t = Typeface.createFromAsset(assetManager, "fonts/icons.ttf");
        setTypeface(t);
    }
}

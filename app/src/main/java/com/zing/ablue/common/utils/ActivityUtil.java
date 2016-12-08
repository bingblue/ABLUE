package com.zing.ablue.common.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zing.ablue.ZApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zing on 15-1-9.
 */
public class ActivityUtil {

    public static List<Activity> activityList = new ArrayList<>();

    public static void add(Activity activity) {
        activityList.add(activity);
    }

    public static void remove(Activity activity) {
        activityList.remove(activity);
    }

    /**
     * 退出程序
     */
    public static void exitAll() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

    /**
     * 获取当前Activity
     * @return
     */
    public static Activity getCurrentActivity() {
        int index = activityList.size() - 1;

        if (index < 0) {
            Log.e("CurrentActivity", "activity ARC error!");
            return null;
        }
        return activityList.get(index);
    }

    public static void showTip(String content) {
        showTip(ZApplication.getContext(), content);
    }

    /**
     * 弹出toast
     *
     * @param context
     * @param content
     */
    public static void showTip(Context context, String content) {
        if (context == null)
            context = ZApplication.getContext();

        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取底层的view
     *
     * @param activity
     * @return
     */
    public static View getRootView(Activity activity) {
        return ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    }
}

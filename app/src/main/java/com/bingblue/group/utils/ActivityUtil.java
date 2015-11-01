package com.bingblue.group.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zing on 15/7/10.
 */
public class ActivityUtil {
    public static List<Activity> activityList = new ArrayList();

    public static void add(Activity activity) {
        activityList.add(activity);
    }

    public static void remove(Activity activity) {
        activityList.remove(activity);
    }

    public static void exitAll() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }
}

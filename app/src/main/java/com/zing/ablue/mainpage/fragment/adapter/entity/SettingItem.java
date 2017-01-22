package com.zing.ablue.mainpage.fragment.adapter.entity;

/**
 * Created by zing on 2017/1/21.
 */

public class SettingItem {
    private boolean isGroupTitle;
    private String icon;
    private String text;
    private int remind;

    public SettingItem(boolean isGroupTitle, String icon, String text, int remind) {
        this.isGroupTitle = isGroupTitle;
        this.icon = icon;
        this.text = text;
        this.remind = remind;
    }

    public SettingItem(String icon, String text, int remind) {
        this.isGroupTitle = false;
        this.icon = icon;
        this.text = text;
        this.remind = remind;
    }

    public SettingItem(String icon, String text) {
        this.isGroupTitle = false;
        this.icon = icon;
        this.text = text;
        this.remind = 0;
    }

    public SettingItem(boolean isGroupTitle, String icon, String text) {
        this.isGroupTitle = isGroupTitle;
        this.icon = icon;
        this.text = text;
        this.remind = 0;
    }

    public boolean isNotGroupTitle() {
        return !isGroupTitle;
    }

    public boolean isGroupTitle() {
        return isGroupTitle;
    }

    public void setGroupTitle(boolean groupTitle) {
        isGroupTitle = groupTitle;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRemind() {
        return remind;
    }

    public void setRemind(int remind) {
        this.remind = remind;
    }
}

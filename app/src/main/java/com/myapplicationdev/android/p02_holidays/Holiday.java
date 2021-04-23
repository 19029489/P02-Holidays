package com.myapplicationdev.android.p02_holidays;

public class Holiday {
    private String name;
    private String icon;
    private String date;

    public Holiday(String name, String icon, String date) {
        this.name = name;
        this.icon = icon;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getDate() {
        return date;
    }

}

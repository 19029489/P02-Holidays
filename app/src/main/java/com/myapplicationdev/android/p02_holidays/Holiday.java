package com.myapplicationdev.android.p02_holidays;

public class Holiday {
    private String name;
    private String icon;

    public Holiday(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }
    public String getName() {
        return name;
    }
    public String getIcon() {
        return icon;
    }

}

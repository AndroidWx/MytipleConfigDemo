package com.unicorn.multiple.myapplication;

import android.app.Application;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2015/10/21.
 */
public class MyApplication extends Application {

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private String baseUrl;

    @Override
    public void onCreate() {
        super.onCreate();


    }
}

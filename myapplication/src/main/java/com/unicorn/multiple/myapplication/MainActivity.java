package com.unicorn.multiple.myapplication;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyApplication app = (MyApplication) getApplication();
        try {
            getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        ApplicationInfo info = null;
        try {
            info = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String msg = info.metaData.getString("URL_CHANNEL");

        if (msg.equals("_debug")) {
            app.setBaseUrl("http://www.debug.com");
        } else if (msg.equals("official")) {
            app.setBaseUrl("http://www.official.com");

        } else if (msg.equals("baidu")) {
            app.setBaseUrl("http://www.baidu.com");

        } else if (msg.equals("_360")) {
            app.setBaseUrl("http://www.360.com");

        } else if (msg.equals("yingyongbao")) {
            app.setBaseUrl("http://www.yingyongbao.com");

        } else if (msg.equals("wandoujia")) {
            app.setBaseUrl("http://www.wandoujia.com");

        } else {
            app.setBaseUrl("http://www.undefine.com");
        }


        String netMode = BuildConfig.NET_MODE;
        if (netMode.equalsIgnoreCase("release"))
            app.setBaseUrl(app.getBaseUrl() + "");
        else
            app.setBaseUrl(app.getBaseUrl() + "/debug");

        TextView.class.cast(findViewById(R.id.tv)).setText(app.getBaseUrl());
    }


}

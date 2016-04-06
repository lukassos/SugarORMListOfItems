package com.lukassos.example.sugarormlistofitems;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.lukassos.example.sugarormlistofitems.dummy.DummyContent;
import com.orm.SugarApp;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.UUID;

/**
 * @author lukassos
 * @date 4/2/2016
 * @time 1:09 PM
 * All rights reserved.
 */

public class
        App extends SugarApp {

    private static final String LOGTAG = "App";

    private static Context mContext;
    private static Random r;
    private static App sInstance;
    private DummyContent items;


    public static App getInstance() {
        return sInstance;
    }

    public static List<DummyContent.DummyItem> getItems() {
        return getContent().getITEMS();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        r = new Random();
        mContext = this;

        Log.d("BroadcastRegService", "starting service BroadcastRegService");


        items =  new DummyContent();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Random getRandom() {
        return r;
    }

    public static Context getContext() {
        return mContext;
    }

    public static long getTimestamp() {
        return System.currentTimeMillis();
    }


    public String getUniqueId() {
        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString();
    }

    public static DummyContent getContent() {
        return getInstance().items;
    }
}

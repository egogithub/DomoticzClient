package com.worldline.domoticzclient;

import android.app.Application;

import be.banksys.maps.sync.EventLoop;

public class DmClientApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EventLoop.start();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        EventLoop.stop();
    }
}

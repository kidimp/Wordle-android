package com.chous.wordle;

import android.app.Application;

public class App extends Application {
    // add to manifest "android:name=".App""
    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static App getContext() {
        return mContext;
    }
}
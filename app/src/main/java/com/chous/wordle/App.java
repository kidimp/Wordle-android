package com.chous.wordle;

import android.app.Application;

/**
 * The `App` class extends the Android `Application` class and serves as the entry point for the application.
 * It is responsible for initializing essential components and providing a reference to the application context.
 * To use this class, it should be declared in the AndroidManifest.xml file using the attribute "android:name" as follows:
 * <p>
 * <a/> < application                <br>
 * &#009 android:name=".App"               <br>
 * &#009 ... other attributes>             <br>
 * &#009 ... other configurations          <br>
 * <a/> < / application>             <br>
 * <p>
 * This class includes a private static instance variable (`mContext`) to hold the application context, and a
 * public static method (`getContext()`) to retrieve the application context throughout the application.
 * <p>
 * Example usage to get the application context:
 * App appContext = App.getContext();
 * <p>
 * The `onCreate` method is overridden to initialize the `mContext` variable when the application is created.
 * It is called by the Android system when the application is starting, and it is the appropriate place for
 * one-time initialization of application-wide resources.
 * <p>
 * Note: It's important to add the appropriate declaration in the AndroidManifest.xml file to ensure that the
 * `App` class is used as the application class.
 *
 * @author Kidimp
 * @version 1.0
 * @since 2023-11-30
 */

public class App extends Application {
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
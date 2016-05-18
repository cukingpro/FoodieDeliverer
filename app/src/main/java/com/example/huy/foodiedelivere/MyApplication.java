package com.example.huy.foodiedelivere;

import android.app.Application;
import android.content.Context;

/**
 * Created by huy on 25/04/2016.
 */
public class MyApplication extends Application {
    private static MyApplication sIntence;

    @Override
    public void onCreate() {
        super.onCreate();
        sIntence = this;
    }

    public static MyApplication getInstence(){
        return sIntence;
    }

    public static Context getAppContext(){
        return sIntence.getApplicationContext();
    }
}

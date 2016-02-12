package com.example.pratik.sugarormdemo;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by pratik on 11/02/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}

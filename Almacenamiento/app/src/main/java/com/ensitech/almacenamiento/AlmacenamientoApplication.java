package com.ensitech.almacenamiento;

import android.app.Application;

public class AlmacenamientoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferenceHelper.initSharedPreferences(this);
    }
}

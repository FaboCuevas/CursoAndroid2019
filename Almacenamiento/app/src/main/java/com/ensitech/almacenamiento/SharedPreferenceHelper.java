package com.ensitech.almacenamiento;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void initSharedPreferences(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(
                    context.getPackageName(),
                    Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.apply();
        }
    }

}

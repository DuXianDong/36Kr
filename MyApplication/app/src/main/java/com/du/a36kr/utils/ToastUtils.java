package com.du.a36kr.utils;

import android.widget.Toast;

import com.du.a36kr.ui.app.MyApp;

/**
 * Created by dllo on 16/9/8.
 */
public final class ToastUtils {
    private ToastUtils() {
    }
    private static boolean isDebug = true;
    public static void shortMsg(String msg){
        if (isDebug){
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
    public static void longMsg(String msg){
        if (isDebug){
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

}

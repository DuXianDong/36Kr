package com.du.a36kr.ui.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/9/8.
 * 当前应用 每一个应用只有一个
 * Context 环境
 *
 * 不要忘记在清单文件 注册
 */
public class MyApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

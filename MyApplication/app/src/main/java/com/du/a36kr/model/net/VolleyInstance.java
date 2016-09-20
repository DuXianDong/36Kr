package com.du.a36kr.model.net;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.du.a36kr.ui.app.MyApp;

/**
 * Created by dllo on 16/9/14.
 * Volley使用单利类 请求网络数据
 */
public class VolleyInstance {
    //定义单利
    private static VolleyInstance instance;
    //请求队列
    private RequestQueue queue;

    //私有构造方法
    private VolleyInstance() {
        queue = Volley.newRequestQueue(MyApp.getContext());
    }

    /**
     * 双重校验锁
     */
    //对外提供一个回去对象的方法
    public static VolleyInstance getInstance() {
        //如果该对象是空
        if (instance == null) {
            //全部线程同步扫描
            synchronized (VolleyInstance.class) {
                //如果该对像还是空
                if (instance == null) {
                    //就创建一个对象
                    instance = new VolleyInstance();
                }

            }
        }
        return instance;
    }

    //对外提供请求方法
    public void statRequest(String url, final VolleyResult result) {
        //请求数据
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //如果请求成功将数据储存到接口里
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //请求失败
                result.failure();
            }
        });
        //添加队列
        queue.add(stringRequest);
    }

}

package com.du.a36kr.model.net;

/**
 * Created by dllo on 16/9/14.
 * 网络请求结果接口
 */
public interface VolleyResult {
    //成功
    void success(String resultStr);
    //失败
    void failure();
}

package com.dhcc.mvp.model.base;

/**
 * Created by Lituo on 2017/4/10 0010. 20:09 .
 * Mail：tony1994_vip@163.com
 * 网络访问Model监听
 */

public interface INetListener {

    void onSucceed(String body);

    void onFailed();

    void onError(int responseCode);
}

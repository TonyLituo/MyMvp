package com.dhcc.mvp.model.network;

import com.dhcc.mvp.model.base.INetListener;

import java.util.Map;

/**
 * Created by Lituo on 2017/4/20 0020. 16:27 .
 * Mail：tony1994_vip@163.com
 */

public interface ITestModel {
    void login(Map<String, String> map, INetListener listener);

    void getCode(Map<String, String> map, INetListener listener);
}

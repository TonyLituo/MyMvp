package com.dhcc.mvp.model.network;

import com.dhcc.mvp.model.base.INetListener;
import com.dhcc.mvp.model.base.UICallBack;
import com.dhcc.mvp.model.base.VisaClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by Lituo on 2017/4/20 0020. 16:30 .
 * Mail：tony1994_vip@163.com
 */

public class TestModelIml implements ITestModel {

    private INetListener mListener;

    public void setListener(INetListener listener) {
        this.mListener = listener;
    }

    @Override
    public void login(Map<String, String> map, INetListener listener) {
        setListener(listener);
        // TODO: 2017/4/20 0020 网络请求数据
        VisaClient.getInstance().test(new UICallBack() {
            @Override
            public void onResponseUI(Call call, String body) {
                mListener.onSucceed(body);
            }

            @Override
            public void onFailureUI(Call call, IOException e) {
                mListener.onFailed();
            }

            @Override
            public void onError(int responseCode) {
                mListener.onError(responseCode);
            }
        });
    }

    @Override
    public void getCode(Map<String, String> map, INetListener listener) {
        setListener(listener);
        map = new HashMap<>();
        map.put("key","488c65f3230c0280757b50686d1f1cd5");
        map.put("sort","asc");
        map.put("time","1418816972");


    }
}

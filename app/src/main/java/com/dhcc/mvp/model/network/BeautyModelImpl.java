package com.dhcc.mvp.model.network;

import com.dhcc.mvp.model.base.INetListener;
import com.dhcc.mvp.model.base.UICallBack;
import com.dhcc.mvp.model.base.VisaClient;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Lituo on 2017/4/20 0020. 20:17 .
 * Mail：tony1994_vip@163.com
 */

public class BeautyModelImpl implements IBeautyModel {
    private INetListener mListener;

    public void setListener(INetListener listener) {
        mListener = listener;
    }

    @Override
    public void getBeauty(INetListener listener) {
        setListener(listener);
        VisaClient.getInstance().beauty(new UICallBack() {
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
}

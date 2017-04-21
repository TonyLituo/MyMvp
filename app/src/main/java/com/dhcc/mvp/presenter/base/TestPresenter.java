package com.dhcc.mvp.presenter.base;

import com.dhcc.mvp.model.base.INetListener;
import com.dhcc.mvp.model.bean.Bean;
import com.dhcc.mvp.model.network.ITestModel;
import com.dhcc.mvp.model.network.TestModelIml;
import com.dhcc.mvp.ui.ITestView;

import java.util.Map;

/**
 * Created by Lituo on 2017/4/20 0020. 16:18 .
 * Mail：tony1994_vip@163.com
 */

public class TestPresenter extends BasePresenter<ITestView> {


    private ITestModel mTestModel;

    public TestPresenter() {
        mTestModel = new TestModelIml();
    }

    public void login(Map<String, String> map) {
        getView().showPrgbar();
        mTestModel.login(map, new INetListener() {
            @Override
            public void onSucceed(String body) {
                getView().hidePrgbar();
                Bean bean = gson.fromJson(body, Bean.class);
                getView().loginSuccess(bean);
            }

            @Override
            public void onFailed() {
                getView().hidePrgbar();
                getView().failure();
            }

            @Override
            public void onError(int responseCode) {
                getView().hidePrgbar();
                getView().error(responseCode);
            }
        });
    }

    public void getCode(Map<String, String> map) {
        mTestModel.getCode(map, new INetListener() {
            @Override
            public void onSucceed(String body) {
                getView().hidePrgbar();
                Bean bean = gson.fromJson(body, Bean.class);
                getView().codeSuccess(bean);
            }

            @Override
            public void onFailed() {
                getView().hidePrgbar();
                getView().failure();
            }

            @Override
            public void onError(int responseCode) {
                getView().hidePrgbar();
                getView().error(responseCode);
            }
        });
    }
}

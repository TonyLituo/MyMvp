package com.dhcc.mvp.ui;

import android.support.annotation.NonNull;
import android.view.View;

import com.dhcc.mvp.R;
import com.dhcc.mvp.model.bean.Bean;
import com.dhcc.mvp.presenter.base.TestPresenter;
import com.dhcc.mvp.ui.base.BaseNetActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;

public class TestActivity extends BaseNetActivity<ITestView, TestPresenter> implements ITestView {


    @NonNull
    @Override
    public TestPresenter createPresenter() {
        return new TestPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void loginSuccess(Bean bean) {

    }

    @Override
    public void codeSuccess(Bean bean) {

    }

    @OnClick({R.id.btn_login, R.id.btn_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Map<String, String> map = new HashMap<>();

                presenter.login(map);

                break;
            case R.id.btn_code:

                Map<String, String> mapcode = new HashMap<>();

                presenter.getCode(mapcode);
                break;
        }
    }
}

package com.dhcc.mvp.presenter.base;


import com.dhcc.mvp.ui.base.IBaseView;
import com.google.gson.Gson;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

/**
 * Created by Lituo on 2017/4/5 0005. 16:08 .
 * Mail：tony1994_vip@163.com
 * persenter的基类
 */

public abstract class BasePresenter<V extends IBaseView> extends MvpNullObjectBasePresenter<V> {

    protected Gson gson;

    protected BasePresenter() {
        this.gson = new Gson();
    }
}

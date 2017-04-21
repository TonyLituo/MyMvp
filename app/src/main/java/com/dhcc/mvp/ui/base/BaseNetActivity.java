package com.dhcc.mvp.ui.base;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by Lituo on 2017/4/20 0020. 16:06 .
 * Mail：tony1994_vip@163.com
 */

public abstract class BaseNetActivity<V extends IBaseNetView, P extends MvpPresenter<V>> extends BaseActivity<V,P> implements IBaseNetView {


    @Override
    public void showPrgbar() {

    }

    @Override
    public void hidePrgbar() {

    }

    @Override
    public void failure() {

    }

    @Override
    public void error(int responseCode) {

    }

}

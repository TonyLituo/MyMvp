package com.dhcc.mvp.presenter.home;

import com.dhcc.mvp.common.utils.LogUtils;
import com.dhcc.mvp.model.base.INetListener;
import com.dhcc.mvp.model.bean.Beauty;
import com.dhcc.mvp.model.bean.BeautyBean;
import com.dhcc.mvp.model.network.BeautyModelImpl;
import com.dhcc.mvp.model.network.IBeautyModel;
import com.dhcc.mvp.presenter.base.BasePresenter;
import com.dhcc.mvp.ui.home.IBeautyView;

import java.util.List;

/**
 * Created by Lituo on 2017/4/20 0020. 18:54 .
 * Mail：tony1994_vip@163.com
 */

public class BeautyPresenter extends BasePresenter<IBeautyView> {
    private IBeautyModel mBeautyModel;

    public BeautyPresenter() {
        mBeautyModel = new BeautyModelImpl();
    }

    public void getBeauty() {
        getView().showPrgbar();
        mBeautyModel.getBeauty(new INetListener() {
            @Override
            public void onSucceed(String body) {
                getView().hidePrgbar();
                LogUtils.e(body);
                Beauty beauty = gson.fromJson(body, Beauty.class);
                List<BeautyBean> list = beauty.getBeans();
                LogUtils.e(list.toString());
                getView().beautySuccess(list);
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

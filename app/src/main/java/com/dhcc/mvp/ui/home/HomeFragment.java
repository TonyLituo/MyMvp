package com.dhcc.mvp.ui.home;


import android.view.View;

import com.dhcc.mvp.R;
import com.dhcc.mvp.presenter.HomePresenter;
import com.dhcc.mvp.ui.base.BaseFragment;

import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Lituo on 2017/4/6 0006. 13:02 .
 * Mail：tony1994_vip@163.com
 */

public class HomeFragment extends BaseFragment<IHomeView, HomePresenter> implements IHomeView {


    Unbinder unbinder;

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }


    @OnClick({R.id.btn_beauty, R.id.btn_fuli, R.id.btn_news})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_beauty:
                mActivityUtils.startActivity(BeautyActivity.class);
                break;
            case R.id.btn_fuli:
                break;
            case R.id.btn_news:
                break;
        }
    }
}

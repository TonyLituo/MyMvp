package com.dhcc.mvp.ui.mine;


import com.dhcc.mvp.R;
import com.dhcc.mvp.presenter.MinePresenter;
import com.dhcc.mvp.ui.base.BaseFragment;

/**
 * Created by Lituo on 2017/4/6 0006. 13:03 .
 * Mail：tony1994_vip@163.com
 */

public class MineFragment extends BaseFragment<IMineView, MinePresenter> implements IMineView {

    @Override
    public MinePresenter createPresenter() {
        return new MinePresenter();
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }


}

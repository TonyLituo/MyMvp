package com.dhcc.mvp.ui.found;


import com.dhcc.mvp.R;
import com.dhcc.mvp.common.utils.LogUtils;
import com.dhcc.mvp.presenter.FoundPresenter;
import com.dhcc.mvp.ui.base.BaseFragment;

/**
 * Created by Lituo on 2017/4/6 0006. 11:53 .
 * Mail：tony1994_vip@163.com
 */

public class FoundFragment extends BaseFragment<IFoundView, FoundPresenter> implements IFoundView {


    @Override
    protected void initView() {
       LogUtils.e("===========");
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_found;
    }

    @Override
    public FoundPresenter createPresenter() {
        return new FoundPresenter();
    }
}

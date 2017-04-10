package com.dhcc.mvp.ui.problem;


import com.dhcc.mvp.R;
import com.dhcc.mvp.persenter.ProblemPresenter;
import com.dhcc.mvp.ui.base.BaseFragment;

/**
 * Created by Lituo on 2017/4/6 0006. 15:52 .
 * Mail：tony1994_vip@163.com
 */

public class ProblemFragment extends BaseFragment<IProblemView, ProblemPresenter> implements IProblemView {
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_problem;
    }

    @Override
    public ProblemPresenter createPresenter() {
        return new ProblemPresenter();
    }
}

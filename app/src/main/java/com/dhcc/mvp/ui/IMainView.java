package com.dhcc.mvp.ui;


import com.dhcc.mvp.ui.base.BaseFragment;
import com.dhcc.mvp.ui.base.IBaseView;

/**
 * Created by Lituo on 2017/4/6 0006. 14:18 .
 * Mail：tony1994_vip@163.com
 */

public interface IMainView extends IBaseView {
//切换Fragment
    void showFragment(BaseFragment fragment);
//设置标题
    void setToolTitle(int strigRes);
}

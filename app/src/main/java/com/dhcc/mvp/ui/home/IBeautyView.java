package com.dhcc.mvp.ui.home;

import com.dhcc.mvp.model.bean.BeautyBean;
import com.dhcc.mvp.ui.base.IBaseNetView;

import java.util.List;

/**
 * Created by Lituo on 2017/4/20 0020. 18:51 .
 * Mail：tony1994_vip@163.com
 */

public interface IBeautyView extends IBaseNetView {

    void beautySuccess(List<BeautyBean> list);

    void loadMore(List<BeautyBean> list);
}

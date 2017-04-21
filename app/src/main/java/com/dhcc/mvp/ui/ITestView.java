package com.dhcc.mvp.ui;

import com.dhcc.mvp.model.bean.Bean;
import com.dhcc.mvp.ui.base.IBaseNetView;

/**
 * Created by Lituo on 2017/4/20 0020. 16:20 .
 * Mail：tony1994_vip@163.com
 */

public interface ITestView extends IBaseNetView {

    void loginSuccess(Bean bean);

    void codeSuccess(Bean bean);
}

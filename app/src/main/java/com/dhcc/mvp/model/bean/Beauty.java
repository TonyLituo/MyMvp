package com.dhcc.mvp.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lituo on 2017/4/20 0020. 20:32 .
 * Mail：tony1994_vip@163.com
 */

public class Beauty {

    @SerializedName("美女")
    private List<BeautyBean> beans;

    public List<BeautyBean> getBeans() {
        return beans;
    }

    public void setBeans(List<BeautyBean> beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return "Beauty{" +
                "beans=" + beans +
                '}';
    }
}

package com.dhcc.mvp.ui.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.dhcc.mvp.R;
import com.dhcc.mvp.model.bean.BeautyBean;
import com.dhcc.mvp.presenter.home.BeautyPresenter;
import com.dhcc.mvp.ui.base.BaseNetActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BeautyActivity extends BaseNetActivity<IBeautyView, BeautyPresenter> implements IBeautyView {


    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;
    @BindView(R.id.rv_beauty)
    RecyclerView mRvBeauty;


    private BeautyAdapter mAdapter;

    private List<BeautyBean> mList;

    private BeautyAdapter.OnItemClickLisenter mItemClickLisenter = new BeautyAdapter.OnItemClickLisenter() {
        @Override
        public void onItemClick(View view, int position) {

        }
    };


    @Override
    public int getLayoutResID() {
        return R.layout.activity_beauty;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText("图片");
        mList = new ArrayList<>();
        mAdapter = new BeautyAdapter(this, mList);
        mAdapter.setOnItemClickLisenter(mItemClickLisenter);
        mRvBeauty.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvBeauty.setAdapter(mAdapter);
        presenter.getBeauty();
    }


    @NonNull
    @Override
    public BeautyPresenter createPresenter() {
        return new BeautyPresenter();
    }

    @Override
    public void beautySuccess(List<BeautyBean> list) {
        mAdapter.update(list);
    }

    @Override
    public void loadMore(List<BeautyBean> list) {
        mAdapter.addData(list);
    }


    @OnClick({R.id.base_img_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.base_img_left:
                finish();
                break;
            default:
                break;
        }
    }
}

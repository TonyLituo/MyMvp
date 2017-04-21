package com.dhcc.mvp.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dhcc.mvp.R;
import com.dhcc.mvp.presenter.MainPresenter;
import com.dhcc.mvp.ui.base.BaseActivity;
import com.dhcc.mvp.ui.base.BaseFragment;
import com.dhcc.mvp.ui.found.FoundFragment;
import com.dhcc.mvp.ui.home.HomeFragment;
import com.dhcc.mvp.ui.mine.MineFragment;
import com.dhcc.mvp.ui.problem.ProblemFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IMainView, MainPresenter> implements IMainView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rg_group)
    RadioGroup mRbtnGroup;
    @BindView(R.id.rbtn_home)
    RadioButton mRbtnHome;
    @BindView(R.id.rbtn_found)
    RadioButton mRbtnFound;
    @BindView(R.id.rbtn_problem)
    RadioButton mRbtnProblem;
    @BindView(R.id.rbtn_my_visa)
    RadioButton mRbtnMyVisa;
    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;
    @BindView(R.id.base_tool_right)
    ImageView mBaseToolRight;


    @BindView(R.id.viewpager_main)
    ViewPager mViewpagerMain;
    //判断是否登录
    private boolean isLogin;

    private List<Fragment> mFragments;
    //当前显示的fragment
    private BaseFragment mCurrentFragment;


    private HomeFragment mHomeFragment;
    private FoundFragment mFoundFragment;
    private ProblemFragment mProblemFragment;
    private MineFragment mMineFragment;

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//判断是否登录
        isLogin = presenter.isLogin();

        mFragments = new ArrayList<>();

        mHomeFragment = new HomeFragment();
        mFoundFragment = new FoundFragment();
        mProblemFragment = new ProblemFragment();
        mMineFragment = new MineFragment();

        mFragments.add(mHomeFragment);
        mFragments.add(mFoundFragment);
        mFragments.add(mProblemFragment);
        mFragments.add(mMineFragment);

        mViewpagerMain.setAdapter(new MainAdapter(getSupportFragmentManager(), mFragments));

        mRbtnHome.setChecked(true);

        mViewpagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRbtnHome.setChecked(true);
                        break;
                    case 1:
                        mRbtnFound.setChecked(true);
                        break;
                    case 2:
                        mRbtnProblem.setChecked(true);
                        break;
                    case 3:
                        mRbtnMyVisa.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//RadioBtn没有butterknife绑定选择改变事件
        mRbtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO: 2017/4/6 0006  交易完刷新页面
                switch (checkedId) {
                    case R.id.rbtn_home://主页
                        mViewpagerMain.setCurrentItem(0,false);
                        setToolTitle(R.string.home);

                        mActivityUtils.showToast("待实现，替换为主页  页面");
                        break;
                    case R.id.rbtn_found://发现
                        mViewpagerMain.setCurrentItem(1,false);
                        setToolTitle(R.string.found);

                        mActivityUtils.showToast("待实现，替换为发现  页面");
                        break;
                    case R.id.rbtn_problem://常见问题
                        mViewpagerMain.setCurrentItem(2,false);
                        setToolTitle(R.string.problem);

                        mActivityUtils.showToast("待实现，替换为常见问题  页面");
                        break;
                    case R.id.rbtn_my_visa://我的签证

                        mViewpagerMain.setCurrentItem(3,false);
                        setToolTitle(R.string.my_visa);
                        if (isLogin) {
                            showFragment(mMineFragment);
                        } else {
                            //// TODO: 2017/4/7 0007 显示未登录页面
                        }
                        mActivityUtils.showToast("待实现，替换为我的签证  页面");
                        break;
                    default:

                        throw new UnsupportedOperationException("未知错误");

                }
            }
        });
    }


    //不用ViewPager时候
    @Override
    public void showFragment(BaseFragment fragment) {
//
//        //要显示的页面为当前页面，跳出方法不做操作
//        if (fragment == mCurrentFragment) return;
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        if (null != mCurrentFragment) {
//            transaction.hide(mCurrentFragment);
//        }
//        if (fragment.isAdded()) {//添加过了直接显示
//            transaction.show(fragment);
//        } else {
//            String tag = fragment.getClass().getSimpleName();
//            // 添加Fragment并设置Tag
//            transaction.add(R.id.layout_container, fragment, tag);
//        }
//
//        transaction.commit();
//        mCurrentFragment = fragment;
    }


    @Override
    public void setToolTitle(int stringRes) {
        String s = getResources().getString(stringRes);
        mBaseToolbarTitle.setText(s);
    }


    @OnClick({R.id.base_img_left, R.id.base_toolbar_title, R.id.base_tool_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.base_img_left:
                break;
            case R.id.base_toolbar_title:
                break;
            case R.id.base_tool_right:
                break;
        }
    }
}

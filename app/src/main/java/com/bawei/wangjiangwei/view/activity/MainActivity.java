package com.bawei.wangjiangwei.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseActivity;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.presenter.HomePresenter;
import com.bawei.wangjiangwei.view.fragment.HomeFragment;
import com.bawei.wangjiangwei.view.fragment.OrderFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;

    List<Fragment> fragmentList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    @Override
    protected void initData() {

        HomeFragment homeFragment = new HomeFragment();
        OrderFragment orderFragment = new OrderFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(orderFragment);

        titleList.add("首页");
        titleList.add("订单");

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });

        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }


    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(HomeEntity homeEntity) {

    }

    @Override
    public void error(Throwable throwable) {

    }

}

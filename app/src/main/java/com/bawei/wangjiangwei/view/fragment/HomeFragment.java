package com.bawei.wangjiangwei.view.fragment;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseFragment;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.adapter.HomeAdapter;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {

    @BindView(R.id.et_home)
    EditText etHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.recy)
    RecyclerView recy;

    @Override
    protected void initView(View inflate) {
        recy.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter.getHomeData("板鞋",1,5);
    }

    @Override
    public void success(HomeEntity homeEntity) {

        HomeAdapter homeAdapter = new HomeAdapter(homeEntity.getResult());
        recy.setAdapter(homeAdapter);
    }

    @Override
    public void error(Throwable throwable) {

    }

    @OnClick(R.id.tv_home)
    public void onViewClicked() {
        String s = etHome.getText().toString();
        presenter.getHomeData(s,1,5);
    }
}

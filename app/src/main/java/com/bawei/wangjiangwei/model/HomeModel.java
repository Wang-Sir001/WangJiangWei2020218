package com.bawei.wangjiangwei.model;

import com.bawei.wangjiangwei.api.HomeApiServise;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bawei.wangjiangwei.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(String keyword, int page, int count, HomeModelCallback homeModelCallback) {
        NetUtils.getInstance().getClass(HomeApiServise.class)
                .getHomeData(keyword,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeEntity homeEntity) {

                            homeModelCallback.success(homeEntity);

                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallback.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

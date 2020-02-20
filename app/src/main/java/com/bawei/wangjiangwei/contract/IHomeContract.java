package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.base.mvp.IBaseModel;
import com.bawei.wangjiangwei.base.mvp.IBaseView;
import com.bawei.wangjiangwei.model.entity.HomeEntity;

public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getHomeData(String keyword,int page,int count,HomeModelCallback homeModelCallback);

        interface HomeModelCallback{
            void success(HomeEntity homeEntity);
            void error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(HomeEntity homeEntity);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getHomeData(String keyword,int page,int count);
    }
}

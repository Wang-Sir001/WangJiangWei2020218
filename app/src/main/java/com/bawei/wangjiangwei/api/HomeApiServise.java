package com.bawei.wangjiangwei.api;

import com.bawei.wangjiangwei.model.entity.HomeEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HomeApiServise {
    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<HomeEntity> getHomeData(@Query("keyword") String keyword,
                                       @Query("page") int page,
                                       @Query("count") int count);
}

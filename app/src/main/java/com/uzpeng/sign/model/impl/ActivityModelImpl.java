package com.uzpeng.sign.model.impl;

import com.uzpeng.sign.entity.ActivityEntity;
import com.uzpeng.sign.model.ActivityModel;
import com.uzpeng.sign.net.ActivityService;
import com.uzpeng.sign.net.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author serverliu on 2017/12/13.
 */

public class ActivityModelImpl implements ActivityModel {

  private DataCallback dataCallback;


  @Override
  public void registerDataCallback(DataCallback dataCallback) {
    this.dataCallback = dataCallback;
  }

  @Override
  public void requestActivityList() {
    Retrofit retrofit2 = new Retrofit.Builder().baseUrl(Url.REQUEST_ACT)
      .addConverterFactory(GsonConverterFactory.create()).build();

    ActivityService activityService = retrofit2.create(ActivityService.class);
    Call<ActivityEntity>  call = activityService.activityList();

    call.enqueue(new Callback<ActivityEntity>() {
      @Override
      public void onResponse(Call<ActivityEntity> call, Response<ActivityEntity> response) {
        //todo 写一个通用的响应判断模块
        dataCallback.onResponseActivityList(response.body());
      }

      @Override
      public void onFailure(Call<ActivityEntity> call, Throwable t) {
        dataCallback.onResponseActivityList(new ActivityEntity());
      }
    });
  }

}

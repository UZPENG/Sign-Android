package com.uzpeng.sign.net;

import com.uzpeng.sign.entity.ActivityEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author serverliu on 2017/12/13.
 */

public interface ActivityService {
  @GET(Url.REQUEST_ACT)
  Call<ActivityEntity> activityList();
}

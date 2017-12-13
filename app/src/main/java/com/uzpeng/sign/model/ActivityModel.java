package com.uzpeng.sign.model;

import com.uzpeng.sign.entity.ActivityEntity;

/**
 * @author serverliu on 2017/12/13.
 */

public interface ActivityModel {


  /**
   * 注册回调
   */
  void registerDataCallback(DataCallback callback);

  /**
   * 请求活动列表
   */
  void requestActivityList();


  interface DataCallback{
    /**
     * 返回活动列表
     */
     void onResponseActivityList(ActivityEntity activityEntity);
  }
}

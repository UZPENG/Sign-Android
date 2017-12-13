package com.uzpeng.sign.view;

import com.uzpeng.sign.entity.ActivityEntity;

/**
 * @author serverliu on 2017/12/13.
 */

public interface ActivityView {

  /**
   * 注册请求函数
   */
  void registerAction(Action action);

  /**
   * 活动列表数据回传
   */
  void onResponseActivityList(ActivityEntity entity);

  /**
   * 签到状态回传
   */
  void onResponseSignState();


  interface Action {
    /**
     * 初始化数据
     */
    void requestActivityList();

    /**
     * @param type 用户身份
     *             管理员身份发起签到；普通用户实行签到
     */
    void requestSign(int type);
  }
}


package com.uzpeng.sign.presenter;

import com.uzpeng.sign.model.ActivityModel;
import com.uzpeng.sign.view.ActivityView;

/**
 * @author serverliu on 2017/12/13.
 */

public interface ActivityPresenter {

  /**
   * 绑定view和model
   */
  void bind(ActivityView view, ActivityModel model);

}

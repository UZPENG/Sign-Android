package com.uzpeng.sign.presenter.impl;

import com.uzpeng.sign.entity.ActivityEntity;
import com.uzpeng.sign.model.ActivityModel;
import com.uzpeng.sign.presenter.ActivityPresenter;
import com.uzpeng.sign.view.ActivityView;

/**
 * @author serverliu on 2017/12/13.
 */

public class ActivityPresenterImpl implements ActivityPresenter,ActivityView.Action,ActivityModel.DataCallback {

  private ActivityView activityView;
  private ActivityModel activityModel;

  @Override
  public void bind(ActivityView view, ActivityModel model) {
    this.activityView = view;
    this.activityModel = model;

    activityModel.registerDataCallback(this);
    activityView.registerAction(this);
  }

  @Override
  public void requestActivityList() {
    activityModel.requestActivityList();
  }

  @Override
  public void requestSign(int type) {

  }

  @Override
  public void  onResponseActivityList(ActivityEntity activityEntity) {
    activityView.onResponseActivityList(activityEntity);
  }
}

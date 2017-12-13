package com.uzpeng.sign.view.impl;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.uzpeng.sign.R;
import com.uzpeng.sign.entity.ActivityEntity;
import com.uzpeng.sign.fragment.ActivityFragment;
import com.uzpeng.sign.model.ActivityModel;
import com.uzpeng.sign.model.impl.ActivityModelImpl;
import com.uzpeng.sign.presenter.ActivityPresenter;
import com.uzpeng.sign.presenter.impl.ActivityPresenterImpl;
import com.uzpeng.sign.view.ActivityView;

public class MainActivity extends AppCompatActivity implements ActivityView,ActivityView.Action{

  private BottomNavigationView buttomNavigateView;
  private FrameLayout content;

  private ActivityView.Action action;
  private ActivityFragment activityFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActivityModel activityModel = new ActivityModelImpl();
    ActivityPresenter activityPresenter = new ActivityPresenterImpl();
    activityPresenter.bind(this, activityModel);

    initView();
  }

  private void initView(){
    buttomNavigateView = findViewById(R.id.navigation_view);
    content = findViewById(R.id.navigation_content);

    activityFragment = new ActivityFragment();
    getSupportFragmentManager().beginTransaction()
      .add(R.id.navigation_content, activityFragment, activityFragment.getClass().getSimpleName())
      .commit();
  }

  @Override
  public void registerAction(Action action) {
    this.action = action;
  }

  @Override
  public void requestActivityList() {
    action.requestActivityList();
  }

  @Override
  public void requestSign(int type) {

  }

  @Override
  public void onResponseActivityList(ActivityEntity entity) {
    activityFragment.initData(entity);
  }

  @Override
  public void onResponseSignState() {

  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
}

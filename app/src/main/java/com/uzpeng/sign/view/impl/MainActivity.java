package com.uzpeng.sign.view.impl;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.uzpeng.sign.R;
import com.uzpeng.sign.entity.ActivityEntity;
import com.uzpeng.sign.fragment.ActivityFragment;
import com.uzpeng.sign.fragment.CourseFragment;
import com.uzpeng.sign.fragment.PersonalFragment;
import com.uzpeng.sign.model.ActivityModel;
import com.uzpeng.sign.model.impl.ActivityModelImpl;
import com.uzpeng.sign.presenter.ActivityPresenter;
import com.uzpeng.sign.presenter.impl.ActivityPresenterImpl;
import com.uzpeng.sign.view.ActivityView;

public class MainActivity extends AppCompatActivity implements ActivityView,ActivityView.Action{

  private ActivityView.Action action;
  private ActivityFragment activityFragment;
  private PersonalFragment personalFragment;
  private CourseFragment courseFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActivityModel activityModel = new ActivityModelImpl();
    ActivityPresenter activityPresenter = new ActivityPresenterImpl();
    activityPresenter.bind(this, activityModel);

    initView();
    initData();
  }

  private void initView(){
    BottomNavigationView bottomNavigateView = findViewById(R.id.navigation_view);
    bottomNavigateView.setOnNavigationItemSelectedListener((view) -> {
      switch (view.getItemId()){
        case R.id.activity:
          if(activityFragment == null) {
            activityFragment = new ActivityFragment();
          }
          getSupportFragmentManager().beginTransaction()
            .replace(R.id.navigation_content, activityFragment, activityFragment.getClass().getSimpleName())
            .commit();
          break;

        case R.id.course:
          if(courseFragment == null){
            courseFragment = new CourseFragment();
          }
          getSupportFragmentManager().beginTransaction()
            .replace(R.id.navigation_content, courseFragment, courseFragment.getClass().getSimpleName())
            .commit();
          break;

        case R.id.personal:
          if(personalFragment == null) {
            personalFragment = new PersonalFragment();
          }
          getSupportFragmentManager().beginTransaction()
            .replace(R.id.navigation_content, personalFragment, personalFragment.getClass().getSimpleName())
            .commit();
          break;
      }
      return true;
    });

    activityFragment = new ActivityFragment();
    getSupportFragmentManager().beginTransaction()
            .add(R.id.navigation_content, activityFragment, activityFragment.getClass().getSimpleName())
            .commit();
  }

  private void initData(){
    requestActivityList();
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

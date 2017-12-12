package com.uzpeng.sign.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.uzpeng.sign.R;

public class MainActivity extends AppCompatActivity {

  private BottomNavigationView buttomNavigateView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }

  private void initView(){
    buttomNavigateView = findViewById(R.id.navigation_view);

  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
}

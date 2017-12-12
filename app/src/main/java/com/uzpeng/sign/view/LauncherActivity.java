package com.uzpeng.sign.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.uzpeng.sign.R;

public class LauncherActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_launcher);

    //todo
    Handler handler = new Handler();
    handler.postDelayed(()->{

    }, 2000);
  }
}

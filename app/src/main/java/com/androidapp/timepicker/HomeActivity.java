package com.androidapp.timepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content_home);
        layout.setOnTouchListener(new OnSwipeTouchListener(this) {

                                      public void onSwipeRight() {

                                      }

                                      public void onSwipeLeft() {
                                          TransitionHelper.transition(HomeActivity.this, SecondActivity.class, true);
                                      }
                                  }
        );

    }

    @Override
    public void onBackPressed() {
        finish();
    }


}

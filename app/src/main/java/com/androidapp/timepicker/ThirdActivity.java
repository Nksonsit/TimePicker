package com.androidapp.timepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content_third);
        layout.setOnTouchListener(new OnSwipeTouchListener(this) {

                                      public void onSwipeRight() {
                                          TransitionHelper.transition(ThirdActivity.this, SecondActivity.class, false);
                                          finish();
                                      }

                                      public void onSwipeLeft() {
                                      }
                                  }
        );

    }

    @Override
    public void onBackPressed() {
//        finish();
        TransitionHelper.transition(ThirdActivity.this, SecondActivity.class, false);
        finish();
    }


}

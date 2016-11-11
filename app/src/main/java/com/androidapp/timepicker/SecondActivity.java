package com.androidapp.timepicker;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RelativeLayout;

public class SecondActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content_second);
        layout.setOnTouchListener(new OnSwipeTouchListener(this) {

                                      public void onSwipeRight() {
                                          TransitionHelper.transition(SecondActivity.this, HomeActivity.class, false);
                                          finish();
                                      }

                                      public void onSwipeLeft() {
                                          TransitionHelper.transition(SecondActivity.this, ThirdActivity.class, true);
                                      }
                                  }
        );


        Fragment first=new FirstFragment();
        manager = getSupportFragmentManager();
        ft = manager.beginTransaction();
        ft.replace(R.id.content, first, FirstFragment.class.getSimpleName());
        ft.commit();


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("2","2");
                Fragment second=new SecondFragment();
                manager = getSupportFragmentManager();
                ft = manager.beginTransaction();
                ft.replace(R.id.content, second, SecondFragment.class.getSimpleName());
                ft.commit();
            }
        },3000);




    }

    @Override
    public void onBackPressed() {
//        finish();
        TransitionHelper.transition(SecondActivity.this, HomeActivity.class, false);
        finish();
    }

}

package com.androidapp.timepicker;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DayViewActivity extends FragmentActivity {

    private TableLayout table;
    private LinearLayout timeView;
    private LinearLayout eventView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        timeView = (LinearLayout) findViewById(R.id.timeview);
        eventView = (LinearLayout) findViewById(R.id.eventview);

        TextView textView=new TextView(this);
        TextView textView1=new TextView(this);
        TextView textView2=new TextView(this);
        TextView textView3=new TextView(this);


        for(int i=0;i<10;i++){
            TextView t=new TextView(this);
            t.setGravity(Gravity.CENTER);
            t.setBackgroundColor(Color.parseColor("#915621"));
            t.setWidth(300);
            t.setHeight(300);
            t.setTextColor(Color.parseColor("#ffffff"));
            t.setText("Hello");

            //eventView.addView(t);


            TextView t1=new TextView(this);
            t1.setGravity(Gravity.CENTER);
            t1.setBackgroundColor(Color.parseColor("#915621"));
            t1.setWidth(300);
            t1.setHeight(300);
            t1.setTextColor(Color.parseColor("#ffffff"));
            t1.setText("Hello");

           // timeView.addView(t1);
        }

        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.parseColor("#915621"));
        textView.setWidth(300);
        textView.setHeight(300);
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setText("Hello");

        textView1.setGravity(Gravity.CENTER);
        textView1.setText("Hello1");
        textView1.setBackgroundColor(Color.parseColor("#452191"));
        textView1.setWidth(300);
        textView1.setHeight(300);
        textView1.setTextColor(Color.parseColor("#ffffff"));

        textView2.setGravity(Gravity.CENTER);
        textView2.setText("Hello2");
        textView2.setBackgroundColor(Color.parseColor("#2176a1"));
        textView2.setWidth(300);
        textView2.setHeight(300);
        textView2.setTextColor(Color.parseColor("#ffffff"));

        textView3.setGravity(Gravity.CENTER);
        textView3.setText("Hello3");
        textView3.setTextColor(Color.parseColor("#ffffff"));
        textView3.setBackgroundColor(Color.parseColor("#456698"));
        textView3.setWidth(300);
        textView3.setHeight(300);

//        timeView.addView(textView);
//        timeView.addView(textView1);
//        timeView.addView(textView2);
//        timeView.addView(textView3);

//        eventView.addView(textView);
//        eventView.addView(textView1);
//        eventView.addView(textView2);
//        eventView.addView(textView3);


    }

}

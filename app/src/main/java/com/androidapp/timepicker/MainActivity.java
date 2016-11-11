package com.androidapp.timepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView sTime;
    private TextView eTime;
    private String initStartTime;
    private String initEndTime;
    private Time time;
    private ArrayList<Time> timeList;
    private boolean correct = false;
    private RecyclerView timeSloatList;
    private TimeSloatAdapter adapter;
    private float diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStartTime = "00:00";
        initEndTime = "00:00";
        time = new Time(initStartTime, initEndTime);
        timeList = new ArrayList<>();
        timeList.add(new Time("00:00", "24:00"));

        sTime = (TextView) findViewById(R.id.stime);
        eTime = (TextView) findViewById(R.id.etime);

        sTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                        .setOnTimeSetListener(new RadialTimePickerDialogFragment.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
                                sTime.setText(hourOfDay + ":" + minute);
                            }
                        })
                        .setDoneText("DONE")
                        .setCancelText("CANCEL")
                        .setForced24hFormat();
                rtpd.show(getSupportFragmentManager(), "MainActivity");
            }
        });


        eTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                        .setOnTimeSetListener(new RadialTimePickerDialogFragment.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
                                eTime.setText(hourOfDay + ":" + minute);
                            }
                        })
                        .setDoneText("DONE")
                        .setCancelText("CANCEL")
                        .setForced24hFormat();
                rtpd.show(getSupportFragmentManager(), "MainActivity");
            }
        });


//        getTime("06:20", "10:00");
//        getTime("18:00", "24:00");
        Button btn = (Button) findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sTime.getText().toString().trim().equals("From Time") && !eTime.getText().toString().trim().equals("To Time")) {
                    diff = (Float.valueOf(sTime.getText().toString().trim().replace(":", "."))) - (Float.valueOf(eTime.getText().toString().trim().replace(":", ".")));
                    if (diff >= 4) {
                        getTime(sTime.getText().toString().trim(), eTime.getText().toString().trim());
                    } else {
                        Toast.makeText(MainActivity.this, "Please select atleast 4 hour time interval.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please select time interval.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        adapter = new TimeSloatAdapter(this, timeList);
        timeSloatList = (RecyclerView) findViewById(R.id.freesloat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        timeSloatList.setLayoutManager(linearLayoutManager);
        timeSloatList.setAdapter(adapter);
    }

    public void getTime(String startTime, String endTime) {
        correct = false;
        Time time1 = timeList.get(0);
        Time a = new Time(initStartTime, startTime);
        Time b = new Time(endTime, initEndTime);

        //Log.e("compare", startTime.compareTo(endTime) + " " + endTime.compareTo(startTime));

        for (int i = 0; i < timeList.size(); i++) {
            Time t = timeList.get(i);
            String pattern = "HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);

            try {
                Date d1 = sdf.parse(t.getStartTime());
                Date d2 = sdf.parse(t.getEndTime());

                Date ds = sdf.parse(startTime);
                Date de = sdf.parse(endTime);
                if (!correct) {
                    if ((ds.compareTo(d1) >= 0) && (d2.compareTo(ds) >= 0)) {
                        //Log.e(startTime, "in");
                        if ((de.compareTo(d1) >= 0) && (d2.compareTo(de) >= 0)) {
                            Log.e(startTime, endTime);
                            correct = true;
                            changeList(timeList.get(i), new Time(startTime, endTime));
                            break;
                        } else {
                            Toast.makeText(MainActivity.this, "Please select valid time interval please see suggestion.", Toast.LENGTH_SHORT).show();
                            continue;
//                            Log.e(startTime + " " + endTime, "out");
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Please select valid time interval please see suggestion.", Toast.LENGTH_SHORT).show();
                        continue;
//                        Log.e(startTime + " " + endTime, "out");

                    }

                }
            } catch (ParseException e) {
            }
        }

        adapter.notifyDataSetChanged();
    }

    public void changeList(Time oldT, Time newT) {
        for (int i = 0; i < timeList.size(); i++) {
            Log.e("time", timeList.get(i).toString());
        }
        ArrayList<Time> list = new ArrayList<>();
        Time new1 = new Time(oldT.getStartTime(), newT.getStartTime());
        Time new2 = new Time(newT.getEndTime(), oldT.getEndTime());
        timeList.remove(oldT);
        timeList.add(new1);
        timeList.add(new2);
        for (int i = 0; i < timeList.size(); i++) {
            Log.e("time", timeList.get(i).toString());
        }
    }
}

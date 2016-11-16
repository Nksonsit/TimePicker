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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView sTime;
    private TextView eTime;
    private String initStartTime;
    private String initEndTime;
    private ArrayList<Studio> timeList;
    private boolean correct = false;
    private RecyclerView timeSloatList;
    private TimeSloatAdapter adapter;
    private float diff;
    private ArrayList<Studio> sugList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStartTime = "00:00";
        initEndTime = "00:00";
        timeList = new ArrayList<>();
        timeList.add(new Studio("10:00", "14:00", "1", "11", "2016"));
        timeList.add(new Studio("1:00", "5:00", "1", "11", "2016"));
        timeList.add(new Studio("6:00", "10:00", "1", "11", "2016"));
        //timeList.add(new Studio("17:00", "22:00","1","11","2016"));

//        timeList.add(new Studio("00:00", "24:00","1","11","2016"));

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
                    diff = (Float.valueOf(eTime.getText().toString().trim().replace(":", "."))) - (Float.valueOf(sTime.getText().toString().trim().replace(":", ".")));
                    Log.e("diff", diff + "");
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
        Collections.sort(timeList, new Comparator<Studio>() {
            @Override
            public int compare(Studio studio, Studio t1) {
                float st = Float.valueOf(studio.getStime().toString().trim().replace(":", "."));
                float et = Float.valueOf(t1.getStime().toString().trim().replace(":", "."));
                Log.e("" + st, "" + et);
                return ((int) st) - ((int) et);
            }
        });
        sugList = sugList(timeList);
        Collections.sort(sugList, new Comparator<Studio>() {
            @Override
            public int compare(Studio studio, Studio t1) {
                float st = Float.valueOf(studio.getStime().toString().trim().replace(":", "."));
                float et = Float.valueOf(t1.getStime().toString().trim().replace(":", "."));
                Log.e("" + st, "" + et);
                return ((int) st) - ((int) et);
            }
        });
        adapter = new TimeSloatAdapter(this, sugList(sugList));
        timeSloatList = (RecyclerView) findViewById(R.id.freesloat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        timeSloatList.setLayoutManager(linearLayoutManager);

        timeSloatList.setAdapter(adapter);
    }

    public void getTime(String startTime, String endTime) {
        correct = false;
        //Log.e("compare", startTime.compareTo(endTime) + " " + endTime.compareTo(startTime));

        for (int i = 0; i < timeList.size(); i++) {
            Studio t = timeList.get(i);
            String pattern = "HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);

            try {
                Date d1 = sdf.parse(t.getStime());
                Date d2 = sdf.parse(t.getEtime());

                Date ds = sdf.parse(startTime);
                Date de = sdf.parse(endTime);
                if (!correct) {
                    if ((ds.compareTo(d1) >= 0) && (d2.compareTo(ds) >= 0)) {
                        //Log.e(startTime, "in");
                        if ((de.compareTo(d1) >= 0) && (d2.compareTo(de) >= 0)) {
                            Log.e(startTime, endTime);
                            correct = true;
                            changeList(timeList.get(i), new Studio(startTime, endTime));
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

        Collections.sort(timeList, new Comparator<Studio>() {
            @Override
            public int compare(Studio studio, Studio t1) {
                float st = Float.valueOf(studio.getStime().toString().trim().replace(":", "."));
                float et = Float.valueOf(t1.getStime().toString().trim().replace(":", "."));
                Log.e("" + st, "" + et);
                return ((int) st) - ((int) et);
            }
        });
        sugList = sugList(timeList);
        Collections.sort(sugList, new Comparator<Studio>() {
            @Override
            public int compare(Studio studio, Studio t1) {
                float st = Float.valueOf(studio.getStime().toString().trim().replace(":", "."));
                float et = Float.valueOf(t1.getStime().toString().trim().replace(":", "."));
                Log.e("" + st, "" + et);
                return ((int) st) - ((int) et);
            }
        });
        adapter.notifyDataSetChanged();
    }

    public ArrayList<Studio> sugList(ArrayList<Studio> list) {
        String s = "00:00";
        String e = "24:00";
        ArrayList<Studio> list1 = new ArrayList<>();
//        Log.e(list.get(0).getStime().toString().trim().equals("00:00")&&list.get(list.size()-1).getEtime().toString().trim().equals("24:00"))
        if (list.get(0).getStime().toString().trim().equals("00:00")&&list.get(list.size()-1).getEtime().toString().trim().equals("24:00")) {
            for (int i = 1; i < list.size()-1; i++) {
                list1.add(new Studio(list.get(i).getEtime(), list.get(i + 1).getStime()));
            }
        }else if (list.get(0).getStime().toString().trim().equals("00:00")&&!list.get(list.size()-1).getEtime().toString().trim().equals("24:00")) {
            for (int i = 0; i < list.size() - 1; i++) {
                list1.add(new Studio(list.get(i).getEtime(), list.get(i + 1).getStime()));
            }
            list1.add(new Studio(list.get(list.size() - 1).getEtime(), "24:00"));
        }else if (!list.get(0).getStime().toString().trim().equals("00:00")&&list.get(list.size()-1).getEtime().toString().trim().equals("24:00")) {
            list1.add(new Studio("00:00", list.get(0).getStime()));
            for (int i = 1; i < list.size(); i++) {
                list1.add(new Studio(list.get(i).getEtime(), list.get(i + 1).getStime()));
            }
        } else {
            list1.add(new Studio("00:00", list.get(0).getStime()));
            for (int i = 1; i < list.size() - 1; i++) {
                list1.add(new Studio(list.get(i).getEtime(), list.get(i + 1).getStime()));
            }
            list1.add(new Studio(list.get(list.size() - 1).getEtime(), "24:00"));
        }
        return list1;
    }

    public void changeList(Studio oldT, Studio newT) {
        for (int i = 0; i < timeList.size(); i++) {
            Log.e("time", timeList.get(i).toString());
        }
        ArrayList<Time> list = new ArrayList<>();
        Studio new1 = new Studio(oldT.getStime(), newT.getStime());
        Studio new2 = new Studio(newT.getEtime(), oldT.getEtime());
        timeList.remove(oldT);
        timeList.add(new1);
        timeList.add(new2);
        for (int i = 0; i < timeList.size(); i++) {
            Log.e("time", timeList.get(i).toString());
        }
    }
}

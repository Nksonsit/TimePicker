package com.androidapp.timepicker;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by priyasindkar on 07-11-2016.
 */

public class TimeSloatAdapter extends RecyclerView.Adapter<TimeSloatAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<Studio> timeList;

    public TimeSloatAdapter(Activity activity, ArrayList<Studio> timeList) {

        this.activity = activity;
        this.timeList = timeList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sloat_item, parent, false);

        return new TimeSloatAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.sTime.setText(timeList.get(position).getStime());
        holder.eTime.setText(timeList.get(position).getEtime());
    }

    @Override
    public int getItemCount() {
        return timeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView sTime;
        public TextView eTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            sTime = (TextView) itemView.findViewById(R.id.stime);
            eTime = (TextView) itemView.findViewById(R.id.etime);
        }
    }
}

package com.androidapp.timepicker;

import android.app.Activity;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishan on 02-11-2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Activity mActivity;
    private List<String> CommonList;
    private OnItemClickedListener mOnItemClickedListener;

    public interface OnItemClickedListener {
        void onItemClicked(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txt);
        }
    }

    public MyAdapter(Activity mActivity, List<String> CommonList) {
        this.CommonList = CommonList;
        this.mActivity = mActivity;
//        mOnItemClickedListener=onItemClickedListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(CommonList.get(position));

    }


    @Override
    public int getItemCount() {
        return CommonList.size();
    }


}


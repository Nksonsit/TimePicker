package com.androidapp.timepicker;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishan on 24-10-2016.
 */

public class FirstFragment extends Fragment {
    private View view;
    private RecyclerView timeList;

    public void FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment, container, false);

        timeList = (RecyclerView) view.findViewById(R.id.timeList);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add("abcd" + 1);
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        timeList.setLayoutManager(mLayoutManager);
        timeList.setItemAnimator(new DefaultItemAnimator());
        MyAdapter adapter = new MyAdapter(getActivity(), list);
        timeList.setAdapter(adapter);
        return view;
    }

}

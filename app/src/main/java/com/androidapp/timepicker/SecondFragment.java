package com.androidapp.timepicker;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishan on 24-10-2016.
 */

public class SecondFragment extends Fragment {
    private View view;
    private RecyclerView eventList;

    public void SecondFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment2, container, false);

        eventList = (RecyclerView) view.findViewById(R.id.eventList);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add("abcd" + 1);
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        eventList.setLayoutManager(mLayoutManager);
        eventList.setItemAnimator(new DefaultItemAnimator());
        MyAdapter adapter = new MyAdapter(getActivity(), list);
        eventList.setAdapter(adapter);
        return view;
    }

}

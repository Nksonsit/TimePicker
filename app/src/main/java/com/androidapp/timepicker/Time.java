package com.androidapp.timepicker;

/**
 * Created by ishan on 02-11-2016.
 */

public class Time {
    String StartTime;
    String EndTime;

    public Time() {
    }

    @Override
    public String toString() {
        return "Time{" +
                "StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                '}';
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public Time(String startTime, String endTime) {

        StartTime = startTime;
        EndTime = endTime;
    }
}

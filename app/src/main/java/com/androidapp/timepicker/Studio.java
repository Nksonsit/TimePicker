package com.androidapp.timepicker;

/**
 * Created by ishan on 16-11-2016.
 */
public class Studio {
    String id;
    String stime,etime,date,emailid,day,month,year;

    public Studio(String stime, String etime, String day, String month, String year) {
        this.stime = stime;
        this.etime = etime;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Studio(String stime, String etime) {
        this.stime = stime;
        this.etime = etime;
    }

    public Studio() {
    }

    public Studio(String id, String stime, String etime, String date, String emailid, String day, String month, String year) {
        this.id = id;
        this.stime = stime;
        this.etime = etime;
        this.date = date;
        this.emailid = emailid;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id='" + id + '\'' +
                ", stime='" + stime + '\'' +
                ", etime='" + etime + '\'' +
                ", date='" + date + '\'' +
                ", emailid='" + emailid + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

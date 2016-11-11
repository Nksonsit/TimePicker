package com.androidapp.timepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

//import com.gun0912.tedpermission.PermissionListener;
//import com.gun0912.tedpermission.TedPermission;



import java.util.Calendar;

/**
 * Created by raghavthakkar on 23-09-2016.
 */

public class TransitionHelper {

    public static void transition(Context context, Class cls, boolean isNewActivity) {
        Intent i = new Intent(context, cls);
        context.startActivity(i);
        Activity activity = (Activity) context;
        if (!isNewActivity) {
            activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        } else {
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }
}

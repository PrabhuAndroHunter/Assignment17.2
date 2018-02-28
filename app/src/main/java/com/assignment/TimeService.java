package com.assignment;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prabhu on 28/2/18.
 */

public class TimeService extends Service {
    private final String TAG = TimeService.class.toString();
    private final IBinder binder = new ServiceBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class ServiceBinder extends Binder {
        public TimeService getService() {
            return TimeService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getTime() {// Creating method
        // SimpleDateFormat is a concrete class for formatting and parsing dates .
        SimpleDateFormat simpleDateFormat = null; // Creating object
        //Applying the condition for getting the date and time
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Setting date format
        }/* else {
            return simpleDateFormat.format(new Date());//returns the date
        }*/
        return simpleDateFormat.format(new Date()); // returns the date
    }
}

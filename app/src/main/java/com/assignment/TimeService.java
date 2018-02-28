package com.assignment;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

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

    // this method will return current time
    public String getTime() {
        SimpleDateFormat simpleDateFormat = null;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // defining time format
        return simpleDateFormat.format(new Date()); // returns the date
    }
}

package com.assignment;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private Button mShowTimeBtn;
    private TextView mShowTimeTv;
    private TimeService timeService;

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            timeService = ((TimeService.ServiceBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            timeService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init layout
        setContentView(R.layout.activity_main);
        // init save button and time textview
        mShowTimeBtn = (Button) findViewById(R.id.btn_showTime);
        mShowTimeTv = (TextView) findViewById(R.id.tv_show_time);

        //set onclick listener on save button
        mShowTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowTimeTv.setText(timeService.getTime()); // set current time
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, TimeService.class);
        this.bindService(intent, connection, BIND_AUTO_CREATE); // bind TimeService
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unbindService(connection); // unbind TimeService
    }
}

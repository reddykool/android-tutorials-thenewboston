package com.example.reddyz.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.reddyz.boundservice.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity {

    MyService myService ;
    boolean isBound = false;

    public void showTime(View v) {
        String currTime = myService.getCurrentTime();
        TextView myText = (TextView)findViewById(R.id.myTextView);
        myText.setText(currTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyService.class);
        bindService(i, myServiceConn, Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection myServiceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
           MyLocalBinder localBinder = (MyLocalBinder)service;
            myService = localBinder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}

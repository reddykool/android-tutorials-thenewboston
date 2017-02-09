package com.example.reddyz.boundservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {
    private final IBinder myBinder = new MyLocalBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyLocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    public String getCurrentTime() {
        SimpleDateFormat dateF = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return dateF.format(new Date());
    }
}

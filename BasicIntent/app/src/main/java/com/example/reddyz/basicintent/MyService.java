package com.example.reddyz.basicintent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;

public class MyService extends Service {

    private static String TAG="com.example.reddyz.basicintent";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
    return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++) {
                    long futureTime = System.currentTimeMillis() +5000;
                    while(System.currentTimeMillis() <futureTime) {
                        synchronized (this){
                            try{
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "onStartCommand running");
                            } catch ( Exception e){}
                        }
                    }
                }
                Log.i(TAG, "onStartCommand runnable end");
            }
        };
        Log.i(TAG, "onStartCommand before thread");
        Thread myThread1 = new Thread(r);
        myThread1.start();
        Log.i(TAG, "onStartCommand started thread");

        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }
}

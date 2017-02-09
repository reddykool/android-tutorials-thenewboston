package com.example.reddyz.basicintent;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Reddyz on 27-09-2016.
 */
public class MyIntentService extends IntentService{

    private static final String TAG = "com.example.reddyz.basicintent";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "Service is now Running...");
    }
}

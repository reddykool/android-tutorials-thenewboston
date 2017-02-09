package com.example.reddyz.receivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverBroadcast extends BroadcastReceiver {
    public ReceiverBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String recvdMsg = intent.getStringExtra("GrabMillion");
        Toast.makeText(context, "Broadcast received Successfully +++", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, recvdMsg, Toast.LENGTH_LONG).show();
    }
}

package com.example.reddyz.sednbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickSendBroadcast(View vw) {
        Intent intent = new Intent();
        intent.setAction("com.example.reddyz.sednbroadcast");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra("GrabMillion", "$ Million $ Dollars $ Transferred $");
        sendBroadcast(intent);
    }

}

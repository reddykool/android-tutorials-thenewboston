package com.example.reddyz.basicfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements TopFragment.TopFragmentListener {

    private String TAG="ReddyzLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"MainActivity->OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void createMeme(String top, String bottom) {
        Log.i(TAG,"MainActivity->createMeme");
        BottomFragment bottomFragment = (BottomFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setBottomFragmentTexts(top, bottom);

    }
}

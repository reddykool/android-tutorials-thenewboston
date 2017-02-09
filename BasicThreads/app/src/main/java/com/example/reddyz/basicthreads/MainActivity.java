package com.example.reddyz.basicthreads;

import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int clickCount = 1;
    static int threadEndCount = 1;

    //@ ways to handle thread execution completion.
    //1. Anonymous object with class implemented within defination;
    Handler andler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView txt = (TextView)findViewById(R.id.myTextView);
            txt.setText("Job Done... Now! "+threadEndCount);
            threadEndCount++;
        }
    };

    //2. new class with respective objected defined seperately;
    MyHandler handler2 = new MyHandler();

    private class MyHandler extends Handler {
        int threadEndCount2 = 1;
        public void handleMessage(Message msg) {
            TextView txt = (TextView)findViewById(R.id.myTextView);
            txt.setText("Job Done well... Now! "+threadEndCount2);
            threadEndCount2++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickedButton(View v) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        } catch (Exception e) {}
                    }
                }
                //handler.sendEmptyMessage(0);
                handler2.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(r);
        thread.start();
        TextView myText = (TextView)findViewById(R.id.myButton);
        myText.setText("Clicked."+clickCount);
        clickCount++;
    }

}

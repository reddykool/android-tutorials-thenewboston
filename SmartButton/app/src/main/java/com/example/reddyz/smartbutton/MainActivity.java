package com.example.reddyz.smartbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button)findViewById(R.id.myButton);
        myButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView myText = (TextView)findViewById(R.id.myText);
                        myText.setText("Hey...You are Millionaire...");
                    }
                }
        );

        myButton.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        TextView myText = (TextView)findViewById(R.id.myText);
                        myText.setText("Hey...You are now a Billionaire...");
                        return false;
                    }
                }
        );
    }
}

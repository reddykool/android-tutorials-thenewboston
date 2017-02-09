package com.example.reddyz.basicintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent = new Intent(this,MyService.class);
        startService(serviceIntent);
    }

    public void onClick(View v)
    {
        Intent i = new Intent(this, SecondaryActivity.class);

        final EditText inputText = (EditText) findViewById(R.id.homeInputText);
        String inputMsg = inputText.getText().toString();
        i.putExtra("homeInputMsg", inputMsg);
        startActivity(i);
    }
}

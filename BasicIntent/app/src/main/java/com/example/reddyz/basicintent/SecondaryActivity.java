package com.example.reddyz.basicintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle homeData = getIntent().getExtras();
        if(homeData == null)
        {
            return;
        }
        String homeInputMsg = homeData.getString("homeInputMsg");
        final TextView showText = (TextView) findViewById(R.id.secShowText);
        showText.setText(homeInputMsg);
    }

    public void onClick(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

package com.example.reddyz.basicjavalyout;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String txt = "Million";
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        RelativeLayout rLayout = new RelativeLayout(this);
        rLayout.setBackgroundColor(Color.BLUE);

        Button btn = new Button(this);
        btn.setBackgroundColor(Color.CYAN);
        btn.setText(txt);

        EditText userName = new EditText(this);

        btn.setId(1);
        userName.setId(2);

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        userNameDetails.addRule(RelativeLayout.ABOVE,btn.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0,0,0,60);

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,r.getDisplayMetrics());
        userName.setWidth(px);
        userName.setTextColor(Color.RED);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        rLayout.addView(userName, userNameDetails);
        rLayout.addView(btn, buttonDetails);

        setContentView(rLayout);
    }
}

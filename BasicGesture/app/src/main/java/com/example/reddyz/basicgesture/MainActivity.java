package com.example.reddyz.basicgesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {

    private TextView myText;
    private GestureDetectorCompat gDetector;

    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (TextView)findViewById(R.id.myText);
        this.gDetector = new GestureDetectorCompat(this, this);
        gDetector.setOnDoubleTapListener(this);

        myButton = (Button)findViewById(R.id.clickButton);
        myButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myText.setText("ohoh..That was Tap!");
                    }
                }
        );

        myButton.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        myText.setText("ohohohoh..That was Loooong Tap!");
                        return true;
                    }
                }
        );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //Begin Gestures
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        myText.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        myText.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        myText.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        myText.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        myText.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        myText.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        myText.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        myText.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        myText.setText("onFling");
        return true;
    }
}

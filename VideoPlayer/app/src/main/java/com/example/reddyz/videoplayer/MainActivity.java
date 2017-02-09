package com.example.reddyz.videoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    static final String TAG="Reddyz-Log";
    static boolean playLocal = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView myVidView = (VideoView) findViewById(R.id.myVideoView);

        if( playLocal ) {
            //from local system

            //myVidView.setVideoPath("E:\\Tech\\dev\\mvid.mp4"); //- Not working
            //Uri uri = Uri.parse("android.resource://videoplayer/raw"+R.raw.mvid); //- Not working
            //Uri uri = Uri.parse("android.resource://videoplayer/raw/mvid"); //- Not working
            Uri uri = Uri.parse("android.resource://" +getPackageName()+ "/"+R.raw.samplevideo5mb);
            myVidView.setVideoURI(uri);
            Log.i(TAG, "Uri :" + uri.toString());
        } else {
            //From internet link
            //myVidView.setVideoPath("https://vimeo.com/78961286"); //- Not working
            //myVidView.setVideoPath("http://www.android-examples.com/wp-content/uploads/2016/01/sample_video.3gp"); //- Working
            myVidView.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4"); //Working
        }

        //Vido player oontrols(play, pause, next, prev
        MediaController myMediaControl = new MediaController(this);
        myMediaControl.setAnchorView(myVidView);
        myVidView.setMediaController(myMediaControl);

        myVidView.start();

    }
}

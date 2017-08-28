package com.example.youngji.videoplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

/**
 * Created by youngji on 2017. 7. 26..
 */

public class VideoViewActivity extends AppCompatActivity{

    private VideoView videoView;
    private String playURL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realvideoview_layout);

        videoView = (VideoView) findViewById(R.id.videoView);

        Bundle b = getIntent().getExtras();

        playURL = b.getString("requestURL");

        System.out.println("------playURL------ : "+playURL);


        videoView.setVideoPath(playURL);


    }
}

package com.example.youngji.videoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by youngji on 2017. 7. 26..
 */

public class VideoActivity extends AppCompatActivity {
    private com.devbrackets.android.exomedia.ui.widget.VideoView videoView;
    private String playURL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview_layout);

        videoView = (com.devbrackets.android.exomedia.ui.widget.VideoView) findViewById(R.id.video_view);



        Bundle b = getIntent().getExtras();

        playURL = b.getString("requestURL");


        if(playURL.length() < 10){
            playURL = "http://192.168.0.27:8080/Volume/Homes/admin/Public/bunny.mp4";
        }
        else{
            playURL = b.getString("requestURL");
        }

        System.out.println("------playURL------ : "+playURL);

        if(playURL.contains("/sdcard/")){
            videoView.setVideoPath(playURL);
        }
        else{
            videoView.setVideoURI(Uri.parse(playURL));
        }





    }
}

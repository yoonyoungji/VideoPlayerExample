package com.example.youngji.videoplayer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

//    ffmpeg -loglevel debug -y -i rtsp://admin:admin@192.168.0.152:554/ufirststream
//            -c copy -map 0:v -f segment -segment_list test.m3u8  -segment_format mpegs -seg
//    ment_list_flags +live -segment_wrap 360 -segment_time 10 %02d.ts

    private EditText httpurl_input;
    private Button playButton;

    private String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpurl_input = (EditText) findViewById(R.id.inputURL);
        playButton = (Button) findViewById(R.id.playButton);

        if (shouldAskPermissions()) {
            askPermissions();
        }

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    url = "rtsp://admin:admin@192.168.0.152/ufirststream";
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                }
                System.out.println("----sendURL---- : "+ url);

                Bundle b = new Bundle();
                b.putString("requestURL", url);

                Intent nextPage = new Intent(MainActivity.this, VideoViewActivity.class);

                nextPage.putExtras(b);
                startActivity(nextPage);


            }
        });
    }


    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }

}

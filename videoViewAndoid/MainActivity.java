package com.example.myvideoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //The video is stored in raw
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vid);
        videoView = findViewById(R.id.videoViewid);
        videoView.setVideoURI(uri);


        MediaController mediacontroler = new MediaController(this);

        videoView.setMediaController(mediacontroler);
        videoView.start();

    }
}

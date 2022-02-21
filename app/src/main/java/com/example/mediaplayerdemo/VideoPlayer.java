package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

//        videoView = findViewById(R.id.videoView);
//        MediaController mediaController = new MediaController(this);
//
//        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.big_buck_bunny);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.start();


    }
}
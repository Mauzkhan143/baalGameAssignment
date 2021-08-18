package com.example.baalgameassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class Congrates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrates);
        VideoView videoView =findViewById(R.id.videoView2);
        String videoPath =getPackageName()+R.raw.congra;
        videoView.setVideoPath(videoPath);
        videoView.start();
    }
}
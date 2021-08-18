package com.example.baalgameassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class Start extends AppCompatActivity {
    AudioManager ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        VideoView videoView =findViewById(R.id.videoView);
        String videoPath =getPackageName()+R.raw.go;
        videoView.setVideoPath(videoPath);
        videoView.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start.this,levelOne.class);
                startActivity(intent);
                finish();

            }
        },3000);

    }
}
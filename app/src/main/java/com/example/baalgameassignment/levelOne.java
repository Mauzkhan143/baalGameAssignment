package com.example.baalgameassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class levelOne extends AppCompatActivity {

    ImageView greenBall1;
    Handler handler;
    MediaPlayer mediaPlayer;
    AudioManager am1;
    int cV;
    int MxV;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);

        greenBall1 =  findViewById(R.id.gball1);
        Button tryBtn = findViewById(R.id.again2);



        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelOne.this,levelOne.class));
        });
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                play();


            }
        },1000);
    }




    private void play()
    {

        greenBall1.setAlpha(1f);
        greenBall1.animate().translationXBy(2000f).setDuration(4000);
    }
    public void ballClicked(View v)
    {
        mediaPlayer.start();
        finish();
        startActivity(new Intent(levelOne.this, levelTwo.class));
    }

}
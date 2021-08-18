package com.example.baalgameassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class levelTwo extends AppCompatActivity {


    ImageView greenBall2;
    Handler handler;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);
        greenBall2 =  findViewById(R.id.gball2);
        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelTwo.this,levelTwo.class));
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
        greenBall2.setAlpha(1f);
        greenBall2.animate().translationXBy(2000f).translationYBy(1000f).setDuration(2500);
    }
    public void ballClicked(View v)
    {
        mediaPlayer.start();
        finish();
        startActivity(new Intent(levelTwo.this, levelThree.class));
    }
}
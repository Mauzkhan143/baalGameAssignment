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
import android.widget.Toast;

public class levelFive extends AppCompatActivity {


    ImageView blueBall5;
    ImageView redBall5;
    Handler handler;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);


        redBall5 = findViewById(R.id.rBall5);
        blueBall5 = findViewById(R.id.bBall5);

        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelFive.this, levelFive.class));
        });
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                playRed();
                playBlue();
            }
        }, 1000);
    }

    private void playRed()
    {

        redBall5.setAlpha(1f);
        redBall5.animate().translationXBy(-2000f).setDuration(4000);
    }

    private void playBlue()
    {

        blueBall5.setAlpha(1f);
        blueBall5.animate().translationYBy(2000f).setDuration(4000);
    }

    public void redBallClicked(View view)
    {
        mediaPlayer.start();
        Toast.makeText(this, "On Red Ball Clicked You loss", Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(levelFive.this,MainActivity.class));
    }
    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        startActivity(new Intent(levelFive.this,levelSix.class));
    }
}
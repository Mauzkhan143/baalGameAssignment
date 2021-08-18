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

public class levelSix extends AppCompatActivity {


    ImageView blueBall6;
    ImageView redBall6;
    ImageView greenBall6;
    Handler handler;
    int ballClicked = 0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_six);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);

        blueBall6= findViewById(R.id.bBall6);
        redBall6 = findViewById(R.id.rBall6);
        greenBall6 = findViewById(R.id.gBall6);

        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelSix.this, levelSix.class));
        });

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                playRed();
                playBlue();
                playGreen();
            }
        }, 1000);
    }

    private void playGreen()
    {

        greenBall6.setAlpha(1f);
        greenBall6.animate().translationXBy(2000f).setDuration(4000);
    }

    private void playBlue()
    {

        blueBall6.setAlpha(1f);
        blueBall6.animate().translationYBy(2000f).setDuration(4000);
    }

    private void playRed()
    {
        redBall6.setAlpha(1f);
        redBall6.animate().translationXBy(2000f).setDuration(4000);
    }

    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blueBall6.setVisibility(View.GONE);
    }

    public void  redBallClicked(View view)
    {
        mediaPlayer.start();
        Toast.makeText(this, "Red ball clicked you loose", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(levelSix.this, MainActivity.class));
    }

    public void greenBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        greenBall6.setVisibility(View.GONE);
    }
    private void checkBallsClicked()
    {
        ballClicked++;
        if (ballClicked==2)
        {
            finish();
            startActivity(new Intent(levelSix.this, levelSeven.class));
        }
    }
}
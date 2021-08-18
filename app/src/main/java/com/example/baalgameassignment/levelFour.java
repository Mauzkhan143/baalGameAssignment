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

public class levelFour extends AppCompatActivity {
    ImageView greenBall4;
    ImageView blueBall4;
    ImageView blackBall4;
    Handler handler;
    int ballClicked = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);

        greenBall4 = findViewById(R.id.gball4);
        blueBall4 = findViewById(R.id.bBall4);
        blackBall4 = findViewById(R.id.blBall4);
        Button tryBtn = findViewById(R.id.again2);




        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                playGreen();
                playBlue();
                playBlack();

            }
        }, 1000);
    }

    public void tryAgain4(View view)
    {
        finish();
        startActivity(new Intent(levelFour.this, levelFour.class));
    }
    private void playBlack()
    {
        blackBall4.setAlpha(1f);
        blackBall4.animate().translationXBy(2000f).translationYBy(-1000).setDuration(4000);
    }

    private void playBlue()
    {
        blueBall4.setAlpha(1f);
        blueBall4.animate().translationYBy(2000f).setDuration(4000);
    }

    private void playGreen()
    {
        greenBall4.setAlpha(1f);
        greenBall4.animate().translationXBy(2000f).setDuration(4000);
    }

    public void blackBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blackBall4.setVisibility(View.GONE);
    }

    public void greenBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        greenBall4.setVisibility(View.GONE);
    }

    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blueBall4.setVisibility(View.GONE);
    }
    private void checkBallsClicked()
    {
        ballClicked++;
        if (ballClicked==3)
        {
            finish();
            startActivity(new Intent(levelFour.this, levelFive.class));
        }
    }
}
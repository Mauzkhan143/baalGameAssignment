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

public class levelEight extends AppCompatActivity {


    ImageView blueBall8;
    ImageView redBall8;
    ImageView greenBall8;
    Handler handler;
    int ballClicked = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_eight);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);

        blueBall8= findViewById(R.id.bBall8);
        redBall8 = findViewById(R.id.rBall8);
        greenBall8 = findViewById(R.id.gBall8);

        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelEight.this, levelEight.class));
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

        greenBall8.setAlpha(1f);
        greenBall8.animate().translationXBy(2000f).setDuration(3200);
    }
    private void playBlue()
    {

        blueBall8.setAlpha(1f);
        blueBall8.animate().translationXBy(2000f).setDuration(4000);
    }
    private void playRed()
    {

        redBall8.setAlpha(1f);
        redBall8.animate().translationXBy(2000f).translationYBy(2000f).setDuration(3200);
    }
    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blueBall8.setVisibility(View.GONE);
    }

    public void  redBallClicked(View view)
    {
        mediaPlayer.start();
        Toast.makeText(this, "On Red ball clicked you loss", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(levelEight.this, MainActivity.class));
    }

    public void greenBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        greenBall8.setVisibility(View.GONE);
    }
    private void checkBallsClicked()
    {
        ballClicked++;
        if (ballClicked==2)
        {
            finish();
            startActivity(new Intent(levelEight.this, levelNine.class));
        }
    }
}
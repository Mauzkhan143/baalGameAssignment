package com.example.baalgameassignment;

import androidx.annotation.NonNull;
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

public class levelNine extends AppCompatActivity {


    ImageView blueBall9;
    ImageView redBall9;
    ImageView greenBall9;
    Handler handler;
    int ballClicked = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_nine);


        blueBall9= findViewById(R.id.bBall9);
        redBall9 = findViewById(R.id.rBall9);
        greenBall9 = findViewById(R.id.gBall9);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);

        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelNine.this, levelNine.class));
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

        greenBall9.setAlpha(1f);
        greenBall9.animate().translationXBy(2000f).translationYBy(-2000f).setDuration(3800);
    }
    private void playBlue()
    {

        blueBall9.setAlpha(1f);
        blueBall9.animate().translationXBy(2000f).setDuration(4000);
    }
    private void playRed()
    {

        redBall9.setAlpha(1f);
        redBall9.animate().translationXBy(2000f).translationYBy(2000f).setDuration(3800);
    }
    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blueBall9.setVisibility(View.GONE);
    }

    public void  redBallClicked(View view)
    {
        mediaPlayer.start();
        Toast.makeText(this, "Red ball clicked you loose", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(levelNine.this, MainActivity.class));
    }

    public void greenBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        greenBall9.setVisibility(View.GONE);
    }
    private void checkBallsClicked()
    {
        ballClicked++;
        if (ballClicked==2)
        {
            finish();
            startActivity(new Intent(levelNine.this, levelTen.class));
        }
    }
}
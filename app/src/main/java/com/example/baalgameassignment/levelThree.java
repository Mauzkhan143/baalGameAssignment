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

public class levelThree extends AppCompatActivity {

    ImageView greenBall3;
    ImageView blueBall3;
    Handler handler;
    int ballClicked = 0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);

        greenBall3 = findViewById(R.id.gball3);
        blueBall3 = findViewById(R.id.bBall3);
        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelThree.this,levelThree.class));
        });
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                playGreen();
                playBlue();

            }
        },1000);
    }

    private void playGreen()
    {

        greenBall3.setAlpha(1f);
        greenBall3.animate().translationXBy(-2000f).setDuration(4000);
    }

    private void playBlue()
    {

        blueBall3.setAlpha(1f);
        blueBall3.animate().translationXBy(2000f).setDuration(4000);
    }
    public void greenBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        greenBall3.setVisibility(View.GONE);
    }

    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blueBall3.setVisibility(View.GONE);
    }
    private void checkBallsClicked()
    {
        ballClicked++;
        if (ballClicked==2)
        {
            finish();
            startActivity(new Intent(levelThree.this, levelFour.class));
        }
    }

}

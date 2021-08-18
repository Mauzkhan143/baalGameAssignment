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

public class levelTen extends AppCompatActivity {


    ImageView blueBall10;
    ImageView redBall10;
    ImageView greenBall10;
    ImageView blackBall10;
    Handler handler;
    int ballClicked = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_ten);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);

        blueBall10= findViewById(R.id.bBall10);
        redBall10 = findViewById(R.id.rBall10);
        greenBall10 = findViewById(R.id.gBall10);
        blackBall10 = findViewById(R.id.blBall10);
        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelTen.this, levelTen.class));
        });
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                playRed();
                playBlue();
                playGreen();
                playBlack();
            }
        }, 1000);
    }
   // @Override
    //public boolean dispatchKeyEvent(KeyEvent event) {

      //  int a=event.getAction();
       // int kC=event.getKeyCode();
       // switch (kC){
        //    case  KeyEvent.KEYCODE_VOLUME_DOWN:
         //       if (a == KeyEvent.ACTION_DOWN){

             //   }
               // return true;



        //}

        //return super.dispatchKeyEvent(event);
   // }

    private void playBlack()
    {

        blackBall10.setAlpha(1f);
        blackBall10.animate().translationXBy(-2000f).translationYBy(-1500f).setDuration(4500);
    }

    private void playGreen()
    {

        greenBall10.setAlpha(1f);
        greenBall10.animate().translationXBy(-2000f).translationYBy(-1500f).setDuration(4500);
    }
    private void playBlue()
    {

        blueBall10.setAlpha(1f);
        blueBall10.animate().translationXBy(2000f).translationYBy(1500f).setDuration(4500);
    }
    private void playRed()
    {

        redBall10.setAlpha(1f);
        redBall10.animate().translationXBy(2000f).translationYBy(1500f).setDuration(4500);
    }

    public void blackBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blackBall10.setVisibility(View.GONE);
    }
    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blueBall10.setVisibility(View.GONE);
    }

    public void  redBallClicked(View view)
    {
        mediaPlayer.start();
        Toast.makeText(this, "Red ball clicked you loose", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(levelTen.this, MainActivity.class));
    }

    public void greenBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        greenBall10.setVisibility(View.GONE);
    }
    private void checkBallsClicked()
    {
        ballClicked++;
        if (ballClicked==3)
        {
            finish();
            startActivity(new Intent(levelTen.this, Congrates.class));
        }
    }
}
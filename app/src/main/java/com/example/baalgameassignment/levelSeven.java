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

public class levelSeven extends AppCompatActivity {

    ImageView blueBall7;
    ImageView redBall7;
    ImageView greenBall7;
    Handler handler;
    int ballClicked = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_seven);
        mediaPlayer=MediaPlayer.create(this,R.raw.hit);


        blueBall7= findViewById(R.id.bBall7);
        redBall7 = findViewById(R.id.rBall7);
        greenBall7 = findViewById(R.id.gBall7);

        Button tryBtn = findViewById(R.id.again2);

        tryBtn.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(levelSeven.this, levelSeven.class));
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
   // @Override
    //public boolean dispatchKeyEvent(KeyEvent event) {

      //  int a=event.getAction();
       // int kC=event.getKeyCode();
       // switch (kC){
        //    case  KeyEvent.KEYCODE_VOLUME_DOWN:
         //       if (a == KeyEvent.ACTION_DOWN){

          //      }
            //    return true;



        //}

      //  return super.dispatchKeyEvent(event);
    //}
    private void playGreen()
    {

        greenBall7.setAlpha(1f);
        greenBall7.animate().translationXBy(2000f).setDuration(2500);
    }
    private void playBlue()
    {

        blueBall7.setAlpha(1f);
        blueBall7.animate().translationXBy(2000f).setDuration(4000);
    }
    private void playRed()
    {

        redBall7.setAlpha(1f);
        redBall7.animate().translationXBy(2000f).setDuration(3000);
    }
    public void blueBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        blueBall7.setVisibility(View.GONE);
    }

    public void  redBallClicked(View view)
    {
        mediaPlayer.start();
        Toast.makeText(this, "Red ball clicked you loose", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(levelSeven.this, MainActivity.class));
    }

    public void greenBallClicked(View view)
    {
        mediaPlayer.start();
        checkBallsClicked();
        greenBall7.setVisibility(View.GONE);
    }
    private void checkBallsClicked()
    {
        ballClicked++;
        if (ballClicked==2)
        {
            finish();
            startActivity(new Intent(levelSeven.this, levelEight.class));
        }
    }
}
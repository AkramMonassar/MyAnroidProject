package com.example.akram.athkar;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Akram on 8/29/2016.
 */
public class MainActiv_3_2 extends Activity{
    MediaPlayer mp3;
    Button run2,pause2,stop2;
    int x=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_3_2);

        mp3=MediaPlayer.create(this,R.drawable.athkar22mp3);
        if(mp3.isPlaying())
        {
            mp3.stop();
        }
        run2=(Button)findViewById(R.id.run2);
        pause2=(Button)findViewById(R.id.pause2);
        stop2=(Button)findViewById(R.id.stop2);

        run2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });
        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.pause();
            }
        });
        stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                   mp3.stop();
                    finish();
                }
            }
        });


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp3.stop();
    }
}

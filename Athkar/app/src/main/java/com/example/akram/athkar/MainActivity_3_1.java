package com.example.akram.athkar;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Akram on 8/20/2016.
 */
public class MainActivity_3_1 extends Activity{
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_1);

        Button run=(Button)findViewById(R.id.run2);
        Button pause=(Button)findViewById(R.id.pause2);

        Button back=(Button)findViewById(R.id.back2);
        mp=MediaPlayer.create(MainActivity_3_1.this,R.drawable.athkarmp3);




        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop(); finish();
            }
        });





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}


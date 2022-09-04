package com.example.akram.athkar;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Akram on 8/20/2016.
 */
public class MainActivity_4_1 extends Activity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_1);
        Button run=(Button)findViewById(R.id.run3);
        //Button stop=(Button)findViewById(R.id.stop3);
        Button pause=(Button)findViewById(R.id.pause3);
        mp=MediaPlayer.create(MainActivity_4_1.this,R.drawable.athkarmp3);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        /*stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();

                Intent i=new Intent(MainActivity_4_1.this,MainActivity_4_1.class);
                startActivity(i);
            }
        });*/
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        Button b_ayat=(Button)findViewById(R.id.b_ayatt_2);
        Button b_doaa=(Button)findViewById(R.id.b_doaa);

        final TextView text1=(TextView)findViewById(R.id.text1_2);
        //text1.setVisibility(text1.VISIBLE);
        final TextView text2=(TextView)findViewById(R.id.text2_2);
        //text2.setVisibility(text2.VISIBLE);
        final TextView text3=(TextView)findViewById(R.id.text3);
        //text3.setVisibility(text3.VISIBLE);
        final TextView text4=(TextView)findViewById(R.id.text4);
        //text4.setVisibility(text4.VISIBLE);
        final TextView text5=(TextView)findViewById(R.id.text5);
        //*****************************************************
        final TextView text11=(TextView)findViewById(R.id.text11);
        final TextView text22=(TextView)findViewById(R.id.text22);
        final TextView text33=(TextView)findViewById(R.id.text33);
        final TextView text44=(TextView)findViewById(R.id.text44);
        final TextView text55=(TextView)findViewById(R.id.text55);


       b_ayat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               text11 .setVisibility(text11.INVISIBLE );
               text22 .setVisibility(text22.INVISIBLE );
               text33 .setVisibility(text33.INVISIBLE );
               text44 .setVisibility(text44.INVISIBLE );
               text55 .setVisibility(text55.INVISIBLE );


               text1.setVisibility(text1.VISIBLE);
               text2.setVisibility(text2.VISIBLE);
               text3.setVisibility(text3.VISIBLE);
               text4.setVisibility(text4.VISIBLE);
               text5.setVisibility(text5.VISIBLE);
           }
       });
        b_doaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                text1 .setVisibility(text1.INVISIBLE );
                text2 .setVisibility(text2.INVISIBLE );
                text3 .setVisibility(text3.INVISIBLE );
                text4 .setVisibility(text4.INVISIBLE );
                text4 .setVisibility(text5.INVISIBLE );

                text11.setVisibility(text11.VISIBLE);
                text22.setVisibility(text22.VISIBLE);
                text33.setVisibility(text33.VISIBLE);
                text44.setVisibility(text44.VISIBLE);
                text55.setVisibility(text55.VISIBLE);



                //finish();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}

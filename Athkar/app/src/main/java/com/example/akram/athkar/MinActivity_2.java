package com.example.akram.athkar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Akram on 8/19/2016.
 */
public class MinActivity_2 extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2);
        Button listene=(Button)findViewById(R.id.b1_listen_2);
        Button reade=(Button)findViewById(R.id.btnMultipleFragment);
        Button back=(Button)findViewById(R.id.b3_listen);




        Toast.makeText(this,"الاذكار المسموعة والمقرؤة",Toast.LENGTH_LONG).show();

        listene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MinActivity_2.this, MainActivity_3_1.class);
                startActivity(a);
            }
        });
        reade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MinActivity_2.this,MainActivity_4_1.class);
                startActivity(a);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MinActivity_2.this,MainActivity.class);
                startActivity(i);
            }
        });



        
        /*
        final   Button show=(Button)findViewById(R.id.b3);
        final EditText val=(EditText)findViewById(R.id.edit1);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b=(Button)v;
               String data=val.getText().toString();

                Toast.makeText(getBaseContext(),"شكراً لك ياً"+data,Toast.LENGTH_LONG).show();
            }
        });




*/


    }

}

package com.example.akram.athkar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.akram.multiplefrag.MultiFragActivity;

/**
 * Created by Akram on 8/19/2016.
 */
public class MinActivity_2_2 extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2_2);
        Button listene2=(Button)findViewById(R.id.b1_listen_2);

        Button back2=(Button)findViewById(R.id.b3_listen_2);




        Toast.makeText(this,"الاذكار المسموعة والمقرؤة",Toast.LENGTH_LONG).show();

        listene2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MinActivity_2_2.this, MainActiv_3_2.class);
                startActivity(b);
            }
        });


        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MinActivity_2_2.this, MainActivity.class);
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

    public void multiple(View view)
    {
        Intent intent=new Intent(getApplicationContext(),MultiFragActivity.class);
        startActivity(intent);
    }
}

package com.example.akram.sapaha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.akram.athkar.R;

/**
 * Created by akram on 9/7/2016.
 */
public class SapahaActivity extends Activity {
    int counter_integer=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sapaha);





    }

    public void increaseInteger(View view)
    {

       counter_integer=counter_integer+1;
        display(counter_integer);
    }
    public void display(int number)
    {
        TextView display_integer=(TextView)findViewById(R.id.counter);

        display_integer.setText(""+number);
    }


    public void set_zero_for_counter(View view)
    {
        TextView display_integer=(TextView)findViewById(R.id.counter);
       //finish();
        //Intent i=new Intent(this,SapahaActivity.class);
        //startActivity(i);
        counter_integer=0;
        display_integer.setText(""+0);
    }
}

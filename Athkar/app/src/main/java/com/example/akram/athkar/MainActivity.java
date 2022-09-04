package com.example.akram.athkar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akram.sapaha.SapahaActivity;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//***********************************************************************


//************************************************************************
        Button go_act2 = (Button) findViewById(R.id.b1_listen_2);
        Button go_act2_2 = (Button) findViewById(R.id.btnMultipleFragment);
        Button about = (Button) findViewById(R.id.b3);
        go_act2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MinActivity_2.class);
                startActivity(i);
            }
        });
try {
   go_act2_2.setOnClickListener(new OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent w=new Intent(MainActivity.this,MinActivity_2_2.class);
           startActivity(w);
       }
   });

}catch (Exception e)
{
  Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
}

        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, setting.class);
                startActivity(i);
            }
        });


        //WelcomeAction action=new WelcomeAction();// create object from class button implement onclicklistener  // and show.setoncliklis(object); send ob
        // show.setOnClickListener(new button1());// Others way write
        //b2.setOnClickListener(new button2());// Others way write

    }

    public void sapaha(View view)
    {
       Intent intent=new Intent(MainActivity.this, SapahaActivity.class);
        startActivity(intent);
    }

    public void end(View view)
    {
        finish();
    }


    class button1 implements OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(getBaseContext(), "هذه اذكار الصباح", Toast.LENGTH_LONG).show();

        }

    }

    class button2 implements OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(getBaseContext(), "هذه اذكار المساء", Toast.LENGTH_LONG).show();

        }

    }
//**********************************************************************88


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater mymenu = getMenuInflater();
        mymenu.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        TextView textv = (TextView) findViewById(R.id.t_menu);
        int id=item.getItemId();
        //***************************
        if (id==R.id.select)
        {
            textv.setText("select item menu item");
        }
        else if(id==R.id.exit)
        {
            textv.setText("select exit menu item");
        }
        return super.onOptionsItemSelected(item);

    }


}
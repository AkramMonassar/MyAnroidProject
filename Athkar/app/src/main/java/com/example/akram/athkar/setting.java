package com.example.akram.athkar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Akram on 8/19/2016.
 */
public class setting extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        Button developer=(Button)findViewById(R.id.bu1);
        Button dev_numb=(Button)findViewById(R.id.bu2);
        Button about=(Button)findViewById(R.id.bu3);

        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://alasbahi1234@gmail.com"));
                startActivity(i);

            }
        });
        dev_numb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Intent.ACTION_DIAL);
                a.setData(Uri.parse("tel:" + "00967775180222"));
                startActivity(a);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(setting.this,About.class);
                startActivity(a);



                /*
                Intent a = new Intent(setting.this,MainActivity.class);
               // a.putExtra("data", "التطبيق النسخة الأولى وسنوافيكم بأحدث التطورات");
                a.putExtra("version", 1);

                startActivity(a);
                */
            }
        });





    }
}

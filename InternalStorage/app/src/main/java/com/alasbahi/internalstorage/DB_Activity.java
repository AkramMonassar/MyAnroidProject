package com.alasbahi.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DB_Activity extends AppCompatActivity {

    TextView username1,password1,email1,firstname1,lastname1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        username1=(TextView) findViewById(R.id.username_textview);
        password1=(TextView) findViewById(R.id.password_textview);
        email1=(TextView) findViewById(R.id.email_textview);
        firstname1=(TextView) findViewById(R.id.firstname_textview);
        lastname1=(TextView) findViewById(R.id.lastname_textview);
    }

    public void Show(View view) {
        String m="";
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=openFileInput("Akram.txt");
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while ((read=fileInputStream.read())!=-1)
            {
                buffer.append((char) read);
            }
            Log.d(buffer.toString() , "Show: Akram");

            m=buffer.toString();
            String[] data=m.split(" ");
            String username2=data[0];
            String password2=data[1];
            String email2=data[2];
            String firstname2=data[3];
            String lastname2=data[4];

            username1.setText(username2);
            password1.setText(password2);
            email1.setText(email2);
            firstname1.setText(firstname2);
            lastname1.setText(lastname2);

        }catch (FileNotFoundException e)
        {
            Toast.makeText(this,"file Not Found",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getBaseContext(),"Data found !"+m,Toast.LENGTH_LONG).show();
    }

    public void Back(View view) {
        Toast.makeText(getBaseContext(),"To main ",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
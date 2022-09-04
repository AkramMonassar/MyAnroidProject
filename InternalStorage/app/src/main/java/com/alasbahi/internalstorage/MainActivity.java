package com.alasbahi.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText username1,password1,email1,firstname1,lastname1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username1=(EditText) findViewById(R.id.editTextUserName);
        password1=(EditText) findViewById(R.id.editTextPassword);
        email1=(EditText) findViewById(R.id.editTextEmail);
        firstname1=(EditText) findViewById(R.id.editTextFirstName);
        lastname1=(EditText) findViewById(R.id.editTextLastName);
    }

    public void Save(View view) {
        String username2=username1.getText().toString();
        String password2=password1.getText().toString();
        String email2=email1.getText().toString();
        String firstname2=firstname1.getText().toString();
        String lastname2=lastname1.getText().toString();

        File file=null;

        username2=username2+" ";
        password2=password2+" ";
        email2=email2+" ";
        firstname2=firstname2+" ";
        lastname2=lastname2+" ";

        FileOutputStream fileOutputStream=null;
        try {
            file=getFilesDir();
            fileOutputStream=openFileOutput("Akram.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(username2.getBytes());
            fileOutputStream.write(password2.getBytes());
            fileOutputStream.write(email2.getBytes());
            fileOutputStream.write(firstname2.getBytes());
            fileOutputStream.write(lastname2.getBytes());
        } catch (IOException e) {
            Log.d(e.toString(), "Save: ");
        }

        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(getBaseContext(),"Successfully save in"+file+"/Data.txt",Toast.LENGTH_LONG).show();

    }

    public void Next(View view) {
        Toast.makeText(getBaseContext(),"To Data Base  ",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,DB_Activity.class);
        startActivity(intent);
    }
}
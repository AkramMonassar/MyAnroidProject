package com.alasbahi.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DBActivity extends AppCompatActivity {

    TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        username=(TextView) findViewById(R.id.id_username_edit);
    }

    public void retriveExPublic(View view) {
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file1=new File(file,"ExPublic.txt");
        String name=getData(file1);
        if(name!=null)
        {
            username.setText(name);
        }
        else {
            username.setText("No Data");
        }

    }

    private String getData(File file1) {
        String name="";
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(file1);
            int read=-1;
            StringBuilder temp = new StringBuilder();
            while ((read=fileInputStream.read())!=-1)
            {
                temp.append((char) read);
            }
            Log.d(temp.toString(), "retrievesInternal: Akram");
            name=temp.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Retrieves Successfully Data",Toast.LENGTH_LONG).show();
        return  name;
    }

    public void retriveExPrivate(View view) {
        File file=getExternalFilesDir("Data");
        File file1=new File(file,"ExPrivate.txt");
        String name=getData(file1);
        if(name!=null)
        {
            username.setText(name);
        }
        else {
            username.setText("No Data");
        }
    }

    public void dataBase(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
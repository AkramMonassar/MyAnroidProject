package com.alasbahi.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.id_username_edit);
    }

    public void saveExPublic(View view) {
        String name=editText.getText().toString();
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file1=new File(file,"ExPublic.txt");
        dataStore(name,file1);
    }

    public void saveExPrivate(View view) {
        String name=editText.getText().toString();
        File file=getExternalFilesDir("Data");
        File file1=new File(file,"ExPrivate.txt");
        dataStore(name,file1);
    }

    public void nextDataBase(View view) {
        Intent in=new Intent(this,DBActivity.class);
        startActivity(in);
    }


    private void dataStore(String name, File file1) {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(file1);
            fileOutputStream.write(name.getBytes());
            Toast.makeText(this,name+" Successfully Data Stored in"+file1,Toast.LENGTH_LONG).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
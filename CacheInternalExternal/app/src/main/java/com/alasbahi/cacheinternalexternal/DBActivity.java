package com.alasbahi.cacheinternalexternal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DBActivity extends AppCompatActivity {

    TextView user_name1,user_name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        user_name1=(TextView) findViewById(R.id.userName1_id);
        user_name2=(TextView) findViewById(R.id.userName2_id);
    }

    public void retrievesInternal(View view) {
        File file=getCacheDir();
        File file1=new File(file,"DataInternal.txt");
        readFileStore(file1,user_name1);
    }
    public void retrievesExternal(View view) {
        File file=getExternalCacheDir();
        File file1=new File(file,"DataExternal.txt");
        readFileStore(file1,user_name2);
    }

    private void readFileStore(File file1,TextView textView) {
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
            textView.setText(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Retrieves Successfully Data",Toast.LENGTH_LONG).show();
    }
    public void backMain(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

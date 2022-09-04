package com.alasbahi.databasesqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText oldName_editText,NewName_editText1;
    DBconnection dBconnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        oldName_editText=(EditText) findViewById(R.id.old_name_id);
        NewName_editText1=(EditText) findViewById(R.id.new_name_id);
        dBconnection=new DBconnection(this);
    }

    public void backMain(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void update(View view) {
        String str1=oldName_editText.getText().toString();
        String str2=NewName_editText1.getText().toString();

        dBconnection.update(str1,str2);
        Toast.makeText(this,"Update Successfully...",Toast.LENGTH_LONG).show();

    }
}
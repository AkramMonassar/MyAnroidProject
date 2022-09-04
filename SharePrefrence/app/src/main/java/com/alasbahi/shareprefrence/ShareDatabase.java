package com.alasbahi.shareprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShareDatabase extends AppCompatActivity {

    String defult="NV";
    EditText userName,passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_database);
        userName=(EditText) findViewById(R.id.id_username2);
        passWord=(EditText) findViewById(R.id.id_password2);

    }

    public void show(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("name",defult);
        String password=sharedPreferences.getString("password",defult);


        if(name==defult|| password==defult)
        {
            Toast.makeText(this,"No Data Found",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Data Found",Toast.LENGTH_LONG).show();
            userName.setText(name);
            passWord.setText(password);
        }


    }
    public void Back(View view) {
        Toast.makeText(this,"Main activity",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}
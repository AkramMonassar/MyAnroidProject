package com.alasbahi.shareprefrence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateHandle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_username;
    EditText editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_username=(EditText) findViewById(R.id.userName);
        editText_password=(EditText) findViewById(R.id.password);
    }

    public void save(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",editText_username.getText().toString());
        editor.putString("password",editText_password.getText().toString());
        editor.commit();
        Toast.makeText(getBaseContext(),"Saved Succesfully",Toast.LENGTH_LONG).show();
    }

    public void Next(View view) {
        Toast.makeText(getBaseContext(),"DataBase",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this, ShareDatabase.class);
        startActivity(intent);
    }
}
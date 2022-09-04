package com.alasbahi.databasesqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText name_edit;
    DBconnection dBconnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        name_edit=(EditText) findViewById(R.id.name_id);

        dBconnection=new DBconnection(this);
    }

    public void delete(View view) {
        String str=name_edit.getText().toString();
        dBconnection.delete(str);
        search2(name_edit);
    }

    public void backMain(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"To Main Page Go",Toast.LENGTH_SHORT).show();
    }

    public  void search2(View view) {
        if (name_edit.getText().toString().isEmpty() == true) {
            Toast.makeText(this, "Not value to Delete", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this,"Successfully Delete",Toast.LENGTH_SHORT).show();
        }
    }
}
package com.alasbahi.databasesqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    EditText emailEditText,fullNameEditText;
    TextView textView_show;

    DBconnection dBconnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        fullNameEditText=(EditText) findViewById(R.id.fullname_id2);
        emailEditText=(EditText) findViewById(R.id.email_id2);

        textView_show=(TextView)findViewById(R.id.viewSearchData_textview);

        dBconnection=new DBconnection(this);

    }

    public void backMain(View view) {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);

    }

public  void search(View view)
{
    Toast.makeText(this,"This is searhc",Toast.LENGTH_LONG).show();
    if(emailEditText.getText().toString().isEmpty()==true&&fullNameEditText.getText().toString().isEmpty()==true)
    {
        Toast.makeText(this,"Not value to Search",Toast.LENGTH_LONG).show();
    }else  if(emailEditText.getText().toString()!=null && fullNameEditText.getText().toString().isEmpty()==true) {
        Toast.makeText(this,"Search by Email",Toast.LENGTH_LONG).show();
        String str1 = emailEditText.getText().toString();
        int i=1;
        String tr2 = dBconnection.search(str1,i);
        textView_show.setText(tr2);
    }else if(emailEditText.getText().toString().isEmpty()==true && fullNameEditText.getText().toString()!=null)
    {
        Toast.makeText(this,"Search by Name",Toast.LENGTH_LONG).show();
        String str1 = fullNameEditText.getText().toString();
        int i=2;
        String tr2 = dBconnection.search(str1,i);
        textView_show.setText(tr2);
    }else {
        Toast.makeText(this,"Not search by Email and Name, Must Search by One",Toast.LENGTH_LONG).show();
    }
}

    public void searchByName(View view) {
        String str1=fullNameEditText.getText().toString();

        Toast.makeText(this,"SErch2",Toast.LENGTH_LONG).show();

    }
}
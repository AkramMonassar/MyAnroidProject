package com.alasbahi.databasesqliteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBconnection database;
    EditText fullname,nationality,email;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullname=(EditText)findViewById(R.id.fullname_id);
        nationality=(EditText)findViewById(R.id.nationality_id);
        email=(EditText)findViewById(R.id.email_id);
        textView=(TextView)findViewById(R.id.showData_textview);

        Toast.makeText(this,"on before onCREATE",Toast.LENGTH_LONG).show();
        database=new DBconnection(this);
        Toast.makeText(this,"after Database",Toast.LENGTH_LONG).show();

    }
    public void save(View view) {
        String full=fullname.getText().toString();
        String na=nationality.getText().toString();
        String em=email.getText().toString();

        DBconnection dBinfo=new DBconnection(this);
        if(full.isEmpty()==false && em.isEmpty()==false) {
            long id = dBinfo.dataInsert(full, na, em);
            if (id < 0) {
                Toast.makeText(this, "NO  inserted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Successfully inserted", Toast.LENGTH_LONG).show();

            }
        }else
            Toast.makeText(this, "NO  inserted added because must fill name , email", Toast.LENGTH_LONG).show();



    }


    public void viewData(View view) {
        String data=database.showData();
        textView.setText(data);
    }

    public void nextSearch(View view) {
        Toast.makeText(this," to Search activity",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this, SearchActivity.class);
        startActivity(intent);

    }

    public void nextUpdate(View view) {
        Intent intent=new Intent(this,UpdateActivity.class);
        startActivity(intent);
        Toast.makeText(this,"To Update Page  Go ",Toast.LENGTH_LONG).show();

    }

    public void nextDelete(View view) {
        Intent intent=new Intent(this,DeleteActivity.class);
        startActivity(intent);
    }
}

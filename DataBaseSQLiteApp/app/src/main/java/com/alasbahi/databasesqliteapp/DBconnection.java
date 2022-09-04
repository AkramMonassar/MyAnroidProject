package com.alasbahi.databasesqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBconnection {

    DBinfo DBINFO;
    public DBconnection(Context context) {
        DBINFO=new DBinfo(context);
    }


    public  long dataInsert(String fulname,String nationality,String email)
    {
       SQLiteDatabase sqLiteDatabase=DBINFO.getWritableDatabase();
       ContentValues contentValues=new ContentValues();
       contentValues.put(DBinfo.names,fulname);
       contentValues.put(DBinfo.national,nationality);
       contentValues.put(DBinfo.email,email);
       long id=sqLiteDatabase.insert(DBinfo.tableName,null,contentValues);
       return id;
    }


    public String showData() {
        SQLiteDatabase sqLiteDatabase=DBINFO.getWritableDatabase();
        String [] columns={DBinfo.UID,DBinfo.names,DBinfo.national,DBinfo.email};
        Cursor cursor=sqLiteDatabase.query(DBinfo.tableName,columns,null,null,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        while (cursor.moveToNext())
        {
            int uid=cursor.getInt(0);
            String name1=cursor.getString(1);
            String nationality1=cursor.getString(2);
            String email1=cursor.getString(3);

             stringBuffer.append(uid+" "+name1+" "+nationality1+" "+email1+"\n");
        }
        return stringBuffer.toString();
    }


    public String search(String choose,int i) {
        SQLiteDatabase sqLiteDatabase=DBINFO.getWritableDatabase();
        String [] columns={DBinfo.names,DBinfo.national,DBinfo.email};
        Cursor cursor=sqLiteDatabase.query(DBinfo.tableName,columns,DBinfo.names+" = '"+choose+"'",null,null,null,null);
        if(i==1)
        {
            cursor=sqLiteDatabase.query(DBinfo.tableName,columns,DBinfo.email+" = '"+choose+"'",null,null,null,null);
        }else  if(i==2){
            cursor=sqLiteDatabase.query(DBinfo.tableName,columns,DBinfo.names+" = '"+choose+"'",null,null,null,null);
        }

        StringBuffer stringBuffer=new StringBuffer();
        while (cursor.moveToNext())
        {
            int index1=cursor.getColumnIndex(DBinfo.names);
            int index2=cursor.getColumnIndex(DBinfo.national);
            int index3=cursor.getColumnIndex(DBinfo.email);

            String fullNam=cursor.getString(index1);
            String nationa=cursor.getString(index2);
            String mail=cursor.getString(index3);

            stringBuffer.append(fullNam+" "+nationa+" "+mail+"\n");
        }
        return stringBuffer.toString();
    }

    public int update(String oldName,String newName) {
        SQLiteDatabase sqLiteDatabase=DBINFO.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(DBinfo.names,newName);

        String[] wereArgs={oldName};


        int count=sqLiteDatabase.update(DBinfo.tableName,contentValues,DBinfo.names+" =?",wereArgs);


        return count;
    }


    public int delete(String name) {
        SQLiteDatabase sqLiteDatabase=DBINFO.getWritableDatabase();

        String[] wereArgs={name};
        String s=DBinfo.names+" =? ";

        int count=sqLiteDatabase.delete(DBinfo.tableName,s,wereArgs);


        return count;
    }





 static   class DBinfo extends SQLiteOpenHelper {

        private static final String dataBase_Name = "akram";
        private static final String tableName = "MOHAMMED";
        private static final int dataBaseVersion = 1;
        private static final String UID ="id";
        private static final String names = "name";
        private static final String email = "email";
        private static final String national="NATIONAL";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " +tableName;
        private static final String CREATE_TABLE = "CREATE TABLE  "+tableName+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+names+" VARCHAR(255), "+national+" VARCHAR(255), "+email+" VARCHAR(255));";

        private Context context;
        public DBinfo(Context context) {
            super(context, dataBase_Name, null, dataBaseVersion);
            this.context=context;
            Toast.makeText(context,"on Contractors",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
                Toast.makeText(context,"on onCreate",Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(context, "dut to" + e, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context,"on onUpgrade",Toast.LENGTH_LONG).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException de) {
                Toast.makeText(context, "dut to" + de, Toast.LENGTH_LONG).show();
            }
        }


    }
}
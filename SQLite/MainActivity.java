package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(getApplicationContext());
        //it will return an sqlite database object
        SQLiteDatabase sqLiteDatabase = myDataBaseHelper.getWritableDatabase();

    }
}

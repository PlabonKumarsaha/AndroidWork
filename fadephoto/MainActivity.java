package com.example.currencyconvertorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    boolean Showing = true;

    public void change(View view)
    {
        ImageButton imb = (ImageButton) findViewById(R.id.imageButton1);
       ImageButton imb2 = (ImageButton)findViewById(R.id.imageButton2);
       if(Showing) {
           Showing = false;
            imb.animate().alpha(0).setDuration(2000);
           imb2.animate().alpha(1).setDuration(2000);


        }
        else {
           Showing = true;
           imb.animate().alpha(1).setDuration(2000);
            imb2.animate().alpha(0).setDuration(2000);


        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

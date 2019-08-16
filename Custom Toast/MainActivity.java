package com.example.practisefirebaseandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This layout infalter class will make the custom_layout a custom Toast
                LayoutInflater inflater = getLayoutInflater();
                //pass the xml name in the first parameter & the coresponding layout id in the second one(Must type cast in the second parameter)!
               View customview = inflater.inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.layoutId));

                Toast toast = new Toast(MainActivity.this);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(customview);
                toast.show();



            }
        });


    }
}

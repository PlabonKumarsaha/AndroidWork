package com.example.activityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button button1;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        textView = findViewById(R.id.textView);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            //we are going to another activity so that we might get some data from the that activity.so we have to return result that's why we use that method

            startActivityForResult(intent,1);
                //startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //gets the returned value!

        //there might be more then one request code involved in a app.so we should check the requestCode!
        if(requestCode == 1){
        String value =data.getStringExtra("key");
        textView.setText(value);}
    }
}

package com.example.intentinandoid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textviewId2;
    String value,value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textviewId2 =findViewById(R.id.textviewId2);

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null)
        {
            //the value "Key" is gotten from the main activity.We identified the data through this key.
          value = bundle.getString("Key");
          //value2 has the editText value
          value2 = bundle.getString("Key2");
          textviewId2.setText(value+ " "+value2);
            //textviewId2.setText(value2);
        }
        else
        {
//noting wil happen!
        }
    }
}

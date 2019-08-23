package com.example.intentinandoid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonId;
    private String data;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        //This method was taken to store the editText value to be send in the next Activity..Before taking this method the data was not being stored!
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
  //Only this following method is neede
            @Override
            public void afterTextChanged(Editable s) {
                data = editText.getText().toString();
            }
        });



        buttonId = findViewById(R.id.buttonId);
        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
                //Intent(Source,Destination.class)
                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                //putExtra method helps to pass the value to the second activity.
                // putextra("first perameter is the key of the value","second perameter is the actual data")
                intent.putExtra("Key2",data);
                intent.putExtra("Key","This is the data");
                startActivity(intent);
            }
        });
    }
}

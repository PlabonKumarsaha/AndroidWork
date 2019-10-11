package com.example.sharedpreferncedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameEditText,passwordEditText;
    private Button saveButtonid,loadButtonid;
    TextView detailsTextViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Shared prefernces uses key-value pair.used for samll amout of data
        //it can store primitive data types like int,float,double,string
        //used to store user details.username,password
        //store user setting.
        //storing last score
        //location catching,multiple choice quiz

        detailsTextViewId = findViewById(R.id.detailsTextViewId);
        loadButtonid = findViewById(R.id.loadButtonid);
        loadButtonid.setOnClickListener(this);
        saveButtonid.setOnClickListener(this);
        saveButtonid = findViewById(R.id.saveButtonid);

        passwordEditText = findViewById(R.id.passwordEditText);
        usernameEditText = findViewById(R.id.usernameEditText);

        loadButtonid.setOnClickListener(this);
        saveButtonid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.saveButtonid) {
            String name = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            if (name.equals(null) || password.equals(null)) {
                Toast.makeText(getApplicationContext(), "Data not entered", Toast.LENGTH_SHORT).show();
            }
            else {
                //writing data in sharedprefernce/stores the data

                SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey", name);
                editor.putString("passwordKey", password);
                editor.commit();
                usernameEditText.setText("");
                passwordEditText.setText("");
                Toast.makeText(getApplicationContext(), "Data Stoared sucessful", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.getId() == R.id.loadButtonid)
        {
            //to Read data
            //shared preferce stores the keys

            SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
            if(sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey"))
            {
                String name = sharedPreferences.getString("usernameKey","Data not found");
                String password = sharedPreferences.getString("passwordKey","Data not found");
                // detailsTextViewId.setText("User Name : "+name+"\n"+"Password"+password);
                usernameEditText.setText(name);
                passwordEditText.setText(password);
            }

        }
        }

    }


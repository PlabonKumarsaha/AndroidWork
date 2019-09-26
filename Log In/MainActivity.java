package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usernameId,passwordId;
    private Button loginbtn;
    private TextView textviewID;
    private int noofatempt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameId = findViewById(R.id.usernameId);
        passwordId = findViewById(R.id.passwordId);
        loginbtn = findViewById(R.id.loginbtn);
        textviewID = findViewById(R.id.textviewID);
        textviewID.setText("Number of attemps left : 3");


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameId.getText().toString();
                String password = passwordId.getText().toString();
                //always compare string with .equals
                if(username.equals("admin") && password.equals("12345"))
                {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                else {
                    noofatempt--;
                    textviewID.setText("Number of attemps left : "+noofatempt);
                    if(noofatempt ==0)
                    {
                        loginbtn.setEnabled(false);
                    }

                }
            }
        });

    }
}

package com.example.firebaseuploadexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText PasswordEditText,EmailEditText;
    private Button sineInbtn;
    TextView sineUpTextViewId;
    ProgressBar progessbarId;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        sineUpTextViewId = findViewById(R.id.sineUpTextViewId);
        progessbarId = findViewById(R.id.progessbarId);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        EmailEditText = findViewById(R.id.EmailEditText);

        sineInbtn = findViewById(R.id.sineInbtn);


        sineInbtn.setOnClickListener(this);
        sineUpTextViewId.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.sineInbtn:

                userLogin();
                break;

            case R.id.sineUpTextViewId:
                Intent intent = new Intent(MainActivity.this,SineupActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userLogin() {
        String userEmail = EmailEditText.getText().toString().trim();
        String password = PasswordEditText.getText().toString();
        if(userEmail.isEmpty())
        {
            EmailEditText.setError("Enter email");
            //foacuses on that editetxt
            EmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
        {
            EmailEditText.setError("Enter a valid email");
            //foacuses on that editetxt
            EmailEditText.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            PasswordEditText.setError("Enter password");
            //foacuses on that editetxt
            PasswordEditText.requestFocus();
            return;
        }
        if (password.length()<6)
        {
            PasswordEditText.setError("Paswword must have more then 6 words");
            //foacuses on that editetxt
            PasswordEditText.requestFocus();
            return;
        }
        progessbarId.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(userEmail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progessbarId.setVisibility(View.GONE);

                if(task.isSuccessful())
                {
                    Intent intent = new Intent(MainActivity.this,RandromActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login unsucessful",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}

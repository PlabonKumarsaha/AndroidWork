package com.example.firebaseuploadexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

public class SineupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText sineUPPasswordEditText,sineUPEmailEditText;
    private Button sineupbtn;
    TextView sineUpTextViewId;
    ProgressBar progessbarId;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sineup);


        mAuth = FirebaseAuth.getInstance();
        sineUpTextViewId = findViewById(R.id.sineUpTextViewId);
        progessbarId = findViewById(R.id.progessbarId);
        sineUPPasswordEditText = findViewById(R.id.sineUPPasswordEditText);
        sineUPEmailEditText = findViewById(R.id.sineUPEmailEditText);

        sineupbtn = findViewById(R.id.sineupbtn);


        sineupbtn.setOnClickListener(this);
        sineUpTextViewId.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.sineupbtn:
                userRegister();

                break;

            case R.id.sineUpTextViewId:
                Intent intent = new Intent(SineupActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userRegister() {
        String userEmail = sineUPEmailEditText.getText().toString().trim();
        String password = sineUPPasswordEditText.getText().toString();
        if(userEmail.isEmpty())
        {
            sineUPEmailEditText.setError("Enter email");
            //foacuses on that editetxt
            sineUPEmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
        {
            sineUPEmailEditText.setError("Enter a valid email");
            //foacuses on that editetxt
            sineUPEmailEditText.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            sineUPPasswordEditText.setError("Enter password");
            //foacuses on that editetxt
            sineUPPasswordEditText.requestFocus();
            return;
        }
        if (password.length()<6)
        {
            sineUPPasswordEditText.setError("Paswword must have more then 6 words");
            //foacuses on that editetxt
            sineUPPasswordEditText.requestFocus();
            return;
        }
        progessbarId.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(userEmail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(getApplicationContext(),"Register Is sucessful",Toast.LENGTH_SHORT).show();
                    sineUPEmailEditText.setText("");
                    sineUPPasswordEditText.setText("");
                    progessbarId.setVisibility(View.GONE);
                } else {
                    // If sign in fails, display a message to the user.
                    progessbarId.setVisibility(View.GONE);

                    //checking unscessful types
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        //already registerd
                        Toast.makeText(getApplicationContext(),"This mail is already taken",Toast.LENGTH_SHORT).show();

                    }
                    else {
                        //error
                        Toast.makeText(getApplicationContext(), "Register Is not sucessful bcz of "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}

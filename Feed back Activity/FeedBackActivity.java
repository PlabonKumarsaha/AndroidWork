package com.example.sharemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedBackActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sendBtn,clearbtn;
    private EditText nameEdittext,messageedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        sendBtn = findViewById(R.id.sendBtn);
        clearbtn = findViewById(R.id.clearBtn);
        sendBtn.setOnClickListener(this);
        clearbtn.setOnClickListener(this);

        nameEdittext = findViewById(R.id.nameEditText);
        messageedittext = findViewById(R.id.messageEditText);


    }

    @Override
    public void onClick(View view) {
        try {

            String name = nameEdittext.getText().toString();
            String message = messageedittext.getText().toString();

            if (view.getId() == R.id.sendBtn) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                //second parameter must be a string array!you can write multiple email adress here too!
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yourEmailAdress@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feed Back from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name :" + name + "\nMessage :" + message);
                startActivity(Intent.createChooser(intent, "Feed back with : "));


            } else if (view.getId() == R.id.clearBtn) {
                nameEdittext.setText("");
                messageedittext.setText("");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}

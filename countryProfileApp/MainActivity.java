package com.example.countryprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bangladeshButton,indiaButton,SrilankaButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangladeshButton=findViewById(R.id.bangladeshButton);
        SrilankaButton =findViewById(R.id.SrilankaButton);
        indiaButton =findViewById(R.id.indiaButton);

        bangladeshButton.setOnClickListener(this);
        SrilankaButton.setOnClickListener(this);
        indiaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.bangladeshButton)
        {
            intent = new Intent(this,ProfileActivity.class);
            intent.putExtra("name","Bangladesh");
            startActivity(intent);
        }
        else if(v.getId()==R.id.SrilankaButton)
        {
            intent = new Intent(this,ProfileActivity.class);
            intent.putExtra("name","srilanka");
            startActivity(intent);
      }

        else if(v.getId()==R.id.indiaButton)
        {
            intent = new Intent(this,ProfileActivity.class);
            intent.putExtra("name","india");
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
        //alertbuilder.setIcon(R.drawable.question);
        alertbuilder.setTitle("This is a title");
        alertbuilder.setMessage("Do you want to close?");
        alertbuilder.setCancelable(false);
        alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertbuilder.create();
        alertDialog.show();
        alertbuilder.show();


    }
}

package com.example.countryprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    ImageView imageviewId;
    TextView textView;

    void showDetails(String  countryName)
    {
        if(countryName.equals("Bangladesh"))
    {
        imageviewId.setImageResource(R.drawable.bd);
        textView.setText(R.string.bdInfo);
    }
        else if(countryName.equals("india"))
        {
            imageviewId.setImageResource(R.drawable.india_flag);
            textView.setText(R.string.indiaInfo);
        }
        if(countryName.equals("srilanka"))
        {
            imageviewId.setImageResource(R.drawable.lanka);
            textView.setText(R.string.srilankainfo);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        imageviewId = findViewById(R.id.imageviewId);
        textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null)
        {
              String countryName =bundle.getString("name");
            showDetails(countryName);
        }

    }
}

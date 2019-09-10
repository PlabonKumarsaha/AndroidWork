package com.example.spinnerdropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String countryNames[];
    private Spinner spinnerid;
    private Button buttonid;
    private TextView textviewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textviewId = findViewById(R.id.textviewId);
        buttonid = findViewById(R.id.buttonid);
        spinnerid = findViewById(R.id.spinnerid);
        countryNames = getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.sample_layout,R.id.sampleTextView,countryNames);
        spinnerid.setAdapter(adapter);

        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = spinnerid.getSelectedItem().toString();
                textviewId.setText(value);
            }
        });
    }
}

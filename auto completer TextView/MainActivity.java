package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView autoTextView;
    String countryName[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoTextView = findViewById(R.id.autoTextView);
        countryName=getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,countryName);

        //Set threshold (1)means it matches the number of character written in editText.so if we write one character then
        //it will show the items that start with that character
        autoTextView.setThreshold(1);

        autoTextView.setAdapter(adapter);
    }
}

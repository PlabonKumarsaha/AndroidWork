package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//Download flags from :https://flagpedia.net/continent/asia
public class MainActivity extends AppCompatActivity {
    ListView listView;
    private String countryName[];
    private int flags[] = {R.drawable.bd,R.drawable.in,R.drawable.lk,R.drawable.np,R.drawable.jp};
    private ImageView imageviewid;
    private TextView countryNameText;
    private TextView countryDescriptiontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
//R.array is setted up in values>>string.xml
        countryName = getResources().getStringArray(R.array.country_name);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,countryName,flags);
        listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               String value = countryName[position];
               Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
           }
       });

    }
}

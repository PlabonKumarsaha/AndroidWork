package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.myListView);

        final ArrayList<String> list = new ArrayList<String>();
        list.add("AB");
        list.add("BC");
        list.add("CD");
        list.add("EF");
        list.add("GH");
        list.add("LM");
        list.add("AB");
        list.add("AB");
        list.add("BC");
        list.add("CD");
        list.add("EF");
        list.add("GH");
        list.add("LM");
        list.add("AB");
        list.add("AB");
        list.add("BC");
        list.add("CD");
        list.add("EF");
        list.add("GH");
        list.add("LM");
        list.add("AB");
  final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
  myListView.setAdapter(arrayAdapter);
       // Log.i("Kisu na","hoy.?");
myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Selected : "+list.get(position),Toast.LENGTH_SHORT).show();
    }
});



    }
}

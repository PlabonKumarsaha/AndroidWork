package com.example.mygridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private GridView gridviewid;
    private String countryName[];
    private int flags[] = {R.drawable.afg,R.drawable.bd,R.drawable.bhutan,R.drawable.indicon,R.drawable.lanka,
            R.drawable.nep ,R.drawable.thailand};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File("D:\\CSS");
        String strFileName = file.getName();
        gridviewid = findViewById(R.id.gridviewid);
        countryName = getResources().getStringArray(R.array.country_name);
        CustomAdapter adapter = new CustomAdapter(this,countryName,flags);

        gridviewid.setAdapter(adapter);

        gridviewid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryName[i];
                Toast.makeText(getApplicationContext(),"Clicked item was : "+value,Toast.LENGTH_SHORT).show();


            }
        });
    }
}

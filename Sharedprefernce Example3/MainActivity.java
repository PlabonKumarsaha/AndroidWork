package com.example.sharedprefex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.graphics.Color.*;
import static android.graphics.Color.RED;
import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    LinearLayout linerLayoutid;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        linerLayoutid = findViewById(R.id.linerLayoutid);

        if(loadColor()!= BLACK)
        {
            linerLayoutid.setBackgroundColor(BLACK);
        }






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.blueMenuID) {
            linerLayoutid.setBackgroundColor(BLUE);
            storeColor(BLUE);
        }
        else if(item.getItemId() == R.id.redMenuID) {
            linerLayoutid.setBackgroundColor(RED);
            storeColor(RED);
        }
        else if(item.getItemId() == R.id.pinkMenuID) {
            linerLayoutid.setBackgroundColor(GREEN);
            storeColor(GREEN);
        }
        else if(item.getItemId() == R.id.yellowMenuID) {
            linerLayoutid.setBackgroundColor(YELLOW);
            storeColor(YELLOW);
        }


        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int red) {
        SharedPreferences sharedPreferences = getSharedPreferences("backgorundColor",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor",red);
        editor.commit();

    }

    private int loadColor()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("backgorundColor",Context.MODE_PRIVATE);
        int returnColor = sharedPreferences.getInt("myColor", BLACK);
        return returnColor;
    }
}




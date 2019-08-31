package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //A directory called "menu" was created in res.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //this method will inflate the menu in mainActivity.

        MenuInflater menuinflater =getMenuInflater();
        menuinflater.inflate(R.menu.menu_layout,menu);



        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.settingId)
        {
            Toast.makeText(getApplicationContext(),"Setting ID",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getItemId() == R.id.AboutUsId)
        {
            Toast.makeText(getApplicationContext(),"About Us ID",Toast.LENGTH_SHORT).show();
            return true;
        }

        if(item.getItemId() == R.id.feedbackId)
        {
            Toast.makeText(getApplicationContext(),"FeedBack ID",Toast.LENGTH_SHORT).show();
            return true;
        }

        if(item.getItemId() == R.id.shareId)
        {
            Toast.makeText(getApplicationContext(),"Share ID",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

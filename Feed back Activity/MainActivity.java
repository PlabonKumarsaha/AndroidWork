package com.example.sharemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //this part is to set up the menu_layout that we created

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //we are checking if the clicked item id matches with the clicked item id!

       if(item.getItemId() == R.id.shareid)
       {
          // Toast.makeText(getApplicationContext(),"share is clicked",Toast.LENGTH_SHORT).show();

           //https://developer.android.com/training/sharing/send (Should Read!)
           Intent intent = new Intent(Intent.ACTION_SEND);
           intent.setType("Text/plain");
           String subject = "Practice demo share";
           String body = "Beginner level so learning and practicing!\n com.example.sharemenu";
           intent.putExtra(Intent.EXTRA_SUBJECT,subject);
           intent.putExtra(Intent.EXTRA_TEXT,body);
           startActivity(Intent.createChooser(intent,"Share with"));

       }

       else if(item.getItemId() == R.id.feedbackid)
       {
           Intent intent = new Intent(this,FeedBackActivity.class);
           startActivity(intent);
       }
        return super.onOptionsItemSelected(item);
    }


}

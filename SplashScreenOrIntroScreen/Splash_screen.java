package com.example.spinnerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class splash_screen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.splashscreenProgressbar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
                startApp();
            }
        });
        thread.start();


    }

    private void startApp() {
        Intent intent = new Intent(splash_screen.this,MainActivity.class);
        startActivity(intent);
        //finish means the activity will be over and not return here!if we did not add the finish and after the splashscreen
        //was gone and the main activity started then if we press back button of the device then it goes back to the splashscreen
        //so in order to eliminate the problem we added finish!
        finish();
    }

    private void work() {

        for (progress = 10; progress <= 100; progress = progress + 10) {
            try {

                Thread.sleep(1000);
                progressBar.setProgress(progress);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.mp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton playButton,pauseButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        mediaPlayer = MediaPlayer.create(this,R.raw.anupam);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.playButton)
        {
        if(mediaPlayer !=null)
        {
            mediaPlayer.start();
            int duration = mediaPlayer.getDuration();
            Toast.makeText(getApplicationContext(),"Playing : "+duration/1000,Toast.LENGTH_SHORT).show();
        }
        }
        if(view.getId() == R.id.pauseButton)
        {


            if(mediaPlayer !=null)
            {
                mediaPlayer.pause();
                Toast.makeText(getApplicationContext(),"paused",Toast.LENGTH_SHORT).show();
            }
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer!=null && mediaPlayer.isPlaying())
        {
         mediaPlayer.stop();
         mediaPlayer.release();
         mediaPlayer = null;
        }
    }
}

package com.example.sharedprefex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button decreasebtn,increasebtn;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        increasebtn = findViewById(R.id.increasebtn);
        decreasebtn = findViewById(R.id.decreasebtn);
        textView = findViewById(R.id.textView);
        increasebtn.setOnClickListener(this);
        decreasebtn.setOnClickListener(this);

        if(loadScore() !=0)
        {
            textView.setText("Score : "+loadScore());
        }


    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.increasebtn)
        {
      score = score +10;
      textView.setText("Score : "+score);

      //the updated scores get passed to the method where shared perfernce is used
      saveScore(score);
        }

        else if(view.getId() == R.id.decreasebtn)
        {

            score = score - 10;
            textView.setText("Score : "+score);
            //the updated scores get passed to the method where shared perfernce is used
            saveScore(score);

        }

    }

    private void saveScore(int score) {

        //Use of shared prefernce

        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastscore",score);
        editor.commit();
    }

    private int loadScore()
    {
        //keeps the score stored after the app is closed
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        //if lastScore doesn't get any value returened it wil get the  value as '0' for the 2nd parameter
        int lastScore = sharedPreferences.getInt("lastscore",0);
        return  lastScore;
    }
}

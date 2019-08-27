package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int locationOfCorrectAns;

    Button Gobutton;
    TextView sumtextView3;
    TextView timertextView;
    //ArrayList<Integer>answers = new ArrayList<int>();
    ArrayList<Integer> answers = new ArrayList<Integer>();
   // int answers[100] = new arr[100];
    Button button0 ;
    Button button1 ;
    Button button2;
    Button button3;
    Button PlayAgainButton;
    TextView resulttextView;
    int score =0;
    int numberofquestions = 0;
    TextView textView2;
public void chooseAnswer(View view)
{

   if( Integer.toString(locationOfCorrectAns).equals(view.getTag().toString()))
   {
       resulttextView.setText("Correct!");
       score++;

   }
   else {
       resulttextView.setText("Wrong!:(");


   }
    textView2.setText(Integer.toString(score)+"/"+Integer.toString(numberofquestions));
    numberofquestions++;
    newQuestion();

}

public void newQuestion()
{
    Random random = new Random();
    int a = random.nextInt(30);
    int b = random.nextInt(30);

    sumtextView3.setText(Integer.toString(a)+" + "+ Integer.toString(b));
    locationOfCorrectAns = random.nextInt(4);
    answers.clear();
    for (int i =0;i<4;i++)
    {
        if(i == locationOfCorrectAns)
        {
            answers.add(a+b);
        }
        else
        {
            int wrong =random.nextInt(60);
            while(wrong == a+b){
                wrong =random.nextInt(60);
            }
            answers.add(wrong);
        }

    }
    button0.setText(Integer.toString(answers.get(0)));
    button1.setText(Integer.toString(answers.get(1)));
    button2.setText(Integer.toString(answers.get(2)));
    button3.setText(Integer.toString(answers.get(3)));

}




public void playAgain(View view)
{
   score = 0;
   numberofquestions=0;
   timertextView.setText("30s");

    newQuestion();
    new CountDownTimer(30100,100)
    {

        @Override
        public void onTick(long millisUntilFinished) {

            timertextView.setText( String.valueOf((millisUntilFinished/1000)+"s"));
        }

        @Override
        public void onFinish() {

            resulttextView.setText("Done!");
            PlayAgainButton.setVisibility(View.VISIBLE);
        }
    }.start();



}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gobutton = findViewById(R.id.Gobutton);
        sumtextView3 = findViewById(R.id.sumtextView3);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        textView2=findViewById(R.id.textView2);
        resulttextView = findViewById(R.id.resulttextView);
        PlayAgainButton=findViewById(R.id.PlayAgainButton);

        timertextView=findViewById(R.id.timertextView);

        //you can pass anything in the perameter of that bcz we don't use it!but we needed it to have  a view when we took the method
        playAgain(findViewById(R.id.PlayAgainButton));
        //countDown interval means after that amount of time we will update a code!



    }

    public void start(View view)
    {
Gobutton.setVisibility(View.INVISIBLE);
    }
}

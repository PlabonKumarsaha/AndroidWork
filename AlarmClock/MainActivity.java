package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    AlarmManager alarmManager;
    TimePicker timepicker;
    Button setalarmBTN,turnoffbtn;
    TextView showTime;
    Context context;
    PendingIntent pendingIntent;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timepicker = findViewById(R.id.timepicker);
        setalarmBTN = findViewById(R.id.setalarmBTN);
        turnoffbtn = findViewById(R.id.turnoffbtn);
        showTime = findViewById(R.id.showTime);
        // context = this.context;
        this.context = this;

        final Calendar calendar = Calendar.getInstance();
         intent = new Intent(getApplicationContext(),Alarm_Receiever.class);

        setalarmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar.set(Calendar.HOUR_OF_DAY,timepicker.getHour());
                calendar.set(Calendar.MINUTE,timepicker.getMinute());

                int hour =timepicker.getHour();
                int min =timepicker.getMinute();

                String hour_string = String.valueOf(hour);
                String min_string = String.valueOf(min);

                if(hour>12)
                {
                    hour_string = String.valueOf(hour-12);
                }
                if(min<10)
                {
                    min_string = "0" +String.valueOf(min);
                }


                setAlarmText("alarn set to "+hour_string+":"+ min_string);

                //create pending intent ..Bcz we don't immidietly need the intent.
                // We will use a delayed intent
                pendingIntent =  PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                try {
                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                }
                catch (Exception e)
                {

                }


            }
        });


        turnoffbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cancel the alarm
                setAlarmText("alarn off");
                alarmManager.cancel(pendingIntent);

            }
        });



    }
    private void setAlarmText(String output) {

        showTime.setText(output);

    }
}

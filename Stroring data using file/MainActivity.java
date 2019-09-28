package com.example.storedatausingfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    Button savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savebtn = findViewById(R.id.savebtn);
        editText = findViewById(R.id.editText);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text =editText.getText().toString();
                if(text == null)
                {
                    Toast.makeText(getApplicationContext(),"Nothing inputed",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        writrTofile(text);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

 //this was called to show the already saved text!
        readFile();
    }

    public void writrTofile(String text) throws IOException {

        //openFileOutput(first perameter is the file name, mode of acessing the file)

        FileOutputStream fileOutputStream = openFileOutput("dairy.text", Context.MODE_PRIVATE);
        //write method only takes byte as a perameter to convert that into byte

        fileOutputStream.write(text.getBytes());
        fileOutputStream.close();
    }

    public void readFile()
    {
        try {
            FileInputStream fileInputStream = openFileInput("dairy.text");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String lines = " ";
            StringBuffer stringBuffer = new StringBuffer();
            while ((lines =bufferedReader.readLine())!= null )
            {
            stringBuffer.append(lines +"\n");
            }
            editText.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

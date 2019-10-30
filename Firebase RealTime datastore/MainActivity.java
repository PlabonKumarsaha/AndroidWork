package com.example.firebaserealtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText,ageEditText;
    Button saveBtn,loadBtn;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);


        databaseReference = FirebaseDatabase.getInstance().getReference("Student");


        saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
            }
        });
        loadBtn = findViewById(R.id.loadBtn);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });


    }

    private void saveData() {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();

        //generate unique key to store data
        String key =databaseReference.push().getKey();

        Student student = new Student(name,age);

        databaseReference.child(key).setValue(student);

        Toast.makeText(getApplicationContext(),"data entered",Toast.LENGTH_SHORT).show();

        nameEditText.setText("");
        ageEditText.setText("");


    }
}

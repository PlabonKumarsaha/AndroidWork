package com.example.firebaserealtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    ListView listViewId;
    DatabaseReference databaseReference;
    private List<Student>studentList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        listViewId = findViewById(R.id.listViewId);
        studentList = new ArrayList<>();
        customAdapter = new CustomAdapter(DetailsActivity.this,studentList);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");


    }

    @Override
    protected void onStart() {
//load the datas after the load button is clicked!
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //to avoid dulicates..We will fetch data every time we click load button
                studentList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    Student student = dataSnapshot1.getValue(Student.class);
                    studentList.add(student);
                }
                listViewId.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}

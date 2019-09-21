package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List listDataHeader;
    HashMap<Object, List<String>> listdatachild;
    private CustomAdapter customAdapter;

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expandableListview);
        prepareListData();

        customAdapter = new CustomAdapter(this,listDataHeader,listdatachild);
        expandableListView.setAdapter(customAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                //this listener works when any item is clicked- collapsed or not!

                Object groupName =listDataHeader.get(i);
                Toast.makeText(getApplicationContext(),"group name : "+groupName,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
             //when the clicked item collapses!
                Object groupName =listDataHeader.get(i);
                Toast.makeText(getApplicationContext(),groupName + " has collapsed!",Toast.LENGTH_SHORT).show();

            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                // a header may have multiple child in that group so in order to cope with that find exactly which child was clicked

                String childString =listdatachild.get(listDataHeader.get(i)).get(i1);
                Toast.makeText(getApplicationContext(),childString,Toast.LENGTH_SHORT).show();

                return false;
            }
        });



        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPosition != -1 && lastExpandedPosition != i)
                {
                   expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });

    }

    private void prepareListData() {
        String headerString[] = getResources().getStringArray(R.array.abbreviation_list_holder);
        String childString[] = getResources().getStringArray(R.array.abbreviation_list_child);
        listDataHeader = new ArrayList<>();
        listdatachild = new HashMap<Object, List<String>>();

        for(int i=0;i<headerString.length;i++)
        {
            //adding header data
            listDataHeader.add(headerString[i]);
            List<String>child = new ArrayList<>();
            child.add(childString[i]);
            listdatachild.put(listDataHeader.get(i),child);


        }


    }
}

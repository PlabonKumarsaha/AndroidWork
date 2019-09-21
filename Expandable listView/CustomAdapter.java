package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class CustomAdapter extends BaseExpandableListAdapter {
     Context context;
    List<String> listDataHeader;
    HashMap<Object, List<String>> listdatachild;


    public CustomAdapter(Context context, List<String> listDataHeader, HashMap<Object, List<String>> listdatachild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listdatachild = listdatachild;
    }

    @Override
    public int getGroupCount() {

        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        //one group may have multiple child so we can't just use size!we use for every single one of them indivisually for every Header!
        return listdatachild.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        // 'il' is for the child position!
        return listdatachild.get(listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String headertext = (String) getGroup(i);
        if(view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = layoutInflater.inflate(R.layout.group_layout,null);
        }
        TextView textView =view.findViewById(R.id.headtextviewid);
        textView.setText(headertext);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String childtext = (String) getChild(i,i1);
        if(view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_layout,null);
        }
        TextView textView =view.findViewById(R.id.childTextView);
        textView.setText(childtext);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {

        //this will be set as false defaultly which has to be made true to make setOnChildClickListener work!
        return true;
    }
}

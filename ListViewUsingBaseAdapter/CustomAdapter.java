package com.example.listviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends BaseAdapter {

    int flags[];
    String countryName[];
    Context context;
    private LayoutInflater inflater;



    CustomAdapter()
    {

//default const!
    }

    CustomAdapter(Context context,String countryName[],int flags[])
    {
     this.context = context;
     this.countryName = countryName;
     this.flags = flags;


    }
    @Override
    public int getCount() {
        //The number of items i want to show is returned by this method

        return countryName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //This method will convert the customly created layout as a view ..In this project the customly created layout is sample_view.
        //this will return the view

        if(convertView==null)
        {
          //this is checking if the first view is already made or not.
          inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView = inflater.inflate(R.layout.sample_view,viewGroup,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageviewid);
        TextView textView = convertView.findViewById(R.id.countryNameText);
        imageView.setImageResource(flags[position]);
        textView.setText(countryName[position]);



        return convertView;
    }
}

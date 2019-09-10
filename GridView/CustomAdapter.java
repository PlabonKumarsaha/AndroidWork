package com.example.mygridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import static android.widget.Toast.*;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int flags[];
    String countryName[];
private LayoutInflater inflater;

    CustomAdapter(Context context,String[] countryName,int flags[])
    {
this.context = context;
this.countryName = countryName;
this.flags = flags;
    }

    @Override
    public int getCount() {

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            try{
            view = inflater.inflate(R.layout.sample_view, viewGroup, false);
        }
            catch(Exception e){
           // makeText(this,"SOmossa ace", LENGTH_SHORT).show();
        }

        }
        try {
            ImageView imageView = (ImageView) view.findViewById(R.id.imagviewid);
            TextView textView =(TextView) view.findViewById(R.id.textviewid);
            imageView.setImageResource(flags[i]);
            textView.setText(countryName[i]);

        }
        catch (Exception e)
        {
            //
        }

        return view;
    }
}

package com.example.firebaseimagestore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

//viewHolder holdes the view of every class.Recyler view will hold a cardview

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {

   private Context context;
   private List<Upload>uploadList;

    public AdapterClass(Context context, List<Upload> uploadList) {
        this.context = context;
        this.uploadList = uploadList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //inflater converts an layout to a class..Here The converted layout is  item layout
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.item_layout,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        Upload upload = uploadList.get(position);
        myViewHolder.textView.setText(upload.getImageName());
        Picasso.get().load(upload.getImageUrl()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.cardviewTextId);
            imageView = itemView.findViewById(R.id.cardviewimageViewId);

        }
    }
}

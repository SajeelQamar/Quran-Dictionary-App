package com.example.quranapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class RetrieveAdapter extends RecyclerView.Adapter<RetrieveAdapter.myviewholder> {

    //retrieveimagemodel data[];
    ArrayList<Model> data;
    //ArrayList<retrieveimagemodel> backup;
    Context context;
    public RetrieveAdapter(ArrayList<Model> data, Context context) {

        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.childitem, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final Model temp = data.get(position);
        holder.txtname.setText(data.get(position).getName());
        holder.txtage.setText(data.get(position).getAge());

        holder.crdview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, childpage.class);


//                intent.putExtra("showname", temp.getName());
//                intent.putExtra("showmodel", temp.getModel());
//                intent.putExtra("showspecs", temp.getSpecs());



                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });

    }




    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView  txtname, txtage;
        CardView crdview;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.showname);
            txtage = itemView.findViewById(R.id.showage);
            crdview = itemView.findViewById(R.id.crdview);
        }
    }


}

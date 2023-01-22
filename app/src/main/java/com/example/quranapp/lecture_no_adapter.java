package com.example.quranapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class lecture_no_adapter extends RecyclerView.Adapter<lecture_no_adapter.myviewholder> {

    //retrieveimagemodel data[];
    ArrayList<lecture_no_model> data;
    Context context;
    public lecture_no_adapter(ArrayList<lecture_no_model> data, Context context) {

        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public lecture_no_adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lecture_no_item, parent, false);
        return new lecture_no_adapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lecture_no_adapter.myviewholder holder, int position) {
        final lecture_no_model temp = data.get(position);
        holder.txt1.setText(data.get(position).getLec_no());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, lecturesPage.class);


                intent.putExtra("dummytable", temp.getDummytable());




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
        TextView txt1;
        LinearLayout linearLayout;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            txt1 = itemView.findViewById(R.id.lec_no_txtview);
            linearLayout = itemView.findViewById(R.id.lec_no_item);
        }
    }
}

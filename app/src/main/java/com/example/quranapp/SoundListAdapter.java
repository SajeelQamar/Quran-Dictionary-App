package com.example.quranapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SoundListAdapter extends ArrayAdapter {
    Activity context;
    String[] mp3;





    public SoundListAdapter(Activity context, String[] mp3) {
        super(context, R.layout.audio_button_item, mp3);
        this.context = context;
        this.mp3=mp3;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.audio_button_item, null, true);
//        TextView textViewCountry = (TextView) row.findViewById(R.id.textViewCountry);
//        TextView textViewCapital = (TextView) row.findViewById(R.id.textViewCapital);
//        ImageView imageFlag = (ImageView) row.findViewById(R.id.imageViewFlag);
//
//        textViewCountry.setText(countryNames[position]);
//        textViewCapital.setText(capitalNames[position]);
//        imageFlag.setImageResource(imageid[position]);
        return  row;
    }
}

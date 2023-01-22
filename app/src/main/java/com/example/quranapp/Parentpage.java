package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Parentpage extends AppCompatActivity {
    TextView showparentname;
    Button btnchild;
    SharedPreferences sp;
    RecyclerView recview;
    public  static sqllitehelper sqllitehelper;
    ArrayList<Model> list = new ArrayList<Model>();
    RetrieveAdapter adapter;
    String spname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentpage);
        sp=getSharedPreferences("myuser", Context.MODE_PRIVATE);
        spname=sp.getString("name","abc");

        showparentname=(TextView) findViewById(R.id.showparentname);
        showparentname.setText(spname);
        btnchild= (Button)findViewById(R.id.addchild);
        recview=(RecyclerView) findViewById(R.id.recview);

        sqllitehelper = new sqllitehelper(this, "Parentsdb.sqlite", null, 1);



        btnchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),childform.class));

            }
        });

        // get all data from sqlite
        try {
            String tbl="children11";
            Cursor cursor = sqllitehelper.getData("SELECT * FROM '"+tbl+"' WHERE pname='"+spname+"' ");
            list.clear();
            while (cursor.moveToNext()) {

                String name = cursor.getString(0);
                String age = cursor.getString(1);
                list.add(new Model(age,name));

                RetrieveAdapter adapter = new RetrieveAdapter(list, getApplicationContext());
                recview.setAdapter(adapter);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(Parentpage.this, 1);
                recview.setLayoutManager(gridLayoutManager);
            }
        }
        catch (Exception e)
        {
            //Toast.makeText(getBaseContext(), e.getMessage(),
                   // Toast.LENGTH_SHORT).show();
        }


        


    }
}
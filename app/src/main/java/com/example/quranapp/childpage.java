package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class childpage extends AppCompatActivity {

    RecyclerView recview;
    lecture_no_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childpage);
        recview=(RecyclerView)findViewById(R.id.recview_childpage);
        ArrayList<lecture_no_model> list=arr();
        lecture_no_adapter adapter = new lecture_no_adapter(list, getApplicationContext());
        recview.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(childpage.this, 1);
        recview.setLayoutManager(gridLayoutManager);

    }

    private ArrayList<lecture_no_model> arr()
    {
        ArrayList<lecture_no_model> list=new ArrayList<>();
        list.add(new lecture_no_model("Lecture # 1","table0"));
        list.add(new lecture_no_model("Lecture # 2","t2"));
        list.add(new lecture_no_model("Lecture # 3","t3"));
        list.add(new lecture_no_model("Lecture # 4","t4"));
        list.add(new lecture_no_model("Lecture # 5","t5"));
        list.add(new lecture_no_model("Lecture # 6","t6"));
        list.add(new lecture_no_model("Lecture # 7","t7"));
        list.add(new lecture_no_model("Lecture # 8","t8"));
        list.add(new lecture_no_model("Lecture # 9","t9"));
        list.add(new lecture_no_model("Lecture # 10","t10"));
        list.add(new lecture_no_model("Lecture # 11","t11"));
        list.add(new lecture_no_model("Lecture # 12","t12"));
        list.add(new lecture_no_model("Lecture # 13","t13"));
        list.add(new lecture_no_model("Lecture # 14","t14"));
        return list;
    }
}
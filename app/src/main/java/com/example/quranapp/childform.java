package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class childform extends AppCompatActivity {
    EditText id,name,age;
    Button insertchildbtn;
    SharedPreferences sp;
    String spname;
    public static sqllitehelper sqllitehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childform);
        sp=getSharedPreferences("myuser", Context.MODE_PRIVATE);

        name=(EditText) findViewById(R.id.cname);
        age=(EditText) findViewById(R.id.cage);
        insertchildbtn=(Button) findViewById(R.id.insertchldbtn);
        sqllitehelper = new sqllitehelper(this, "Parentsdb.sqlite", null, 1);
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS children11(name VARCHAR PRIMARY KEY NOT NULL,age VARCHAR,pname VARCHAR)");
        insertchildbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spname=sp.getString("name","abc");
                try {
                    sqllitehelper.insertchild(name.getText().toString().trim(),age.getText().toString().trim(),spname);
                    Toast.makeText(getApplicationContext(), "Added child successfully!", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    age.setText("");



                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
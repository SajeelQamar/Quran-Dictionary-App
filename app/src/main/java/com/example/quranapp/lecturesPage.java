package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class lecturesPage extends AppCompatActivity {
    MediaPlayer mediaPlayer=new MediaPlayer();
    String[] leftrow_eng=new String[12];
    String[] leftrow_arabic=new String[12];
    String[] leftrow_urdu=new String[12];
    String[] rightrow_eng=new String[12];
    String[] rightrow_arabic=new String[12];
    String[] rightrow_urdu=new String[12];
    String[] left_audio_arr=new String[12];

    TextView headerleft;
    TextView headerright;
    ArrayList<lecturemodel> list=new ArrayList<lecturemodel>();
    ListView lv_lefteng,lv_leftarabic,lv_lefturdu,lv_leftaudio,lv_righteng,lv_rightarabic,lv_righturdu,lv_rightaudio;
    SearchView searchView;
    View Rootview;
    public static sqllitehelper sqllitehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures_page);
        lv_lefteng=(ListView)findViewById(R.id.leftrow_list_eng);
        lv_leftarabic=(ListView)findViewById(R.id.leftrow_list_arabic);
        lv_lefturdu=(ListView)findViewById(R.id.leftrow_list_urdu);
        lv_righteng=(ListView)findViewById(R.id.rightrow_list_eng);
        lv_rightarabic=(ListView)findViewById(R.id.right_list_arabic);
        lv_righturdu=(ListView)findViewById(R.id.rightrow_list_urdu);
        lv_leftaudio=(ListView)findViewById(R.id.leftrow_list_audio);
        lv_rightaudio=(ListView)findViewById(R.id.right_list_audio);
        searchView=(SearchView)findViewById(R.id.searchView);
        Rootview=findViewById(R.id.root_layout);
        sqllitehelper = new sqllitehelper(this, "Parentsdb.sqlite", null, 1);
        headerleft=(TextView) findViewById(R.id.headerleft);
        headerright=(TextView) findViewById(R.id.headerright);




        Intent intent = getIntent();
        String tablename=intent.getStringExtra("dummytable");

        Cursor cursor1=sqllitehelper.getData("SELECT * FROM '"+tablename+"'");

        while (cursor1.moveToNext()) {
                String left_eng = cursor1.getString(0);
                String left_arabic = cursor1.getString(1);
                String left_urdu = cursor1.getString(2);
                String right_eng = cursor1.getString(4);
                String right_arabic = cursor1.getString(5);
                String right_urdu = cursor1.getString(6);
                list.add(new lecturemodel(left_eng,left_arabic,left_urdu,right_eng,right_arabic,right_urdu));



        }
        for(int i=0;i<=11;i++)
        {
            leftrow_eng[i]=list.get(i+1).getLeftrow_eng();

        }

        for(int i=0;i<=11;i++)
        {
            leftrow_arabic[i]=list.get(i+1).getLeftrow_arabic();

        }
        for(int i=0;i<=11;i++)
        {
            leftrow_urdu[i]=list.get(i+1).getLeftrow_urdu();

        }

        for(int i=0;i<=11;i++)
        {
            rightrow_eng[i]=list.get(i+1).getRightrow_eng();

        }
        for(int i=0;i<=11;i++)
        {
            rightrow_arabic[i]=list.get(i+1).getRightrow_arabic();

        }
        for(int i=0;i<=11;i++)
        {
            rightrow_urdu[i]=list.get(i+1).getRightrow_urdu();

        }
        headerleft.setText(list.get(0).leftrow_eng);
        headerright.setText(list.get(0).rightrow_eng);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leftrow_eng);
        lv_lefteng.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leftrow_arabic);
        lv_leftarabic.setAdapter(arrayAdapter1);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leftrow_urdu);
        lv_lefturdu.setAdapter(arrayAdapter2);

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rightrow_eng);
        lv_righteng.setAdapter(arrayAdapter3);

        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rightrow_arabic);
        lv_rightarabic.setAdapter(arrayAdapter4);

        ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rightrow_urdu);
        lv_righturdu.setAdapter(arrayAdapter5);


        SoundListAdapter soundListAdapter=new SoundListAdapter(this,left_audio_arr);
        lv_leftaudio.setAdapter(soundListAdapter);

        SoundListAdapter soundListAdapter1=new SoundListAdapter(this,left_audio_arr);
        lv_rightaudio.setAdapter(soundListAdapter1);

        lv_leftaudio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int var=position+1;
                 Cursor c = sqllitehelper.getData("select leftaudio from '"+tablename+"' WHERE id='"+var+"'");
                 if(c.moveToNext()) {
                     byte[] audio = c.getBlob(0);
                     c.close();
                     try {


                         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audio);
                         File audio1 = null;

                         audio1 = File.createTempFile("sound", "sound");

                         FileOutputStream fos = null;

                         fos = new FileOutputStream(audio1);


                         fos.write(audio);


                         fos.close();


                         mediaPlayer.reset();

                         mediaPlayer.setDataSource(audio1.getAbsolutePath());


                         mediaPlayer.prepare();

                         mediaPlayer.start();
                     }catch (Exception e)
                     {

                     }


                 }



            }
        });

lv_rightaudio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int var=position+1;
        Cursor c = sqllitehelper.getData("select rightaudio from '"+tablename+"' WHERE id='"+var+"'");
        if(c.moveToNext()) {
            byte[] audio = c.getBlob(0);
            c.close();
            try {


                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audio);
                File audio1 = null;

                audio1 = File.createTempFile("sound", "sound");

                FileOutputStream fos = null;

                fos = new FileOutputStream(audio1);


                fos.write(audio);


                fos.close();


                mediaPlayer.reset();

                mediaPlayer.setDataSource(audio1.getAbsolutePath());


                mediaPlayer.prepare();

                mediaPlayer.start();
            }catch (Exception e)
            {

            }


        }
    }
});


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                arrayAdapter1.getFilter().filter(newText);
                arrayAdapter2.getFilter().filter(newText);
                arrayAdapter3.getFilter().filter(newText);
                arrayAdapter4.getFilter().filter(newText);
                arrayAdapter5.getFilter().filter(newText);
                return false;
            }
        });

        lv_lefteng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String var=arrayAdapter.getItem(position);

            }
        });

        lv_lefteng.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        lv_lefturdu.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        lv_leftarabic.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        lv_righteng.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        lv_rightarabic.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        lv_righturdu.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        lv_leftaudio.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

        lv_rightaudio.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchView.setQuery("", false);
        Rootview.requestFocus();
    }
}
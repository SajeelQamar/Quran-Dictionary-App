package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.net.DatagramPacket;

public class MainActivity extends AppCompatActivity {

    public static sqllitehelper sqllitehelper;
    Button addparent, nextbtn;
    EditText tvparent;
    String name, pname;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("myuser", Context.MODE_PRIVATE);
        addparent = (Button) findViewById(R.id.insertparent);
        nextbtn = (Button) findViewById(R.id.nextbtn);
        tvparent = (EditText) findViewById(R.id.name);

        sqllitehelper = new sqllitehelper(this, "Parentsdb.sqlite", null, 1);
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS Parent(name VARCHAR PRIMARY KEY NOT NULL)");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS table0(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,leftaudio blob,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,rightaudio blob,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t2(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t3(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t4(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t5(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t6(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t7(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t8(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t9(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t10(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t11(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t12(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t13(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t14(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        sqllitehelper.queryData("CREATE TABLE IF NOT EXISTS t15(lefteng VARCHAR ,leftarabic VARCHAR ,lefturdu VARCHAR,righteng VARCHAR,rightarabic VARCHAR,righturdu VARCHAR,id VARCHAR PRIMARY KEY NOT NULL   )");
        lecture1();
//        lecture2();
//        lecture3();
//        lecture4();
//        lecture5();
//        lecture6();
//        lecture7();
//        lecture8();
//        lecture9();
//        lecture10();
//        lecture11();
//        lecture12();
//        lecture13();
//        lecture14();
        addparent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                pname = tvparent.getText().toString().trim();


                try {
                    sqllitehelper.insertData(tvparent.getText().toString().trim());

                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pname = tvparent.getText().toString().trim();
//                Cursor cursor = sqllitehelper.getData("SELECT name FROM parent WHERE name = '"+pname+"'");
//                while (cursor.moveToNext()) {
//                    String name = cursor.getString(0);
//                }
//                   // Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();


                if (!tvparent.getText().toString().trim().equals("")) {
                    Cursor cursor1 = sqllitehelper.getData("SELECT name FROM Parent WHERE name='" + pname + "'");
                    while (cursor1.moveToNext()) {
                        name = cursor1.getString(0);
                    }
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("name", name);
                    editor.commit();
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), Parentpage.class));

                } else {
                    Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public void lecture1() {
        String leftrow_eng0 = "This,that";
        String leftrow_eng1 = "This";
        String leftrow_eng2 = "that";
        String leftrow_eng3 = "This";
        String leftrow_eng4 = "that";
        String leftrow_eng5 = "these";
        String leftrow_eng6 = "those";
        String leftrow_eng7 = "he who";
        String leftrow_eng8 = "she who";
        String leftrow_eng9 = "those who";
        String leftrow_eng10 = "these";
        String leftrow_eng11 = "those";
        String leftrow_eng12 = "those who";

        String leftrow_arabic0 = "This,that";
        String leftrow_arabic1 = "mg هَٰذَا";
        String leftrow_arabic2 = "mg ذٰلِكَ";
        String leftrow_arabic3 = "fgهذِهٍ";
        String leftrow_arabic4 = "fg تِلْكَ";
        String leftrow_arabic5 = "mg/fg هؤُلَاء";
        String leftrow_arabic6 = "mg/fg اُولئِكَ";
        String leftrow_arabic7 = "mg الَّذِي";
        String leftrow_arabic8 = "fg الَّتِي ";
        String leftrow_arabic9 = "mg الَّذِينَ";
        String leftrow_arabic10 = "(for br.pl)هذِهِ";
        String leftrow_arabic11 = "(for br.pl)تِلْكَ";
        String leftrow_arabic12 = "(for br.pl)الَّتِي";

        String leftrow_urdu0 = "This,that";
        String leftrow_urdu1 = "یہ";
        String leftrow_urdu2 = " وہ";
        String leftrow_urdu3 = "یہ";
        String leftrow_urdu4 = "ؤہ";
        String leftrow_urdu5 = "یہ سب";
        String leftrow_urdu6 = "ؤہ سب";
        String leftrow_urdu7 = "ؤہ جو";
        String leftrow_urdu8 = "ؤہ جو";
        String leftrow_urdu9 = "ؤہ سب جو";
        String leftrow_urdu10 = "یہ سب";
        String leftrow_urdu11 = "ؤہ سب";
        String leftrow_urdu12 = "ؤہ سب جو";


        String rightrow_eng0 = "No,No!!";
        String rightrow_eng1 = "There is no god";
        String rightrow_eng2 = "except Allah";
        String rightrow_eng3 = "never,certainly not";
        String rightrow_eng4 = "not";
        String rightrow_eng5 = "not";
        String rightrow_eng6 = "not";
        String rightrow_eng7 = "not";
        String rightrow_eng8 = "yes, indeed";
        String rightrow_eng9 = "not, other than";
        String rightrow_eng10 = "besides, less than";
        String rightrow_eng11 = "except, unless, if not";
        String rightrow_eng12 = "yes";

        String rightrow_arabic0 = "No,No!!";
        String rightrow_arabic1 = "لَا إلهَ";
        String rightrow_arabic2 = "إلَّا الله";
        String rightrow_arabic3 = "كَلّا";
        String rightrow_arabic4 = "(for future) لَنْ";
        String rightrow_arabic5 = "(for past)لَمْ";
        String rightrow_arabic6 = "مَا";
        String rightrow_arabic7 = "fg لَيْسَ";
        String rightrow_arabic8 = "بَلَى";
        String rightrow_arabic9 = "غَيْر";
        String rightrow_arabic10 = "دُونَ";
        String rightrow_arabic11 = "إلَّا";
        String rightrow_arabic12 = "نَعَمْ";

        String rightrow_urdu0 = "NO,No!!";
        String rightrow_urdu1 = "نہیں کوئی مابود";
        String rightrow_urdu2 = "سوائے اللہ کے";
        String rightrow_urdu3 = "ہرگزنہيں";
        String rightrow_urdu4 = "ہرگزنہيں";
        String rightrow_urdu5 = "نہيں";
        String rightrow_urdu6 = "کیا،جو،نہيں";
        String rightrow_urdu7 = "نہيں";
        String rightrow_urdu8 = "کیوں نہیں";
        String rightrow_urdu9 = "سواۓ،نہ";
        String rightrow_urdu10 = "سواۓ";
        String rightrow_urdu11 = "سواۓ،مگر";
        String rightrow_urdu12 = "ہاں";



        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            InputStream leftinputStream0 = getAssets().open("1.mp4");
            InputStream leftinputStream1 = getAssets().open("1.mp4");
            InputStream leftinputStream2 = getAssets().open("2.mp4");
            InputStream leftinputStream3 = getAssets().open("3.mp4");
            InputStream leftinputStream4 = getAssets().open("4.mp4");
            InputStream leftinputStream5 = getAssets().open("5.mp4");
            InputStream leftinputStream6 = getAssets().open("6.mp4");
            InputStream leftinputStream7 = getAssets().open("7.mp4");
            InputStream leftinputStream8 = getAssets().open("8.mp4");
            InputStream leftinputStream9 = getAssets().open("9.mp4");
            InputStream leftinputStream10 = getAssets().open("10.mp4");
            InputStream leftinputStream11 = getAssets().open("11.mp4");
            InputStream leftinputStream12 = getAssets().open("12.mp4");

            InputStream rightinputStream0 = getAssets().open("13.mp4");
            InputStream rightinputStream1 = getAssets().open("13.mp4");
            InputStream rightinputStream2 = getAssets().open("14.mp4");
            InputStream rightinputStream3 = getAssets().open("15.mp4");
            InputStream rightinputStream4 = getAssets().open("16.mp4");
            InputStream rightinputStream5 = getAssets().open("17.mp4");
            InputStream rightinputStream6 = getAssets().open("18.mp4");
            InputStream rightinputStream7 = getAssets().open("19.mp4");
            InputStream rightinputStream8 = getAssets().open("20.mp4");
            InputStream rightinputStream9 = getAssets().open("21.mp4");
            InputStream rightinputStream10 = getAssets().open("22.mp4");
            InputStream rightinputStream11 = getAssets().open("23.mp4");
            InputStream rightinputStream12 = getAssets().open("24.mp4");

            byte[] leftaudio0 = new byte[leftinputStream0.available()];
            byte[] leftaudio1 = new byte[leftinputStream1.available()];
            byte[] leftaudio2 = new byte[leftinputStream2.available()];
            byte[] leftaudio3 = new byte[leftinputStream3.available()];
            byte[] leftaudio4 = new byte[leftinputStream4.available()];
            byte[] leftaudio5 = new byte[leftinputStream5.available()];
            byte[] leftaudio6 = new byte[leftinputStream6.available()];
            byte[] leftaudio7 = new byte[leftinputStream7.available()];
            byte[] leftaudio8 = new byte[leftinputStream8.available()];
            byte[] leftaudio9 = new byte[leftinputStream9.available()];
            byte[] leftaudio10 = new byte[leftinputStream10.available()];
            byte[] leftaudio11 = new byte[leftinputStream11.available()];
            byte[] leftaudio12 = new byte[leftinputStream12.available()];

            byte[] rightaudio0 = new byte[rightinputStream0.available()];
            byte[] rightaudio1 = new byte[rightinputStream1.available()];
            byte[] rightaudio2 = new byte[rightinputStream2.available()];
            byte[] rightaudio3 = new byte[rightinputStream3.available()];
            byte[] rightaudio4 = new byte[rightinputStream4.available()];
            byte[] rightaudio5 = new byte[rightinputStream5.available()];
            byte[] rightaudio6 = new byte[rightinputStream6.available()];
            byte[] rightaudio7 = new byte[rightinputStream7.available()];
            byte[] rightaudio8 = new byte[rightinputStream8.available()];
            byte[] rightaudio9 = new byte[rightinputStream9.available()];
            byte[] rightaudio10 = new byte[rightinputStream10.available()];
            byte[] rightaudio11 = new byte[rightinputStream11.available()];
            byte[] rightaudio12 = new byte[rightinputStream12.available()];

            leftinputStream0.read(leftaudio0);
            leftinputStream1.read(leftaudio1);
            leftinputStream2.read(leftaudio2);
            leftinputStream3.read(leftaudio3);
            leftinputStream4.read(leftaudio4);
            leftinputStream5.read(leftaudio5);
            leftinputStream6.read(leftaudio6);
            leftinputStream7.read(leftaudio7);
            leftinputStream8.read(leftaudio8);
            leftinputStream9.read(leftaudio9);
            leftinputStream10.read(leftaudio10);
            leftinputStream11.read(leftaudio11);
            leftinputStream12.read(leftaudio12);

            rightinputStream0.read(rightaudio0);
            rightinputStream1.read(rightaudio1);
            rightinputStream2.read(rightaudio2);
            rightinputStream3.read(rightaudio3);
            rightinputStream4.read(rightaudio4);
            rightinputStream5.read(rightaudio5);
            rightinputStream6.read(rightaudio6);
            rightinputStream7.read(rightaudio7);
            rightinputStream8.read(rightaudio8);
            rightinputStream9.read(rightaudio9);
            rightinputStream10.read(rightaudio10);
            rightinputStream11.read(rightaudio11);
            rightinputStream12.read(rightaudio12);

//

            sqllitehelper.insertlec1(leftrow_eng0, leftrow_arabic0, leftrow_urdu0,leftaudio0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0,rightaudio0, id0);
            sqllitehelper.insertlec1(leftrow_eng1, leftrow_arabic1, leftrow_urdu1,leftaudio1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1,rightaudio1, id1);
            sqllitehelper.insertlec1(leftrow_eng2, leftrow_arabic2, leftrow_urdu2,leftaudio2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2,rightaudio2, id2);
            sqllitehelper.insertlec1(leftrow_eng3, leftrow_arabic3, leftrow_urdu3,leftaudio3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3,rightaudio3, id3);
            sqllitehelper.insertlec1(leftrow_eng4, leftrow_arabic4, leftrow_urdu4,leftaudio4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4,rightaudio4, id4);
            sqllitehelper.insertlec1(leftrow_eng5, leftrow_arabic5, leftrow_urdu5,leftaudio5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5,rightaudio5, id5);
            sqllitehelper.insertlec1(leftrow_eng6, leftrow_arabic6, leftrow_urdu6,leftaudio6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6,rightaudio6, id6);
            sqllitehelper.insertlec1(leftrow_eng7, leftrow_arabic7, leftrow_urdu7,leftaudio7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7,rightaudio7, id7);
            sqllitehelper.insertlec1(leftrow_eng8, leftrow_arabic8, leftrow_urdu8,leftaudio8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8,rightaudio8, id8);
            sqllitehelper.insertlec1(leftrow_eng9, leftrow_arabic9, leftrow_urdu9,leftaudio9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9,rightaudio9, id9);
            sqllitehelper.insertlec1(leftrow_eng10, leftrow_arabic10, leftrow_urdu10,leftaudio10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10,rightaudio10, id10);
            sqllitehelper.insertlec1(leftrow_eng11, leftrow_arabic11, leftrow_urdu11,leftaudio11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11,rightaudio11, id11);
            sqllitehelper.insertlec1(leftrow_eng12, leftrow_arabic12, leftrow_urdu12,leftaudio12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12,rightaudio12, id12);

            leftinputStream0.close();
            leftinputStream1.close();
            leftinputStream2.close();
            leftinputStream3.close();
            leftinputStream4.close();
            leftinputStream5.close();
            leftinputStream6.close();
            leftinputStream7.close();
            leftinputStream8.close();
            leftinputStream9.close();
            leftinputStream10.close();
            leftinputStream11.close();
            leftinputStream12.close();

            rightinputStream0.close();
            rightinputStream1.close();
            rightinputStream2.close();
            rightinputStream3.close();
            rightinputStream4.close();
            rightinputStream5.close();
            rightinputStream6.close();
            rightinputStream7.close();
            rightinputStream8.close();
            rightinputStream9.close();
            rightinputStream10.close();
            rightinputStream11.close();
            rightinputStream12.close();


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

             Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void lecture2() {
        String leftrow_eng0 = "Whose ?";
        String leftrow_eng1 = "his";
        String leftrow_eng2 = "their";
        String leftrow_eng3 = "your";
        String leftrow_eng4 = "yours truly";
        String leftrow_eng5 = "my";
        String leftrow_eng6 = "us";
        String leftrow_eng7 = " her";
        String leftrow_eng8 = "their";
        String leftrow_eng9 = "Yours truly";
        String leftrow_eng10 = "their";
        String leftrow_eng11 = "their";
        String leftrow_eng12 = "your";

        String leftrow_arabic0 = "Whose ?";
        String leftrow_arabic1 = "(mg) هُ";
        String leftrow_arabic2 = "(mg) هُمَْ";
        String leftrow_arabic3 = "(mg) كٍَ";
        String leftrow_arabic4 = "(mg) كُمَْ";
        String leftrow_arabic5 = "(me) يْ";
        String leftrow_arabic6 = "(mg/fg) نَاَ";
        String leftrow_arabic7 = " (fg)  هَا";
        String leftrow_arabic8 = "(fg) هُنَّ  ";
        String leftrow_arabic9 = "(fg) كَ";
        String leftrow_arabic10 = "(for bl.pl)هَا ِ";
        String leftrow_arabic11 = "(dl) هُمَا";
        String leftrow_arabic12 = "(dl) كُمَا ";


        String leftrow_urdu0 = "Whose ?";
        String leftrow_urdu1 = "اس کا۔کی۔کے";
        String leftrow_urdu2 = " ان کا۔کی۔کے";
        String leftrow_urdu3 = "آپ کا۔کی۔کے";
        String leftrow_urdu4 = "آپ سب کا۔کی۔کے";
        String leftrow_urdu5 = "میرا ";
        String leftrow_urdu6 = "ہمارا";
        String leftrow_urdu7 = "اس کا۔کی۔کے";
        String leftrow_urdu8 = "ان کا۔کی۔کے";
        String leftrow_urdu9 = "آپ کا۔کی۔کے";
        String leftrow_urdu10 = "ان سب کا۔کی۔کے";
        String leftrow_urdu11 = "ان دونوں کا";
        String leftrow_urdu12 = "آپ دونوں کا";


        String rightrow_eng0 = "Who ?";
        String rightrow_eng1 = "he";
        String rightrow_eng2 = "Them";
        String rightrow_eng3 = "you ";
        String rightrow_eng4 = " you all";
        String rightrow_eng5 = "I";
        String rightrow_eng6 = " We";
        String rightrow_eng7 = "She ";
        String rightrow_eng8 = "They";
        String rightrow_eng9 = "You ";
        String rightrow_eng10 = "They";
        String rightrow_eng11 = "Those two";
        String rightrow_eng12 = "You two";

        String rightrow_arabic0 = "Who ?";
        String rightrow_arabic1 = "(mg) هُوَ َ";
        String rightrow_arabic2 = " (mg) هُمْ ";
        String rightrow_arabic3 = " (mg) أَنْتَ";
        String rightrow_arabic4 = "(mg)أَنْتُم ";
        String rightrow_arabic5 = "(mg/fg)أَنَا ";
        String rightrow_arabic6 = "(mg/fg)نَحْنُ ";
        String rightrow_arabic7 = "(fg) هِيَ ";
        String rightrow_arabic8 = "(fg) هُنَّ ";
        String rightrow_arabic9 = "(fg)  أَنْتِ ";
        String rightrow_arabic10 = "(for br.pl) هِيَ ";
        String rightrow_arabic11 = " (dl) هُمَا ";
        String rightrow_arabic12 = "(dl)أَنْتُمَا ";


        String rightrow_urdu0 = "Who ?";
        String rightrow_urdu1 = " وہ ";
        String rightrow_urdu2 = " وہ سب  ";
        String rightrow_urdu3 = "  آپ  ";
        String rightrow_urdu4 = " آپ سب  ";
        String rightrow_urdu5 = "میں ";
        String rightrow_urdu6 = "  ہم ";
        String rightrow_urdu7 = "  وہ ";
        String rightrow_urdu8 = " وہ سب ";
        String rightrow_urdu9 = "آپ ";
        String rightrow_urdu10 = " وہ سب ";
        String rightrow_urdu11 = " وہ دونوں ";
        String rightrow_urdu12 = "آپ دونوں ";


        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec2(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec2(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec2(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec2(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec2(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec2(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec2(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec2(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec2(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec2(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec2(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec2(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec2(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            //   Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void lecture3() {

        String leftrow_eng0 = "Where?";
        String leftrow_eng1 = "above,up";
        String leftrow_eng2 = "under";
        String leftrow_eng3 = "in front of";
        String leftrow_eng4 = "back,after";
        String leftrow_eng5 = "in front of";
        String leftrow_eng6 = " behind ";
        String leftrow_eng7 = "right;oath";
        String leftrow_eng8 = " left";
        String leftrow_eng9 = " between ";
        String leftrow_eng10 = " around ";
        String leftrow_eng11 = "wherever";
        String leftrow_eng12 = "wherever";

        String leftrow_arabic0 = "Where?";
        String leftrow_arabic1 = "فَوْقَ ";
        String leftrow_arabic2 = "تَحْتَ ";
        String leftrow_arabic3 = "بَيْنَ أَيَدَيِ،";
        String leftrow_arabic4 = "خَلْفَ ";
        String leftrow_arabic5 = "أَمَامَ ";
        String leftrow_arabic6 = "وَرَاء ";
        String leftrow_arabic7 = "يَمِيْن ";
        String leftrow_arabic8 = "شِمَال  ";
        String leftrow_arabic9 = "بَيْنَ ";
        String leftrow_arabic10 = "حَوْلَ ";
        String leftrow_arabic11 = "حَيْثُ ";
        String leftrow_arabic12 = "أيْنَمَا ";


        String leftrow_urdu0 = "Where?";
        String leftrow_urdu1 = "اوپر ";
        String leftrow_urdu2 = "  نیچے ";
        String leftrow_urdu3 = " سامنے";
        String leftrow_urdu4 = "پیچھے ";
        String leftrow_urdu5 = "  سامنے";
        String leftrow_urdu6 = "پیچھے ";
        String leftrow_urdu7 = " قسم, دائیں ";
        String leftrow_urdu8 = " بائیں ";
        String leftrow_urdu9 = " درمیان";
        String leftrow_urdu10 = " اطراف ";
        String leftrow_urdu11 = "جہاں،جس جگہ";
        String leftrow_urdu12 = "جہاں ";

        String rightrow_eng0 = "Questions ?";
        String rightrow_eng1 = "what?,that which";
        String rightrow_eng2 = "Who?, the onw who";
        String rightrow_eng3 = " When? the time when";
        String rightrow_eng4 = "Where? ";
        String rightrow_eng5 = "how?";
        String rightrow_eng6 = "how many?";
        String rightrow_eng7 = "which?";
        String rightrow_eng8 = "wherefrom?,why ";
        String rightrow_eng9 = "Is?Am?Are?Do?Have ";
        String rightrow_eng10 = " what?";
        String rightrow_eng11 = " why?";
        String rightrow_eng12 = "ifnot,whynot ";

        String rightrow_arabic0 = "Questions ?";
        String rightrow_arabic1 = "مَا َ";
        String rightrow_arabic2 = "مَنْ ";
        String rightrow_arabic3 = "مَتى ";
        String rightrow_arabic4 = "أَيْنَ ";
        String rightrow_arabic5 = "كَيْفَ ";
        String rightrow_arabic6 = "كَمْ ";
        String rightrow_arabic7 = "أَيُّ ";
        String rightrow_arabic8 = "أَنّى ";
        String rightrow_arabic9 = "أَ،هَل ";
        String rightrow_arabic10 = "مَذَا َ";
        String rightrow_arabic11 = " لمَ،لِمَذَا ";
        String rightrow_arabic12 = "لَوْ لَاْ";


        String rightrow_urdu0 = "Questions ?";
        String rightrow_urdu1 = "کیا،جو ";
        String rightrow_urdu2 = " کون،جو ";
        String rightrow_urdu3 = "  کب،جب ";
        String rightrow_urdu4 = " کہاں،جہاں";
        String rightrow_urdu5 = " کیسے،جیسے ";
        String rightrow_urdu6 = " کتنا،جتنا ";
        String rightrow_urdu7 = "کونسا،جو ";
        String rightrow_urdu8 = " کہاں سے،جہاں سے ";
        String rightrow_urdu9 = " کیا؟  ";
        String rightrow_urdu10 = " کیا؟  ";
        String rightrow_urdu11 = " کیا؟  ";
        String rightrow_urdu12 = " اگر نہ،کیوں نہیں؟   ";


        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec3(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec3(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec3(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec3(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec3(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec3(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec3(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec3(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec3(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec3(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec3(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec3(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec3(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            //   Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void lecture4() {

        String leftrow_eng0 = "Miscellaneous";
        String leftrow_eng1 = " endowed with;owner";
        String leftrow_eng2 = " endowed with;owner";
        String leftrow_eng3 = " people of;owners of";
        String leftrow_eng4 = "people of;relatives";
        String leftrow_eng5 = "family,realtives,people";
        String leftrow_eng6 = " donot,willnot ";
        String leftrow_eng7 = " what an excellent ";
        String leftrow_eng8 = "  what an evil ";
        String leftrow_eng9 = "  evil is that which ";
        String leftrow_eng10 = " sth similar ";
        String leftrow_eng11 = "similitude";
        String leftrow_eng12 = " than the one who";

        String leftrow_arabic0 = "Miscellaneous";
        String leftrow_arabic1 = "(mg) ذُو،ذَا،ذِي ";
        String leftrow_arabic2 = "(fg) ذَات ";
        String leftrow_arabic3 = "أُوْلْواْ،أُوْلي";
        String leftrow_arabic4 = "أهْل  ";
        String leftrow_arabic5 = "آل  ";
        String leftrow_arabic6 = "أَلَا  ";
        String leftrow_arabic7 = "نِعْمَ  ";
        String leftrow_arabic8 = "بِئسَ   ";
        String leftrow_arabic9 = "بِئْسَمَا  ";
        String leftrow_arabic10 = "مِثْل  ";
        String leftrow_arabic11 = "مَثَل  ";
        String leftrow_arabic12 = "مِمَّنْ  ";


        String leftrow_urdu0 = "Miscellaneous";
        String leftrow_urdu1 = "والا ";
        String leftrow_urdu2 = "والی ";
        String leftrow_urdu3 = " والے";
        String leftrow_urdu4 = "والا ";
        String leftrow_urdu5 = "  قوم ،گہرکے لوگ،اتباغ کرنے والے";
        String leftrow_urdu6 = "خبردار،کیا نہیں ";
        String leftrow_urdu7 = " کیا ہی خوب،کیا ہی اچھا ";
        String leftrow_urdu8 = " کیا ہی برا ";
        String leftrow_urdu9 = " برا ہے جو";
        String leftrow_urdu10 = " جیسے ";
        String leftrow_urdu11 = "مثال";
        String leftrow_urdu12 = "(اس) سے جو ";

        String rightrow_eng0 = "When ?";
        String rightrow_eng1 = "before ";
        String rightrow_eng2 = " after ";
        String rightrow_eng3 = "  time,period";
        String rightrow_eng4 = " when ";
        String rightrow_eng5 = "when";
        String rightrow_eng6 = "then";
        String rightrow_eng7 = " therefore";
        String rightrow_eng8 = "but  ";
        String rightrow_eng9 = "near,with  ";
        String rightrow_eng10 = " nothing but";
        String rightrow_eng11 = " nothing but";
        String rightrow_eng12 = "than the one who ";

        String rightrow_arabic0 = "When ?";
        String rightrow_arabic1 = "قَبْل ََ";
        String rightrow_arabic2 = "بَعْد  ";
        String rightrow_arabic3 = "حِين  ";
        String rightrow_arabic4 = "(for past)إذْ  ";
        String rightrow_arabic5 = "(for future)إذَا ";
        String rightrow_arabic6 = "ثُمَّ  ";
        String rightrow_arabic7 = "فُ  ";
        String rightrow_arabic8 = "بَل  ";
        String rightrow_arabic9 = "عِنْدَ،لَدى،لَدُنْ  ";
        String rightrow_arabic10 = "إِنْ...إِلَّا َ";
        String rightrow_arabic11 = "  مَا...إِلَّا  ";
        String rightrow_arabic12 = "أُلٌاْ";


        String rightrow_urdu0 = "When ?";
        String rightrow_urdu1 = "پہلے  ";
        String rightrow_urdu2 = " بعد ";
        String rightrow_urdu3 = "  وقت،مدت ";
        String rightrow_urdu4 = " جب ";
        String rightrow_urdu5 = " جب  ";
        String rightrow_urdu6 = "  پھر ";
        String rightrow_urdu7 = "پس،تو  ";
        String rightrow_urdu8 = " بلکہ  ";
        String rightrow_urdu9 = " پاس،نذدیک   ";
        String rightrow_urdu10 = " نہیں،مگر   ";
        String rightrow_urdu11 = "  نہیں،مگر  ";
        String rightrow_urdu12 = "   کہ نہیں   ";


        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec4(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec4(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec4(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec4(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec4(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec4(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec4(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec4(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec4(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec4(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec4(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec4(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec4(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            //   Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void lecture5() {


        String leftrow_eng0 = " Prepositions + مَا ...";
        String leftrow_eng1 = " with that,because";
        String leftrow_eng2 = "  about what ";
        String leftrow_eng3 = "  in what ";
        String leftrow_eng4 = "as,just as ";
        String leftrow_eng5 = "for what/that which";
        String leftrow_eng6 = " out of what  ";
        String leftrow_eng7 = " as to,as for ";
        String leftrow_eng8 = " if;either,or ";
        String leftrow_eng9 = "  that";
        String leftrow_eng10 = "  verily,is but  ";
        String leftrow_eng11 = "as if ";
        String leftrow_eng12 = " whenever";

        String leftrow_arabic0 = "Prepositions + مَا ...";
        String leftrow_arabic1 = "بِمَا ";
        String leftrow_arabic2 = "عَمَّا ";
        String leftrow_arabic3 = "فِيمَا ";
        String leftrow_arabic4 = "كَمَا   ";
        String leftrow_arabic5 = "لِمَا   ";
        String leftrow_arabic6 = "مِمَّا   ";
        String leftrow_arabic7 = "أَمَّا   ";
        String leftrow_arabic8 = "إِمَّا    ";
        String leftrow_arabic9 = "أَنَّمَا   ";
        String leftrow_arabic10 = "إِنَّمَا   ";
        String leftrow_arabic11 = "كَاَنَّمَا   ";
        String leftrow_arabic12 = "كُلَّمَا   ";


        String leftrow_urdu0 = "Prepositions + مَا ...";
        String leftrow_urdu1 = "(اس) پرجو، اس لیے کہ  ";
        String leftrow_urdu2 = "(اس) سےجو  ";
        String leftrow_urdu3 = "  (اس) میں جو ";
        String leftrow_urdu4 = " جیسا کہ  ";
        String leftrow_urdu5 = "  (اس کے) لۓ جو ";
        String leftrow_urdu6 = "(اس)سے جو  ";
        String leftrow_urdu7 = " جو   ";
        String leftrow_urdu8 = " اگر، یا  ";
        String leftrow_urdu9 = "  بے شک، یہ کہ ";
        String leftrow_urdu10 = "  صرف،بے شک  ";
        String leftrow_urdu11 = "گویا کہ";
        String leftrow_urdu12 = "جب بھی ";

        String rightrow_eng0 = "Prepositions";
        String rightrow_eng1 = " with,in ";
        String rightrow_eng2 = " about ";
        String rightrow_eng3 = " in";
        String rightrow_eng4 = "  as,like ";
        String rightrow_eng5 = "for";
        String rightrow_eng6 = "from ";
        String rightrow_eng7 = " towards ";
        String rightrow_eng8 = "by(of oath)  ";
        String rightrow_eng9 = "until ";
        String rightrow_eng10 = " on";
        String rightrow_eng11 = " with  ";
        String rightrow_eng12 = " and;by(of oath) ";

        String rightrow_arabic0 = "Prepositions";
        String rightrow_arabic1 = "بِ ََ";
        String rightrow_arabic2 = "عَنْ   ";
        String rightrow_arabic3 = "فِي   ";
        String rightrow_arabic4 = "كَ   ";
        String rightrow_arabic5 = " ل،لَ  ";
        String rightrow_arabic6 = " مِنْ   ";
        String rightrow_arabic7 = "إِلَى   ";
        String rightrow_arabic8 = "تَ   ";
        String rightrow_arabic9 = "حَتَّى   ";
        String rightrow_arabic10 = "عَلَى َ";
        String rightrow_arabic11 = " مَعَ  ";
        String rightrow_arabic12 = "وَ ";


        String rightrow_urdu0 = "Prepositions";
        String rightrow_urdu1 = "ساتھ،سے،پر    ";
        String rightrow_urdu2 = " سے،بارے میں ";
        String rightrow_urdu3 = "  میں ";
        String rightrow_urdu4 = " جیسے ";
        String rightrow_urdu5 = " لۓ   ";
        String rightrow_urdu6 = "   سے ";
        String rightrow_urdu7 = "  طرف، تک  ";
        String rightrow_urdu8 = " قسم ہے  ";
        String rightrow_urdu9 = "یہاں تک کہ  ";
        String rightrow_urdu10 = "  پر   ";
        String rightrow_urdu11 = " ساتھ   ";
        String rightrow_urdu12 = "  اور   ";

        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec5(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec5(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec5(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec5(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec5(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec5(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec5(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec5(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec5(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec5(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec5(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec5(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec5(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    public void lecture6() {


        String leftrow_eng0 = "Prefix for verb,...";
        String leftrow_eng1 = "has surely";
        String leftrow_eng2 = "will(for near future)";
        String leftrow_eng3 = "will (for future)";
        String leftrow_eng4 = " will surely";
        String leftrow_eng5 = " indeed ";
        String leftrow_eng6 = "surely";
        String leftrow_eng7 = "let sb do (imperative)";
        String leftrow_eng8 = "the ";
        String leftrow_eng9 = " or? ";
        String leftrow_eng10 = " or";
        String leftrow_eng11 = "some of ";
        String leftrow_eng12 = "everyone";

        String leftrow_arabic0 = "Prefix for verb,...";
        String leftrow_arabic1 = "قَدْ (+فعل) ";
        String leftrow_arabic2 = "سَ (+فعل)";
        String leftrow_arabic3 = "سَوْفَ (+فعل)";
        String leftrow_arabic4 = "لَ+فعل+نَّ ";
        String leftrow_arabic5 = " لَقَدْ(+فعل) ";
        String leftrow_arabic6 = "لَ ";
        String leftrow_arabic7 = "ل،لْ(أَمْر)";
        String leftrow_arabic8 = "الْ ";
        String leftrow_arabic9 = "اَمْ ";
        String leftrow_arabic10 = "اَوْ ";
        String leftrow_arabic11 = "بَعْض ";
        String leftrow_arabic12 = "كُلَّ ";


        String leftrow_urdu0 = "Prefix for verb,...";
        String leftrow_urdu1 = "يقيناً";
        String leftrow_urdu2 = " بہت جلد ";
        String leftrow_urdu3 = "جلد";
        String leftrow_urdu4 = "ضرور ";
        String leftrow_urdu5 = "تہقیق";
        String leftrow_urdu6 = "ضرور(تاکید کے لۓ)";
        String leftrow_urdu7 = "چاہیے کہ";
        String leftrow_urdu8 = "وُه";
        String leftrow_urdu9 = "يا۔۔۔؟ ";
        String leftrow_urdu10 = "يا";
        String leftrow_urdu11 = "بعَض";
        String leftrow_urdu12 = "سارے";

        String rightrow_eng0 = "Inna...";
        String rightrow_eng1 = "truly";
        String rightrow_eng2 = "that";
        String rightrow_eng3 = "as if";
        String rightrow_eng4 = "but";
        String rightrow_eng5 = "may be";
        String rightrow_eng6 = "that";
        String rightrow_eng7 = "if";
        String rightrow_eng8 = "alone";
        String rightrow_eng9 = "possibly ";
        String rightrow_eng10 = "when";
        String rightrow_eng11 = "if";
        String rightrow_eng12 = "O! ";

        String rightrow_arabic0 = "Inna...";
        String rightrow_arabic1 = "إنّ ";
        String rightrow_arabic2 = "أَنَّ ";
        String rightrow_arabic3 = "كَأَنَّ ";
        String rightrow_arabic4 = "لكِنَّ ";
        String rightrow_arabic5 = "لَعَلَّ ";
        String rightrow_arabic6 = "أَنْ ";
        String rightrow_arabic7 = "إِنْ ";
        String rightrow_arabic8 = "إِيَّا ";
        String rightrow_arabic9 = "عَسَى ";
        String rightrow_arabic10 = "لَمَّا ";
        String rightrow_arabic11 = "لَوْ ";
        String rightrow_arabic12 = "يَا،يَاأَيُّهَا";


        String rightrow_urdu0 = "Inna...";
        String rightrow_urdu1 = "بے شک ";
        String rightrow_urdu2 = "کہ";
        String rightrow_urdu3 = " گویا کہ";
        String rightrow_urdu4 = "لیکن";
        String rightrow_urdu5 = "شائد کہ";
        String rightrow_urdu6 = "کہ";
        String rightrow_urdu7 = "اگر";
        String rightrow_urdu8 = "ہی";
        String rightrow_urdu9 = "ممکن ہے";
        String rightrow_urdu10 = "جب ";
        String rightrow_urdu11 = "اگر";
        String rightrow_urdu12 = "اۓ ";

        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec6(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec6(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec6(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec6(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec6(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec6(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec6(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec6(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec6(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec6(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec6(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec6(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec6(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void lecture7() {


        String leftrow_eng0="Some attributes (of Allah and others)";
        String leftrow_eng1=" knowing,everaware";
        String leftrow_eng2="Lord ";
        String leftrow_eng3="Compassionate";
        String leftrow_eng4=" Peace";
        String leftrow_eng5=" one who listens ";
        String leftrow_eng6="grateful";
        String leftrow_eng7="mighty ";
        String leftrow_eng8=" most forgiving  ";
        String leftrow_eng9=" all-powerfull";
        String leftrow_eng10=" warner";
        String leftrow_eng11="strong helper ";
        String leftrow_eng12="one who takes care of thing for another ";

        String leftrow_arabic0="Some attributes (of Allah and others)";
        String leftrow_arabic1="خَبِير ";
        String leftrow_arabic2="رَبّ ";
        String leftrow_arabic3="رَحْمن ";
        String leftrow_arabic4="سَلَام ";
        String leftrow_arabic5=" سَمِيع  ";
        String leftrow_arabic6="شَكُور ";
        String leftrow_arabic7="عَزِيز ";
        String leftrow_arabic8="غَفُور  ";
        String leftrow_arabic9="قَدِير  ";
        String leftrow_arabic10="نَزِير ";
        String leftrow_arabic11="نَصِير ";
        String leftrow_arabic12="وَكِيل ";


        String leftrow_urdu0 ="Some attributes (of Allah and others)";
        String leftrow_urdu1 =" خبردار ";
        String leftrow_urdu2 =" پروردگار ";
        String leftrow_urdu3 ="بڑا مہربان ";
        String leftrow_urdu4 ="سلامتی ";
        String leftrow_urdu5 ="سننے والا ";
        String leftrow_urdu6 ="بڑا شکر گزار ";
        String leftrow_urdu7 ="زبردست";
        String leftrow_urdu8 ="خوب مغاف کرنے والا ";
        String leftrow_urdu9 =" قدرت والے  ";
        String leftrow_urdu10 ="ڈرانے والے";
        String leftrow_urdu11 ="مدد کرنے والا";
        String leftrow_urdu12 ="مدد گار";

        String rightrow_eng0="Some attributes (of Allah and others)";
        String rightrow_eng1="first";
        String rightrow_eng2="last";
        String rightrow_eng3="other";
        String rightrow_eng4="trustworthy";
        String rightrow_eng5="one who sees clearly";
        String rightrow_eng6="far";
        String rightrow_eng7=" most forgiving";
        String rightrow_eng8="protector";
        String rightrow_eng9="wise ";
        String rightrow_eng10="forbearing";
        String rightrow_eng11="praiseworthy";
        String rightrow_eng12="boiling water  ";

        String rightrow_arabic0="Some attributes (of Allah and others)";
        String rightrow_arabic1="(fg) أَوَّل  ";
        String rightrow_arabic2="(fg) آخِر  ";
        String rightrow_arabic3="(fg) آخَر ";
        String rightrow_arabic4="أَمِين  ";
        String rightrow_arabic5="بَصِير  ";
        String rightrow_arabic6="بَعِيد  ";
        String rightrow_arabic7="تَوَّاب  ";
        String rightrow_arabic8="حَفِيظ  ";
        String rightrow_arabic9="حَكِيم  ";
        String rightrow_arabic10="حَلِيم  ";
        String rightrow_arabic11="حَمِيد  ";
        String rightrow_arabic12="حَمِيم ";



        String rightrow_urdu0 = "Some attributes (of Allah and others)";
        String rightrow_urdu1 = " پہلا  ";
        String rightrow_urdu2 = " آخری";
        String rightrow_urdu3 = " دوسرا";
        String rightrow_urdu4 = " امانت دار";
        String rightrow_urdu5 = "دیکھنے جاننے والا ";
        String rightrow_urdu6 = " دور";
        String rightrow_urdu7 = "خوب توبہ قبول کرنے والا";
        String rightrow_urdu8 = "حفاظت کرنے والا";
        String rightrow_urdu9 = "حکمت والا ";
        String rightrow_urdu10 = " تحمل والا ";
        String rightrow_urdu11 = "تعریف کیا ہوا";
        String rightrow_urdu12 = " گرم پانی ";



        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec7(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec7(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec7(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec7(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec7(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec7(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec7(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec7(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec7(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec7(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec7(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec7(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec7(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void lecture8() {


        String leftrow_eng0="Noun of Superiority اسم تَفْضِيل";
        String leftrow_eng1=" most severe";
        String leftrow_eng2="higher ,supeior ";
        String leftrow_eng3="better-knowing";
        String leftrow_eng4="  nearer ";
        String leftrow_eng5=" bigger ";
        String leftrow_eng6=" more;most ";
        String leftrow_eng7="better ";
        String leftrow_eng8=" more worthy  ";
        String leftrow_eng9="  lower;less";
        String leftrow_eng10=" more unjust";
        String leftrow_eng11="better guided";
        String leftrow_eng12="closer;woe ";

        String leftrow_arabic0="Noun of Superiority اسم تَفْضِيل";
        String leftrow_arabic1="أَشَدّ  ";
        String leftrow_arabic2="أَعْلَ  ";
        String leftrow_arabic3="أَعْلَم  ";
        String leftrow_arabic4="أَقْرَب  ";
        String leftrow_arabic5=" أَكْبَر   ";
        String leftrow_arabic6="أَكْثَر  ";
        String leftrow_arabic7="أَحْسَن  ";
        String leftrow_arabic8="أَحَقّ   ";
        String leftrow_arabic9="أَدْنَى   ";
        String leftrow_arabic10="أَظْلَم  ";
        String leftrow_arabic11="أَهْدَى  ";
        String leftrow_arabic12="أَوْلَى  ";


        String leftrow_urdu0 ="Noun of Superiority اسم تَفْضِيل";
        String leftrow_urdu1 =" بہت سخت ";
        String leftrow_urdu2 =" بہت بلند ";
        String leftrow_urdu3 =" بہت جاننے والا ";
        String leftrow_urdu4 ="بہت قریب ";
        String leftrow_urdu5 =" بہت بڑا ";
        String leftrow_urdu6 ="بہت بڑا ";
        String leftrow_urdu7 ="بہت اچھا";
        String leftrow_urdu8 ="بڑا حق دار ";
        String leftrow_urdu9 ="کمتر  ";
        String leftrow_urdu10 ="زیادہ ظالم";
        String leftrow_urdu11 ="زیادہ ہدایت یافتہ";
        String leftrow_urdu12 ="زیادہ ہدایت یافتہ";

        String rightrow_eng0="Some attributes ";
        String rightrow_eng1="severe;strong ";
        String rightrow_eng2="high;exalted ";
        String rightrow_eng3="knower ";
        String rightrow_eng4="near";
        String rightrow_eng5="big ";
        String rightrow_eng6="plenty;much";
        String rightrow_eng7=" quick;fast";
        String rightrow_eng8="merciful";
        String rightrow_eng9="supreme ";
        String rightrow_eng10="little";
        String rightrow_eng11="honorable";
        String rightrow_eng12="subtle  ";

        String rightrow_arabic0="Some attributes";
        String rightrow_arabic1="شَدِيد ";
        String rightrow_arabic2="عَلِيّ ";
        String rightrow_arabic3="عَليِم ";
        String rightrow_arabic4="قَرِيب   ";
        String rightrow_arabic5="fg كَبِير ";
        String rightrow_arabic6="fg كَثِير";
        String rightrow_arabic7="سَرِيع   ";
        String rightrow_arabic8="رَحِيم   ";
        String rightrow_arabic9="عَظِيم   ";
        String rightrow_arabic10=" fg قَلِيل ";
        String rightrow_arabic11="كَرِيم   ";
        String rightrow_arabic12="لَطِيف  ";



        String rightrow_urdu0 = "Some attributes ";
        String rightrow_urdu1 = " سخت   ";
        String rightrow_urdu2 = " بلند";
        String rightrow_urdu3 = " خوب جاننے والا";
        String rightrow_urdu4 = "  قریب";
        String rightrow_urdu5 = "بڑا ";
        String rightrow_urdu6 = " زیادہ";
        String rightrow_urdu7 = "جلد";
        String rightrow_urdu8 = " نہایت رحم والا";
        String rightrow_urdu9 = "بڑا ";
        String rightrow_urdu10 = "  تھوڑا  ";
        String rightrow_urdu11 = "عزت والا";
        String rightrow_urdu12 = " عزت والا ";


        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec8(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec8(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec8(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec8(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec8(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec8(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec8(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec8(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec8(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec8(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec8(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec8(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec8(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void lecture9() {



        String leftrow_eng0="Prophets and ....";
        String leftrow_eng1="  Messenger";
        String leftrow_eng2="Prophet ";
        String leftrow_eng3="Prophets";
        String leftrow_eng4="    نُوح ";
        String leftrow_eng5="  إِسْمَاعِيل  ";
        String leftrow_eng6="  (إسْرَائِيل)";
        String leftrow_eng7=" شُعَيْب  ";
        String leftrow_eng8="  عِيسَى ابنُ   ";
        String leftrow_eng9=" Satan ";
        String leftrow_eng10=" pharaoh ";
        String leftrow_eng11="people of hud";
        String leftrow_eng12="people of salih  ";

        String leftrow_arabic0="Prophets and ....";
        String leftrow_arabic1="رَسُول ";
        String leftrow_arabic2="نَبِيّ ";
        String leftrow_arabic3="نَبِيُّون،نَبِيَّين،أَنْبِيَاء ";
        String leftrow_arabic4="أَدَم ";
        String leftrow_arabic5=" لُوط ";
        String leftrow_arabic6="يَعْقُوب ";
        String leftrow_arabic7="هُود ";
        String leftrow_arabic8="مُوسَى ";
        String leftrow_arabic9="شَيْطَان ";
        String leftrow_arabic10=" فِرْعَوْن ";
        String leftrow_arabic11="عَاد  ";
        String leftrow_arabic12=" ثَمُود  ";


        String leftrow_urdu0 ="Prophets and ....";
        String leftrow_urdu1 =" بھیجا ہوا  ";
        String leftrow_urdu2 =" نبی ";
        String leftrow_urdu3 =" نبی ";
        String leftrow_urdu4 ="  إِبْرَاهيِم ";
        String leftrow_urdu5 =" إِسْحاق ";
        String leftrow_urdu6 =" يُوسُف ";
        String leftrow_urdu7 ="صَالِح";
        String leftrow_urdu8 ="مَرْيَمَ ";
        String leftrow_urdu9 ="سركش،شرير  ";
        String leftrow_urdu10 ="مَصر کے بادشاہوں کا لقب";
        String leftrow_urdu11 ="ہود علیہ السلام کی قوم";
        String leftrow_urdu12 ="صَلح علیہ السلام کی قوم";

        String rightrow_eng0=" Allah's Signs...";
        String rightrow_eng1="sign ";
        String rightrow_eng2="evidence ";
        String rightrow_eng3="Quran  ";
        String rightrow_eng4="cattle ";
        String rightrow_eng5="mountain ";
        String rightrow_eng6="sea,large river ";
        String rightrow_eng7=" sun ";
        String rightrow_eng8="moon ";
        String rightrow_eng9="night  ";
        String rightrow_eng10="day";
        String rightrow_eng11="earth";
        String rightrow_eng12="sky  ";

        String rightrow_arabic0=" Allah's Signs...";
        String rightrow_arabic1="آيَته  ";
        String rightrow_arabic2="بَيَّنَته  ";
        String rightrow_arabic3="قُرْآن  ";
        String rightrow_arabic4="أَنْعَام    ";
        String rightrow_arabic5="جَبَل  ";
        String rightrow_arabic6="بَحْر ";
        String rightrow_arabic7="شَمْس    ";
        String rightrow_arabic8="قَمَر    ";
        String rightrow_arabic9="لَيْل    ";
        String rightrow_arabic10=" نَهَار ";
        String rightrow_arabic11="أَرْض    ";
        String rightrow_arabic12="سَمَاء   ";



        String rightrow_urdu0 = " Allah's Signs...";
        String rightrow_urdu1 = " آیت    ";
        String rightrow_urdu2 = " کھلی دلیل";
        String rightrow_urdu3 = "قرآن";
        String rightrow_urdu4 = "   گاۓ بکری وغیرہ ";
        String rightrow_urdu5 = "پہاڑ  ";
        String rightrow_urdu6 = " دریا";
        String rightrow_urdu7 = " سورج ";
        String rightrow_urdu8 = "  چاند ";
        String rightrow_urdu9 = "رات ";
        String rightrow_urdu10 = "  دن ";
        String rightrow_urdu11 = "زمین";
        String rightrow_urdu12 = " آسمان ";



        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec9(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec9(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec9(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec9(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec9(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec9(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec9(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec9(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec9(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec9(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec9(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec9(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec9(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void lecture10() {



        String leftrow_eng0="Last Day,...";
        String leftrow_eng1=" companion,fellow";
        String leftrow_eng2="end ";
        String leftrow_eng3="torment";
        String leftrow_eng4="chastisement(as a result of sin) ";
        String leftrow_eng5="  Resurrection  ";
        String leftrow_eng6="  meeting";
        String leftrow_eng7="  fixed   ";
        String leftrow_eng8="  river  ";
        String leftrow_eng9=" fire   ";
        String leftrow_eng10=" woe unto ";
        String leftrow_eng11="day ";
        String leftrow_eng12=" that day   ";

        String leftrow_arabic0="Last Day,...";
        String leftrow_arabic1="صَاحِب  ";
        String leftrow_arabic2="عَقِبَة  ";
        String leftrow_arabic3="عَزَاب";
        String leftrow_arabic4="عِقَاب ";
        String leftrow_arabic5=" قِيَامَة ";
        String leftrow_arabic6="لِقَاء ";
        String leftrow_arabic7="مُسَمَّى ";
        String leftrow_arabic8="نَهَر  ";
        String leftrow_arabic9="نَار ";
        String leftrow_arabic10=" وَيْل ";
        String leftrow_arabic11="يَوْم  ";
        String leftrow_arabic12=" يَوْمَئِذٍ  ";


        String leftrow_urdu0 ="Last Day,...";
        String leftrow_urdu1 ="ساتھی ";
        String leftrow_urdu2 ="  انجام  ";
        String leftrow_urdu3 =" سخت دکھ  ";
        String leftrow_urdu4 ="  عزاب ";
        String leftrow_urdu5 =" قیامت ";
        String leftrow_urdu6 =" ملنا ";
        String leftrow_urdu7 ="مُقرر";
        String leftrow_urdu8 ="نہر  ";
        String leftrow_urdu9 ="آگ  ";
        String leftrow_urdu10 ="ہلاکت";
        String leftrow_urdu11 ="دن";
        String leftrow_urdu12 =" اس دن";

        String rightrow_eng0=" Last Day,... ";
        String rightrow_eng1="forever;ever ";
        String rightrow_eng2=" reward  ";
        String rightrow_eng3="term  ";
        String rightrow_eng4="the Hereafter ";
        String rightrow_eng5="painful  ";
        String rightrow_eng6="reward  ";
        String rightrow_eng7=" helfire ";
        String rightrow_eng8="reward ";
        String rightrow_eng9="garden   ";
        String rightrow_eng10="the Hell";
        String rightrow_eng11="reckoning ";
        String rightrow_eng12="hour(day of resurrection)";

        String rightrow_arabic0=" Last Day,...";
        String rightrow_arabic1="أَبَدًا    ";
        String rightrow_arabic2="أَجْر   ";
        String rightrow_arabic3="أَجَل  ";
        String rightrow_arabic4="الْلآخِرَة    ";
        String rightrow_arabic5="أَلِيم  ";
        String rightrow_arabic6="ثَوَاب ";
        String rightrow_arabic7="جَحِيم    ";
        String rightrow_arabic8="جَزَاء    ";
        String rightrow_arabic9="جَنَّة    ";
        String rightrow_arabic10=" جَهَنَّم  ";
        String rightrow_arabic11="حِسَاب    ";
        String rightrow_arabic12="سَاعَة    ";



        String rightrow_urdu0 = " Last Day,...";
        String rightrow_urdu1 = " ہمیشہ    ";
        String rightrow_urdu2 = "ثواب ";
        String rightrow_urdu3 = "مُقرره مُدت";
        String rightrow_urdu4 = "  آخرت ";
        String rightrow_urdu5 = " دردناک  ";
        String rightrow_urdu6 = " ثواب ";
        String rightrow_urdu7 = " بھڑکتی آگ ";
        String rightrow_urdu8 = "   بدلہ  ";
        String rightrow_urdu9 = "جنت ";
        String rightrow_urdu10 = "  جہنم ";
        String rightrow_urdu11 = " گننا ";
        String rightrow_urdu12 = " وقت  ";




        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec10(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec10(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec10(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec10(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec10(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec10(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec10(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec10(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec10(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec10(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec10(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec10(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec10(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void lecture11() {



        String leftrow_eng0="Deen,...";
        String leftrow_eng1=" matter;affair ";
        String leftrow_eng2="fear ";
        String leftrow_eng3="truth;right";
        String leftrow_eng4="falsehood ";
        String leftrow_eng5="   wisdom   ";
        String leftrow_eng6="  praise";
        String leftrow_eng7="  religion;law    ";
        String leftrow_eng8="  charity  ";
        String leftrow_eng9=" witness,present   ";
        String leftrow_eng10=" prayer  ";
        String leftrow_eng11=" clear  ";
        String leftrow_eng12=" light  ";

        String leftrow_arabic0="Deen,...";
        String leftrow_arabic1="أَمْر  ";
        String leftrow_arabic2="تَقْوَى  ";
        String leftrow_arabic3="حَقّ";
        String leftrow_arabic4="بَاطِل ";
        String leftrow_arabic5=" حِكْمَة ";
        String leftrow_arabic6="حَمْد ";
        String leftrow_arabic7="دِين ";
        String leftrow_arabic8="زَكَاة  ";
        String leftrow_arabic9="شَهِيد  ";
        String leftrow_arabic10=" صَلَاة ";
        String leftrow_arabic11="مُبِين  ";
        String leftrow_arabic12=" نُور  ";


        String leftrow_urdu0 ="Deen,...";
        String leftrow_urdu1 ="کام،معاملہ ";
        String leftrow_urdu2 ="   ڈرنا   ";
        String leftrow_urdu3 =" ٹھیک   ";
        String leftrow_urdu4 ="  غلط،ناحق ";
        String leftrow_urdu5 =" حکمت ";
        String leftrow_urdu6 =" شکر ";
        String leftrow_urdu7 ="دین،بدلہ ";
        String leftrow_urdu8 ="زکوۃ  ";
        String leftrow_urdu9 =" گواہ  ";
        String leftrow_urdu10 =" نماز";
        String leftrow_urdu11 =" بیان کرنے والا ";
        String leftrow_urdu12 =" روشنی";

        String rightrow_eng0=" Faith,..... ";
        String rightrow_eng1=" one ";
        String rightrow_eng2=" god   ";
        String rightrow_eng3="partner   ";
        String rightrow_eng4="witness ";
        String rightrow_eng5="throne   ";
        String rightrow_eng6="hidden  ";
        String rightrow_eng7=" unseen ";
        String rightrow_eng8=" book  ";
        String rightrow_eng9="word   ";
        String rightrow_eng10=" angel ";
        String rightrow_eng11=" treaty   ";
        String rightrow_eng12="one";

        String rightrow_arabic0="  Faith,.....";
        String rightrow_arabic1="أَحَد ";
        String rightrow_arabic2="إله ";
        String rightrow_arabic3="شَرِيك ";
        String rightrow_arabic4="شَهَادَة ";
        String rightrow_arabic5="عَرْش  ";
        String rightrow_arabic6="عهْد ";
        String rightrow_arabic7="غَيْب";
        String rightrow_arabic8="كِتَاب";
        String rightrow_arabic9="كَلِمَة";
        String rightrow_arabic10="مَلَك ";
        String rightrow_arabic11="مِيثَاق ";
        String rightrow_arabic12="وَاحِد";



        String rightrow_urdu0 = "  Faith,.....";
        String rightrow_urdu1 = " اکیلا    ";
        String rightrow_urdu2 = "معبود ";
        String rightrow_urdu3 = "شریک،ساتھی";
        String rightrow_urdu4 = "  گواہی ";
        String rightrow_urdu5 = "  شاہی تخت   ";
        String rightrow_urdu6 = "  عہد ";
        String rightrow_urdu7 = "غیرحاضر";
        String rightrow_urdu8 = "    کتاب  ";
        String rightrow_urdu9 = " بات ";
        String rightrow_urdu10 = "  فرشتہ ";
        String rightrow_urdu11 = "  عہد ";
        String rightrow_urdu12 = "  ایک   ";



        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec11(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec11(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec11(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec11(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec11(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec11(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec11(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec11(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec11(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec11(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec11(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec11(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec11(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void lecture12() {




        String leftrow_eng0="Deeds,... ";
        String leftrow_eng1=" actions,deeds ";
        String leftrow_eng2=" good(dccd) ";
        String leftrow_eng3="evil,bad";
        String leftrow_eng4="good,better ";
        String leftrow_eng5="   evil,worse   ";
        String leftrow_eng6="  sin";
        String leftrow_eng7="  sin ";
        String leftrow_eng8=" sin ";
        String leftrow_eng9="  unlawful ";
        String leftrow_eng10=" name   ";
        String leftrow_eng11=" discourse;speech   ";
        String leftrow_eng12=" good ";

        String leftrow_arabic0="Deeds,... ";
        String leftrow_arabic1="أَعْمَال   ";
        String leftrow_arabic2="حَسَنَة";
        String leftrow_arabic3="سَيَّئة ";
        String leftrow_arabic4="خَيْر ";
        String leftrow_arabic5=" شَرّ  ";
        String leftrow_arabic6="إِثْم  ";
        String leftrow_arabic7="ذَنْب  ";
        String leftrow_arabic8="جُنَاح   ";
        String leftrow_arabic9="حَرَام  ";
        String leftrow_arabic10=" اِسْم ";
        String leftrow_arabic11="حَدِيث   ";
        String leftrow_arabic12=" طَيَّبَة   ";


        String leftrow_urdu0 ="Deeds,... ";
        String leftrow_urdu1 ="اعمال ";
        String leftrow_urdu2 ="نیکی";
        String leftrow_urdu3 =" برائ،گناہ";
        String leftrow_urdu4 =" بہتر،بھلا  ";
        String leftrow_urdu5 ="  برائ  ";
        String leftrow_urdu6 ="  گناہ  ";
        String leftrow_urdu7 =" گناہ  ";
        String leftrow_urdu8 =" گناہ ";
        String leftrow_urdu9 ="   ممنوع  ";
        String leftrow_urdu10 ="  نام ";
        String leftrow_urdu11 ="بات  ";
        String leftrow_urdu12 =" پاک";

        String rightrow_eng0="Blessings,......";
        String rightrow_eng1="favors ";
        String rightrow_eng2="authority,warrant ";
        String rightrow_eng3="grace";
        String rightrow_eng4="water ";
        String rightrow_eng5=" dominion,reign ";
        String rightrow_eng6="favor";
        String rightrow_eng7=" all ";
        String rightrow_eng8=" permission   ";
        String rightrow_eng9="punishment,power";
        String rightrow_eng10="all,everybody ";
        String rightrow_eng11="same,equal ";
        String rightrow_eng12=" party,group ";

        String rightrow_arabic0=" Blessings,......";
        String rightrow_arabic1="آَلَاء  ";
        String rightrow_arabic2="سُلْطَان ";
        String rightrow_arabic3="فَضْل  ";
        String rightrow_arabic4="مَاء ";
        String rightrow_arabic5="مُلْك  ";
        String rightrow_arabic6="نِعْمَة ";
        String rightrow_arabic7="أَجْمَعْون،أَجْمَعِين";
        String rightrow_arabic8="إِذْن";
        String rightrow_arabic9="بَأْس ";
        String rightrow_arabic10="جَمِيع ";
        String rightrow_arabic11="سَوَاء ";
        String rightrow_arabic12="فَرِيق ";



        String rightrow_urdu0 = " Blessings,......";
        String rightrow_urdu1 = " نعمتیں ";
        String rightrow_urdu2 = "زور،حکومت ";
        String rightrow_urdu3 = " مہربانی ";
        String rightrow_urdu4 = "  پانی ";
        String rightrow_urdu5 = "بادشاہت،غلبہ ";
        String rightrow_urdu6 = "   انعام  ";
        String rightrow_urdu7 = "سَب کے سَب ";
        String rightrow_urdu8 = " حکم،اجازت ";
        String rightrow_urdu9 = " سختی،لڑائ";
        String rightrow_urdu10 = " سَب،سارے ";
        String rightrow_urdu11 = "برابر";
        String rightrow_urdu12 = "گروہ  ";




        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec12(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec12(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec12(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec12(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec12(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec12(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec12(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec12(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec12(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec12(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec12(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec12(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec12(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void lecture13() {




        String leftrow_eng0="Relatives,... ";
        String leftrow_eng1="  mother ";
        String leftrow_eng2=" father ";
        String leftrow_eng3=" wife;husband ";
        String leftrow_eng4="man ";
        String leftrow_eng5="  woman ";
        String leftrow_eng6="    child   ";
        String leftrow_eng7="father  ";
        String leftrow_eng8=" descendants;children   ";
        String leftrow_eng9="son ";
        String leftrow_eng10="sons ";
        String leftrow_eng11=" brother  ";
        String leftrow_eng12=" brothers ";

        String leftrow_arabic0="Relatives,... ";
        String leftrow_arabic1="أُمٌّ ";
        String leftrow_arabic2="أَب،أَبَتِ ";
        String leftrow_arabic3=" زَوْج ";
        String leftrow_arabic4="رَجُل ";
        String leftrow_arabic5=" اِمْرَأَة";
        String leftrow_arabic6=" وَلَد ";
        String leftrow_arabic7="وَالِد ";
        String leftrow_arabic8=" ذُرَّيَّة";
        String leftrow_arabic9="اِبْن";
        String leftrow_arabic10="  بَنُون،بَنِين،أَبْنَاء ";
        String leftrow_arabic11=" أخ ";
        String leftrow_arabic12="  إِخْوَان    ";


        String leftrow_urdu0 ="Relatives,... ";
        String leftrow_urdu1 ="ماں ";
        String leftrow_urdu2 ="باپ";
        String leftrow_urdu3 =" شوہر،بیوی";
        String leftrow_urdu4 ="مرد ";
        String leftrow_urdu5 ="عورت";
        String leftrow_urdu6 =" لڑکا یا لڑکی  ";
        String leftrow_urdu7 ="باپ ";
        String leftrow_urdu8 =" اولاد ";
        String leftrow_urdu9 ="    بیٹا   ";
        String leftrow_urdu10 ="  بیٹے  ";
        String leftrow_urdu11 =" بھائ ";
        String leftrow_urdu12 ="  بھائ";

        String rightrow_eng0="Self (body parts,...)";
        String rightrow_eng1=" face ";
        String rightrow_eng2="   eye;spring  ";
        String rightrow_eng3="sights  ";
        String rightrow_eng4="mouths ";
        String rightrow_eng5="  tongue;language ";
        String rightrow_eng6=" heart";
        String rightrow_eng7=" breast  ";
        String rightrow_eng8="  hand    ";
        String rightrow_eng9="foot";
        String rightrow_eng10=" soul  ";
        String rightrow_eng11=" soul;spirit";
        String rightrow_eng12="  power;strength ";

        String rightrow_arabic0=" Self (body parts,...)";
        String rightrow_arabic1="وجْه  ";
        String rightrow_arabic2="عَيْن ";
        String rightrow_arabic3="أَبصَار ";
        String rightrow_arabic4=" أفْوَاه ";
        String rightrow_arabic5="لِسَان ";
        String rightrow_arabic6=" قَلْب  ";
        String rightrow_arabic7="صَدْر ";
        String rightrow_arabic8="يَد ";
        String rightrow_arabic9="رِجْلٌ ";
        String rightrow_arabic10="نَفْس  ";
        String rightrow_arabic11=" رُوح  ";
        String rightrow_arabic12="قُوَّة ";



        String rightrow_urdu0 = "Self (body parts,...)";
        String rightrow_urdu1 = " چرہ  ";
        String rightrow_urdu2 = "آنکہ،چشمہ ";
        String rightrow_urdu3 = " نگاہیں ";
        String rightrow_urdu4 = "منہ  ";
        String rightrow_urdu5 = "زبان ";
        String rightrow_urdu6 = " دل  ";
        String rightrow_urdu7 = "سینہ ";
        String rightrow_urdu8 = " ھاتھ  ";
        String rightrow_urdu9 = " پیر";
        String rightrow_urdu10 = " جی،جان ";
        String rightrow_urdu11 = "روح";
        String rightrow_urdu12 = "قوت";






        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec13(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec13(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec13(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec13(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec13(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec13(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec13(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec13(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec13(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec13(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec13(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec13(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec13(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void lecture14() {




        String leftrow_eng0="World,...";
        String leftrow_eng1=" house ";
        String leftrow_eng2="abode  ";
        String leftrow_eng3="world";
        String leftrow_eng4=" way  ";
        String leftrow_eng5="path ";
        String leftrow_eng6="world ";
        String leftrow_eng7="trial;persecution   ";
        String leftrow_eng8=" town  ";
        String leftrow_eng9=" wealth  ";
        String leftrow_eng10=" provision;enjoyment ";
        String leftrow_eng11="  mosque    ";
        String leftrow_eng12=" place;abode  ";

        String leftrow_arabic0="World,... ";
        String leftrow_arabic1="بَيْت ";
        String leftrow_arabic2="دَار";
        String leftrow_arabic3=" دُنْيَا ";
        String leftrow_arabic4="سَبِيل ";
        String leftrow_arabic5=" صِرَاط";
        String leftrow_arabic6=" عَالَم ";
        String leftrow_arabic7="فِتْنَة ";
        String leftrow_arabic8=" قَرْيَة";
        String leftrow_arabic9="مَال";
        String leftrow_arabic10="مَاتَاع ";
        String leftrow_arabic11="مَسْجد";
        String leftrow_arabic12="مَكَان";


        String leftrow_urdu0 ="World,... ";
        String leftrow_urdu1 ="گھر ";
        String leftrow_urdu2 ="گھر";
        String leftrow_urdu3 ="دنیا";
        String leftrow_urdu4 ="راستہ ";
        String leftrow_urdu5 ="راستہ";
        String leftrow_urdu6 ="ساری مخلوقات";
        String leftrow_urdu7 =" مصیبت،فساد";
        String leftrow_urdu8 =" بستی ";
        String leftrow_urdu9 ="مال";
        String leftrow_urdu10 ="   فائدہ،نفغ  ";
        String leftrow_urdu11 =" مسجد ";
        String leftrow_urdu12 ="  جگہ،مقام ";

        String rightrow_eng0="People,...";
        String rightrow_eng1="  community    ";
        String rightrow_eng2="people ";
        String rightrow_eng3="man";
        String rightrow_eng4="men,people ";
        String rightrow_eng5="male ";
        String rightrow_eng6=" female";
        String rightrow_eng7=" slave   ";
        String rightrow_eng8="   enemy    ";
        String rightrow_eng9="disbelievers ";
        String rightrow_eng10=" criminal";
        String rightrow_eng11="chiefs,leaders ";
        String rightrow_eng12="protectingfriend;guardian ";

        String rightrow_arabic0="People,...";
        String rightrow_arabic1="أُمَّة   ";
        String rightrow_arabic2="قَوْم ";
        String rightrow_arabic3="اِنْسَان ";
        String rightrow_arabic4=" نَاس ";
        String rightrow_arabic5="ذَكَر ";
        String rightrow_arabic6=" أُنْثَى  ";
        String rightrow_arabic7="عَبْد ";
        String rightrow_arabic8="عَدُوّ ";
        String rightrow_arabic9="كُفَّار ";
        String rightrow_arabic10="مُجْرِم  ";
        String rightrow_arabic11="مَلَأ ";
        String rightrow_arabic12="وَلِيّ ";



        String rightrow_urdu0 = "People,...";
        String rightrow_urdu1 = "جماعت،مدت";
        String rightrow_urdu2 = "گروہ،جماعت";
        String rightrow_urdu3 = "  انسان  ";
        String rightrow_urdu4 = "لوگ ";
        String rightrow_urdu5 = "مرد،نر ";
        String rightrow_urdu6 = " عورت،مادہ ";
        String rightrow_urdu7 = "بندہ،غلام  ";
        String rightrow_urdu8 = " دشقن  ";
        String rightrow_urdu9 = " کفار  ";
        String rightrow_urdu10 = "  گنہگار،قصوروار ";
        String rightrow_urdu11 = "بڑے لوگوں کی جماعت";
        String rightrow_urdu12 = " بچانے والا دوست  ";


        String id0 = "0";
        String id1 = "1";
        String id2 = "2";
        String id3 = "3";
        String id4 = "4";
        String id5 = "5";
        String id6 = "6";
        String id7 = "7";
        String id8 = "8";
        String id9 = "9";
        String id10 = "10";
        String id11 = "11";
        String id12 = "12";


        try {
            sqllitehelper.insertlec14(leftrow_eng0, leftrow_arabic0, leftrow_urdu0, rightrow_eng0, rightrow_arabic0, rightrow_urdu0, id0);
            sqllitehelper.insertlec14(leftrow_eng1, leftrow_arabic1, leftrow_urdu1, rightrow_eng1, rightrow_arabic1, rightrow_urdu1, id1);
            sqllitehelper.insertlec14(leftrow_eng2, leftrow_arabic2, leftrow_urdu2, rightrow_eng2, rightrow_arabic2, rightrow_urdu2, id2);
            sqllitehelper.insertlec14(leftrow_eng3, leftrow_arabic3, leftrow_urdu3, rightrow_eng3, rightrow_arabic3, rightrow_urdu3, id3);
            sqllitehelper.insertlec14(leftrow_eng4, leftrow_arabic4, leftrow_urdu4, rightrow_eng4, rightrow_arabic4, rightrow_urdu4, id4);
            sqllitehelper.insertlec14(leftrow_eng5, leftrow_arabic5, leftrow_urdu5, rightrow_eng5, rightrow_arabic5, rightrow_urdu5, id5);
            sqllitehelper.insertlec14(leftrow_eng6, leftrow_arabic6, leftrow_urdu6, rightrow_eng6, rightrow_arabic6, rightrow_urdu6, id6);
            sqllitehelper.insertlec14(leftrow_eng7, leftrow_arabic7, leftrow_urdu7, rightrow_eng7, rightrow_arabic7, rightrow_urdu7, id7);
            sqllitehelper.insertlec14(leftrow_eng8, leftrow_arabic8, leftrow_urdu8, rightrow_eng8, rightrow_arabic8, rightrow_urdu8, id8);
            sqllitehelper.insertlec14(leftrow_eng9, leftrow_arabic9, leftrow_urdu9, rightrow_eng9, rightrow_arabic9, rightrow_urdu9, id9);
            sqllitehelper.insertlec14(leftrow_eng10, leftrow_arabic10, leftrow_urdu10, rightrow_eng10, rightrow_arabic10, rightrow_urdu10, id10);
            sqllitehelper.insertlec14(leftrow_eng11, leftrow_arabic11, leftrow_urdu11, rightrow_eng11, rightrow_arabic11, rightrow_urdu11, id11);
            sqllitehelper.insertlec14(leftrow_eng12, leftrow_arabic12, leftrow_urdu12, rightrow_eng12, rightrow_arabic12, rightrow_urdu12, id12);


            Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    public void go(View view) {





        String leftrow_eng0="Miscellaneous";
        String leftrow_eng1=" endowed with;owner";
        String leftrow_eng2=" endowed with;owner";
        String leftrow_eng3=" people of;owners of";
        String leftrow_eng4="people of;relatives";
        String leftrow_eng5="family,realtives,people";
        String leftrow_eng6=" donot,willnot ";
        String leftrow_eng7=" what an excellent ";
        String leftrow_eng8="  what an evil ";
        String leftrow_eng9="  evil is that which ";
        String leftrow_eng10=" sth similar ";
        String leftrow_eng11="similitude";
        String leftrow_eng12=" than the one who";

        String leftrow_arabic0="Miscellaneous";
        String leftrow_arabic1="(mg) ذُو،ذَا،ذِي ";
        String leftrow_arabic2="(fg) ذَات ";
        String leftrow_arabic3="أُوْلْواْ،أُوْلي";
        String leftrow_arabic4="أهْل  ";
        String leftrow_arabic5="آل  ";
        String leftrow_arabic6="أَلَا  ";
        String leftrow_arabic7="نِعْمَ  ";
        String leftrow_arabic8="بِئسَ   ";
        String leftrow_arabic9="بِئْسَمَا  ";
        String leftrow_arabic10="مِثْل  ";
        String leftrow_arabic11="مَثَل  ";
        String leftrow_arabic12="مِمَّنْ  ";


        String leftrow_urdu0 ="Miscellaneous";
        String leftrow_urdu1 ="والا ";
        String leftrow_urdu2 ="والی ";
        String leftrow_urdu3 =" والے";
        String leftrow_urdu4 ="والا ";
        String leftrow_urdu5 ="  قوم ،گہرکے لوگ،اتباغ کرنے والے";
        String leftrow_urdu6 ="خبردار،کیا نہیں ";
        String leftrow_urdu7 =" کیا ہی خوب،کیا ہی اچھا ";
        String leftrow_urdu8 =" کیا ہی برا ";
        String leftrow_urdu9 =" برا ہے جو";
        String leftrow_urdu10 =" جیسے ";
        String leftrow_urdu11 ="مثال";
        String leftrow_urdu12 ="(اس) سے جو ";

        String rightrow_eng0="When ?";
        String rightrow_eng1="before ";
        String rightrow_eng2=" after ";
        String rightrow_eng3="  time,period";
        String rightrow_eng4=" when ";
        String rightrow_eng5="when";
        String rightrow_eng6="then";
        String rightrow_eng7=" therefore";
        String rightrow_eng8="but  ";
        String rightrow_eng9="near,with  ";
        String rightrow_eng10=" nothing but";
        String rightrow_eng11=" nothing but";
        String rightrow_eng12="than the one who ";

        String rightrow_arabic0="When ?";
        String rightrow_arabic1="قَبْل ََ";
        String rightrow_arabic2="بَعْد  ";
        String rightrow_arabic3="حِين  ";
        String rightrow_arabic4="(for past)إذْ  ";
        String rightrow_arabic5="(for future)إذَا ";
        String rightrow_arabic6="ثُمَّ  ";
        String rightrow_arabic7="فُ  ";
        String rightrow_arabic8="بَل  ";
        String rightrow_arabic9="عِنْدَ،لَدى،لَدُنْ  ";
        String rightrow_arabic10="إِنْ...إِلَّا َ";
        String rightrow_arabic11="  مَا...إِلَّا  ";
        String rightrow_arabic12="أُلٌاْ";



        String rightrow_urdu0 = "When ?";
        String rightrow_urdu1 = "پہلے  ";
        String rightrow_urdu2 = " بعد ";
        String rightrow_urdu3 = "  وقت،مدت ";
        String rightrow_urdu4 = " جب ";
        String rightrow_urdu5 = " جب  ";
        String rightrow_urdu6 = "  پھر ";
        String rightrow_urdu7 = "پس،تو  ";
        String rightrow_urdu8 = " بلکہ  ";
        String rightrow_urdu9 = " پاس،نذدیک   ";
        String rightrow_urdu10 = " نہیں،مگر   ";
        String rightrow_urdu11 = "  نہیں،مگر  ";
        String rightrow_urdu12 = "   کہ نہیں   ";





        String id0="0";
        String id1="1";
        String id2="2";
        String id3="3";
        String id4="4";
        String id5="5";
        String id6="6";
        String id7="7";
        String id8="8";
        String id9="9";
        String id10="10";
        String id11="11";
        String id12="12";


        try{
            sqllitehelper.insertlec4(leftrow_eng0,leftrow_arabic0,leftrow_urdu0,rightrow_eng0,rightrow_arabic0,rightrow_urdu0,id0);
            sqllitehelper.insertlec4(leftrow_eng1,leftrow_arabic1,leftrow_urdu1,rightrow_eng1,rightrow_arabic1,rightrow_urdu1,id1);
            sqllitehelper.insertlec4(leftrow_eng2,leftrow_arabic2,leftrow_urdu2,rightrow_eng2,rightrow_arabic2,rightrow_urdu2,id2);
            sqllitehelper.insertlec4(leftrow_eng3,leftrow_arabic3,leftrow_urdu3,rightrow_eng3,rightrow_arabic3,rightrow_urdu3,id3);
            sqllitehelper.insertlec4(leftrow_eng4,leftrow_arabic4,leftrow_urdu4,rightrow_eng4,rightrow_arabic4,rightrow_urdu4,id4);
            sqllitehelper.insertlec4(leftrow_eng5,leftrow_arabic5,leftrow_urdu5,rightrow_eng5,rightrow_arabic5,rightrow_urdu5,id5);
            sqllitehelper.insertlec4(leftrow_eng6,leftrow_arabic6,leftrow_urdu6,rightrow_eng6,rightrow_arabic6,rightrow_urdu6,id6);
            sqllitehelper.insertlec4(leftrow_eng7,leftrow_arabic7,leftrow_urdu7,rightrow_eng7,rightrow_arabic7,rightrow_urdu7,id7);
            sqllitehelper.insertlec4(leftrow_eng8,leftrow_arabic9,leftrow_urdu8,rightrow_eng8,rightrow_arabic8,rightrow_urdu8,id8);
            sqllitehelper.insertlec4(leftrow_eng9,leftrow_arabic9,leftrow_urdu9,rightrow_eng9,rightrow_arabic9,rightrow_urdu9,id9);
            sqllitehelper.insertlec4(leftrow_eng10,leftrow_arabic10,leftrow_urdu10,rightrow_eng10,rightrow_arabic10,rightrow_urdu10,id10);
            sqllitehelper.insertlec4(leftrow_eng11,leftrow_arabic11,leftrow_urdu11,rightrow_eng11,rightrow_arabic11,rightrow_urdu11,id11);
            sqllitehelper.insertlec4(leftrow_eng12,leftrow_arabic12,leftrow_urdu12,rightrow_eng12,rightrow_arabic12,rightrow_urdu12,id12);


            Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }






    }
}
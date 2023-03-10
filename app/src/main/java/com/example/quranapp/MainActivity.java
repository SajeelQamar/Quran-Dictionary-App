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
        String leftrow_arabic1 = "mg ????????????";
        String leftrow_arabic2 = "mg ????????????";
        String leftrow_arabic3 = "fg??????????";
        String leftrow_arabic4 = "fg ????????????";
        String leftrow_arabic5 = "mg/fg ??????????????";
        String leftrow_arabic6 = "mg/fg ????????????????";
        String leftrow_arabic7 = "mg ??????????????";
        String leftrow_arabic8 = "fg ?????????????? ";
        String leftrow_arabic9 = "mg ??????????????????";
        String leftrow_arabic10 = "(for br.pl)??????????";
        String leftrow_arabic11 = "(for br.pl)????????????";
        String leftrow_arabic12 = "(for br.pl)??????????????";

        String leftrow_urdu0 = "This,that";
        String leftrow_urdu1 = "????";
        String leftrow_urdu2 = " ????";
        String leftrow_urdu3 = "????";
        String leftrow_urdu4 = "????";
        String leftrow_urdu5 = "???? ????";
        String leftrow_urdu6 = "???? ????";
        String leftrow_urdu7 = "???? ????";
        String leftrow_urdu8 = "???? ????";
        String leftrow_urdu9 = "???? ???? ????";
        String leftrow_urdu10 = "???? ????";
        String leftrow_urdu11 = "???? ????";
        String leftrow_urdu12 = "???? ???? ????";


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
        String rightrow_arabic1 = "?????? ????????";
        String rightrow_arabic2 = "?????????? ????????";
        String rightrow_arabic3 = "??????????";
        String rightrow_arabic4 = "(for future) ????????";
        String rightrow_arabic5 = "(for past)????????";
        String rightrow_arabic6 = "??????";
        String rightrow_arabic7 = "fg ????????????";
        String rightrow_arabic8 = "??????????";
        String rightrow_arabic9 = "??????????";
        String rightrow_arabic10 = "??????????";
        String rightrow_arabic11 = "??????????";
        String rightrow_arabic12 = "????????????";

        String rightrow_urdu0 = "NO,No!!";
        String rightrow_urdu1 = "???????? ???????? ??????????";
        String rightrow_urdu2 = "?????????? ???????? ????";
        String rightrow_urdu3 = "????????????????";
        String rightrow_urdu4 = "????????????????";
        String rightrow_urdu5 = "????????";
        String rightrow_urdu6 = "??????????????????????";
        String rightrow_urdu7 = "????????";
        String rightrow_urdu8 = "???????? ????????";
        String rightrow_urdu9 = "??????????????";
        String rightrow_urdu10 = "????????";
        String rightrow_urdu11 = "????????????????";
        String rightrow_urdu12 = "??????";



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
        String leftrow_arabic1 = "(mg) ????";
        String leftrow_arabic2 = "(mg) ??????????";
        String leftrow_arabic3 = "(mg) ??????";
        String leftrow_arabic4 = "(mg) ??????????";
        String leftrow_arabic5 = "(me) ????";
        String leftrow_arabic6 = "(mg/fg) ????????";
        String leftrow_arabic7 = " (fg)  ??????";
        String leftrow_arabic8 = "(fg) ??????????  ";
        String leftrow_arabic9 = "(fg) ????";
        String leftrow_arabic10 = "(for bl.pl)?????? ??";
        String leftrow_arabic11 = "(dl) ??????????";
        String leftrow_arabic12 = "(dl) ?????????? ";


        String leftrow_urdu0 = "Whose ?";
        String leftrow_urdu1 = "???? ????????????????";
        String leftrow_urdu2 = " ???? ????????????????";
        String leftrow_urdu3 = "???? ????????????????";
        String leftrow_urdu4 = "???? ???? ????????????????";
        String leftrow_urdu5 = "???????? ";
        String leftrow_urdu6 = "??????????";
        String leftrow_urdu7 = "???? ????????????????";
        String leftrow_urdu8 = "???? ????????????????";
        String leftrow_urdu9 = "???? ????????????????";
        String leftrow_urdu10 = "???? ???? ????????????????";
        String leftrow_urdu11 = "???? ?????????? ????";
        String leftrow_urdu12 = "???? ?????????? ????";


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
        String rightrow_arabic1 = "(mg) ???????? ??";
        String rightrow_arabic2 = " (mg) ???????? ";
        String rightrow_arabic3 = " (mg) ????????????";
        String rightrow_arabic4 = "(mg)?????????????? ";
        String rightrow_arabic5 = "(mg/fg)?????????? ";
        String rightrow_arabic6 = "(mg/fg)???????????? ";
        String rightrow_arabic7 = "(fg) ???????? ";
        String rightrow_arabic8 = "(fg) ?????????? ";
        String rightrow_arabic9 = "(fg)  ???????????? ";
        String rightrow_arabic10 = "(for br.pl) ???????? ";
        String rightrow_arabic11 = " (dl) ?????????? ";
        String rightrow_arabic12 = "(dl)?????????????????? ";


        String rightrow_urdu0 = "Who ?";
        String rightrow_urdu1 = " ???? ";
        String rightrow_urdu2 = " ???? ????  ";
        String rightrow_urdu3 = "  ????  ";
        String rightrow_urdu4 = " ???? ????  ";
        String rightrow_urdu5 = "?????? ";
        String rightrow_urdu6 = "  ???? ";
        String rightrow_urdu7 = "  ???? ";
        String rightrow_urdu8 = " ???? ???? ";
        String rightrow_urdu9 = "???? ";
        String rightrow_urdu10 = " ???? ???? ";
        String rightrow_urdu11 = " ???? ?????????? ";
        String rightrow_urdu12 = "???? ?????????? ";


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
        String leftrow_arabic1 = "???????????? ";
        String leftrow_arabic2 = "???????????? ";
        String leftrow_arabic3 = "???????????? ??????????????????";
        String leftrow_arabic4 = "???????????? ";
        String leftrow_arabic5 = "?????????????? ";
        String leftrow_arabic6 = "???????????? ";
        String leftrow_arabic7 = "?????????????? ";
        String leftrow_arabic8 = "????????????  ";
        String leftrow_arabic9 = "???????????? ";
        String leftrow_arabic10 = "???????????? ";
        String leftrow_arabic11 = "???????????? ";
        String leftrow_arabic12 = "???????????????? ";


        String leftrow_urdu0 = "Where?";
        String leftrow_urdu1 = "???????? ";
        String leftrow_urdu2 = "  ???????? ";
        String leftrow_urdu3 = " ??????????";
        String leftrow_urdu4 = "?????????? ";
        String leftrow_urdu5 = "  ??????????";
        String leftrow_urdu6 = "?????????? ";
        String leftrow_urdu7 = " ??????, ?????????? ";
        String leftrow_urdu8 = " ?????????? ";
        String leftrow_urdu9 = " ????????????";
        String leftrow_urdu10 = " ?????????? ";
        String leftrow_urdu11 = "?????????????? ??????";
        String leftrow_urdu12 = "???????? ";

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
        String rightrow_arabic1 = "?????? ??";
        String rightrow_arabic2 = "???????? ";
        String rightrow_arabic3 = "???????? ";
        String rightrow_arabic4 = "???????????? ";
        String rightrow_arabic5 = "???????????? ";
        String rightrow_arabic6 = "???????? ";
        String rightrow_arabic7 = "?????????? ";
        String rightrow_arabic8 = "?????????? ";
        String rightrow_arabic9 = "???????????? ";
        String rightrow_arabic10 = "?????????? ??";
        String rightrow_arabic11 = " ?????????????????????? ";
        String rightrow_arabic12 = "???????? ????????";


        String rightrow_urdu0 = "Questions ?";
        String rightrow_urdu1 = "???????????? ";
        String rightrow_urdu2 = " ???????????? ";
        String rightrow_urdu3 = "  ?????????? ";
        String rightrow_urdu4 = " ??????????????????";
        String rightrow_urdu5 = " ?????????????????? ";
        String rightrow_urdu6 = " ?????????????????? ";
        String rightrow_urdu7 = "???????????????? ";
        String rightrow_urdu8 = " ???????? ?????????????? ???? ";
        String rightrow_urdu9 = " ????????  ";
        String rightrow_urdu10 = " ????????  ";
        String rightrow_urdu11 = " ????????  ";
        String rightrow_urdu12 = " ?????? ?????????????? ??????????   ";


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
        String leftrow_arabic1 = "(mg) ?????????????????????? ";
        String leftrow_arabic2 = "(fg) ???????? ";
        String leftrow_arabic3 = "????????????????????????????????";
        String leftrow_arabic4 = "????????  ";
        String leftrow_arabic5 = "????  ";
        String leftrow_arabic6 = "??????????  ";
        String leftrow_arabic7 = "????????????  ";
        String leftrow_arabic8 = "??????????   ";
        String leftrow_arabic9 = "??????????????????  ";
        String leftrow_arabic10 = "??????????  ";
        String leftrow_arabic11 = "??????????  ";
        String leftrow_arabic12 = "??????????????  ";


        String leftrow_urdu0 = "Miscellaneous";
        String leftrow_urdu1 = "???????? ";
        String leftrow_urdu2 = "???????? ";
        String leftrow_urdu3 = " ????????";
        String leftrow_urdu4 = "???????? ";
        String leftrow_urdu5 = "  ?????? ???????????? ?????????????????? ???????? ????????";
        String leftrow_urdu6 = "???????????????????? ???????? ";
        String leftrow_urdu7 = " ?????? ???? ?????????????? ???? ???????? ";
        String leftrow_urdu8 = " ?????? ???? ?????? ";
        String leftrow_urdu9 = " ?????? ???? ????";
        String leftrow_urdu10 = " ???????? ";
        String leftrow_urdu11 = "????????";
        String leftrow_urdu12 = "(????) ???? ???? ";

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
        String rightrow_arabic1 = "?????????? ????";
        String rightrow_arabic2 = "??????????  ";
        String rightrow_arabic3 = "????????  ";
        String rightrow_arabic4 = "(for past)??????  ";
        String rightrow_arabic5 = "(for future)???????? ";
        String rightrow_arabic6 = "??????????  ";
        String rightrow_arabic7 = "????  ";
        String rightrow_arabic8 = "??????  ";
        String rightrow_arabic9 = "????????????????????????????????????  ";
        String rightrow_arabic10 = "????????...???????????? ??";
        String rightrow_arabic11 = "  ??????...????????????  ";
        String rightrow_arabic12 = "????????????";


        String rightrow_urdu0 = "When ?";
        String rightrow_urdu1 = "????????  ";
        String rightrow_urdu2 = " ?????? ";
        String rightrow_urdu3 = "  ?????????????? ";
        String rightrow_urdu4 = " ???? ";
        String rightrow_urdu5 = " ????  ";
        String rightrow_urdu6 = "  ?????? ";
        String rightrow_urdu7 = "??????????  ";
        String rightrow_urdu8 = " ????????  ";
        String rightrow_urdu9 = " ??????????????????   ";
        String rightrow_urdu10 = " ????????????????   ";
        String rightrow_urdu11 = "  ????????????????  ";
        String rightrow_urdu12 = "   ???? ????????   ";


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


        String leftrow_eng0 = " Prepositions + ?????? ...";
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

        String leftrow_arabic0 = "Prepositions + ?????? ...";
        String leftrow_arabic1 = "?????????? ";
        String leftrow_arabic2 = "???????????? ";
        String leftrow_arabic3 = "???????????? ";
        String leftrow_arabic4 = "??????????   ";
        String leftrow_arabic5 = "??????????   ";
        String leftrow_arabic6 = "????????????   ";
        String leftrow_arabic7 = "????????????   ";
        String leftrow_arabic8 = "????????????    ";
        String leftrow_arabic9 = "????????????????   ";
        String leftrow_arabic10 = "????????????????   ";
        String leftrow_arabic11 = "????????????????????   ";
        String leftrow_arabic12 = "????????????????   ";


        String leftrow_urdu0 = "Prepositions + ?????? ...";
        String leftrow_urdu1 = "(????) ?????????? ???? ?????? ????  ";
        String leftrow_urdu2 = "(????) ????????  ";
        String leftrow_urdu3 = "  (????) ?????? ???? ";
        String leftrow_urdu4 = " ???????? ????  ";
        String leftrow_urdu5 = "  (???? ????) ???? ???? ";
        String leftrow_urdu6 = "(????)???? ????  ";
        String leftrow_urdu7 = " ????   ";
        String leftrow_urdu8 = " ???????? ????  ";
        String leftrow_urdu9 = "  ???? ?????? ???? ???? ";
        String leftrow_urdu10 = "  ???????????? ????  ";
        String leftrow_urdu11 = "???????? ????";
        String leftrow_urdu12 = "???? ?????? ";

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
        String rightrow_arabic1 = "???? ????";
        String rightrow_arabic2 = "????????   ";
        String rightrow_arabic3 = "??????   ";
        String rightrow_arabic4 = "????   ";
        String rightrow_arabic5 = " ????????  ";
        String rightrow_arabic6 = " ????????   ";
        String rightrow_arabic7 = "??????????   ";
        String rightrow_arabic8 = "????   ";
        String rightrow_arabic9 = "????????????   ";
        String rightrow_arabic10 = "?????????? ??";
        String rightrow_arabic11 = " ????????  ";
        String rightrow_arabic12 = "???? ";


        String rightrow_urdu0 = "Prepositions";
        String rightrow_urdu1 = "????????????????????    ";
        String rightrow_urdu2 = " ?????????????? ?????? ";
        String rightrow_urdu3 = "  ?????? ";
        String rightrow_urdu4 = " ???????? ";
        String rightrow_urdu5 = " ????   ";
        String rightrow_urdu6 = "   ???? ";
        String rightrow_urdu7 = "  ???????? ????  ";
        String rightrow_urdu8 = " ?????? ????  ";
        String rightrow_urdu9 = "???????? ???? ????  ";
        String rightrow_urdu10 = "  ????   ";
        String rightrow_urdu11 = " ????????   ";
        String rightrow_urdu12 = "  ??????   ";

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
        String leftrow_arabic1 = "???????? (+??????) ";
        String leftrow_arabic2 = "???? (+??????)";
        String leftrow_arabic3 = "???????????? (+??????)";
        String leftrow_arabic4 = "????+??????+?????? ";
        String leftrow_arabic5 = " ????????????(+??????) ";
        String leftrow_arabic6 = "???? ";
        String leftrow_arabic7 = "????????(??????????)";
        String leftrow_arabic8 = "?????? ";
        String leftrow_arabic9 = "???????? ";
        String leftrow_arabic10 = "???????? ";
        String leftrow_arabic11 = "?????????? ";
        String leftrow_arabic12 = "?????????? ";


        String leftrow_urdu0 = "Prefix for verb,...";
        String leftrow_urdu1 = "????????????";
        String leftrow_urdu2 = " ?????? ?????? ";
        String leftrow_urdu3 = "??????";
        String leftrow_urdu4 = "???????? ";
        String leftrow_urdu5 = "??????????";
        String leftrow_urdu6 = "????????(?????????? ???? ????)";
        String leftrow_urdu7 = "?????????? ????";
        String leftrow_urdu8 = "??????";
        String leftrow_urdu9 = "???????????? ";
        String leftrow_urdu10 = "????";
        String leftrow_urdu11 = "????????";
        String leftrow_urdu12 = "????????";

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
        String rightrow_arabic1 = "?????? ";
        String rightrow_arabic2 = "?????????? ";
        String rightrow_arabic3 = "?????????????? ";
        String rightrow_arabic4 = "???????????? ";
        String rightrow_arabic5 = "?????????????? ";
        String rightrow_arabic6 = "???????? ";
        String rightrow_arabic7 = "???????? ";
        String rightrow_arabic8 = "???????????? ";
        String rightrow_arabic9 = "?????????? ";
        String rightrow_arabic10 = "???????????? ";
        String rightrow_arabic11 = "???????? ";
        String rightrow_arabic12 = "??????????????????????????????";


        String rightrow_urdu0 = "Inna...";
        String rightrow_urdu1 = "???? ???? ";
        String rightrow_urdu2 = "????";
        String rightrow_urdu3 = " ???????? ????";
        String rightrow_urdu4 = "????????";
        String rightrow_urdu5 = "???????? ????";
        String rightrow_urdu6 = "????";
        String rightrow_urdu7 = "??????";
        String rightrow_urdu8 = "????";
        String rightrow_urdu9 = "???????? ????";
        String rightrow_urdu10 = "???? ";
        String rightrow_urdu11 = "??????";
        String rightrow_urdu12 = "???? ";

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
        String leftrow_arabic1="???????????? ";
        String leftrow_arabic2="???????? ";
        String leftrow_arabic3="???????????? ";
        String leftrow_arabic4="???????????? ";
        String leftrow_arabic5=" ????????????  ";
        String leftrow_arabic6="???????????? ";
        String leftrow_arabic7="???????????? ";
        String leftrow_arabic8="????????????  ";
        String leftrow_arabic9="????????????  ";
        String leftrow_arabic10="???????????? ";
        String leftrow_arabic11="???????????? ";
        String leftrow_arabic12="???????????? ";


        String leftrow_urdu0 ="Some attributes (of Allah and others)";
        String leftrow_urdu1 =" ???????????? ";
        String leftrow_urdu2 =" ???????????????? ";
        String leftrow_urdu3 ="?????? ???????????? ";
        String leftrow_urdu4 ="???????????? ";
        String leftrow_urdu5 ="???????? ???????? ";
        String leftrow_urdu6 ="?????? ?????? ???????? ";
        String leftrow_urdu7 ="????????????";
        String leftrow_urdu8 ="?????? ???????? ???????? ???????? ";
        String leftrow_urdu9 =" ???????? ????????  ";
        String leftrow_urdu10 ="?????????? ????????";
        String leftrow_urdu11 ="?????? ???????? ????????";
        String leftrow_urdu12 ="?????? ??????";

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
        String rightrow_arabic1="(fg) ????????????  ";
        String rightrow_arabic2="(fg) ????????  ";
        String rightrow_arabic3="(fg) ???????? ";
        String rightrow_arabic4="????????????  ";
        String rightrow_arabic5="????????????  ";
        String rightrow_arabic6="????????????  ";
        String rightrow_arabic7="??????????????  ";
        String rightrow_arabic8="????????????  ";
        String rightrow_arabic9="????????????  ";
        String rightrow_arabic10="????????????  ";
        String rightrow_arabic11="????????????  ";
        String rightrow_arabic12="???????????? ";



        String rightrow_urdu0 = "Some attributes (of Allah and others)";
        String rightrow_urdu1 = " ????????  ";
        String rightrow_urdu2 = " ????????";
        String rightrow_urdu3 = " ??????????";
        String rightrow_urdu4 = " ?????????? ??????";
        String rightrow_urdu5 = "???????????? ?????????? ???????? ";
        String rightrow_urdu6 = " ??????";
        String rightrow_urdu7 = "?????? ???????? ???????? ???????? ????????";
        String rightrow_urdu8 = "?????????? ???????? ????????";
        String rightrow_urdu9 = "???????? ???????? ";
        String rightrow_urdu10 = " ???????? ???????? ";
        String rightrow_urdu11 = "?????????? ?????? ??????";
        String rightrow_urdu12 = " ?????? ???????? ";



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


        String leftrow_eng0="Noun of Superiority ?????? ????????????????";
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

        String leftrow_arabic0="Noun of Superiority ?????? ????????????????";
        String leftrow_arabic1="????????????  ";
        String leftrow_arabic2="????????????  ";
        String leftrow_arabic3="??????????????  ";
        String leftrow_arabic4="??????????????  ";
        String leftrow_arabic5=" ??????????????   ";
        String leftrow_arabic6="??????????????  ";
        String leftrow_arabic7="??????????????  ";
        String leftrow_arabic8="????????????   ";
        String leftrow_arabic9="??????????????   ";
        String leftrow_arabic10="??????????????  ";
        String leftrow_arabic11="??????????????  ";
        String leftrow_arabic12="??????????????  ";


        String leftrow_urdu0 ="Noun of Superiority ?????? ????????????????";
        String leftrow_urdu1 =" ?????? ?????? ";
        String leftrow_urdu2 =" ?????? ???????? ";
        String leftrow_urdu3 =" ?????? ?????????? ???????? ";
        String leftrow_urdu4 ="?????? ???????? ";
        String leftrow_urdu5 =" ?????? ?????? ";
        String leftrow_urdu6 ="?????? ?????? ";
        String leftrow_urdu7 ="?????? ????????";
        String leftrow_urdu8 ="?????? ???? ?????? ";
        String leftrow_urdu9 ="????????  ";
        String leftrow_urdu10 ="?????????? ????????";
        String leftrow_urdu11 ="?????????? ?????????? ??????????";
        String leftrow_urdu12 ="?????????? ?????????? ??????????";

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
        String rightrow_arabic1="???????????? ";
        String rightrow_arabic2="???????????? ";
        String rightrow_arabic3="???????????? ";
        String rightrow_arabic4="????????????   ";
        String rightrow_arabic5="fg ???????????? ";
        String rightrow_arabic6="fg ????????????";
        String rightrow_arabic7="????????????   ";
        String rightrow_arabic8="????????????   ";
        String rightrow_arabic9="????????????   ";
        String rightrow_arabic10=" fg ???????????? ";
        String rightrow_arabic11="????????????   ";
        String rightrow_arabic12="????????????  ";



        String rightrow_urdu0 = "Some attributes ";
        String rightrow_urdu1 = " ??????   ";
        String rightrow_urdu2 = " ????????";
        String rightrow_urdu3 = " ?????? ?????????? ????????";
        String rightrow_urdu4 = "  ????????";
        String rightrow_urdu5 = "?????? ";
        String rightrow_urdu6 = " ??????????";
        String rightrow_urdu7 = "??????";
        String rightrow_urdu8 = " ?????????? ?????? ????????";
        String rightrow_urdu9 = "?????? ";
        String rightrow_urdu10 = "  ??????????  ";
        String rightrow_urdu11 = "?????? ????????";
        String rightrow_urdu12 = " ?????? ???????? ";


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
        String leftrow_eng4="    ???????? ";
        String leftrow_eng5="  ??????????????????????  ";
        String leftrow_eng6="  (????????????????????)";
        String leftrow_eng7=" ??????????????  ";
        String leftrow_eng8="  ???????????? ????????   ";
        String leftrow_eng9=" Satan ";
        String leftrow_eng10=" pharaoh ";
        String leftrow_eng11="people of hud";
        String leftrow_eng12="people of salih  ";

        String leftrow_arabic0="Prophets and ....";
        String leftrow_arabic1="???????????? ";
        String leftrow_arabic2="???????????? ";
        String leftrow_arabic3="???????????????????????????????????????????????????????????? ";
        String leftrow_arabic4="?????????? ";
        String leftrow_arabic5=" ???????? ";
        String leftrow_arabic6="???????????????? ";
        String leftrow_arabic7="???????? ";
        String leftrow_arabic8="???????????? ";
        String leftrow_arabic9="???????????????? ";
        String leftrow_arabic10=" ?????????????????? ";
        String leftrow_arabic11="????????  ";
        String leftrow_arabic12=" ????????????  ";


        String leftrow_urdu0 ="Prophets and ....";
        String leftrow_urdu1 =" ?????????? ??????  ";
        String leftrow_urdu2 =" ?????? ";
        String leftrow_urdu3 =" ?????? ";
        String leftrow_urdu4 ="  ?????????????????????? ";
        String leftrow_urdu5 =" ?????????????? ";
        String leftrow_urdu6 =" ???????????? ";
        String leftrow_urdu7 ="????????????";
        String leftrow_urdu8 ="???????????????? ";
        String leftrow_urdu9 ="??????????????????  ";
        String leftrow_urdu10 ="???????? ???? ???????????????? ???? ??????";
        String leftrow_urdu11 ="?????? ???????? ???????????? ???? ??????";
        String leftrow_urdu12 ="???????? ???????? ???????????? ???? ??????";

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
        String rightrow_arabic1="??????????  ";
        String rightrow_arabic2="??????????????????  ";
        String rightrow_arabic3="????????????  ";
        String rightrow_arabic4="????????????????    ";
        String rightrow_arabic5="??????????  ";
        String rightrow_arabic6="?????????? ";
        String rightrow_arabic7="??????????    ";
        String rightrow_arabic8="??????????    ";
        String rightrow_arabic9="??????????    ";
        String rightrow_arabic10=" ???????????? ";
        String rightrow_arabic11="??????????    ";
        String rightrow_arabic12="????????????   ";



        String rightrow_urdu0 = " Allah's Signs...";
        String rightrow_urdu1 = " ??????    ";
        String rightrow_urdu2 = " ???????? ????????";
        String rightrow_urdu3 = "????????";
        String rightrow_urdu4 = "   ?????? ???????? ?????????? ";
        String rightrow_urdu5 = "????????  ";
        String rightrow_urdu6 = " ????????";
        String rightrow_urdu7 = " ???????? ";
        String rightrow_urdu8 = "  ???????? ";
        String rightrow_urdu9 = "?????? ";
        String rightrow_urdu10 = "  ???? ";
        String rightrow_urdu11 = "????????";
        String rightrow_urdu12 = " ?????????? ";



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
        String leftrow_arabic1="????????????  ";
        String leftrow_arabic2="??????????????  ";
        String leftrow_arabic3="????????????";
        String leftrow_arabic4="???????????? ";
        String leftrow_arabic5=" ???????????????? ";
        String leftrow_arabic6="???????????? ";
        String leftrow_arabic7="???????????????? ";
        String leftrow_arabic8="??????????  ";
        String leftrow_arabic9="???????? ";
        String leftrow_arabic10=" ?????????? ";
        String leftrow_arabic11="??????????  ";
        String leftrow_arabic12=" ????????????????????  ";


        String leftrow_urdu0 ="Last Day,...";
        String leftrow_urdu1 ="?????????? ";
        String leftrow_urdu2 ="  ??????????  ";
        String leftrow_urdu3 =" ?????? ??????  ";
        String leftrow_urdu4 ="  ???????? ";
        String leftrow_urdu5 =" ?????????? ";
        String leftrow_urdu6 =" ???????? ";
        String leftrow_urdu7 ="??????????";
        String leftrow_urdu8 ="??????  ";
        String leftrow_urdu9 ="????  ";
        String leftrow_urdu10 ="??????????";
        String leftrow_urdu11 ="????";
        String leftrow_urdu12 =" ???? ????";

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
        String rightrow_arabic1="??????????????    ";
        String rightrow_arabic2="??????????   ";
        String rightrow_arabic3="??????????  ";
        String rightrow_arabic4="????????????????????    ";
        String rightrow_arabic5="????????????  ";
        String rightrow_arabic6="???????????? ";
        String rightrow_arabic7="????????????    ";
        String rightrow_arabic8="????????????    ";
        String rightrow_arabic9="????????????    ";
        String rightrow_arabic10=" ????????????????  ";
        String rightrow_arabic11="????????????    ";
        String rightrow_arabic12="????????????    ";



        String rightrow_urdu0 = " Last Day,...";
        String rightrow_urdu1 = " ??????????    ";
        String rightrow_urdu2 = "???????? ";
        String rightrow_urdu3 = "???????????? ????????";
        String rightrow_urdu4 = "  ???????? ";
        String rightrow_urdu5 = " ????????????  ";
        String rightrow_urdu6 = " ???????? ";
        String rightrow_urdu7 = " ???????????? ???? ";
        String rightrow_urdu8 = "   ????????  ";
        String rightrow_urdu9 = "?????? ";
        String rightrow_urdu10 = "  ???????? ";
        String rightrow_urdu11 = " ???????? ";
        String rightrow_urdu12 = " ??????  ";




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
        String leftrow_arabic1="??????????  ";
        String leftrow_arabic2="??????????????  ";
        String leftrow_arabic3="????????";
        String leftrow_arabic4="???????????? ";
        String leftrow_arabic5=" ?????????????? ";
        String leftrow_arabic6="?????????? ";
        String leftrow_arabic7="???????? ";
        String leftrow_arabic8="????????????  ";
        String leftrow_arabic9="????????????  ";
        String leftrow_arabic10=" ???????????? ";
        String leftrow_arabic11="????????????  ";
        String leftrow_arabic12=" ????????  ";


        String leftrow_urdu0 ="Deen,...";
        String leftrow_urdu1 ="???????????????????? ";
        String leftrow_urdu2 ="   ????????   ";
        String leftrow_urdu3 =" ????????   ";
        String leftrow_urdu4 ="  ???????????????? ";
        String leftrow_urdu5 =" ???????? ";
        String leftrow_urdu6 =" ?????? ";
        String leftrow_urdu7 ="???????????????? ";
        String leftrow_urdu8 ="????????  ";
        String leftrow_urdu9 =" ????????  ";
        String leftrow_urdu10 =" ????????";
        String leftrow_urdu11 =" ???????? ???????? ???????? ";
        String leftrow_urdu12 =" ??????????";

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
        String rightrow_arabic1="?????????? ";
        String rightrow_arabic2="?????? ";
        String rightrow_arabic3="???????????? ";
        String rightrow_arabic4="???????????????? ";
        String rightrow_arabic5="??????????  ";
        String rightrow_arabic6="???????? ";
        String rightrow_arabic7="??????????";
        String rightrow_arabic8="????????????";
        String rightrow_arabic9="??????????????";
        String rightrow_arabic10="?????????? ";
        String rightrow_arabic11="?????????????? ";
        String rightrow_arabic12="????????????";



        String rightrow_urdu0 = "  Faith,.....";
        String rightrow_urdu1 = " ??????????    ";
        String rightrow_urdu2 = "?????????? ";
        String rightrow_urdu3 = "????????????????????";
        String rightrow_urdu4 = "  ?????????? ";
        String rightrow_urdu5 = "  ???????? ??????   ";
        String rightrow_urdu6 = "  ?????? ";
        String rightrow_urdu7 = "??????????????";
        String rightrow_urdu8 = "    ????????  ";
        String rightrow_urdu9 = " ?????? ";
        String rightrow_urdu10 = "  ?????????? ";
        String rightrow_urdu11 = "  ?????? ";
        String rightrow_urdu12 = "  ??????   ";



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
        String leftrow_arabic1="????????????????   ";
        String leftrow_arabic2="??????????????";
        String leftrow_arabic3="?????????????? ";
        String leftrow_arabic4="?????????? ";
        String leftrow_arabic5=" ????????  ";
        String leftrow_arabic6="??????????  ";
        String leftrow_arabic7="??????????  ";
        String leftrow_arabic8="????????????   ";
        String leftrow_arabic9="????????????  ";
        String leftrow_arabic10=" ?????????? ";
        String leftrow_arabic11="????????????   ";
        String leftrow_arabic12=" ????????????????   ";


        String leftrow_urdu0 ="Deeds,... ";
        String leftrow_urdu1 ="?????????? ";
        String leftrow_urdu2 ="????????";
        String leftrow_urdu3 =" ??????????????????";
        String leftrow_urdu4 =" ??????????????????  ";
        String leftrow_urdu5 ="  ????????  ";
        String leftrow_urdu6 ="  ????????  ";
        String leftrow_urdu7 =" ????????  ";
        String leftrow_urdu8 =" ???????? ";
        String leftrow_urdu9 ="   ??????????  ";
        String leftrow_urdu10 ="  ?????? ";
        String leftrow_urdu11 ="??????  ";
        String leftrow_urdu12 =" ??????";

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
        String rightrow_arabic1="????????????  ";
        String rightrow_arabic2="???????????????? ";
        String rightrow_arabic3="??????????  ";
        String rightrow_arabic4="???????? ";
        String rightrow_arabic5="??????????  ";
        String rightrow_arabic6="?????????????? ";
        String rightrow_arabic7="??????????????????????????????????????????";
        String rightrow_arabic8="??????????";
        String rightrow_arabic9="?????????? ";
        String rightrow_arabic10="???????????? ";
        String rightrow_arabic11="???????????? ";
        String rightrow_arabic12="???????????? ";



        String rightrow_urdu0 = " Blessings,......";
        String rightrow_urdu1 = " ???????????? ";
        String rightrow_urdu2 = "?????????????????? ";
        String rightrow_urdu3 = " ?????????????? ";
        String rightrow_urdu4 = "  ???????? ";
        String rightrow_urdu5 = "???????????????????????? ";
        String rightrow_urdu6 = "   ??????????  ";
        String rightrow_urdu7 = "?????? ???? ?????? ";
        String rightrow_urdu8 = " ?????????????????? ";
        String rightrow_urdu9 = " ??????????????????";
        String rightrow_urdu10 = " ???????????????? ";
        String rightrow_urdu11 = "??????????";
        String rightrow_urdu12 = "????????  ";




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
        String leftrow_arabic1="?????????? ";
        String leftrow_arabic2="???????????????????? ";
        String leftrow_arabic3=" ?????????? ";
        String leftrow_arabic4="?????????? ";
        String leftrow_arabic5=" ??????????????????";
        String leftrow_arabic6=" ?????????? ";
        String leftrow_arabic7="???????????? ";
        String leftrow_arabic8=" ??????????????????";
        String leftrow_arabic9="??????????";
        String leftrow_arabic10="  ???????????????????????????????????????????? ";
        String leftrow_arabic11=" ???? ";
        String leftrow_arabic12="  ????????????????    ";


        String leftrow_urdu0 ="Relatives,... ";
        String leftrow_urdu1 ="?????? ";
        String leftrow_urdu2 ="??????";
        String leftrow_urdu3 =" ??????????????????";
        String leftrow_urdu4 ="?????? ";
        String leftrow_urdu5 ="????????";
        String leftrow_urdu6 =" ???????? ???? ????????  ";
        String leftrow_urdu7 ="?????? ";
        String leftrow_urdu8 =" ?????????? ";
        String leftrow_urdu9 ="    ????????   ";
        String leftrow_urdu10 ="  ????????  ";
        String leftrow_urdu11 =" ???????? ";
        String leftrow_urdu12 ="  ????????";

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
        String rightrow_arabic1="????????  ";
        String rightrow_arabic2="?????????? ";
        String rightrow_arabic3="?????????????? ";
        String rightrow_arabic4=" ?????????????? ";
        String rightrow_arabic5="???????????? ";
        String rightrow_arabic6=" ??????????  ";
        String rightrow_arabic7="?????????? ";
        String rightrow_arabic8="?????? ";
        String rightrow_arabic9="???????????? ";
        String rightrow_arabic10="??????????  ";
        String rightrow_arabic11=" ????????  ";
        String rightrow_arabic12="???????????? ";



        String rightrow_urdu0 = "Self (body parts,...)";
        String rightrow_urdu1 = " ??????  ";
        String rightrow_urdu2 = "?????????????????? ";
        String rightrow_urdu3 = " ???????????? ";
        String rightrow_urdu4 = "??????  ";
        String rightrow_urdu5 = "???????? ";
        String rightrow_urdu6 = " ????  ";
        String rightrow_urdu7 = "???????? ";
        String rightrow_urdu8 = " ????????  ";
        String rightrow_urdu9 = " ??????";
        String rightrow_urdu10 = " ???????????? ";
        String rightrow_urdu11 = "??????";
        String rightrow_urdu12 = "??????";






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
        String leftrow_arabic1="?????????? ";
        String leftrow_arabic2="????????";
        String leftrow_arabic3=" ?????????????? ";
        String leftrow_arabic4="???????????? ";
        String leftrow_arabic5=" ????????????";
        String leftrow_arabic6=" ???????????? ";
        String leftrow_arabic7="?????????????? ";
        String leftrow_arabic8=" ??????????????";
        String leftrow_arabic9="????????";
        String leftrow_arabic10="?????????????? ";
        String leftrow_arabic11="????????????";
        String leftrow_arabic12="????????????";


        String leftrow_urdu0 ="World,... ";
        String leftrow_urdu1 ="?????? ";
        String leftrow_urdu2 ="??????";
        String leftrow_urdu3 ="????????";
        String leftrow_urdu4 ="?????????? ";
        String leftrow_urdu5 ="??????????";
        String leftrow_urdu6 ="???????? ??????????????";
        String leftrow_urdu7 =" ????????????????????";
        String leftrow_urdu8 =" ???????? ";
        String leftrow_urdu9 ="??????";
        String leftrow_urdu10 ="   ??????????????????  ";
        String leftrow_urdu11 =" ???????? ";
        String leftrow_urdu12 ="  ???????????????? ";

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
        String rightrow_arabic1="????????????   ";
        String rightrow_arabic2="?????????? ";
        String rightrow_arabic3="???????????????? ";
        String rightrow_arabic4=" ???????? ";
        String rightrow_arabic5="?????????? ";
        String rightrow_arabic6=" ??????????????  ";
        String rightrow_arabic7="?????????? ";
        String rightrow_arabic8="???????????? ";
        String rightrow_arabic9="?????????????? ";
        String rightrow_arabic10="??????????????  ";
        String rightrow_arabic11="?????????? ";
        String rightrow_arabic12="???????????? ";



        String rightrow_urdu0 = "People,...";
        String rightrow_urdu1 = "??????????????????";
        String rightrow_urdu2 = "????????????????????";
        String rightrow_urdu3 = "  ??????????  ";
        String rightrow_urdu4 = "?????? ";
        String rightrow_urdu5 = "???????????? ";
        String rightrow_urdu6 = " ?????????????????? ";
        String rightrow_urdu7 = "??????????????????  ";
        String rightrow_urdu8 = " ????????  ";
        String rightrow_urdu9 = " ????????  ";
        String rightrow_urdu10 = "  ???????????????????????????? ";
        String rightrow_urdu11 = "?????? ?????????? ???? ??????????";
        String rightrow_urdu12 = " ?????????? ???????? ????????  ";


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
        String leftrow_arabic1="(mg) ?????????????????????? ";
        String leftrow_arabic2="(fg) ???????? ";
        String leftrow_arabic3="????????????????????????????????";
        String leftrow_arabic4="????????  ";
        String leftrow_arabic5="????  ";
        String leftrow_arabic6="??????????  ";
        String leftrow_arabic7="????????????  ";
        String leftrow_arabic8="??????????   ";
        String leftrow_arabic9="??????????????????  ";
        String leftrow_arabic10="??????????  ";
        String leftrow_arabic11="??????????  ";
        String leftrow_arabic12="??????????????  ";


        String leftrow_urdu0 ="Miscellaneous";
        String leftrow_urdu1 ="???????? ";
        String leftrow_urdu2 ="???????? ";
        String leftrow_urdu3 =" ????????";
        String leftrow_urdu4 ="???????? ";
        String leftrow_urdu5 ="  ?????? ???????????? ?????????????????? ???????? ????????";
        String leftrow_urdu6 ="???????????????????? ???????? ";
        String leftrow_urdu7 =" ?????? ???? ?????????????? ???? ???????? ";
        String leftrow_urdu8 =" ?????? ???? ?????? ";
        String leftrow_urdu9 =" ?????? ???? ????";
        String leftrow_urdu10 =" ???????? ";
        String leftrow_urdu11 ="????????";
        String leftrow_urdu12 ="(????) ???? ???? ";

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
        String rightrow_arabic1="?????????? ????";
        String rightrow_arabic2="??????????  ";
        String rightrow_arabic3="????????  ";
        String rightrow_arabic4="(for past)??????  ";
        String rightrow_arabic5="(for future)???????? ";
        String rightrow_arabic6="??????????  ";
        String rightrow_arabic7="????  ";
        String rightrow_arabic8="??????  ";
        String rightrow_arabic9="????????????????????????????????????  ";
        String rightrow_arabic10="????????...???????????? ??";
        String rightrow_arabic11="  ??????...????????????  ";
        String rightrow_arabic12="????????????";



        String rightrow_urdu0 = "When ?";
        String rightrow_urdu1 = "????????  ";
        String rightrow_urdu2 = " ?????? ";
        String rightrow_urdu3 = "  ?????????????? ";
        String rightrow_urdu4 = " ???? ";
        String rightrow_urdu5 = " ????  ";
        String rightrow_urdu6 = "  ?????? ";
        String rightrow_urdu7 = "??????????  ";
        String rightrow_urdu8 = " ????????  ";
        String rightrow_urdu9 = " ??????????????????   ";
        String rightrow_urdu10 = " ????????????????   ";
        String rightrow_urdu11 = "  ????????????????  ";
        String rightrow_urdu12 = "   ???? ????????   ";





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
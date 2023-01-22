package com.example.quranapp;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class sqllitehelper extends SQLiteOpenHelper {
    public sqllitehelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String name) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Parent VALUES (?)";



        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);

        statement.executeInsert();

    }
    public void insertchild(String name,String age,String pname) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO children11 VALUES (?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, age);
        statement.bindString(3, pname);

        statement.executeInsert();
    }
    public void insertlec1(String leftroweng,String leftrowarabic,String leftrowurdu,byte[] leftaudio,String rightroweng,String rightrowarabic,String rightrowurdu,byte[] rightaudio,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO table0 VALUES (?,?,?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindBlob(4, leftaudio);
        statement.bindString(5, rightroweng);
        statement.bindString(6, rightrowarabic);
        statement.bindString(7, rightrowurdu);
        statement.bindBlob(8, rightaudio);
        statement.bindString(9, id);



        statement.executeInsert();
    }
    public void insertlec2(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t2 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec3(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t3 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec4(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t4 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec5(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t5 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec6(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t6 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec7(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t7 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec8(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t8 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec9(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t9 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec10(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t10 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec11(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t11 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec12(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t12 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec13(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t13 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec14(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t14 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }
    public void insertlec15(String leftroweng,String leftrowarabic,String leftrowurdu,String rightroweng,String rightrowarabic,String rightrowurdu,String id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO t15 VALUES (?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,leftroweng);
        statement.bindString(2, leftrowarabic);
        statement.bindString(3, leftrowurdu);
        statement.bindString(4, rightroweng);
        statement.bindString(5, rightrowarabic);
        statement.bindString(6, rightrowurdu);
        statement.bindString(7, id);



        statement.executeInsert();
    }


    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

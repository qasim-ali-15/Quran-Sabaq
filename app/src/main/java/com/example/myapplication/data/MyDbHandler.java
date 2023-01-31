package com.example.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.model.QuranTable;
import com.example.myapplication.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    SQLiteDatabase db;
    String create = " CREATE TABLE " + Params.TABLE_NAME + "( "
            + Params.KEY_ID + " INTEGER PRIMARY KEY, " + Params.KEY_NAME
            + " TEXT, " + Params.KEY_SABAQ + " TEXT," + Params.KEY_SABAQI + "TEXT," +
            Params.KEY_MANZAIL + ")";
    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("myDB","Query Runs : "+ create);
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + create);
        onCreate(db);
    }


    /*public void addStudent(QuranTable Stu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, Stu.getName());
        values.put(Params.KEY_SABAQ, Stu.getSabaq());
        values.put(Params.KEY_SABAQI, Stu.getSabaqi());
        values.put(Params.KEY_MANZAIL, Stu.getManzil());

        db.insert(Params.TABLE_NAME,null,values);

        Log.d("myDB","Sucessfully inserted");
        db.close();

    }*/

    public void addStudent(QuranTable Stu) {
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, Stu.getName());
        values.put(Params.KEY_SABAQ, Stu.getSabaq());
        values.put(Params.KEY_SABAQI, Stu.getSabaqi());
        values.put(Params.KEY_MANZAIL, Stu.getManzil());
        db = this.getWritableDatabase();

        db.insert(Params.TABLE_NAME,null,values);

        Log.d("myDB","Sucessfully inserted");
        db.close();
    }

    public List<QuranTable> getStudentList(){
        String sql="select * from "+ Params.TABLE_NAME;
        db=this.getReadableDatabase();
        List<QuranTable> storeStudents = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                int id=Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String sabaq = cursor.getString(2);
                String sabaqi = cursor.getString(3);
                String manzil = cursor.getString(4);
                storeStudents.add(new QuranTable(id,name,sabaq,sabaqi,manzil));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return storeStudents;
    }

    public void updateStudents(QuranTable quranTable){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Params.KEY_NAME,quranTable.getName());
        contentValues.put(Params.KEY_SABAQ,quranTable.getSabaq());
        contentValues.put(Params.KEY_SABAQI,quranTable.getSabaqi());
        contentValues.put(Params.KEY_MANZAIL,quranTable.getManzil());
        db=this.getWritableDatabase();
        db.update(Params.TABLE_NAME,contentValues,Params.KEY_ID + " = ?", new String[]
                {String.valueOf(quranTable.getId())});
    }
}

package com.example.ani_irctc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class database extends SQLiteOpenHelper {
        public database(Context e)
        {
            super(e,"ANI_IRCTC",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table API(API_KEY  TEXT)");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db ,int old,int version)
        {
            db.execSQL("DROP TABLE IF EXISTS API");
            onCreate(db);
        }
        public void  delete()
        {
            SQLiteDatabase a=getWritableDatabase();
            a.delete("API",null,null);
        }
        public void insert(String api_key)
        {
            ContentValues value=new ContentValues();
            value.put("API_KEY",api_key);
            SQLiteDatabase db=getWritableDatabase();
            db.insert("API",null,value);

        }
        public Cursor fetch()
        {
            SQLiteDatabase db=getReadableDatabase();
            Cursor c=db.rawQuery("select * from API",null,null);
            return c;
        }
    }




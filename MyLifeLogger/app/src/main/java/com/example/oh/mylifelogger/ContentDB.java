package com.example.oh.mylifelogger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Oh on 2016-12-02.
 */

public class ContentDB extends SQLiteOpenHelper
{
    public ContentDB(Context context, String name){
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE database (_id INTEGER PRIMARY KEY AUTOINCREMENT, latitude REAR, longitude REAR, "
                + "type TEXT , content TEXT , photo_location TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS database";
        db.execSQL(sql);
        onCreate(db);
    }
    public void insert(Double latitude, Double longitude, String content, String type, String photo_location){
        SQLiteDatabase db = getWritableDatabase();

        Log.d("SQL", "Latitude : " + latitude + "Longitude : " + longitude + "Content : " + content + "Type : " + type + "Photo_location : " + photo_location);
        db.execSQL("INSERT INTO database VALUES(NULL, " + latitude + ", " + longitude + ", '" + type + "', '" + content + "', '" + photo_location + "');");
        db.close();
    }

    public String getResult()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM database", null);
        String res="";
        while(cursor.moveToNext())
        {
            Double latitude = cursor.getDouble(cursor.getColumnIndex("latitude"));
            Double longitude = cursor.getDouble(cursor.getColumnIndex("longitude"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            String content = cursor.getString(cursor.getColumnIndex("content"));

            res="위도"+latitude+"경도"+longitude+"유형"+type+"내용"+content;

        }
        return res;
    }

}

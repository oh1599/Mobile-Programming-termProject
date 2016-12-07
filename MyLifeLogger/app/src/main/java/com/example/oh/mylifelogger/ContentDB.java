package com.example.oh.mylifelogger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Oh on 2016-12-02.
 */

public class ContentDB extends SQLiteOpenHelper{

    public ContentDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE content( _id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, content TEXT, latitude REAL, longitude REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS content";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(int hour, int minute, Double latitude, Double longitude, int category, String whatido, float time, String photo_location){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO database VALUES(NULL, " + hour + ", " + minute + ", " + latitude + ", " + longitude + ", "
                + category + ", '" + whatido + "', " + time + ", '" + photo_location + "');");
        Log.d ("SQL", "select : " + "(hour:" + hour + ")(minute:" + minute + ")(latitude:" + latitude + ")(longitude:" + longitude
                + ")(category:" + category + ")(whatido:" + whatido + ")(time:" + time +")(photo_location: " + photo_location + ")");
        db.close();
    }
}

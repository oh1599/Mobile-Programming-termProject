package com.example.oh.mylifelogger;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    TextView result;
    ContentDB helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result=(TextView)findViewById(R.id.result);

        result.setText("위도"+37.63386+"경도"+126.83041+"유형: 등하교"+" 내용: 등교 시간이다.");
    }
}

package com.example.oh.mylifelogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//한샘이형 하이
public class MainActivity extends AppCompatActivity {

    Intent writeIntent,mapIntent,resultIntent,statisticIntent;
    ImageView writeImage,mapImage,resultImage,statisticImage;
    TextView writeText,mapText,resultText,statisticText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeIntent=new Intent(getApplicationContext(),WriteActivity.class);
        mapIntent=new Intent(getApplicationContext(),MapsActivity.class);
        statisticIntent=new Intent(getApplicationContext(),StatisticActivity.class);
        resultIntent=new Intent(getApplicationContext(),ResultActivity.class);

        writeImage=(ImageView)findViewById(R.id.writeImage);
        mapImage=(ImageView)findViewById(R.id.mapImage);
        resultImage=(ImageView)findViewById(R.id.resultImage);
        statisticImage=(ImageView)findViewById(R.id.statisticImage);

        writeText=(TextView)findViewById(R.id.writeText);
        mapText=(TextView)findViewById(R.id.mapText);
        resultText=(TextView)findViewById(R.id.resultText);
        statisticText=(TextView)findViewById(R.id.statisticText);

        writeImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(writeIntent);
            }
        });

        writeText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(writeIntent);
            }
        });

        mapImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mapIntent);
            }
        });

        mapText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mapIntent);
            }
        });

        resultImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(resultIntent);
            }
        });

        resultText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(resultIntent);
            }
        });

        statisticImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(statisticIntent);
            }
        });

        statisticText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(statisticIntent);
            }
        });
    }

}

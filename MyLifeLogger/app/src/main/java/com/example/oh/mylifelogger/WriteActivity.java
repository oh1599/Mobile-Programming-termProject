package com.example.oh.mylifelogger;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class WriteActivity extends AppCompatActivity {

    Button camera;
    TextView typeText;
    Spinner spinner;
    ImageView setPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        camera=(Button)findViewById(R.id.takePicture);
        spinner = (Spinner)findViewById(R.id.thema);
        typeText=(TextView)findViewById(R.id.typeText);
        setPicture=(ImageView)findViewById(R.id.setPicture);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                typeText.setText(""+ parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        camera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        setup();
    }

    private void setup()
    {
        camera= (Button)findViewById(R.id.takePicture);
        setPicture = (ImageView)findViewById(R.id.setPicture);

        camera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        setPicture.setImageURI(data.getData());
    }
}

package com.example.oh.mylifelogger;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class WriteActivity extends AppCompatActivity {

    Button camera,store;
    TextView typeText,result;
    EditText content;
    Spinner spinner;
    ImageView setPicture;
    SQLiteDatabase db;
    ContentDB helper;
    Intent intent;

    double latitude=0;
    double longitude=0;
    String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        helper = new ContentDB(WriteActivity.this,"content.db");
        result=(TextView)findViewById(R.id.result);
        content=(EditText)findViewById(R.id.content);

        intent=new Intent(getApplicationContext(),MainActivity.class);

        camera=(Button)findViewById(R.id.takePicture);
        store=(Button)findViewById(R.id.store);

        spinner = (Spinner)findViewById(R.id.thema);
        typeText=(TextView)findViewById(R.id.typeText);
        setPicture=(ImageView)findViewById(R.id.setPicture);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                typeText.setText(""+ parent.getItemAtPosition(position));
                type=""+parent.getItemAtPosition(position);
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

        //저장 버튼 클릭
        store.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                helper.insert(latitude,longitude,type,content.getText().toString(),"dd");
                content.setText("");
                startActivity(intent);
            }
        });
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

    private class GPSListener implements LocationListener {


        @Override
        public void onLocationChanged(Location location) {
            if (location.getProvider().equals(LocationManager.GPS_PROVIDER))
            {
                longitude = location.getLongitude();    //경도
                latitude = location.getLatitude();         //위도
                float accuracy = location.getAccuracy();        //신뢰도
            }
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
        @Override
        public void onProviderEnabled(String provider) {
        }
        @Override
        public void onProviderDisabled(String provider) {
        }
    }
    private void startLocationService()
    {
        LocationManager manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        GPSListener gpsListener = new GPSListener();


        try{
            manager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0, 0, gpsListener);
            manager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    0, 0, gpsListener);
        }
        catch (SecurityException ex){
            ex.printStackTrace();
        }
    }
}

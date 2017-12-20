package com.example.wouter.spinthebottle;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor Accelero;
    private int Score = 0;
    private SensorManager SensorM;
    private static final String Tag = "MainActivity";
    float Veltot;
    TextView TeamOne ;
    Gameplay newgame = new Gameplay();
    ImageView Bottle ;
    public void RotateOnShake(Gameplay newgame, ImageView Bottle)
    {
        if (Veltot > 250){
            newgame.Rotateanimation(Bottle);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bottle = (ImageView) findViewById(R.id.bottlespinImg);

        //Sensormeter + accelerometer aanmaken
        SensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        Accelero = SensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorM.registerListener(this, Accelero, SensorManager.SENSOR_DELAY_GAME);

        // Initializatie van buttons imageview enz..
        Button playGameBtn = (Button) findViewById(R.id.gameplaybtn);
        TeamOne = (TextView)  findViewById(R.id.teamA);




        //Text Verwerken van team a
        TeamOne.setText("Team 1 :"+ Score );
        // Button Click Listner voor de game
        playGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rotatie testen
                System.out.println(newgame.getrotation(true, 0));
                newgame.Rotateanimation(Bottle);
                TeamOne.setText("Team 1 :"+ Score );
                Score++;

            }
        });
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
      //  Log.d(Tag, "OnSensorChanged: X :" + sensorEvent.values[0] + "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]);
        Veltot = 1;
        for ( int j =0 ; j < sensorEvent.values.length;  j++ ){
            Veltot *=  Math.abs(sensorEvent.values[j]) ;
        }
        if(Veltot > 400){
            newgame.Rotateanimation(Bottle);
            newgame.getrotation(false,Veltot);
        }


        Log.d(Tag, "Total log values:" + Veltot);
    }
}

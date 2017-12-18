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

import java.lang.reflect.Type;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor Accelero;
    private SensorManager SensorM;
    private static final String Tag = "MainActivity";
    private static int currentstate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Sensormeter + accelerometer aanmaken
       SensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        Accelero = SensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorM.registerListener(this,Accelero,SensorManager.SENSOR_DELAY_GAME);




        // Gameplay Class
       final Gameplay newgame = new Gameplay();


        // Initializatie van buttons imageview enz..
        final ImageView Bottle = (ImageView) findViewById(R.id.bottlespinImg);
        Button playGameBtn = (Button) findViewById(R.id.gameplaybtn);

        // Button Click Listner voor de game
        playGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rotatie testen
                System.out.println(newgame.getrotation());
                newgame.Rotateanimation(Bottle);

            }
        });
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
      //  Log.d(Tag, "OnSensorChanged: X :" + sensorEvent.values[0] + "Y:" + sensorEvent.values[1] + "Z:" + sensorEvent.values[2]);
         float Veltot = 1;

        for ( int j =0 ; j < sensorEvent.values.length;  j++ ){
            Veltot *=  Math.abs(sensorEvent.values[j]) ;
        }


        Log.d(Tag, "Total log values:" + Veltot);
    }
}

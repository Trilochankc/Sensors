package com.trilochan.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AccelerometerActivity extends AppCompatActivity {
    private TextView tvShowAxix;
    private SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        tvShowAxix = findViewById(R.id.tvshowaxix);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
            @Override

            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                String Xaxis = "X :"  + values[0];
                String Yaxis = "Y :"  + values[1];
                String Zaxis = "Z :"  + values[2];

                tvShowAxix.setText(Xaxis + "" + Yaxis + "" + Zaxis+ "");
            }
        };

        if (sensor !=null){
            sensorManager.registerListener(sel, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        }
        else {
            Toast.makeText(this, "no sensor found", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.trilochan.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class Gyroscope extends AppCompatActivity {
    private SensorManager sensorManager;
    private EditText etXaxis, etYaxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        setTitle("Gyroscope Sensor");
        etXaxis = findViewById(R.id.etXaxis);
        etYaxis = findViewById(R.id.etYaxis);

        sensorGyro();
    }

    private void sensorGyro()
    {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener gyrolistern = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if ( event.values[1] < 0){
                    int value1 = Integer.parseInt(etXaxis.getText().toString());
                    value1 = value1 -1;
                    etXaxis.setText(value1);
                }
                else if(event.values[1] < 0){
                    int value2 = Integer.parseInt(etYaxis.getText().toString());
                    value2 = value2 -1;
                    etYaxis.setText(value2);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
}

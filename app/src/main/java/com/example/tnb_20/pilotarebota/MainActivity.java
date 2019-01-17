package com.example.tnb_20.pilotarebota;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    SensorManager sensorMgr;
    Sensor sensor;
   // ImageView img;

    // Control de la velocitat
    float velocitatX = 30.0f;
    float velocitatY = 30.0f;
    float iniciX, iniciY;

    // Mides per fer càlculs
    int statusBar, width, height;

    ArrayList<Bola> bolas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        bolas = new ArrayList();

        // Obtenim les dimensions de la pantalla
        DisplayMetrics display = this.getBaseContext().getResources().getDisplayMetrics();
        width = display.widthPixels;
        height = display.heightPixels;

        for (int x = 0; x < 2;x++){
            Random random = new Random();
            ImageView img = new ImageView(getApplicationContext());
            img.setImageDrawable(getDrawable(R.drawable.bola));
            int posY = random.nextInt((height/2) - 500 + 1) + 500;
            int posX = random.nextInt((width/2) - 500 + 1) + 500;

            //Log.v("pos", Integer.toString(n));


            img.setX(posX);
            img.setY(posY);

            rl.addView(img);
            
            bolas.add(new Bola(posX, posY, velocitatX, velocitatY, img, height, width));
        }


        // La bola
       // img = (ImageView) findViewById(R.id.imageView);



        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();

        myTimer.schedule(myTask, 0, 100);

        // Mida de l'statusBar per calcular l'alçada de l'aplicació
        statusBar = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));

    }

    class MyTimerTask extends TimerTask {
        public void run() {

            for (Bola bola:bolas) {
                bola.move();
            }
            /*if(img.getX() < 0){
                velocitatX = velocitatX*-1;
            }

            if((img.getX() + img.getWidth()) > width){
                velocitatX = velocitatX*-1;
            }

            if(img.getY() < 0){
                velocitatY = velocitatY*-1;
            }

            if((img.getY() + img.getHeight()) > height){
                velocitatY = velocitatY*-1;
            }

            float novaPosicioX = img.getX() + velocitatX;
            float novaPosicioY = img.getY() + velocitatY;

            img.setY(novaPosicioY);
            img.setX(novaPosicioX);*/
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
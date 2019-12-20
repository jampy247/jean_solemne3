package com.app.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.app.biblioteca.R;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Home_act extends AppCompatActivity {



    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);



        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i<images.length ;i++)
        {
            Instrucciones(images[i]);
        }
    }




    public void Instrucciones(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);


        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }





    public void info(View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
    public void Serv(View v)
    {
        Intent i = new Intent(this, Sec_act.class);
        startActivity(i);
    }

    public void Base(View v)
    {
        Intent i = new Intent(this, Base_act.class);
        startActivity(i);
    }



    public void Libros(View view)
    {
        String[] datos = {"Farenheit", "Revival", "El Alquimista"};
        Intent i = new Intent(this, Libros_act.class);
        i.putExtra("libros", datos);
        startActivity(i);
    }

}

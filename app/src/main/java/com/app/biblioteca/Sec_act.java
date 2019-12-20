package com.app.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Sec_act extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);
    }

    public void Incidencia1(View v)
    {
        String [] vulnerabilidades = {"1234"};
        tv.setText("contraseña muy obvia "+vulnerabilidades[0]);
    }
    public void Incidencia2(View v)
    {
        String [] vulnerabilidades = {"user"};
        tv.setText("nombre de usuario obvio"+vulnerabilidades[1]);
    }
}

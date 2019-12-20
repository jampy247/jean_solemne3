package com.app.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.biblioteca.R;

public class Libros_act extends AppCompatActivity {

    private Spinner spn;
    private TextView tv;
    private EditText et1, et2;
    private String[] precios = new String[]{"7000", "22000", "45000","88000","15600"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_act);

        spn = (Spinner)findViewById(R.id.spn);
        tv = (TextView)findViewById(R.id.result);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);

        Bundle dat = getIntent().getExtras();
        String[] lista = dat.getStringArray("libros");

        ArrayAdapter adapt = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lista);

        spn.setAdapter(adapt);

    }

    public void Calcular(View v)
    {
        if(spn.getSelectedItem().equals("Farenheit"))
        {
            String precio = precios[0];
            int st = Integer.parseInt(et1.getText().toString());
            int cp = Integer.parseInt(et2.getText().toString());
            int pc = Integer.parseInt(precio);
            int resultado = pc * st + cp;

            tv.setText("Stock disponible: "+ st + "\n"
                     + "Precio final: "+ resultado);
        }

        if(spn.getSelectedItem().equals("Revival"))
        {
            String precioRevival = precios[1];

            int stock = Integer.parseInt(et1.getText().toString());
            int costo = Integer.parseInt(et2.getText().toString());
            int precioLibro = Integer.parseInt(precioRevival);

            int resultado = precioLibro*stock+costo;

            tv.setText("Stock disponible: " +stock+ "\n"
            +"el precio final es: "+ resultado);
        }

        if(spn.getSelectedItem().equals("El Alquimista"))
        {

            String precioAlquimista = precios[2];

            int stock = Integer.parseInt(et1.getText().toString());
            int costo = Integer.parseInt(et2.getText().toString());
            int precioLibro = Integer.parseInt(precioAlquimista);

            int resultado = precioLibro*stock+costo;

            tv.setText("Stock disponible: " +stock+ "\n"
                    +"el precio final es: "+ resultado);
        }
    }

    public void books( View v){
        Intent i = new Intent(this, Mqtt_act.class);
        startActivity(i);

    }

}

package com.app.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {

    private EditText edit1,edit2 ,edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        edit1=(EditText)findViewById(R.id.edit1);
        edit2=(EditText)findViewById(R.id.edit2);
        edit3=(EditText)findViewById(R.id.edit3);
    }
    public void AñadirLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "primero",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!edit1.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo",edit1.getText().toString());
            registro.put("nombre",edit2.getText().toString());
            registro.put("precio",edit3.getText().toString());

            BaseDeDatos.insert("libros",null,registro);

            BaseDeDatos.close();

            Toast.makeText(this,"se ingreso correctamente",Toast.LENGTH_SHORT).show();
        }
    }


    public void EliminarLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "primero",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = edit1.getText().toString();
        BaseDeDatos.delete("libros","codigo"+codigo,null);
        BaseDeDatos.close();

        Toast.makeText(this,"libro eliminado por el codigo  "+codigo ,Toast.LENGTH_SHORT).show();
    }

    public void ModificarLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "primero",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = edit1.getText().toString();



        ContentValues cont = new ContentValues();
        cont.put("codigo",edit1.getText().toString());
        cont.put("nombre",edit2.getText().toString());
        cont.put("precio",edit3.getText().toString());
        BaseDeDatos.update("libros", cont,"codigo"+codigo,null);



        if(!edit1.getText().toString().isEmpty()){
            BaseDeDatos.update("libros", cont,"codigo"+codigo,null);
            Toast.makeText(this,"libro modificado por el codigo  "+codigo ,Toast.LENGTH_SHORT).show();

        }
}
}

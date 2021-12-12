package com.example.ejercicio1pjr;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import  com.example.ejercicio1pjr.cositas.sqlite;

public class agregar extends AppCompatActivity {

    private EditText gmail,contraseña, idioma, edad, nombre;

    public void onCreate(Bundle b) {

        super.onCreate(b);

        setContentView(R.layout.activity_agregar);

        gmail = (EditText) findViewById(R.id.gmail);
        contraseña = (EditText) findViewById(R.id.pass);
        idioma = (EditText) findViewById(R.id.idioma);
        edad = (EditText) findViewById(R.id.edad);
        nombre=(EditText) findViewById(R.id.Nombre);

    }

    public void agregar(View v){

        String gm = gmail.getText().toString();
        String con = contraseña.getText().toString();
        String idi = idioma.getText().toString();
        int ed = Integer.parseInt(edad.getText().toString());
        String nom = nombre.getText().toString();


        sqlite bh = new sqlite(agregar.this, "usuarios", null,1);
        if(bh!=null){

            SQLiteDatabase db = bh.getWritableDatabase();
            ContentValues cona = new ContentValues();
            cona.put("gmail", gm);
            cona.put("contraseña", con);
            cona.put("idioma", idi);
            cona.put("edad", ed);
            cona.put("nombre", nom);
            long insertado = db.insert("usuarios", null, cona);
            if(insertado<0){

                Toast.makeText(agregar.this, "Exito", Toast.LENGTH_SHORT).show();
                gmail.setText("");
                contraseña.setText("");
                idioma.setText("");
                edad.setText("");
                nombre.setText("");

            }else {

                Toast.makeText(agregar.this, "ERROR", Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(agregar.this, "hay campos vacios", Toast.LENGTH_LONG).show();
        }
    }

    public boolean ComprobarCampos(){
        if(gmail.getText().toString().isEmpty()||contraseña.getText().toString().isEmpty()||
                idioma.getText().toString().isEmpty()||edad.getText().toString().isEmpty()
                ||nombre.getText().toString().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

}

package com.example.ejercicio1pjr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.ejercicio1pjr.cositas.Usuarios;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Usuarios> usuarios = new ArrayList<>();
    private ListView lista;
    private int usuariosSelecionado = -1;
    private Object mActionMode;
    private SharedPreferences cositas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.mostrar_activity);
        llenarLista();
        onClick();


        cositas = getSharedPreferences("Preferenes", Context.MODE_PRIVATE);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_añadir:
                añadir();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void añadir() {
        Intent intent = new Intent(this, agregar.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void onResume(){
        super.onResume();
        usuarios.removeAll(usuarios);
        llenarLista();
    }

    private void onClick() {
    }

    private void llenarLista() {
    }







}
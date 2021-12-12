package com.example.ejercicio1pjr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ejercicio1pjr.cositas.Usuarios;
import com.example.ejercicio1pjr.cositas.sqlite;

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
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setOnItemClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                usuariosSelecionado = position;
                mActionMode = MainActivity.this.startActionMode(amc);
                view.setSelected(true);
                return true;
            }
        });
    }

    private ActionMode.Callback amc = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.opciones, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
            if(item.getItemId() == R.id.EliminarItem){
                eliminarUsuario();
                mode.finish();
            }else if(item.getItemId() == R.id.EditarItem){
                Usuarios usu = usuarios.get(usuariosSelecionado);
                Intent in = new Intent(MainActivity.this,agregar.class);
                in.putExtra("gmail", usu.getGmail());
                startActivity(in);
                mode.finish();
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    }


    private void llenarLista() {

        sqlite zh = new sqlite(MainActivity.this, "usuarios", null,1);
        if(zh!=null){

            SQLiteDatabase db = zh.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT nombre,edad,idioma FROM usuarios", null);

            if(c.moveToFirst()){

                do{

                    usuarios.add(new Usuarios(c.getString(3),
                            c.getInt(2), c.getString(4)));

                }while(c.moveToNext());
            }
        }

        String[] arreglo = new String[usuarios.size()];
        for ( int i = 0; i<arreglo.length; i++){

            arreglo[i] = usuarios.get(i).getNombre();
            arreglo[i] = String.valueOf(usuarios.get(i).getEdad());
            arreglo[i] = usuarios.get(i).getIdioma();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, arreglo);
        lista.setAdapter(adapter);
    }

    private void eliminarUsuario() {

    }








}
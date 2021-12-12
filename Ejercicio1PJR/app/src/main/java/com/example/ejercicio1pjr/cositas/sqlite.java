package com.example.ejercicio1pjr.cositas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {

    public static final String URL_CONEXION = "jdbc:mysql://host:puerto/BD";
    public static final String USUARIO_BDD = "root";
    public static final String PASSWORD_BDD = "";

    public String usuarios = "CREATE TABLE usuarios(gmail TEXT PRIMARY KEY ,nombre TEXT," +
            "contraseña TEXT, edad INTEGER, idioma ENUM)";

    public sqlite(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context,nombre,factory,version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuarios);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

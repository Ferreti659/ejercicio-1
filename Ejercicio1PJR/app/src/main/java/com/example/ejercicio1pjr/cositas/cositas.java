package com.example.ejercicio1pjr.cositas;

import android.content.SharedPreferences;

public class cositas {

    public static String getUserUsercositas(SharedPreferences preferences) {

        return preferences.getString("Usurio", "");

    }

    public static String getUserPasscositas(SharedPreferences preferences) {

        return preferences.getString("pass", "");

    }

}

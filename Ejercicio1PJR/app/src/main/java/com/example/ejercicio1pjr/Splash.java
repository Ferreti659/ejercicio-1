package com.example.ejercicio1pjr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.ejercicio1pjr.cositas.cositas;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);

        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        Intent intentlogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);
        if(!TextUtils.isEmpty(com.example.ejercicio1pjr.cositas.cositas.getUserUsercositas(prefs))
                && !TextUtils.isEmpty(com.example.ejercicio1pjr.cositas.cositas.getUserPasscositas(prefs))){
            startActivity(intentMain);
        }else {
            startActivity(intentlogin);
        }
        finish();


    }
}

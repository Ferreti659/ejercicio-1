package com.example.ejercicio1pjr;

import android.app.Application;
import android.os.SystemClock;

public class App extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        SystemClock.sleep(3000);
    }

}

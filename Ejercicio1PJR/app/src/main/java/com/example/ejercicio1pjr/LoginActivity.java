package com.example.ejercicio1pjr;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;





public class LoginActivity extends AppCompatActivity {

    private SharedPreferences cositas;
    private TextView editTextUser;
    private TextView editTextPassword;
    private Button btnLogin;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindUI();
        cositas = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        setCredeantialsIfExists();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = editTextUser.getText().toString();
                String pass = editTextPassword.getText().toString();

                if (login(user, pass)) {

                    goToMain();
                    saveOnPreferences(user, pass);

                }

            }


        });

    }


    private void bindUI() {

        editTextUser = (TextView) findViewById(R.id.editTextUser);
        editTextPassword = (TextView) findViewById(R.id.editTextPassword);
        switch1 = (Switch) findViewById((R.id.switch1));
        btnLogin = (Button) findViewById(R.id.btnLogin);

    }

    private void setCredeantialsIfExists() {
        String user = com.example.ejercicio1pjr.cositas.cositas.getUserUsercositas(cositas);
        String pass = com.example.ejercicio1pjr.cositas.cositas.getUserPasscositas(cositas);
        if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
            editTextUser.setText(user);
            editTextPassword.setText(pass);
        }

    }

    private boolean login(String user, String pass) {

        if (!isValiduser(user)) {
            Toast.makeText(this, "usario no valido", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!isValidPassword(pass)) {
            Toast.makeText(this, "Contraseña incorrecta, 4 caracteres minimo", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


    private void saveOnPreferences(String user, String pass) {

        if(switch1.isChecked()){
            SharedPreferences.Editor editor = cositas.edit();
            editor.putString("user", user);
            editor.putString("pass", pass);
            editor.apply();
        }

    }

    private boolean isValiduser(String user) {

        return !TextUtils.isEmpty(user) && Patterns.DOMAIN_NAME.matcher(user).matches();


    }

    private boolean isValidPassword(String pass) {

        return pass.length() >= 4;

    }


    private void goToMain() {

        Intent intent  = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }


}

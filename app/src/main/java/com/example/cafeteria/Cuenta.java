package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cuenta extends AppCompatActivity {
    private TextView textView, textView2;
    private static ArrayList<String[]> credentialsList = new ArrayList<>();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuenta_refresh);

        Intent intent = getIntent();
        String mail = intent.getStringExtra("mail");
        String pass = intent.getStringExtra("pass");

        credentialsList.add(new String[]{mail, pass});

        textView = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);

        textView.setText(credentialsList.get(0)[0]);
        textView2.setText(credentialsList.get(0)[1]);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear un Intent para iniciar la nueva actividad
                Intent intent = new Intent(Cuenta.this, MainActivity.class);
                startActivity(intent);
                // Finalizar la actividad actual si no se desea regresar a ella
                finish();
            }
        }, 3000); // 3000 milisegundos = 3 segundos

        }

    public static boolean validateCredentials(String email, String password) {
        for (String[] credentials : credentialsList) {
            if (credentials[0].equals(email) && credentials[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String[]> getCredentialsList() {
        return credentialsList;
    }
}

package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearCuenta extends AppCompatActivity {

    private Button btnCrear, linkLogin;

    private EditText etMail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crearcuenta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            linkLogin = findViewById(R.id.btn3);

            linkLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent3);

                }
            });

            btnCrear = findViewById(R.id.btn4);
            etMail = findViewById(R.id.etmail2);
            etPass = findViewById(R.id.etpass2);


            btnCrear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email = etMail.getText().toString();
                    String pass = etPass.getText().toString();

                    Intent intent = new Intent(CrearCuenta.this, Cuenta.class);
                    intent.putExtra("mail", email);
                    intent.putExtra("pass", pass);
                    startActivity(intent);

                }
            });



            return insets;
        });
    }
}
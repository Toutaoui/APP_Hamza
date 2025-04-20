package com.example.quiz_hamza_toutaoui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Step 1: Declaration
    EditText etLogin, etPassword;
    Button bLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2: Recuperation des ids
        etLogin = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        bLogin = findViewById(R.id.bLogin);
        tvRegister = findViewById(R.id.tvRegister);

        // Step 3: Association de listeners
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération des identifiants sauvegardés
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String savedEmail = sharedPreferences.getString("email", null);
                String savedPassword = sharedPreferences.getString("password", null);

                String enteredEmail = etLogin.getText().toString();
                String enteredPassword = etPassword.getText().toString();

                // Vérification
                if (enteredEmail.equals(savedEmail) && enteredPassword.equals(savedPassword)) {
                    startActivity(new Intent(MainActivity.this, Quiz1.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Login or password incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
}

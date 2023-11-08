package com.example.tindercarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button btnSignUpRef = findViewById(R.id.btnSignUp);
        Button btnLoginRef = findViewById(R.id.btnLogin);

        btnSignUpRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLoginRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}

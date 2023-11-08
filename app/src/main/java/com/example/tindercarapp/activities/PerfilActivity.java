package com.example.tindercarapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tindercarapp.R;
import com.google.android.material.button.MaterialButton;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //referencia del boton para volver al home
        MaterialButton volverHomeBtn = findViewById(R.id.volverHome);
        volverHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

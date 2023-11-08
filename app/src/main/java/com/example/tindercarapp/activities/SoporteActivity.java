package com.example.tindercarapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tindercarapp.R;

public class SoporteActivity extends AppCompatActivity {

    private TextView mensajeInicial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soporte);


        //referencia al boton para volver al home
        ImageView volverHomeBtn = findViewById(R.id.volverHome);
        volverHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SoporteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //referencia al id del msj
        mensajeInicial = findViewById(R.id.mensajeInicial);
        mensajeInicial.setVisibility(View.INVISIBLE); //para que el msj este oculto

        //metodo para mostrar el msj despues de 1,3 segundos
        mensajeInicial.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMsjInicial();
            }
        }, 1300);
    }

    //funcion para hacer visible el msj inicial
    private void mostrarMsjInicial() {
        mensajeInicial.setVisibility(View.VISIBLE);
    }
}

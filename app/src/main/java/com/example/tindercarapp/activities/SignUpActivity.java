package com.example.tindercarapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tindercarapp.R;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        /*Button crearCuenta = findViewById(R.id.crearCuenta);
        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mostrarMensaje();
            }
        });*/

    }
    /*private void mostrarMensaje(){
        Toast.makeText(this, "Se creó la cuenta", Toast.LENGTH_LONG).show();
    }*/
}

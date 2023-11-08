package com.example.tindercarapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tindercarapp.R;
import com.google.android.material.button.MaterialButton;

public class PerfilActivity extends AppCompatActivity {

    private MaterialButton popUpEliminarCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //referencia boton eliminar cuenta
        popUpEliminarCuenta = findViewById(R.id.eliminarCuenta);

        popUpEliminarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmarEliminarCuenta = new AlertDialog.Builder(PerfilActivity.this);
                confirmarEliminarCuenta.setMessage("¿Estas seguro que deseas eliminar tu cuenta?")
                        .setCancelable(false)
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PerfilActivity.this, InicioActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog tituloPopUp = confirmarEliminarCuenta.create();
                tituloPopUp.setTitle("Eliminar cuenta");
                tituloPopUp.show();
            }
        });

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

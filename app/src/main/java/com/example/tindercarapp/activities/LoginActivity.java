package com.example.tindercarapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.example.tindercarapp.R;
import com.example.tindercarapp.controladores.DatabaseHelper;
import com.example.tindercarapp.helpers.ValidacionInputs;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity activity = LoginActivity.this;
    private NestedScrollView nestedScrollView;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutContrasenia;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextContrasenia;
    private AppCompatButton appCompatButtonIniciarSesion;
    private AppCompatTextView textViewRegistro;
    private ValidacionInputs validacionInputs;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        // Verifica si la barra de acción no es nula antes de intentar ocultarla
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        iniciarVistas();
        iniciarListeners();
        iniciarObjs();
    }

    //inicializa vistas
    private void iniciarVistas(){
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutContrasenia = (TextInputLayout) findViewById(R.id.textInputLayoutContrasenia);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextContrasenia = (TextInputEditText) findViewById(R.id.textInputEditTextContrasenia);
        appCompatButtonIniciarSesion = (AppCompatButton) findViewById(R.id.appCompatIniciarSesion);
        textViewRegistro = (AppCompatTextView) findViewById(R.id.textViewRegistro);
    }

    //inicializa listeners
    private void iniciarListeners(){
        appCompatButtonIniciarSesion.setOnClickListener(this);
        textViewRegistro.setOnClickListener(this);
    }

    //objectos a usar
    private void iniciarObjs(){
        databaseHelper = new DatabaseHelper(activity);
        validacionInputs = new ValidacionInputs(activity);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.appCompatIniciarSesion){
            verificacionSQLite();

        } else if (view.getId() == R.id.textViewRegistro) {
            // Navigate to RegisterActivity
            Intent intentRegistro = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intentRegistro);
        }
    }



    //valida campos y verificar credenciales de inicio de sesión de SQLite
    private void verificacionSQLite(){

        if (!validacionInputs.iptCompletado(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))){
            return;
        }
        if (!validacionInputs.iptEmailValido(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))){
            return;
        }

        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim(), textInputEditTextContrasenia.getText().toString().trim())){
            Intent cuentaIntent = new Intent(activity, ListaUsuariosActivity.class);
            cuentaIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
            vaciarCampos();
            startActivity(cuentaIntent);

         }
        else {
            // agregar string para msj error
            Snackbar.make(nestedScrollView, getString(R.string.error_validacion_email_contrasenia), Snackbar.LENGTH_LONG).show();
        }
    }

    //formateo de campos
    private void vaciarCampos(){
        textInputEditTextEmail.setText(null);
        textInputEditTextContrasenia.setText(null);
    }

}

package com.example.tindercarapp.helpers;

import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ValidacionInputs {
    private Context context;
    public ValidacionInputs(Context context){
        this.context = context;
    }

    //metodo para comprobar que el campo de email este completo
    public boolean iptCompletado(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String msj){
        String valor = textInputEditText.getText().toString().trim();
        if (valor.isEmpty()){
            textInputLayout.setError(msj);
            ocultarTeclado(textInputEditText);
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    //metodo para comprobar email valido
    public boolean iptEmailValido(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String msj){
        String valor = textInputEditText.getText().toString().trim();

        if (valor.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(valor).matches()){
            textInputLayout.setError(msj);
            ocultarTeclado(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

        public boolean iptEmailMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String msj){
            String valor1 = textInputEditText1.getText().toString().trim();
            String valor2 = textInputEditText2.getText().toString().trim();

            if (!valor1.contentEquals(valor2)){
                textInputLayout.setError(msj);
                ocultarTeclado(textInputEditText2);
                return false;
            }
            return true;
        }

    public void ocultarTeclado(View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

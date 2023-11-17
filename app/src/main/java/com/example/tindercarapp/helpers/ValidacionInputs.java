package com.example.tindercarapp.helpers;

import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class ValidacionInputs {
    private Context context;
    public ValidacionInputs(Context context){
        this.context = context;
    }

    //metodo para comprobar que el campo de email este completo
    public boolean iptCompletado(EditText email, String msj){
        String valor = email.getText().toString().trim();
        if (valor.isEmpty()){
            email.setError(msj);
            ocultarTeclado(email);
        } else {
            email.setError(msj);
        }
        return true;
    }

    //metodo para comprobar email valido
    public boolean iptEmailValido(EditText email, String msj){
        String valor = email.getText().toString().trim();

        if (valor.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(valor).matches()){
            email.setError(msj);
            ocultarTeclado(email);
            return false;
        } else {
            email.setError(msj);
        }
        return true;
    }

        public boolean iptEmailMatches(EditText editText1, EditText editText2, String msj){
            String valor1 = editText1.getText().toString().trim();
            String valor2 = editText2.getText().toString().trim();

            if (!valor1.contentEquals(valor2)){
                editText1.setError(msj);
                ocultarTeclado(editText2);
                return false;
            }
            return true;
        }


    public void ocultarTeclado(View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

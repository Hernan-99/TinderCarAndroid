package com.example.tindercarapp.controladores;

import com.example.tindercarapp.modelos.Cochera;
import java.util.List;

public interface iCocheras {
    Cochera elemento(int id); //devuelve el elemento dado su id
    Cochera elemento(String nombreCochera); //devuelve el elemento con su nombre

    List<Cochera> lista(); //devuelve una lista de todos los elementos registrados

    void agregar(Cochera cochera); //añade el elemento indicado
    void actualizar(int id, Cochera cochera); // actualiza datos del elemento dado su id

    void borrar(int id); //Elimina el elemento indicado con su id

}

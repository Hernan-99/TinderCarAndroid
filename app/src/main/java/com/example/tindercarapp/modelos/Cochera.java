package com.example.tindercarapp.modelos;

import android.media.Image;

public class Cochera {
    //atributos clase cochera
    private int id;
    private String nombreCochera;
    private Image imagen;
    private String descripcion;

    public Cochera(){

    }

    //Constructor con argumentos
    public Cochera(int id, String nombreCochera, Image imagen, String descripcion) {
        this.id = id;
        this.nombreCochera = nombreCochera;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCochera() {
        return nombreCochera;
    }

    public void setNombreCochera(String nombreCochera) {
        this.nombreCochera = nombreCochera;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Cochera{" +
                "id=" + id +
                ", nombreCochera='" + nombreCochera + '\'' +
                ", imagen=" + imagen +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}//fin cochera

package com.example.tindercarapp.domain;

public class CocheraDomain {

    private String imgCochera;
    private String tituloCochera;
    private String descripcionCochera;

    public CocheraDomain(String imgCochera, String tituloCochera, String descripcionCochera) {
        this.imgCochera = imgCochera;
        this.tituloCochera = tituloCochera;
        this.descripcionCochera = descripcionCochera;
    }


    public String getImgCochera() {
        return imgCochera;
    }

    public void setImgCochera(String imgCochera) {
        this.imgCochera = imgCochera;
    }

    public String getTituloCochera() {
        return tituloCochera;
    }

    public void setTituloCochera(String tituloCochera) {
        this.tituloCochera = tituloCochera;
    }

    public String getDescripcionCochera() {
        return descripcionCochera;
    }

    public void setDescripcionCochera(String descripcionCochera) {
        this.descripcionCochera = descripcionCochera;
    }
}

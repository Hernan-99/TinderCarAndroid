package com.example.tindercarapp.domain;

public class VehiculoDomain {
    private String tipoVehiculo;
    private String iconoVehiculo;

    public VehiculoDomain(String tipoVehiculo, String iconoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        this.iconoVehiculo = iconoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getIconoVehiculo() {
        return iconoVehiculo;
    }

    public void setIconoVehiculo(String iconoVehiculo) {
        this.iconoVehiculo = iconoVehiculo;
    }
}

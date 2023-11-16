package com.example.tindercarapp.modelos;

public class Usuario {

    private int id_usuario;
    private String nombre_usuario;
    private String contrasenia_usuario;
    private String confirmar_contrasenia;
    private String apellido_usuario;
    private String correo_usuario;
    private int telefono_usuario;

    public Usuario(int id_usuario, String nombre_usuario, String contrasenia_usuario,
                   String apellido_usuario, String correo_usuario, int telefono_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia_usuario = contrasenia_usuario;
        this.apellido_usuario = apellido_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia_usuario() {
        return contrasenia_usuario;
    }

    public void setContrasenia_usuario(String contrasenia_usuario) {
        this.contrasenia_usuario = contrasenia_usuario;
    }

    public String getConfirmar_contrasenia() {
        return confirmar_contrasenia;
    }

    public void setConfirmar_contrasenia(String confirmar_contrasenia) {
        this.confirmar_contrasenia = confirmar_contrasenia;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public int getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(int telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }
}

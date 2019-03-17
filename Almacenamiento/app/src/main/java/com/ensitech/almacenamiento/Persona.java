package com.ensitech.almacenamiento;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String correo;

    public Persona() {
        nombre = "";
        apellido = "";
        edad = 0;
        genero = "";
        correo = "";
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    public Persona(String nombre, String apellido, int edad, String genero, String correo) {
            this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

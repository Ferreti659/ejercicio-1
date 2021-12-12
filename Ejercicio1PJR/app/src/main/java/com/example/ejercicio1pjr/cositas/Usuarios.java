package com.example.ejercicio1pjr.cositas;

public class Usuarios {

    private String gmail;
    private int edad;
    private String nombre;
    private String contraseña;
    private String idioma;

    public Usuarios (String gmail, String nombre, int edad, String contraseña, String idioma){
        setContraseña(contraseña);
        setGmail(gmail);
        setIdioma(idioma);
        setNombre(nombre);
        setEdad(edad);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}

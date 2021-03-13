package com.miempresa.entidades;

public class Aviso {
  private String nombre;
  private String correo;
  private String pelicula;
  private String fechaEstreno;
  
  public Aviso() { 
    
  }

  public Aviso(String nombre, String correo, String pelicula, String fechaEstreno) {
    this.nombre = nombre;
    this.correo = correo;
    this.pelicula = pelicula;
    this.fechaEstreno = fechaEstreno;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getPelicula() {
    return pelicula;
  }

  public void setPelicula(String pelicula) {
    this.pelicula = pelicula;
  }

  public String getFechaEstreno() {
    return fechaEstreno;
  }

  public void setFechaEstreno(String fechaEstreno) {
    this.fechaEstreno = fechaEstreno;
  }
  
  
}

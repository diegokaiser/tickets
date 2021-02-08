package com.miempresa.entidades;

public class Cine {

  private Integer idCine;
  private String nombre;
  private String direccion;
  private String logo;
  private Integer estado;
  private String fechaRegistro;
  private Integer idDistrito;

  public Cine() {

  }

  public Cine(Integer idCine) {
    this.idCine = idCine;
  }

  public Cine(String nombre, String direccion, String logo, Integer estado, String fechaRegistro, Integer idDistrito) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.logo = logo;
    this.estado = estado;
    this.fechaRegistro = fechaRegistro;
    this.idDistrito = idDistrito;
  }

  public Cine(Integer idCine, String nombre, String direccion, String logo, Integer estado, String fechaRegistro, Integer idDistrito) {
    this.idCine = idCine;
    this.nombre = nombre;
    this.direccion = direccion;
    this.logo = logo;
    this.estado = estado;
    this.fechaRegistro = fechaRegistro;
    this.idDistrito = idDistrito;
  }

  public Integer getIdCine() {
    return idCine;
  }

  public void setIdCine(Integer idCine) {
    this.idCine = idCine;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

  public String getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(String fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  public Integer getIdDistrito() {
    return idDistrito;
  }

  public void setIdDistrito(Integer idDistrito) {
    this.idDistrito = idDistrito;
  }
  
  
}

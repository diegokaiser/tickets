package com.miempresa.entidades;

public class Entrada {

  private Integer idEntrada;
  private String precio;
  private String tipo;
  private Integer estado;
  private Integer idSala;
  private Integer idPelicula;
  private Integer stock;
  private String fechaRegistro;

  public Entrada() {

  }

  public Entrada(Integer idEntrada) {
    this.idEntrada = idEntrada;
  }

  public Entrada(String precio, String tipo, Integer estado, Integer idSala, Integer idPelicula, Integer stock, String fechaRegistro) {
    this.precio = precio;
    this.tipo = tipo;
    this.estado = estado;
    this.idSala = idSala;
    this.idPelicula = idPelicula;
    this.stock = stock;
    this.fechaRegistro = fechaRegistro;
  }
  
  

  public Entrada(Integer idEntrada, String precio, String tipo, Integer estado, Integer idSala, Integer idPelicula, Integer stock, String fechaRegistro) {
    this.idEntrada = idEntrada;
    this.precio = precio;
    this.tipo = tipo;
    this.estado = estado;
    this.idSala = idSala;
    this.idPelicula = idPelicula;
    this.stock = stock;
    this.fechaRegistro = fechaRegistro;
  }

  public Integer getIdEntrada() {
    return idEntrada;
  }

  public void setIdEntrada(Integer idEntrada) {
    this.idEntrada = idEntrada;
  }

  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

  public Integer getIdSala() {
    return idSala;
  }

  public void setIdSala(Integer idSala) {
    this.idSala = idSala;
  }

  public Integer getIdPelicula() {
    return idPelicula;
  }

  public void setIdPelicula(Integer idPelicula) {
    this.idPelicula = idPelicula;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public String getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(String fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }
  
  
}

package com.miempresa.entidades;

public class Entrada {

    public static String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  private Integer idEntrada;
  private double precio;
  private String tipo;
  private Integer estado;
  private Integer idSala;
  private Integer idPelicula;
  private Integer stock;
  private String fechaRegistro;
  //Datos extras
  private String nombrePelicula;
  private String fechaEstreno;
  private Integer numeroSala;
  private String nombreCine;

  public Entrada() {

  }

  public Entrada(Integer idEntrada) {
    this.idEntrada = idEntrada;
  }

  public Entrada(Double precio, String tipo, Integer estado, Integer idSala, Integer idPelicula, Integer stock, String fechaRegistro) {
    this.precio = precio;
    this.tipo = tipo;
    this.estado = estado;
    this.idSala = idSala;
    this.idPelicula = idPelicula;
    this.stock = stock;
    this.fechaRegistro = fechaRegistro;
  }
  public Entrada(Integer idEntrada, Double precio, String tipo, Integer estado, Integer idSala, Integer idPelicula, Integer stock, String fechaRegistro) {
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

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
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

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }
  
  
}

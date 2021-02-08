package com.miempresa.entidades;

public class Sala {

  private Integer idSala;
  private Integer numero;
  private Integer idCine;
  private Integer capacidad;
  private String tipoSala;
  private Integer estado;
  private String fechaRegistro;

  public Sala() {

  }

  public Sala(Integer idSala) {
    this.idSala = idSala;
  }

  public Sala(Integer idSala, Integer numero, Integer idCine, Integer capacidad, String tipoSala, Integer estado) {
    this.idSala = idSala;
    this.numero = numero;
    this.idCine = idCine;
    this.capacidad = capacidad;
    this.tipoSala = tipoSala;
    this.estado = estado;
  }

  public Sala(Integer idSala, Integer numero, Integer idCine, Integer capacidad, String tipoSala, Integer estado, String fechaRegistro) {
    this.idSala = idSala;
    this.numero = numero;
    this.idCine = idCine;
    this.capacidad = capacidad;
    this.tipoSala = tipoSala;
    this.estado = estado;
    this.fechaRegistro = fechaRegistro;
  }

  public Integer getIdSala() {
    return idSala;
  }

  public void setIdSala(Integer idSala) {
    this.idSala = idSala;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Integer getIdCine() {
    return idCine;
  }

  public void setIdCine(Integer idCine) {
    this.idCine = idCine;
  }

  public Integer getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(Integer capacidad) {
    this.capacidad = capacidad;
  }

  public String getTipoSala() {
    return tipoSala;
  }

  public void setTipoSala(String tipoSala) {
    this.tipoSala = tipoSala;
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
}

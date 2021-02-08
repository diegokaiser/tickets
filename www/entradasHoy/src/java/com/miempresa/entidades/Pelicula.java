package com.miempresa.entidades;

public class Pelicula {
  
  private Integer idPelicula;
  private String nombre;
  private String duracion;
  private String fechaEstreno;
  private String idioma;
  private String pais;
  private Integer subtitulos;
  private Integer doblada;
  private String portada;
  private String descripcion;
  private String genero;
  private Integer estado;
  
  public Pelicula() {
  
  }

  public Pelicula(Integer idPelicula) {
    this.idPelicula = idPelicula;
  }

  public Pelicula(String nombre, String duracion, String fechaEstreno, String idioma, String pais, Integer subtitulos, Integer doblada, String portada, String genero, Integer estado) {
    this.nombre = nombre;
    this.duracion = duracion;
    this.fechaEstreno = fechaEstreno;
    this.idioma = idioma;
    this.pais = pais;
    this.subtitulos = subtitulos;
    this.doblada = doblada;
    this.portada = portada;
    this.genero = genero;
    this.estado = estado;
  }

  public Pelicula(Integer idPelicula, String nombre, String duracion, String fechaEstreno, String idioma, String pais, Integer subtitulos, Integer doblada, String portada, String descripcion, String genero, Integer estado) {
    this.idPelicula = idPelicula;
    this.nombre = nombre;
    this.duracion = duracion;
    this.fechaEstreno = fechaEstreno;
    this.idioma = idioma;
    this.pais = pais;
    this.subtitulos = subtitulos;
    this.doblada = doblada;
    this.portada = portada;
    this.descripcion = descripcion;
    this.genero = genero;
    this.estado = estado;
  }

  public Integer getIdPelicula() {
    return idPelicula;
  }

  public void setIdPelicula(Integer idPelicula) {
    this.idPelicula = idPelicula;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDuracion() {
    return duracion;
  }

  public void setDuracion(String duracion) {
    this.duracion = duracion;
  }

  public String getFechaEstreno() {
    return fechaEstreno;
  }

  public void setFechaEstreno(String fechaEstreno) {
    this.fechaEstreno = fechaEstreno;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public Integer getSubtitulos() {
    return subtitulos;
  }

  public void setSubtitulos(Integer subtitulos) {
    this.subtitulos = subtitulos;
  }

  public Integer getDoblada() {
    return doblada;
  }

  public void setDoblada(Integer doblada) {
    this.doblada = doblada;
  }

  public String getPortada() {
    return portada;
  }

  public void setPortada(String portada) {
    this.portada = portada;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }
}

package com.miempresa.entidades;

public class Usuario {

  private Integer idUsuario;
  private String nombre;
  private String apellido;
  private String correo;
  private String contrasena;
  private String tipoDocumento;
  private String numeroDocumento;
  private Integer idTipoUsuario;
  private Integer estado;

  public Usuario() {

  }

  public Usuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Usuario(String nombre, String apellido, String correo, String contrasena, String tipoDocumento, String numeroDocumento, Integer idTipoUsuario, Integer estado) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.contrasena = contrasena;
    this.tipoDocumento = tipoDocumento;
    this.numeroDocumento = numeroDocumento;
    this.idTipoUsuario = idTipoUsuario;
    this.estado = estado;
  }

  public Usuario(Integer idUsuario, String nombre, String apellido, String correo, String contrasena, String tipoDocumento, String numeroDocumento, Integer idTipoUsuario, Integer estado) {
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.contrasena = contrasena;
    this.tipoDocumento = tipoDocumento;
    this.numeroDocumento = numeroDocumento;
    this.idTipoUsuario = idTipoUsuario;
    this.estado = estado;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
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

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  public Integer getIdTipoUsuario() {
    return idTipoUsuario;
  }

  public void setIdTipoUsuario(Integer idTipoUsuario) {
    this.idTipoUsuario = idTipoUsuario;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

  public void setEstado(String estado) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}

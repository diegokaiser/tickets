/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Pelicula;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class PeliculaDAO implements IServicePelicula {

  private static ConnectionDB con;
  private static PreparedStatement pstm;
  private static CallableStatement cstm;
  private static ResultSet res;

  public PeliculaDAO() {
    con = ConnectionDB.getInstance();
  }

  @Override
  public Boolean insertar(Pelicula t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Boolean actualizar(Pelicula t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Pelicula seleccionPorId(Object idUsuario) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Pelicula> seleccionarTodo() {
    List<Pelicula> peliculas = new ArrayList<>();
    final String SQL_SELECT = "{call usp_listarPeliculas()}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECT);
      res = cstm.executeQuery();
      while (res.next()) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(res.getInt(1));
        pelicula.setNombre(res.getString(2));
        pelicula.setDuracion(res.getString(3));
        pelicula.setFechaEstreno(res.getString(4));
        pelicula.setIdioma(res.getString(5));
        pelicula.setPais(res.getString(6));
        pelicula.setSubtitulos(res.getInt(7));
        pelicula.setDoblada(res.getInt(8));
        pelicula.setPortada(res.getString(9));
        pelicula.setDescripcion(res.getString(10));
        pelicula.setGenero(res.getString(12));
        pelicula.setEstado(res.getInt(13));
        peliculas.add(pelicula);
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar listado de películas");
      e.printStackTrace();
    } finally {
      close();
    }
    return peliculas;
  }
  
  @Override
  public List<Pelicula> seleccionarUltimos() {
    List<Pelicula> peliculas = new ArrayList<>();
    final String SQL_SELECT = "{call usp_listarPeliculas()}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECT);
      res = cstm.executeQuery();
      while (res.next()) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(res.getInt(1));
        pelicula.setNombre(res.getString(2));
        pelicula.setDuracion(res.getString(3));
        pelicula.setFechaEstreno(res.getString(4));
        pelicula.setIdioma(res.getString(5));
        pelicula.setPais(res.getString(6));
        pelicula.setSubtitulos(res.getInt(7));
        pelicula.setDoblada(res.getInt(8));
        pelicula.setPortada(res.getString(9));
        pelicula.setDescripcion(res.getString(10));
        pelicula.setGenero(res.getString(12));
        pelicula.setEstado(res.getInt(13));
        peliculas.add(pelicula);
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar listado de películas");
      e.printStackTrace();
    } finally {
      close();
    }
    return peliculas;
  }

  @Override
  public List<Pelicula> seleccionarEstrenos() {
    List<Pelicula> peliculas = new ArrayList<>();
    final String SQL_SELECT = "{call usp_listarPeliculas()}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECT);
      res = cstm.executeQuery();
      while (res.next()) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(res.getInt(1));
        pelicula.setNombre(res.getString(2));
        pelicula.setDuracion(res.getString(3));
        pelicula.setFechaEstreno(res.getString(4));
        pelicula.setIdioma(res.getString(5));
        pelicula.setPais(res.getString(6));
        pelicula.setSubtitulos(res.getInt(7));
        pelicula.setDoblada(res.getInt(8));
        pelicula.setPortada(res.getString(9));
        pelicula.setDescripcion(res.getString(10));
        pelicula.setGenero(res.getString(12));
        pelicula.setEstado(res.getInt(13));
        peliculas.add(pelicula);
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar listado de películas");
      e.printStackTrace();
    } finally {
      close();
    }
    return peliculas;
  }

  @Override
  public List<Pelicula> seleccionarRecomendados() {
    List<Pelicula> peliculas = new ArrayList<>();
    final String SQL_SELECT = "{call usp_listarPeliculas()}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECT);
      res = cstm.executeQuery();
      while (res.next()) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(res.getInt(1));
        pelicula.setNombre(res.getString(2));
        pelicula.setDuracion(res.getString(3));
        pelicula.setFechaEstreno(res.getString(4));
        pelicula.setIdioma(res.getString(5));
        pelicula.setPais(res.getString(6));
        pelicula.setSubtitulos(res.getInt(7));
        pelicula.setDoblada(res.getInt(8));
        pelicula.setPortada(res.getString(9));
        pelicula.setDescripcion(res.getString(10));
        pelicula.setGenero(res.getString(12));
        pelicula.setEstado(res.getInt(13));
        peliculas.add(pelicula);
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar listado de películas");
      e.printStackTrace();
    } finally {
      close();
    }
    return peliculas;
  }

  @Override
  public Boolean eliminar(Pelicula t
  ) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void close() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}

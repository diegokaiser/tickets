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
      } catch (Exception e) {
        System.out.println("Error al recuperar listado de películas");
        e.printStackTrace();
      } finally {
        close();
      }
      return peliculas;
    }

    @Override
    public Boolean eliminar
    (Pelicula t
    
      ) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close
    
      () {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  }

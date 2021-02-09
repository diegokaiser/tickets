package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Pelicula;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
  public Pelicula seleccionPorId(int idPelicula) {
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
        pelicula.setNombre(res.getString("nombre"));
        pelicula.setDuracion(res.getString("duracion"));
        pelicula.setFechaEstreno(res.getString("fechaEstreno"));
        pelicula.setIdioma(res.getString("idioma"));
        pelicula.setPais(res.getString("pais"));
        //pelicula.setSubtitulos(res.getInt("subtitlos"));
        pelicula.setDoblada(res.getInt("doblada"));
        pelicula.setPortada(res.getString("portada"));
        pelicula.setDescripcion(res.getString("descripcion"));
        pelicula.setGenero(res.getString("genero"));
        pelicula.setEstado(res.getInt("estado"));
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
        pelicula.setNombre(res.getString("nombre"));
        pelicula.setDuracion(res.getString("duracion"));
        pelicula.setFechaEstreno(res.getString("fechaEstreno"));
        pelicula.setIdioma(res.getString("idioma"));
        pelicula.setPais(res.getString("pais"));
        pelicula.setSubtitulos(res.getInt("subtitlos"));
        pelicula.setDoblada(res.getInt("doblada"));
        pelicula.setPortada(res.getString("portada"));
        pelicula.setDescripcion(res.getString("descripcion"));
        pelicula.setGenero(res.getString("genero"));
        pelicula.setEstado(res.getInt("estado"));
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
        pelicula.setNombre(res.getString("nombre"));
        pelicula.setDuracion(res.getString("duracion"));
        pelicula.setFechaEstreno(res.getString("fechaEstreno"));
        pelicula.setIdioma(res.getString("idioma"));
        pelicula.setPais(res.getString("pais"));
        pelicula.setSubtitulos(res.getInt("subtitlos"));
        pelicula.setDoblada(res.getInt("doblada"));
        pelicula.setPortada(res.getString("portada"));
        pelicula.setDescripcion(res.getString("descripcion"));
        pelicula.setGenero(res.getString("genero"));
        pelicula.setEstado(res.getInt("estado"));
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
        pelicula.setNombre(res.getString("nombre"));
        pelicula.setDuracion(res.getString("duracion"));
        pelicula.setFechaEstreno(res.getString("fechaEstreno"));
        pelicula.setIdioma(res.getString("idioma"));
        pelicula.setPais(res.getString("pais"));
        pelicula.setSubtitulos(res.getInt("subtitulos"));
        pelicula.setDoblada(res.getInt("doblada"));
        pelicula.setPortada(res.getString("portada"));
        pelicula.setDescripcion(res.getString("descripcion"));
        pelicula.setGenero(res.getString("genero"));
        pelicula.setEstado(res.getInt("estado"));
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
  public Boolean eliminar(Pelicula t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void close() {
    try {
      if (res != null) {
        res.close();
      }
      if (cstm != null) {
        cstm.close();
      }
      if (con != null) {
        con.close();
      }

    } catch (Exception e) {
      System.out.println("Error al cerrar conexion :" + e.getMessage());
    }
  }

}

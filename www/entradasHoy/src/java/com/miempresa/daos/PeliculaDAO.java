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
      Boolean resultFlag = false;
      final String SQL_INSERTAR = "{call usp_insertarPelicula(?,?,?,?,?,?,?,?,?,?,?)}";
      try {
          cstm = con.getConnection().prepareCall(SQL_INSERTAR);
          cstm.setString(1, t.getNombre());
          cstm.setString(2, t.getDuracion());
          cstm.setString(3, t.getFechaEstreno());
          cstm.setString(4, t.getIdioma());
          cstm.setString(5, t.getPais());  
          cstm.setInt(6, t.getSubtitulos());
          cstm.setInt(7, t.getDoblada());  
          cstm.setString(8, t.getPortada());
          cstm.setString(9, t.getDescripcion());  
          cstm.setString(10, t.getGenero());
          cstm.setInt(11, t.getEstado());            
          int result = cstm.executeUpdate();
          if (result > 0) {
              resultFlag = true;
          }
      } catch (Exception e) {
          System.out.println("Eror al insertar pelicula");
          e.printStackTrace();
      } finally {
          close();
      }
      return resultFlag;
  }
    
 @Override
  public Boolean actualizar(Pelicula pelicula) {
    Boolean resultFlag = false;
    final String SQL_UPDATE = "update pelicula set nombre=?, duracion=?, fechaEstreno=?, idioma=?, pais=?, subtitulos=?, doblada=?, portada=?, descripcion=?, genero=?, estado=? where idPelicula=?";
    try {
      pstm = con.getConnection().prepareStatement(SQL_UPDATE);
      pstm.setString(1, pelicula.getNombre());
      pstm.setString(2, pelicula.getDuracion());
      pstm.setString(3, pelicula.getFechaEstreno());
      pstm.setString(4, pelicula.getIdioma());
      pstm.setString(5, pelicula.getPais());
      //pstm.setInt(6, pelicula.getSubtitulos());
      pstm.setInt(7, pelicula.getDoblada());
      pstm.setString(8, pelicula.getPortada());
      pstm.setString(9, pelicula.getDescripcion());
      pstm.setString(10, pelicula.getGenero());
        System.out.println(pelicula.getNombre()+"update");
      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al actualizar la pelicula");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
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
        pelicula.setTrailer(res.getString("trailer"));
        pelicula.setRecomendada(res.getString("recomendada"));
        pelicula.setProtagonistas(res.getString("protagonistas"));
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
        //pelicula.setSubtitulos(res.getInt("subtitlos"));
        pelicula.setDoblada(res.getInt("doblada"));
        pelicula.setPortada(res.getString("portada"));
        pelicula.setDescripcion(res.getString("descripcion"));
        pelicula.setGenero(res.getString("genero"));
        pelicula.setTrailer(res.getString("trailer"));
        pelicula.setRecomendada(res.getString("recomendada"));
        pelicula.setProtagonistas(res.getString("protagonistas"));
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
    final String SQL_SELECT = "{call usp_listarPeliculasSinEstrenar()}";
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
        pelicula.setTrailer(res.getString("trailer"));
        pelicula.setRecomendada(res.getString("recomendada"));
        pelicula.setProtagonistas(res.getString("protagonistas"));
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
    final String SQL_SELECT = "{call usp_listarPeliculasRecomendadas()}";
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
        //pelicula.setSubtitulos(res.getInt("subtitulos"));
        pelicula.setDoblada(res.getInt("doblada"));
        pelicula.setPortada(res.getString("portada"));
        pelicula.setDescripcion(res.getString("descripcion"));
        pelicula.setGenero(res.getString("genero"));
        pelicula.setTrailer(res.getString("trailer"));
        pelicula.setRecomendada(res.getString("recomendada"));
        pelicula.setProtagonistas(res.getString("protagonistas"));
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
  public Boolean eliminar(Pelicula pelicula) {
    Boolean resultFlag = false;
    final String SQL_DELETE = "update pelicula set estado=0 where idPelicula=?";

    try {
      pstm = con.getConnection().prepareStatement(SQL_DELETE);
      pstm.setInt(1, pelicula.getIdPelicula());
      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar la pelicula");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }
  
    @Override
  public Pelicula seleccionPorId(int idPelicula) {
    Pelicula pelicula = new Pelicula();
    final String SQL_SELECT_BY_ID = "SELECT * FROM pelicula WHERE idPelicula=?";
    try {
      pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_ID);
      pstm.setInt(1,idPelicula );
      res = pstm.executeQuery();
      while (res.next()) {
        pelicula.setIdPelicula(res.getInt(1));
        pelicula.setNombre(res.getString(2));
        pelicula.setDuracion(res.getString(3));
        pelicula.setFechaEstreno(res.getString(4));
        pelicula.setIdioma(res.getString(5));
        pelicula.setPais(res.getString(6));
        //pelicula.setSubtitulos(res.getInt(7));
        pelicula.setDoblada(res.getInt(7));
        pelicula.setPortada(res.getString(8));
        pelicula.setDescripcion(res.getString(9));
        pelicula.setGenero(res.getString(10));
        pelicula.setEstado(res.getInt(11));
        pelicula.setTrailer(res.getString(15));
        pelicula.setProtagonistas(res.getString(19));
        pelicula.setPortadaDestacada(res.getString(20));
        /*
        System.out.println(res.getInt(1)+" ");
        System.out.println(res.getString(2));
        System.out.println(res.getString(3));
        System.out.println(res.getString(4));
        System.out.println(res.getString(5));
        System.out.println(res.getString(6));
        System.out.println(res.getString(7));
        System.out.println(res.getString(8));
        System.out.println(res.getString(9));
        System.out.println(res.getString(10));
        System.out.println(res.getString(11));
        System.out.println(res.getString(15));
        System.out.println(res.getString(19));
        */
      }
    } catch (Exception e) {
      System.out.println("Error al seleccionar la pelicula");
      e.printStackTrace();
    } finally {
      close();
    }
    return pelicula;
  }
  
  @Override
  public List<Pelicula> seleccionarDestacado() {
    List<Pelicula> peliculas = new ArrayList<>();
    final String SQL_SELECT = "{call usp_listarPeliculaDestacada()}";
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
        //pelicula.setSubtitulos(res.getInt("subtitulos"));
        pelicula.setDoblada(res.getInt("doblada"));
        pelicula.setDescripcion(res.getString("descripcion"));
        pelicula.setGenero(res.getString("genero"));
        pelicula.setEstado(res.getInt("estado"));
        pelicula.setPortada(res.getString("portada"));
        pelicula.setTrailer(res.getString("trailer"));
        pelicula.setRecomendada(res.getString("recomendada"));
        pelicula.setProtagonistas(res.getString("protagonistas"));        
        pelicula.setPortadaDestacada(res.getString("portadaDestacada"));
        peliculas.add(pelicula);
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar película destacada");
      e.printStackTrace();
    } finally {
      close();
    }
    return peliculas;
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

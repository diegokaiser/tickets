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
        pelicula.setGenero(res.getString("trailer"));
        pelicula.setGenero(res.getString("recomendada"));
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
        pelicula.setGenero(res.getString("trailer"));
        pelicula.setGenero(res.getString("recomendada"));
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
        pelicula.setGenero(res.getString("trailer"));
        pelicula.setGenero(res.getString("recomendada"));
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
        pelicula.setDoblada(res.getInt(8));
        pelicula.setPortada(res.getString(9));
        pelicula.setDescripcion(res.getString(10));
        pelicula.setGenero(res.getString(11));
        
          
        System.out.println(res.getInt(1)+" ");
        System.out.println(res.getString(2));
        System.out.println(res.getString(3));
        System.out.println(res.getString(4));
      }


    } catch (Exception e) {
      System.out.println("Error al eliminar la pelicula");
      e.printStackTrace();
    } finally {
      close();
    }
    return pelicula;
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

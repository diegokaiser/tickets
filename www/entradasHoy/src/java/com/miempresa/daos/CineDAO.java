package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Cine;
import com.miempresa.entidades.Distrito;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CineDAO implements IServiceCine {

  private static ConnectionDB con;
  private static PreparedStatement pstm;
  private static CallableStatement cstm;
  private static ResultSet res;

  public CineDAO() {
    con = ConnectionDB.getInstance();
  }

  @Override
  public Boolean insertar(Cine cine) {
    Boolean resultFlag = false;
    final String SQL_INSERT = "insert into cine (nombre, direccion, logo, estado, idDistrito) values (?,?,?,?,?)";
    try {
      pstm = con.getConnection().prepareStatement(SQL_INSERT);

      pstm.setString(1, cine.getNombre());
      pstm.setString(2, cine.getDireccion());
      pstm.setString(3, cine.getLogo());
      pstm.setInt(4, cine.getEstado());
      pstm.setInt(5, cine.getIdDistrito());

      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al insertar el cine");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  @Override
  public Boolean actualizar(Cine cine) {
    Boolean resultFlag = false;
    final String SQL_UPDATE = "update cine set nombre=?, direccion=?,logo=?, estado=? where idCine=?";
    try {
      pstm = con.getConnection().prepareStatement(SQL_UPDATE);
      pstm.setString(1, cine.getNombre());
      pstm.setString(2, cine.getDireccion());
      pstm.setString(3, cine.getLogo());
      pstm.setInt(4, cine.getEstado());
      pstm.setInt(5, cine.getIdCine());

      System.out.println(cine.getNombre() + "update");
      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al actualizar el cine");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  @Override
  public Cine seleccionPorId(int idCine) {
    Cine cine = new Cine();
    final String SQL_SELECT_BY_ID = "SELECT * FROM cine WHERE idCine=?";
    try {
      pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_ID);
      pstm.setInt(1, idCine);
      res = pstm.executeQuery();
      while (res.next()) {
        cine.setIdCine(res.getInt(1));
        cine.setNombre(res.getString(2));
        cine.setDireccion(res.getString(3));
        cine.setIdDistrito(res.getInt(7));
        cine.setLogo(res.getString(8));        
        cine.setEstado(res.getInt(9));
//        cine.setFechaRegistro(res.getString(6));
//        cine.setIdDistrito(res.getInt(7));
//        System.out.println(res.getInt(1)+" ");
//        System.out.println(res.getString(2));
//        System.out.println(res.getString(3));
//        System.out.println(res.getString(4));
      }

    } catch (Exception e) {
      System.out.println("Error al eliminar al cine");
      e.printStackTrace();
    } finally {
      close();
    }
    return cine;
  }

  @Override
  public List<Cine> seleccionarTodo() {
    List<Cine> cines = new ArrayList<>();
    final String SQL_SELECTALL = "{call usp_listarCines()}";

    try {
      cstm = con.getConnection().prepareCall(SQL_SELECTALL);
      res = cstm.executeQuery();
      while (res.next()) {
        Cine cine = new Cine();
        cine.setIdCine(res.getInt(1));
        cine.setNombre(res.getString(2));
        cine.setDireccion(res.getString(3));
        cine.setLogo(res.getString(4));
        cine.setEstado(res.getInt(5));
        cine.setDistrito(res.getString(6));
        cines.add(cine);
        //cine.setIdDistrito(res.getInt("idDistrito"));
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar el listado de cines");
      e.printStackTrace();
    } finally {
      close();
    }
    return cines;
  }

  @Override
  public Boolean eliminar(Cine cine) {
    Boolean resultFlag = false;
    final String SQL_DELETE = "update cine set estado=? where idCine=?";

    try {
      pstm = con.getConnection().prepareStatement(SQL_DELETE);
      pstm.setInt(1, cine.getEstado());
      pstm.setInt(2, cine.getIdCine());
      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar al cine");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
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

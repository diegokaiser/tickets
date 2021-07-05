package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Distrito;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DistritoDAO implements IServiceDistrito {

  private static ConnectionDB con;
  private static PreparedStatement pstm;
  private static CallableStatement cstm;
  private static ResultSet res;

  public DistritoDAO() {
    con = ConnectionDB.getInstance();
  }

  @Override
  public Distrito seleccionPorId(int idDistrito) {
    Distrito distrito = new Distrito();
    final String SQL_SELECT_BY_ID = "SELECT * FROM distrito WHERE idDistrito=?";
    try {
      pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_ID);
      pstm.setInt(1, idDistrito);
      res = pstm.executeQuery();
      while(res.next()) {
        distrito.setIdDistrito(res.getInt(1));
        distrito.setNombre(res.getString(2));
        System.out.println("ID: " + res.getInt(1)+ " Distrito: "+ res.getString(2));
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar al usuario");
      e.printStackTrace();
    } finally {
      close();
    }
    return distrito;
  }

  @Override
  public Boolean insertar(Distrito t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Boolean actualizar(Distrito t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Distrito> seleccionarTodo() {
    List<Distrito> distritos = new ArrayList<>();
    final String SQL_SELECTALL = "{call usp_listarDistritos()}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECTALL);
      res = cstm.executeQuery();
      while (res.next()) {
        Distrito distrito = new Distrito();
        distrito.setIdDistrito(res.getInt(1));
        distrito.setNombre(res.getString("nombre"));
        distritos.add(distrito);
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar el listado de distritos");
      e.printStackTrace();
    } finally {
      close();
    }
    return distritos;
  }

  @Override
  public Boolean eliminar(Distrito t) {
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

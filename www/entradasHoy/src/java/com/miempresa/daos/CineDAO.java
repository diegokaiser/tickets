package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Cine;
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
  public Boolean insertar(Cine t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Boolean actualizar(Cine t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Cine seleccionPorId(Object idUsuario) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        cine.setNombre(res.getString("nombre"));
        cine.setDireccion(res.getString("direccion"));
        cine.setLogo(res.getString("logo"));
        cine.setEstado(res.getInt("estado"));
        cine.setIdDistrito(res.getInt("idDistrito"));
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
  public Boolean eliminar(Cine t) {
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

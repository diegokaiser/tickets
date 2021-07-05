/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Compra;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JosueFlores
 */
public class CompraDAO implements IserviceCompra {

  private static ConnectionDB con;
  private static PreparedStatement pstm;
  private static CallableStatement cstm;
  private static ResultSet res;

  public CompraDAO() {
    con = ConnectionDB.getInstance();
  }

  @Override
  public Boolean insertar(Compra t) {
 
    Boolean resultFlag = false;
    final String SQL_INSERT = "{call usp_insertarCompra(?,?,?,?)}";
    try {
        
     cstm = con.getConnection().prepareCall(SQL_INSERT);
     
      cstm.setInt(1, t.getIdUsuario());
      cstm.setInt(2, t.getIdEntrada());
      cstm.setInt(3, t.getNumeroEntradas());
      cstm.setInt(4, t.getEstado());


      int result = cstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al comprar entrada");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;    
   }
  

  @Override
  public Boolean actualizar(Compra t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Compra> seleccionarTodo() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Boolean eliminar(Compra t) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public List<Compra> dropListCine(int idPelicula) {
    List<Compra> compras = new ArrayList<>();
    final String SQL_SELECTALL = "{call usp_listarCinesPorPelicula(?)}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECTALL);
      cstm.setInt(1, idPelicula);
      res = cstm.executeQuery();

      while (res.next()) {
        Compra compra = new Compra();
        compra.setNombreCine(res.getString(1));
        compra.setIdCine(res.getInt(2));
        compras.add(compra);
        System.out.println("DATA FROM: CompraDAO - dropListCine");
        System.out.println("Nombre: "+res.getString(1));
        System.out.println("ID: "+res.getInt(2));
        System.out.println("========================================================================================");
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar el listado de alimentacion del drop list");
      e.printStackTrace();
    } finally {
      close();
    }
    return compras;
  }

  public List<Compra> dropListSala(int idCine) {
    List<Compra> compras = new ArrayList<>();
    final String SQL_SELECTALL = "{call usp_listarCinesPorPelicula2(?)}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECTALL);
      cstm.setInt(1, idCine);
      res = cstm.executeQuery();

      while (res.next()) {
        Compra compra = new Compra();
        compra.setNumeroSala(res.getInt(1));
        compras.add(compra);
        System.out.println("DATA FROM: CompraDAO - dropListSala");
        System.out.println("ID: "+res.getInt(1));
        System.out.println("========================================================================================");
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar el listado de alimentacion del drop list");
      e.printStackTrace();
    } finally {
      close();
    }
    return compras;
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

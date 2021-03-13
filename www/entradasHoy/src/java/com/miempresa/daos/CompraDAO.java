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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        compras.add(compra);
        System.out.println("DATA FROM :CompraDAO - dropListCine");
        System.out.println("Nombre: "+res.getString(1));
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

  public List<Compra> dropListSala(String nombreCine) {
    List<Compra> compras = new ArrayList<>();
    final String SQL_SELECTALL = "{call usp_listarCinesPorPelicula2(?)}";

    try {
      cstm = con.getConnection().prepareCall(SQL_SELECTALL);
      cstm.setString(1, nombreCine);
      res = cstm.executeQuery();

      while (res.next()) {
        Compra compra = new Compra();
        compra.setIdEntrada(res.getInt(1));
        compra.setPrecio(res.getDouble(2));
        compra.setTipo(res.getString(3));
        compra.setNombreCine(res.getString(4));
        compra.setDireccion(res.getString(5));
        compra.setNumeroSala(res.getInt(6));
        compra.setNombrePelicula(res.getString(7));
        compra.setIdCine(res.getInt(8));
        compras.add(compra);
        System.out.println("DATA FROM :dropListSala");
        System.out.println("ID: "+res.getInt(1));
        System.out.println("Precio: "+res.getDouble(2));
        System.out.println("Tipo: "+res.getString(3));
        System.out.println("Nombre Cine: "+res.getString(4));
        System.out.println("Direcicón: "+res.getString(5));
        System.out.println("Nro Sala: "+res.getInt(6));
        System.out.println("Película: "+res.getString(7));
        System.out.println("IdCine: "+res.getInt(8));
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

}

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
public class CompraDAO implements IserviceCompra{
  
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
    }    }
    
    public List<Compra> llenarDropList(int idPelicula) {
        List<Compra> compras = new ArrayList<>();
        final String SQL_SELECTALL ="{call usp_listarCinesPorPelicula(?)}";

        try {
            cstm = con.getConnection().prepareCall(SQL_SELECTALL);
            cstm.setInt(1, idPelicula);
            res = cstm.executeQuery();
            
            while (res.next()) {
                Compra compra = new Compra();
                compra.setNombreCine(res.getString(1));
                compras.add(compra);
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

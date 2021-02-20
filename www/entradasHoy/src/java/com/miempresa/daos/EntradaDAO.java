/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Entrada;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JosueFlores
 */
public class EntradaDAO implements IserviceEntrada{
  private static ConnectionDB con;
  private static PreparedStatement pstm;
  private static CallableStatement cstm;
  private static ResultSet res;

  public EntradaDAO() {
    con = ConnectionDB.getInstance();
  }
    @Override
    public Entrada seleccionPorId(int idEntrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean insertar(Entrada t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean actualizar(Entrada t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entrada> seleccionarTodo() {
        List<Entrada> entradas = new ArrayList<>();
        final String SQL_SELECTALL = "{call usp_listarEntradas()}";
        
        try {
            cstm = con.getConnection().prepareCall(SQL_SELECTALL);
            res = cstm.executeQuery();
            while (res.next()) {
                Entrada entrada = new Entrada();
                entrada.setIdEntrada(res.getInt(1));
                entrada.setNombrePelicula(res.getString(2));
                entrada.setFechaEstreno(res.getString(3));
                entrada.setPrecio(res.getDouble(4));
                entrada.setTipo(res.getString(5));
                entrada.setEstado(res.getInt(6));
                entrada.setNumeroSala(res.getInt(7));
                entrada.setNombreCine(res.getString(8));
                entrada.setStock(res.getInt(9));
                entradas.add(entrada);
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar el listado de entradas");
            e.printStackTrace();
        } finally {
            close();
        }
        return entradas;
    }

    @Override
    public Boolean eliminar(Entrada t) {
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
    
}

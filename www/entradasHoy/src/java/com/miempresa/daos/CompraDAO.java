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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Compra> llenarDropList(int idPelicula) {
        List<Compra> compras = new ArrayList<>();
        final String SQL_SELECTALL ="{call usp_listarCinesPorPelicula()}";
  
        try {
//            System.out.println(idPelicula+"el1");
            cstm = con.getConnection().prepareCall(SQL_SELECTALL);
//            System.out.println(idPelicula+"el2");
            cstm.setInt(1, idPelicula);
//            System.out.println(idPelicula+"el3");
            res = cstm.executeQuery();
//            System.out.println(idPelicula+"el4");
            
            while (res.next()) {
                Compra compra = new Compra();
                compra.setIdEntrada(res.getInt(1));
                compra.setPrecio(res.getDouble(2));
                compra.setTipo(res.getString(3));
                compra.setNombreCine(res.getString(4));
                compra.setDireccion(res.getString(5));
                compra.setNumeroSala(res.getInt(6));
                compra.setNombrePelicula(res.getString(7));
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

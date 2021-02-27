/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import com.miempresa.daos.CompraDAO;
import com.miempresa.entidades.Compra;
import java.util.List;

/**
 *
 * @author JosueFlores
 */
public class TestLlenarDropList {
<<<<<<< HEAD
=======
    public static void main(String[] args) {
        CompraDAO compraDAO= new CompraDAO();
        List<Compra> compra=compraDAO.dropListCine(65);
        for (int i = 0; i < compra.size(); i++) {
                    System.out.println(compra.get(i).getNombreCine());        
>>>>>>> 8d7c0e9... falta comprar

  public static void main(String[] args) {
    CompraDAO compraDAO = new CompraDAO();
    //List<Compra> compra=compraDAO.llenarDropList(65);
    //for (int i = 0; i < compra.size(); i++) {
    //System.out.println(compra.get(i).getNombreCine());        

    //}
  }
}

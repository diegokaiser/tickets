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
    public static void main(String[] args) {
        CompraDAO compraDAO= new CompraDAO();
        
        System.out.println(compraDAO.llenarDropList(1).get(1).getNombreCine());
        
    }
}

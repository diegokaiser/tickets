/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import com.miempresa.daos.EntradaDAO;

/**
 *
 * @author JosueFlores
 */
public class TestListarEntradas {
    public static void main(String[] args) {
        EntradaDAO entradaDAO= new EntradaDAO();
        entradaDAO.seleccionarTodo();
        for (int i = 0; i <3 ; i++) {
            System.out.println(entradaDAO.seleccionarTodo());
        }
    }
}

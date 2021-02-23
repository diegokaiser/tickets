/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import com.miempresa.daos.EntradaDAO;
import com.miempresa.entidades.Entrada;

/**
 *
 * @author JosueFlores
 */
public class TestInsertarEntrada {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        EntradaDAO entradaDAO = new EntradaDAO();
        entrada.setPrecio(20.0);
        entrada.setTipo("2D");
        entrada.setEstado(1);
        entrada.setIdSala(1);
        entrada.setIdPelicula(1);
        entrada.setStock(250);
       
        if(entradaDAO.insertar(entrada)){
            System.out.println("Se inserto");
        }else {
            System.out.println("No se inserto");
        }
        
        
    }
    
}

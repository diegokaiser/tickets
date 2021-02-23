/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import com.miempresa.daos.EntradaDAO;
import com.miempresa.entidades.Sala;

/**
 *
 * @author JosueFlores
 */
public class ListarSalas {
    public static void main(String[] args) {
       
        EntradaDAO entrada = new EntradaDAO();

        
        
        for (int i = 0; i < 1; i++) {
            System.out.println(entrada.seleccionarSala().get(i).getNumero());
        }
        
        
    }
}

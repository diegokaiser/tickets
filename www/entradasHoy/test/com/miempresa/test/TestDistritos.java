/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import com.miempresa.daos.CineDAO;

/**
 *
 * @author JosueFlores
 */
public class TestDistritos {
    public static void main(String[] args) {
        CineDAO cine = new CineDAO();
        
        cine.listarDistritos();
        for (int i = 0; i <cine.listarDistritos().size() ; i++) {
            System.out.println(cine.listarDistritos().get(i));
            
        }
 
       
        
    }
}

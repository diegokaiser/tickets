/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import java.util.Date;

/**
 *
 * @author JosueFlores
 */
public class TestDate {
      public static void main(String[] args) {
                Date d=new Date();  
             d.setHours(d.getHours() + 24);
        System.out.println("day  : "+d.getDate()+"hour"+d.getHours() ); 
     
        
    }      
}

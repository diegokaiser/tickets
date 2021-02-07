/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.daos;

import com.miempresa.entidades.Usuario;
import java.util.List;

/**
 *
 * @author User
 */
public interface ICRUD <T> {
    
    Boolean insertar(T t);
    Boolean actualizar(T t);
    List<T> seleccionarTodo();
    Boolean eliminar(T t);
    void close();
   
}

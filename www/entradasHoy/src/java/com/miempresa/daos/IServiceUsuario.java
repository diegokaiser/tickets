/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.daos;

import com.miempresa.entidades.Usuario;

/**
 *
 * @author User
 */
public interface IServiceUsuario extends ICRUD<Usuario>{
     Boolean login(Usuario usuario);
}

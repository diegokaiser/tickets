/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import com.miempresa.daos.UsuarioDAO;
import com.miempresa.entidades.Usuario;

/**
 *
 * @author JosueFlores
 */
public class TestSelectPorCorreo {

  public static void main(String[] args) {
    Usuario usuario = new Usuario();
    usuario.setCorreo("donquixotedlm@gmail.com");
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    if(usuarioDAO.validar(usuario)) {
      System.out.println(":)");
    } else {
      System.out.println(":(");
    }
  }
}

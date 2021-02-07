package com.miempresa.test;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.daos.UsuarioDAO;
import com.miempresa.entidades.Usuario;

public class TestLogin {
    public static void main(String[] args) {
        ConnectionDB.getInstance();
        Usuario usuario = new Usuario();
        
        usuario.setCorreo("sandalio@brayans.pe");
        usuario.setContrasena("1234567");
        
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(usuarioDAO.login(usuario)) {
            System.out.println("Login con éxito chuls!");
        } else {
            System.out.println("Tas en na' papu");
        }
    }
}

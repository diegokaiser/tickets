package com.miempresa.test;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.daos.UsuarioDAO;

public class TestConnection {
    public static void main(String[] args) {
        ConnectionDB.getInstance();
        
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        usuarioDAO.seleccionPorId(100);
        
    }
}

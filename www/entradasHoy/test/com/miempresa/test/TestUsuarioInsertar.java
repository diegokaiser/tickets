package com.miempresa.test;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.daos.UsuarioDAO;
import com.miempresa.entidades.Usuario;

public class TestUsuarioInsertar {
    
    public static void main(String[] args) {
        ConnectionDB.getInstance();
        Usuario usuario = new Usuario();
        
        usuario.setNombre("Sandalio");
        usuario.setApellido("Meltronco");
        usuario.setCorreo("sandalio@brayans.pe");
        usuario.setContrasena("1234567");

        usuario.setTipoDocumento("1");
        usuario.setNumeroDocumento("44444444");
        usuario.setIdTipoUsuario(3);
        usuario.setEstado(1);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(usuarioDAO.insertar(usuario)) {
            System.out.println("Se insertaron correctamente los datos :)");
        } else {
            System.out.println("No se insertaron los datos :(");
        }
    }
}

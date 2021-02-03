package com.isil.controllers;

import com.isil.daos.UsuarioDAO;
import com.isil.entities.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String processing = request.getParameter("sprocessing");

        switch (processing) {
            case "registro":
                registrar(request, response);
                break;
            case "login":
                login(request, response);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + processing);
        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombre          = request.getParameter("nombre");
        String apellido        = request.getParameter("apellido");
        String correo          = request.getParameter("correo");
        String contrasena      = request.getParameter("contrasena");
        String tipoDocumento   = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumenti");
        String recontrasena    = request.getParameter("recontrasena");

        if(
            nombre.trim().isEmpty() ||
            apellido.trim().isEmpty() ||
            tipoDocumento.isEmpty() ||
            numeroDocumento.trim().isEmpty() ||
            correo.trim().isEmpty() ||
            contrasena.trim().isEmpty() &&
            contrasena.trim() != recontrasena.trim()
        ) {
            request.getRequestDispatcher(request.getContextPath() + "/registro/error.jsp").forward(request, response);
        } else {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setTipoDocumento(tipoDocumento);
            usuario.setNumeroDocumento(numeroDocumento);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);
            usuario.setEstado(0);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if(usuarioDAO.insertar(usuario)) {
                request.getRequestDispatcher(request.getContextPath() + "/registro/mensajeAnotado.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher(request.getContextPath() + "/registro/error.jsp").forward(request, response);
            }
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

package com.isil.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsuarioController", value = "/UsuarioController")
public class UsuarioController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre          = request.getParameter("nombre");
        String apellido        = request.getParameter("apellido");
        String tipoDocumento   = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumenti");
        String correo          = request.getParameter("correo");
        String contrasena      = request.getParameter("contrasena");

        // todos los campos del form
        // se pueden realizar aqui las validaciones de campos
        if(
            nombre.trim().isEmpty() ||
            apellido.trim().isEmpty() ||
            tipoDocumento.isEmpty() ||
            numeroDocumento.trim().isEmpty() ||
            correo.trim().isEmpty() ||
            contrasena.trim().isEmpty()
        ) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


}

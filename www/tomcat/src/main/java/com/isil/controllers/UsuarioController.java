package com.isil.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String processing = request.getParameter("sprocessing");

//        switch (processing) {
//            case "registro":
//                break;
//            case "login":
//                break;
//        }

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
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/registro/error.jsp"));
        } else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
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

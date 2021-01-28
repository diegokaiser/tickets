package com.isil.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsuarioController", value = "/UsuarioController")
public class UsuarioController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("name");
        // todos los campos del form
        // se pueden realizar aqui las validaciones de campos
        if(usuario.trim().isEmpty()) {
            request.getRequestDispatcher("error404/index.jsp").forward(request, response);
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

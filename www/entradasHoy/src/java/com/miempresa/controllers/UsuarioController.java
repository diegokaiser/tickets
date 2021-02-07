package com.miempresa.controllers;

import com.miempresa.daos.UsuarioDAO;
import com.miempresa.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String processing = request.getParameter("processing");
        switch(processing) {
            case "registro":
                registrar(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "listarUsuarios":
                listarTodo(request, response);
                break;
            case "loginAdmin":
                loginAdmin(request, response);
                break;
            case "detalleUsuario":
                detalleUsuario(request, response);
                break;
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioDAO.seleccionarTodo();
        request.getSession().setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("admin/usuarios/index.jsp").forward(request, response);
    }

    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void detalleUsuario(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package com.miempresa.controllers;

import com.miempresa.daos.PeliculaDAO;
import com.miempresa.entidades.Pelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class HomeController extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String proceso = request.getParameter("log");
    switch (proceso) {
      case "in":
        in(request, response);
        lastest(request, response);
        break;
      case "out":
        out(request, response);
        break;
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(false);
    if (session != null) {
      String correo = (String) session.getAttribute("correo");
    }
  }

  private void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/index.jsp").forward(request, response);
    HttpSession session = request.getSession();
    session.invalidate();
  }

  private void lastest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    
    List<Pelicula> lastest = new ArrayList<>();
    lastest = peliculaDAO.seleccionarUltimos();
    request.setAttribute("lastest", lastest);
    
    List<Pelicula> commingSoon = new ArrayList<>();
    commingSoon = peliculaDAO.seleccionarEstrenos();
    request.setAttribute("commingSoon", commingSoon);
    
    List<Pelicula> screen = new ArrayList<>();
    screen = peliculaDAO.seleccionarDestacado();
    request.setAttribute("screen", screen);
    
    List<Pelicula> recommended = new ArrayList<>();
    recommended = peliculaDAO.seleccionarRecomendados();
    request.setAttribute("recommended", recommended);
    request.getRequestDispatcher("/login/index.jsp").forward(request, response);
  }
}

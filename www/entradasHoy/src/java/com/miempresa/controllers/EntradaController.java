package com.miempresa.controllers;

import com.miempresa.daos.EntradaDAO;
import com.miempresa.daos.PeliculaDAO;
import com.miempresa.entidades.Entrada;
import com.miempresa.entidades.Pelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntradaController extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String proceso = request.getParameter("processing");
    switch (proceso) {
      case "listarEntradas":
        listarEntradas(request, response);
        break;
      case "seleccionarEntrada":
        seleccionarEntrada(request, response);
        break;
      case "verificarEntrada":
        verificarEntrada(request, response);
        break;
      case "comprarEntrada":
        comprarEntrada(request, response);
        break;
      case "validarCompra":
        validarCompra(request, response);
        break;
      case "cancelarEntrada":
        cancelarEntrada(request, response);
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

  private void listarEntradas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntradaDAO entradaDAO = new EntradaDAO();
    List<Entrada> entradas = new ArrayList<>();
    entradas = entradaDAO.seleccionarTodo();
    request.setAttribute("entradas", entradas);
    System.out.println("dasdasdashola");
    System.out.println(entradas.get(0));
    request.getRequestDispatcher("/admin/entradas/index.jsp").forward(request, response);
  }

  private void seleccionarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idPelicula");
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    Pelicula pelicula = peliculaDAO.seleccionPorId(Integer.parseInt(id));
    request.setAttribute("pelicula", pelicula);
    request.getRequestDispatcher("/entrada/index.jsp").forward(request, response);
  }
  
  private void verificarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/entrada/validarEntrada.jsp").forward(request, response);
  }
  
  private void comprarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("comprarEntrada");
    request.getRequestDispatcher("/entrada/comprarEntrada.jsp").forward(request, response);
    /*
    EntradaDAO entradaDAO = new EntradaDAO();
    if (entradaDAO.insertar(entrada)) {
      System.out.println("Se registraron las entradas");
      request.getRequestDispatcher("/entrada/comprarEntrada.jsp").forward(request, response);
    } else {
      System.out.println("No se registraron las entradas");
      request.getRequestDispatcher("/entrada/index.jsp").forward(request, response);
    }
    */
  }
  
  private void validarCompra(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  private void cancelarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // al cancelar entrada debe borrar los datos de la session
    request.getRequestDispatcher("/entrada/index.jsp").forward(request, response);
  }
}

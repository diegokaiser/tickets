/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.controllers;

import com.miempresa.daos.CompraDAO;
import com.miempresa.daos.PeliculaDAO;
import com.miempresa.entidades.Compra;
import com.miempresa.entidades.Pelicula;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JosueFlores
 */
public class CompraController extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String proceso = request.getParameter("processing");
    switch (proceso) {
      case "llenarDropList":
        llenarDropList(request, response);
        break;
      case "compraEntrada":
        compraEntrada(request, response);
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

  private void llenarDropList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //String idPelicula=request.getParameter("idPelicula");

    CompraDAO comprasDAO = new CompraDAO();
    List<Compra> compras = new ArrayList<>();
    compras = comprasDAO.dropListCine(1);
    request.setAttribute("compras", compras);
    
//    List<Compra> compras2= new ArrayList<>();
//    compras2=comprasDAO.dropListSala();
//    request.getRequestDispatcher("/entrada/index.jsp").forward(request, response);

  }

  private void compraEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idPelicula");
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    Pelicula pelicula = peliculaDAO.seleccionPorId(Integer.parseInt(id));
    request.setAttribute("pelicula", pelicula);
    
    request.getRequestDispatcher("/entrada/validarEntrada.jsp").forward(request, response);
  }
}

package com.miempresa.controllers;

import com.miempresa.daos.CineDAO;
import com.miempresa.daos.DistritoDAO;
import com.miempresa.entidades.Cine;
import com.miempresa.entidades.Distrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CineController extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String proceso = request.getParameter("processing");
    switch (proceso) {
      case "registro":
        registrar(request, response);
        break;
      case "listarCines":
        listarTodo(request, response);
        break;
      case "botoneEditarCine":
        botonEditarCine(request, response);
        break;
      case "deshabilitarCine":
        deshabilitarCine(request, response);
        break;
      case "habilitarCine":
        habilitarCine(request, response);
        break;
      case "editarCine":
        editarCine(request, response);
        break;
      case "agregarCine":
        agregarCine(request, response);
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

  private void registrar(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void listarTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    CineDAO cineDAO = new CineDAO();
    List<Cine> cines = new ArrayList<>();
    cines = cineDAO.seleccionarTodo();
    request.setAttribute("cines", cines);

    DistritoDAO distritoDAO = new DistritoDAO();
    List<Distrito> distritos = new ArrayList<>();
    distritos = distritoDAO.seleccionarTodo();
    request.setAttribute("distritos", distritos);

    request.getRequestDispatcher("/admin/cines/index.jsp").forward(request, response);
  }

  private void agregarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String direccion = request.getParameter("direccion");
    String logo = request.getParameter("logo");
    String estado = request.getParameter("estado");
    String distrito = request.getParameter("idDistrito");
    Cine cine = new Cine();

    cine.setNombre(nombre);
    cine.setDireccion(direccion);
    cine.setLogo(logo);
    cine.setEstado(Integer.parseInt(estado));
    cine.setIdDistrito(Integer.parseInt(distrito));
      System.out.println(distrito);

    CineDAO cineDAO = new CineDAO();
    if (cineDAO.insertar(cine)) {
      System.out.println("Se ingreso el cine");
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
    } else {
      System.out.println("No se ingreso la cine");
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
    }
  }

  private void deshabilitarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idCine");
    System.out.println(id);
    Cine cine = new Cine();
    cine.setIdCine(Integer.parseInt(id.toString()));
    cine.setEstado(0);

    CineDAO cineDAO = new CineDAO();
    if (cineDAO.eliminar(cine)) {
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
      request.getRequestDispatcher("admin/estrenos/index.jsp").forward(request, response);

      System.out.println("Se deshabilito");
    } else {
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
      request.getRequestDispatcher("admin/estrenos/index.jsp").forward(request, response);

      System.out.println("error en la deshabilitacion de la pelicula");
    }

  }

  private void habilitarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idCine");
    System.out.println(id);
    Cine cine = new Cine();
    cine.setIdCine(Integer.parseInt(id.toString()));
    cine.setEstado(1);

    CineDAO cineDAO = new CineDAO();
    if (cineDAO.eliminar(cine)) {
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
      request.getRequestDispatcher("admin/estrenos/index.jsp").forward(request, response);
      System.out.println("Se habilito");
    } else {
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
      request.getRequestDispatcher("admin/estrenos/index.jsp").forward(request, response);
      System.out.println("error en la habilitacion de la pelicula");
    }

  }

  private void botonEditarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idCine");

    CineDAO cineDAO = new CineDAO();
    Cine cine = cineDAO.seleccionPorId(Integer.parseInt(id.toString()));
    request.getSession().setAttribute("cine", cine);

    DistritoDAO distritoDAO = new DistritoDAO();
    List distritos = new ArrayList<>();
    distritos = distritoDAO.seleccionarTodo();
    request.setAttribute("distritos", distritos);

    request.getRequestDispatcher("/admin/cines/detalle.jsp").forward(request, response);
  }

  private void editarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("idCine");
    String nombre = request.getParameter("nombre");
    String direccion = request.getParameter("direccion");
    String logo = request.getParameter("logo");
    String estado = request.getParameter("estado");

    Cine cine = new Cine();
    cine.setIdCine(Integer.parseInt(id.toString()));
    cine.setNombre(nombre);
    cine.setDireccion(direccion);
    cine.setLogo(logo);
    cine.setEstado(Integer.parseInt(estado.toString()));

    CineDAO cineDAO = new CineDAO();
    if (cineDAO.actualizar(cine)) {
      System.out.println("Se actualizo el cine");
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
    } else {
      System.out.println("error");
      request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
    }
  }
}

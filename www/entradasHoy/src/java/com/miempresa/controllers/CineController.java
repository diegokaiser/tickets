package com.miempresa.controllers;

import com.miempresa.daos.CineDAO;
import com.miempresa.entidades.Cine;
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
      case "eliminarCine":
        eliminarCine(request, response);
        break;
      case "editarCine":
        editarCine(request, response);
        break;
      case "agregarCine":
         agregarCine(request, response);

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
    request.getRequestDispatcher("/admin/cines/index.jsp").forward(request, response);
    System.out.println("dasdasdashola");
    System.out.println(cines.get(0));
  }

  private void listarDistritos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    CineDAO cineDAO = new CineDAO();
    List distritos = new ArrayList<>();
    distritos = cineDAO.listarDistritos();
    request.setAttribute("distritos", distritos);
    request.getRequestDispatcher("/admin/cines/modal.jsp").forward(request, response);
    System.out.println("listar");
    System.out.println(distritos.get(1));
  }

  private void eliminarCine(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void botonEditarCine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("asdasdasdas");
    String id = request.getParameter("idCine");

    CineDAO cineDAO = new CineDAO();
    Cine cine = cineDAO.seleccionPorId(Integer.parseInt(id.toString()));
    request.getSession().setAttribute("cine", cine);
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

    private void agregarCine(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
        Cine cine= new Cine();
        
        String nombre=request.getParameter("nombre");
        String direccion=request.getParameter("direccion");
        String logo=request.getParameter("logo");
        String estado=request.getParameter("estado");
        String distrito=request.getParameter("distrito"); 
       
        
        cine.setNombre(nombre);
        cine.setDireccion(direccion);
        cine.setLogo(logo);
        cine.setEstado(Integer.parseInt(estado));
        cine.setIdDistrito(Integer.parseInt(distrito));
   
        CineDAO cineDAO= new CineDAO();
        if(cineDAO.insertar(cine)){
            System.out.println("Se ingreso el cine"); 
               request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);

        }else{
            System.out.println("No se ingreso la cine");
            request.getRequestDispatcher("/CineController?processing=listarCines").forward(request, response);
        }
            
    }

}

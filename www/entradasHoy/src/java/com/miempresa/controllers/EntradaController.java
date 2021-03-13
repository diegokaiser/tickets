package com.miempresa.controllers;

import com.miempresa.daos.CineDAO;
import com.miempresa.daos.CompraDAO;
import com.miempresa.daos.EntradaDAO;
import com.miempresa.daos.PeliculaDAO;
import com.miempresa.entidades.Cine;
import com.miempresa.entidades.Compra;
import com.miempresa.entidades.Entrada;
import com.miempresa.entidades.Pelicula;
import com.miempresa.entidades.Sala;
import com.miempresa.entidades.Aviso;
import com.miempresa.entidades.Usuario;
import com.miempresa.mails.SendAlert;
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
      case "insertarEntrada":
        insertarEntrada(request, response);
        break;        
      case "crearAviso":
        crearAviso(request, response);
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

    CineDAO cineDAO = new CineDAO();
    List<Cine> cines = new ArrayList<>();
    cines = cineDAO.seleccionarTodo();
    request.setAttribute("cines", cines);

    PeliculaDAO peliculaDAO = new PeliculaDAO();
    List<Pelicula> peliculas = new ArrayList<>();
    List<Sala> salas= new ArrayList<>();
    peliculas = peliculaDAO.seleccionarTodo();
    salas=entradaDAO.seleccionarSala();
    request.setAttribute("peliculas", peliculas);
    request.setAttribute("salas", salas);    
    request.getRequestDispatcher("/admin/entradas/index.jsp").forward(request, response);
  }

  private void seleccionarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idPelicula");
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    Pelicula pelicula = peliculaDAO.seleccionPorId(Integer.parseInt(id));
    request.setAttribute("pelicula", pelicula);
    
    String nombreCine = request.getParameter("nombreCine");
    CompraDAO compraDAO = new CompraDAO();

    List cines = new ArrayList<>();
    cines = compraDAO.dropListCine(Integer.parseInt(id));
    request.setAttribute("cines", cines);
    
    List salas = new ArrayList<>();
    salas = compraDAO.dropListSala(Integer.parseInt(id));
    request.setAttribute("salas", salas);
    List <Compra>compras = new ArrayList<>();
    compras = compraDAO.dropListCine(Integer.parseInt(id));
    request.setAttribute("compras", compras);
      System.out.println(compras.get(1).getNombreCine());     

    List compras2= new ArrayList<>();
   compras2=compraDAO.dropListSala(compras.get(1).getNombreCine());
    request.setAttribute("compras2", compras2);
    
    request.getRequestDispatcher("/entrada/index.jsp").forward(request, response);
  }
  
  private void verificarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/ntrada/validarEntrada.jsp").forward(request, response);
  }
  
  private void comprarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("dasdas");
      String id = request.getParameter("idPelicula");
   String idUsuario= request.getParameter("idUsuario");
   String idEntrada=request.getParameter("idCompra2");
   String numeroEntradas=request.getParameter("numeroEntradas");
      System.out.println("asdffasdfasdfasd");
    request.getRequestDispatcher("/entrada/prueba.jsp").forward(request, response);
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

  private void insertarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String precio = request.getParameter("precio");
    String tipo = request.getParameter("tipo");
    String estado = request.getParameter("estado");
    String idSala = request.getParameter("idSala");
    String idPelicula = request.getParameter("idPelicula");
    String stock=request.getParameter("stock");

    Entrada entrada = new Entrada();
    entrada.setPrecio(Integer.parseInt(precio)*1.0);
    entrada.setTipo(tipo);
    entrada.setEstado(Integer.parseInt(estado));
    entrada.setIdSala(Integer.parseInt(idSala));
    entrada.setIdPelicula(Integer.parseInt(idPelicula));
    entrada.setStock(Integer.parseInt(stock));    

    EntradaDAO entradaDAO = new EntradaDAO();
    if (entradaDAO.insertar(entrada)) {
      System.out.println("Se ingreso la entrada");
      request.getRequestDispatcher("/EntradaController?processing=listarEntradas").forward(request, response);
    } else {
      System.out.println("No se ingreso la entrada");
      request.getRequestDispatcher("/EntradaController?processing=listarEntradas").forward(request, response);
    }
  }

  private void crearAviso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String correo = request.getParameter("correo");
    String pelicula = request.getParameter("pelicula");
    String fechaEstreno = request.getParameter("fechaEstreno");
    
    SendAlert smv = new SendAlert();
    
    Aviso aviso = new Aviso();
    aviso.setNombre(nombre);
    aviso.setCorreo(correo);
    aviso.setPelicula(pelicula);
    aviso.setFechaEstreno(fechaEstreno);
    boolean test = smv.sendAlert(aviso, request);    
    if(test) {
      request.getRequestDispatcher("/estrenos/alertaExito.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("/estrenos/alertaError.jsp").forward(request, response);
    }
  }
}

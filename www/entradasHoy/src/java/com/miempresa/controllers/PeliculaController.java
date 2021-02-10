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

public class PeliculaController extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String proceso = request.getParameter("processing");
    switch (proceso) {
      case "lastest":
        lastest(request, response);
        break;
      case "commingSoon":
        commingSoon(request, response);
        break;
      case "recommended":
        recommended(request, response);
        break;
      case "listarPeliculas":
        listarTodo(request, response);
        break;
      case "botonEditarPelicula":
        botonEditarPelicula(request, response);
        break;
      case "editarPelicula":
        editarPelicula(request, response);
        break;
      case "eliminarPelicula":
        eliminarPelicula(request, response);
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

  private void lastest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    List<Pelicula> lastest = new ArrayList<>();
    lastest = peliculaDAO.seleccionarUltimos();
    request.setAttribute("lastest", lastest);
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }

  private void commingSoon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    List<Pelicula> commingSoon = new ArrayList<>();
    commingSoon = peliculaDAO.seleccionarEstrenos();
    request.setAttribute("commingSoon", commingSoon);
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }

  private void recommended(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    List<Pelicula> recommended = new ArrayList<>();
    recommended = peliculaDAO.seleccionarRecomendados();
    request.setAttribute("recommended", recommended);
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }

  private void listarTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    List<Pelicula> peliculas = new ArrayList<>();
    peliculas = peliculaDAO.seleccionarTodo();
    request.setAttribute("peliculas", peliculas);
    request.getRequestDispatcher("/admin/estrenos/index.jsp").forward(request, response);
  }

  private void botonEditarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idPelicula");
    PeliculaDAO peliculaDAO = new PeliculaDAO();
    Pelicula pelicula = peliculaDAO.seleccionPorId(Integer.parseInt(id.toString()));
    request.setAttribute("pelicula", pelicula);
    request.getRequestDispatcher("/admin/estrenos/detalle.jsp").forward(request, response);
  }

  private void editarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idPelicula");
    String nombre = request.getParameter("nombre");
    String duracion = request.getParameter("duracion");
    String fechaEstreno = request.getParameter("fechaEstreno");
    String idioma = request.getParameter("idioma");
    String pais = request.getParameter("pais");
    String subtitulos = request.getParameter("subtitulos");
    String doblada = request.getParameter("doblada");
    String portada = request.getParameter("portada");
    String descripcion = request.getParameter("descripcion");
    String genero = request.getParameter("genero");
    String estado = request.getParameter("estado");

    Pelicula pelicula = new Pelicula();
    pelicula.setIdPelicula(Integer.parseInt(id.toString()));
    pelicula.setNombre(nombre);
    pelicula.setDuracion(duracion);
    pelicula.setFechaEstreno(fechaEstreno);
    pelicula.setIdioma(idioma);
    pelicula.setPais(pais);
    pelicula.setSubtitulos(Integer.parseInt(subtitulos.toString()));
    pelicula.setDoblada(Integer.parseInt(doblada.toString()));
    pelicula.setPortada(portada);
    pelicula.setDescripcion(descripcion);
    pelicula.setGenero(genero);
    pelicula.setEstado(Integer.parseInt(estado.toString()));

    PeliculaDAO peliculaDAO = new PeliculaDAO();
    if (peliculaDAO.actualizar(pelicula)) {
      System.out.println("Se actualizo");
      request.getRequestDispatcher("/PeliculaController?processing=listarPeliculas").forward(request, response);
    } else {
      System.out.println("error");
      request.getRequestDispatcher("/PeliculaController?processing=listarPeliculas").forward(request, response);
    }
  }

  private void eliminarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("idPelicula");
    System.out.println(id);
    Pelicula pelicula = new Pelicula();
    pelicula.setIdPelicula(Integer.parseInt(id.toString()));
    pelicula.setEstado(0);

    PeliculaDAO peliculaDAO = new PeliculaDAO();
    if (peliculaDAO.eliminar(pelicula)) {      
      System.out.println("Se desahiblito");
      request.getRequestDispatcher("/PeliculaController?processing=listarPeliculas").forward(request, response);
    } else {      
      System.out.println("error en la deshabilitacion de la pelicula");
      request.getRequestDispatcher("/PeliculaController?processing=listarPeliculas").forward(request, response);
    }
  }
}

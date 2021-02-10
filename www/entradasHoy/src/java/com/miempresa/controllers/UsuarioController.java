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
import javax.servlet.http.HttpSession;

public class UsuarioController extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String proceso = request.getParameter("processing");
    switch (proceso) {
      case "registro":
        registrar(request, response);
        break;
      case "login":
        login(request, response);
        break;
      case "loginAdmin":
        loginAdmin(request, response);
        break;
      case "listarUsuarios":
        listarTodo(request, response);
        break;
      case "botonEditarUsuario":
        botonEditarUsuario(request, response);
        break;
      case "eliminarUsuario":
        eliminarUsuario(request, response);
        break;
      case "editarUsuario":
        editarUsuario(request, response);
        break;
      case "habilitarUsuario":
        habilitarUsuario(request, response);
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

  private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String tipoDocumento = request.getParameter("tipoDocumento");
    String numeroDocumento = request.getParameter("numeroDocumento");
    String correo = request.getParameter("correo");
    String contrasena = request.getParameter("contrasena");

    if (nombre.trim().isEmpty() || contrasena.trim().isEmpty()) {
      request.getRequestDispatcher("/registro/error.jsp").forward(request, response);
    } else {
      Usuario usuario = new Usuario();
      usuario.setNombre(nombre);
      usuario.setApellido(apellido);
      usuario.setTipoDocumento(tipoDocumento);
      usuario.setNumeroDocumento(numeroDocumento);
      usuario.setCorreo(correo);
      usuario.setContrasena(contrasena);
      usuario.setIdTipoUsuario(3);
      usuario.setEstado(0);
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      if (usuarioDAO.insertar(usuario)) {
        request.setAttribute("nombre", nombre);
        request.getRequestDispatcher("/registro/mensajeAnotado.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("/registro/error.jsp").forward(request, response);
      }
    }
  }

  private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String correo = request.getParameter("correo");
    String contrasena = request.getParameter("contrasena");

    if (correo.trim().isEmpty() || contrasena.trim().isEmpty()) {
      request.getRequestDispatcher("/login/error.jsp").forward(request, response);
    } else {
      Usuario usuario = new Usuario();
      usuario.setCorreo(correo);
      usuario.setContrasena(contrasena);
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      if (usuarioDAO.login(usuario)) {
        HttpSession session = request.getSession();
        session.setAttribute("correo", correo);
        request.getRequestDispatcher("/HomeController?log=in").forward(request, response);
      } else {
        request.getRequestDispatcher("/login/error.jsp").forward(request, response);
      }
    }
  }

  private void listarTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    List<Usuario> usuarios = new ArrayList<>();
    usuarios = usuarioDAO.seleccionarTodo();
    request.setAttribute("usuarios", usuarios);
    request.getRequestDispatcher("/admin/usuarios/index.jsp").forward(request, response);
  }

  private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String correo = request.getParameter("correo");
    String contrasena = request.getParameter("contrasena");

    if (correo.trim().isEmpty() || contrasena.trim().isEmpty()) {
      // error
      request.getRequestDispatcher("/login/error.jsp").forward(request, response);
    } else {
      Usuario usuario = new Usuario();
      usuario.setCorreo(correo);
      usuario.setContrasena(contrasena);
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      if (usuarioDAO.loginAdmin(usuario)) {
        HttpSession session = request.getSession();
        session.setAttribute("correo", correo);
        request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
      } else {
        // error
        request.getRequestDispatcher("/admin/login/index.jsp").forward(request, response);
      }
    }
  }

  private void botonEditarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idUsuario");
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = usuarioDAO.seleccionPorId(Integer.parseInt(id.toString()));
    request.getSession().setAttribute("usuario", usuario);
    request.getRequestDispatcher("admin/usuarios/detalle.jsp").forward(request, response);
  }

  private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("idUsuario");
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String tipoDocumento = request.getParameter("tipoDocumento");
    String numeroDocumento = request.getParameter("numeroDocumento");
    String correo = request.getParameter("correo");
    String contrasena = request.getParameter("contrasena");

    Usuario usuario = new Usuario();
    usuario.setIdUsuario(Integer.parseInt(id.toString()));
    usuario.setNombre(nombre);
    usuario.setApellido(apellido);
    usuario.setTipoDocumento(tipoDocumento);
    usuario.setNumeroDocumento(numeroDocumento);
    usuario.setCorreo(correo);
    usuario.setContrasena(contrasena);

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    if (usuarioDAO.actualizar(usuario)) {
      System.out.println("Se actualizo");
      request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
    } else {
      System.out.println("error");
      request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
    }
  }

  private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("idUsuario");
    System.out.println(id);
    Usuario usuario = new Usuario();
    usuario.setIdUsuario(Integer.parseInt(id.toString()));
    usuario.setEstado(0);

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    if (usuarioDAO.eliminar(usuario)) {      
      System.out.println("Se desahiblito");
      request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
    } else {      
      System.out.println("error en la deshabilitacion del usuario");
      request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
    }
  }

  private void habilitarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("idUsuario");
    System.out.println(id);
    Usuario usuario = new Usuario();
    usuario.setIdUsuario(Integer.parseInt(id.toString()));
    usuario.setEstado(1);

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    if (usuarioDAO.habilitar(usuario)) {
      System.out.println("Se Habilito");
      request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
    } else {      
      System.out.println("error en la habilitacion del usuario");
      request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
    }
  }
}

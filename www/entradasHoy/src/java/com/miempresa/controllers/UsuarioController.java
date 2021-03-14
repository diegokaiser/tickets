package com.miempresa.controllers;

import com.miempresa.daos.UsuarioDAO;
import com.miempresa.entidades.Usuario;
import com.miempresa.mails.SendEmail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
      case "validarUsuario":
        validarUsuario(request, response);
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
      SendEmail smv = new SendEmail();
      String code = smv.getRandom();
      Usuario usuario = new Usuario();
      usuario.setNombre(nombre);
      usuario.setApellido(apellido);
      usuario.setTipoDocumento(tipoDocumento);
      usuario.setNumeroDocumento(numeroDocumento);
      usuario.setCorreo(correo);
      usuario.setContrasena(contrasena);
      usuario.setIdTipoUsuario(3);
      usuario.setEstado(0);
      usuario.setCode(code);
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      boolean test = smv.sendEmail(usuario, request);
      
      if (usuarioDAO.insertar(usuario)) {
        if(test) {
          HttpSession session = request.getSession();
          session.setAttribute("authcode", code);
        } 
               
        request.getRequestDispatcher("/registro/mensajeAnotado.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("/registro/error.jsp").forward(request, response);
      }
    }
  }

  private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String nombre = "";
    String apellido = "";
    String correo = request.getParameter("correo");
    String tipoDocumento = "";
    String numeroDocumento = "";
    String contrasena = request.getParameter("contrasena");

    if (correo.trim().isEmpty() || contrasena.trim().isEmpty()) {
      request.getRequestDispatcher("/login/error.jsp").forward(request, response);
    } else {
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      Usuario usuario = new Usuario();
      usuario.setCorreo(correo);
      usuario = usuarioDAO.seleccionarPorCorreo(usuario);

      nombre = usuario.getNombre();
      apellido = usuario.getApellido();
      tipoDocumento = usuario.getTipoDocumento();
      numeroDocumento = usuario.getNumeroDocumento();

      if (usuarioDAO.login(usuario)) {
        HttpSession session = request.getSession();
        session.setAttribute("nombre", nombre);//
        session.setAttribute("apellido", apellido);//
        session.setAttribute("correo", correo);//
        session.setAttribute("tipoDocumento", tipoDocumento);//
        session.setAttribute("name", nombre);//
        session.setAttribute("name2", nombre);//
        session.setAttribute("apellido2", apellido);//
         session.setAttribute("nombre", nombre);//

        System.out.println("UsuarioController: login");
        System.out.println(nombre);
        System.out.println(apellido);  
          System.out.println(correo);
          System.out.println(tipoDocumento);
          System.out.println(numeroDocumento);
          System.out.println("EstoEstafuncinoadnoasdasda");
        // Listar los valores en sesion
        System.out.println("========================================================================================");
        System.out.println("Listado de valores en sesion - UsuarioController - login");
        if(session != null) {
          Enumeration en = session.getAttributeNames();
          for (; en.hasMoreElements(); ) {
            String name = (String)en.nextElement();
            System.out.println(name+": " + session.getAttribute(name));
          }
        }
        System.out.println("========================================================================================");
        
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
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = new Usuario();
    String correo = request.getParameter("correo");
    String contrasena = request.getParameter("contrasena");

    if (correo.trim().isEmpty() || contrasena.trim().isEmpty()) {
      request.getRequestDispatcher("/login/error.jsp").forward(request, response);
    } else {
      usuario.setCorreo(correo);
      usuario = usuarioDAO.seleccionarPorCorreo(usuario);
      correo = usuario.getCorreo();
      String nombre = usuario.getNombre();

      if (usuarioDAO.loginAdmin(usuario)) {
        HttpSession session = request.getSession();
        session.setAttribute("correo", correo);
        session.setAttribute("nombre", nombre);
        request.getRequestDispatcher("/UsuarioController?processing=listarUsuarios").forward(request, response);
      } else {
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

  private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
    String id = request.getParameter("correo");
    System.out.println(id);
    Usuario usuario = new Usuario();
    usuario.setCorreo(id);
    usuario.setEstado(1);
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();  
    if (usuarioDAO.validar(usuario)) {
      System.out.println("Se validó y activó al usuario ID: "+ id);
      request.getRequestDispatcher("/registro/mensajeValidado.jsp").forward(request, response);
    } else {
      System.out.println("No se validó y activó al usuario ID: "+ id);
      request.getRequestDispatcher("/registro/error.jsp").forward(request, response);
    }
  }
  
}

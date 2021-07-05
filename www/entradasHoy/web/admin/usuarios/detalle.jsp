<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.miempresa.entidades.Usuario"%>
<%
  Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>Admin Area</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/nprogress.css" rel="stylesheet">    
    <!-- Ion.RangeSlider -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/normalize.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/custom.min.css" rel="stylesheet">    
  </head>
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <%@ include file="./../includes/side.jsp" %>
        <%@ include file="./../includes/top.jsp" %>
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Editar a <%=usuario.getNombre()%></h3>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_content">
                    <div class="row">
                      <div class="col-xs-12 col-lg-4">
                      </div>
                      <div class="col-sm-12 col-lg-4">
                        <form action="<%=request.getContextPath()%>/UsuarioController" method="POST">
                          <input type="hidden" id="processing" name="processing" value="editarUsuario">
                          <input type="hidden"  id="idUsuario" name="idUsuario" value="<%=usuario.getIdUsuario()%>">
                          <h2>Editar</h2>
                          <div class="form-group pt-4">
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" value="<%=usuario.getNombre()%>">
                          </div>
                          <div class="form-group">
                            <label for="apellido">Apellido:</label>
                            <input type="text" class="form-control" id="apellido" name="apellido" value="<%=usuario.getApellido()%>">
                          </div>
                          <div class="form-group">
                            <label for="tipoDocumento">Tipo de Documento de Identidad:</label>
                            <select class="form-control" name="tipoDocumento" id="tipoDocumento">
                              <c:set var="tipoDocumento" value="<%=usuario.getTipoDocumento()%>" />
                              <c:choose>
                                <c:when test="${tipoDocumento == 1}">
                                  <option value="1" selected>DNI</option>
                                  <option value="2">C.E</option>
                                </c:when>
                                <c:otherwise>
                                  <option value="1">DNI</option>
                                  <option value="2" selected>C.E</option>
                                </c:otherwise>
                              </c:choose>
                            </select>
                          </div>
                          <div class="form-group">
                            <label for="numeroDocumento">Documento de Identidad:</label>
                            <input type="text" class="form-control" id="numeroDocumento" name="numeroDocumento" value="<%=usuario.getNumeroDocumento()%>">
                          </div>
                          <div class="form-group">
                            <label for="correo">Correo electrónico:</label>
                            <input type="text" class="form-control" id="correo" name="correo" value="<%=usuario.getCorreo()%>">
                          </div>
                          <div class="form-group">
                            <label for="contrasena">Contraseña:</label>
                            <input type="password" class="form-control" id="contrasena" name="contrasena" value="<%=usuario.getContrasena()%>">
                          </div>
                          <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block my-4">Actualizar</button>
                          </div>
                        </form>
                      </div>
                      <div class="col-xs-12 col-lg-4">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/nprogress.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/custom.min.js"></script>

  </body>
</html>
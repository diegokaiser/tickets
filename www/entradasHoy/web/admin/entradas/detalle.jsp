<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.miempresa.entidades.Pelicula"%>
<%
  Pelicula pelicula = (Pelicula) request.getSession().getAttribute("pelicula");
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
                <h3>Editar a <%=pelicula.getNombre()%></h3>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_content">
                    <div class="row">
                      <div class="col-xs-12 col-lg-3">
                      </div>
                      <div class="col-sm-12 col-lg-6">
                        <form action="<%=request.getContextPath()%>/PeliculaController" method="POST">
                          <input type="hidden" id="processing" name="processing" value="editarPelicula">
                          <input type="hidden"  id="idPelicula" name="idPelicula" value="<%=pelicula.getIdPelicula()%>">
                          <h2>Editar</h2>

                          <div class="form-group pt-4">
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" value="<%=pelicula.getNombre()%>">
                          </div>

                          <div class="form-group">
                            <label for="duracion">Duración:</label>
                            <input type="text" class="form-control" id="duracion" name="duracion" value="<%=pelicula.getDuracion()%>">
                          </div>

                          <div class="form-group">
                            <label for="fechaEstreno">Fecha Estreno</label>
                            <input type="text" class="form-control" id="fechaEstreno" name="fechaEstreno" value="<%=pelicula.getFechaEstreno()%>">
                          </div>

                          <div class="form-group">
                            <label for="idioma">Idioma:</label>
                            <input type="text" class="form-control" id="idioma" name="idioma" value="<%=pelicula.getIdioma()%>">
                          </div>

                          <div class="form-group">
                            <label for="pais">País: </label>
                            <input type="text" class="form-control" id="pais" name="pais" value="<%=pelicula.getPais()%>">
                          </div>

                          <div class="form-group">
                            <label for="subtitulos">Subtitulos: </label>
                            <input type="text" class="form-control" id="subtitulos" name="subtitulos" value="<%=pelicula.getSubtitulos()%>">
                          </div>

                          <div class="form-group">
                            <label for="doblada">Doblada: </label>
                            <select class="form-control" id="doblada" name="doblada">
                              <c:choose>
                                <c:when test="${pelicula.getDoblada() == 1}">
                                  <option value="1" selected>Disponible</option>
                                  <option value="0">No disponible</option>
                                </c:when>
                                <c:otherwise>
                                  <option value="1">Disponible</option>
                                  <option value="0" selected="">No disponible</option>                                                      
                                </c:otherwise>
                              </c:choose>
                            </select>
                          </div>

                          <div class="form-group">
                            <label for="portada">Portada: </label>
                            <input type="text" class="form-control" id="portada" name="portada" value="<%=pelicula.getPortada()%>">
                          </div>

                          <div class="form-group">
                            <label for="descripcion">Descripción: </label>
                            <textarea class="form-control" id="descripcion" name="descripcion" style="min-height: 100px; resize: none;"><%=pelicula.getDescripcion()%></textarea>
                          </div>

                          <div class="form-group">
                            <label for="genero">Género: </label>
                            <input type="text" class="form-control" id="genero" name="genero" value="<%=pelicula.getGenero()%>">
                          </div>

                          <div class="form-group">
                            <label for="estado">Estado: </label>
                            <select class="form-control" id="estado" name="estado">
                              <c:choose>
                                <c:when test="${pelicula.getEstado() == 1}">
                                  <option value="1" selected>En estreno</option>
                                  <option value="0">Por estrenar</option>
                                </c:when>
                                <c:otherwise>
                                  <option value="1">En estreno</option>
                                  <option value="0" selected="">Por estrenar</option>                                                      
                                </c:otherwise>
                              </c:choose>                                                  
                            </select>
                          </div>

                          <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block my-4">Actualizar</button>
                          </div>
                        </form>
                      </div>
                      <div class="col-xs-12 col-lg-3">
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
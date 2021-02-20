<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>Admin Area</title>
    <!-- Bootstrap -->
    <link href="//cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/green.css" rel="stylesheet">
    <!-- Datatables -->

    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/scroller.bootstrap.min.css" rel="stylesheet">

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
                <h3>Listado de Peliculas</h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_content">
                    <div class="row">
                      <div class="col-sm-12 text-right">
                          <%@ include file="./../estrenos/modal.jsp" %>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-sm-12">
                        <div class="card-box table-responsive">
                          <table id="datatable" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                              <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Duración</th>
                                <th>Fecha de Estreno</th>
                                <th>Idioma</th>
                                <th>País de origen</th>
                                <th>Subtítulos</th>
                                <th>Doblada</th>
                                <th>Portada</th>
                                <th>Descripción</th>
                                <th>Género</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                              </tr>
                            </thead>


                            <!-- Lista Pelicuals estrenadas -->
                            <tbody>
                              <c:forEach var="pelicula" items="${peliculas}">
                                <tr>
                                  <td>${pelicula.idPelicula}</td>
                                  <td>${pelicula.nombre}</td>
                                  <td>${pelicula.duracion}</td>
                                  <td>
                                    ${pelicula.fechaEstreno}
                                  </td>
                                  <td>${pelicula.idioma}</td>
                                  <td>${pelicula.pais}</td>
                                  <td>
                                    <c:choose>
                                      <c:when test="${pelicula.subtitulos == 1}">
                                        Sí
                                      </c:when>
                                      <c:otherwise>
                                        No
                                      </c:otherwise>
                                    </c:choose>
                                  </td>
                                  <td>
                                    <c:choose>
                                      <c:when test="${pelicula.doblada == 1}">
                                        Sí
                                      </c:when>
                                      <c:otherwise>
                                        No
                                      </c:otherwise>
                                    </c:choose>
                                  </td>
                                  <td>
                                    <c:choose>
                                      <c:when test="${pelicula.portada != ''}">
                                        Sí
                                      </c:when>
                                      <c:otherwise>
                                        No
                                      </c:otherwise>
                                    </c:choose>
                                  </td>
                                  <td>
                                    <c:choose>
                                      <c:when test="${pelicula.descripcion != '}'}">
                                        Sí
                                      </c:when>
                                      <c:otherwise>
                                        No
                                      </c:otherwise>
                                    </c:choose>
                                  </td>
                                  <td>${pelicula.genero}</td>

                                  <td>
                                  <c:choose>
                                    <c:when test="${pelicula.estado == 1}">
                                      En estreno
                                    </c:when>
                                    <c:otherwise>
                                      Por estrenar
                                    </c:otherwise>
                                  </c:choose>
                                  </td>

                                  <td width="140">
                                    <div class="admin-actions">
                                      <a href="<%=request.getContextPath()%>/PeliculaController?processing=botonEditarPelicula&idPelicula=${pelicula.idPelicula}" class="btn btn-success text-left" style="width: 100%;"><i class="fa fa-pencil"></i>&nbsp;&nbsp;Editar</a><br>
                                      <c:choose>
                                        <c:when test="${pelicula.estado == 1}">
                                          <a href="<%=request.getContextPath()%>/PeliculaController?processing=eliminarPelicula&idPelicula=${pelicula.idPelicula}" class="btn btn-danger text-left" style="width: 100%;"><i class="fa fa-times"></i>&nbsp;&nbsp;Deshabilitar</a>
                                        </c:when>
                                        <c:otherwise>
                                          <a href="#" class="btn btn-primary text-left" style="width: 100%;"><i class="fa fa-check"></i>&nbsp;&nbsp;Habilitar</a><br>
                                        </c:otherwise>
                                      </c:choose>                                      
                                    </div>
                                  </td>
                                </tr>
                              </c:forEach>
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
        <%@ include file="./../includes/footer.jsp" %>
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
    <!-- iCheck -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/dataTables.bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/dataTables.buttons.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/buttons.bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/buttons.flash.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/buttons.html5.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/buttons.print.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/dataTables.fixedHeader.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/dataTables.keyTable.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/dataTables.responsive.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/responsive.bootstrap.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/dataTables.scroller.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/jszip.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/pdfmake.min.js"></script>
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="<%=request.getContextPath()%>/RESOURCES/admin/js/custom.min.js"></script>
  </body>
</html>

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
                <h3>Listado de entradas</h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_content">
                    <div class="row">
                      <div class="col-sm-12 text-right">
                          <%@ include file="./../entradas/modal.jsp" %>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-sm-12">
                        <div class="card-box table-responsive">
                          <table id="datatable" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                              <tr>
                                <th>ID</th>
                                <th>Pelicula</th>
                                <th>Fecha estreno</th>
                                <th>Precio</th>
                                <th>Tipo</th>
                                <th>Estado</th>
                                <th>Sala</th>
                                <th>Cine</th>
                                <th>Stock</th>
                                <th>Acciones</th>
                              </tr>
                            </thead>


                            <!-- Lista Pelicuals estrenadas -->
                            <tbody>
                              <c:forEach var="entrada" items="${entradas}">
                                <tr>
                                  <td>${entrada.idEntrada}</td>
                                  <td>${entrada.nombrePelicula}</td>
                                  <td>${entrada.fechaEstreno}</td>
                                  <td>${entrada.precio}</td>
                                  <td>${entrada.tipo}</td>
                                  <td>${entrada.estado}</td>
                                  <td>${entrada.numeroSala}</td>
                                  <td>${entrada.nombreCine}</td>
                                  <td>${entrada.stock}</td>
 
                                  <td width="140">
                                    <div class="admin-actions">
                                      <a href="<%=request.getContextPath()%>/EntradaController?processing=botonEditarEntrada&idEntrada=${entrada.idEntrada}" class="btn btn-success text-left" style="width: 100%;"><i class="fa fa-pencil"></i>&nbsp;&nbsp;Editar</a><br>
                                      <c:choose>
                                        <c:when test="${entrada.estado == 1}">
                                          <a href="<%=request.getContextPath()%>/EntradaController?processing=deshabilitarEntrada&idEntrada=${entrada.idEntrada}" class="btn btn-danger text-left" style="width: 100%;"><i class="fa fa-times"></i>&nbsp;&nbsp;Deshabilitar</a>
                                        </c:when>
                                        <c:otherwise>
                                          <a href="<%=request.getContextPath()%>/EntradaController?processing=habilitarEntrada&idEntrada=${entrada.idEntrada}" class="btn btn-primary text-left" style="width: 100%;"><i class="fa fa-check"></i>&nbsp;&nbsp;Habilitar</a>
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

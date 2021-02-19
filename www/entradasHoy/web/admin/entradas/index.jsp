<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="es">
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
                <h3>Usuarios registrados</h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_content">                    
                    <div class="row">
                      <div class="col-sm-12">
                        <div class="card-box table-responsive">
                          <table id="datatable" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                              <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Película</th>
                                <th>Cine</th>
                                <th>Sala</th>
                                <th>Tipo</th>
                                <th>Precio</th>
                                <th>Fecha registro</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td>1</td>
                                <td>Ivan Robles</td>
                                <td>Venom, let there be Carnage</td>
                                <td>UVK Larcomar</td>
                                <td>9</td>
                                <td>2D</td>
                                <td>25.00</td>
                                <td>19/02/2021</td>
                                <td>
                                  Por confirmar
                                </td>
                                <td width="140">
                                  <div class="admin-actions">
                                    <a href="" data-id="" class="btn btn-success text-left" style="width: 100%;"><i class="fa fa-check"></i>&nbsp;&nbsp;Confirmar</a>
                                  </div>
                                </td>
                              </tr>
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

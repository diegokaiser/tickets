<%@page import="com.miempresa.entidades.Cine"%>
<%
Cine cine = (Cine)request.getSession().getAttribute("cine");
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
                        <h3>Editar a <%=cine.getNombre()%></h3>
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
                                            <input type="hidden"  id="idPelicula" name="idPelicula" value="<%=cine.getNombre()%>">
                                            <h2>Editar</h2>
                                            
                                            <div class="form-group pt-4">
                                                <label for="nombre">Nombre:</label>
                                                <input type="text" class="form-control" id="nombre" name="nombre" value="<%=cine.getDireccion()%>">
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="duracion">Dirección</label>
                                                <input type="text" class="form-control" id="duracion" name="duracion" value="<%=cine.getLogo()%>">
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="fechaEstreno">Logo</label>
                                                <input type="text" class="form-control" id="fechaEstreno" name="fechaEstreno" value="<%=cine.getEstado()%>">
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="idioma">Estado</label>
                                                <input type="text" class="form-control" id="idioma" name="idioma" value="<%=cine.getEstado()%>">
                                            </div>                                                                                                                           
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-primary btn-block my-4">Actualiza</button>
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
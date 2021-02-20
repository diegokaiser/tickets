<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.miempresa.entidades.Pelicula"%>
<%
  Pelicula pelicula = (Pelicula) request.getSession().getAttribute("pelicula");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <%@ include file="../WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/styles.jsp" %>
    <title><%=pelicula.getNombre()%>  | Solo Estrenos</title>
  </head>
  <body>
    <div class="bkg_video">
      <video autoplay loop poster="<%=request.getContextPath()%>/RESOURCES/images/<%=pelicula.getPortadaDestacada()%>">
        <source src="<%=request.getContextPath()%>/RESOURCES/images/bkg_video.webm">
      </video>
    </div>
    <div class="content" data-estado="<%=pelicula.getEstado()%>">
      <%@ include file="../WEB-INF/jspf/web/header.jsp" %>
      <div class="form">
        <!-- este form envia datos, los datos a enviarse vienen del form anterior y este muestra los datos anteriores y los envia a la ddbb -->
        <form action="<%=request.getContextPath()%>/EntradaController" method="POST">
          <input type="hidden" id="processing" name="processing" value="comprarEntrada">
          <h2 class="text-center">Valida tus datos!</h2>
          <h4 class="text-center">"<%=pelicula.getNombre()%>"</h4>
          <h4 data-estreno="<%=pelicula.getFechaEstreno()%>" id="fechaEstreno" class="text-center">Estreno el <span id="fecha"></span></h4>
          <!-- Si se estrena en varios cines -->
          <div class="form-group mt-5">
            <label for="idCine">Elegir cine:</label>
            <select class="form-control" name="idCine" id="idCine">
              <option selected>Obtener el cine</option>
            </select>
          </div>
          <!-- y si se proyecta en más de una sala -->
          <div class="form-group">
            <label for="idSala">Elegir sala</label>
            <select class="form-control" name="idSala" id="idSala">
              <option selected>Obtener la sala</option>
            </select>
          </div>
          <h4 class="mt-5">Entrada 1:</h4>          
          <div class="form-group pt-4">
            <label for="fullName1">Nombre Completo:</label>
            <input type="text" class="form-control" id="fullName1" value="obtener nombre">
          </div>
          <div class="form-group">
            <label for="nrodoc1">Documento de Identidad:</label>
            <input type="text" class="form-control" id="nrodoc1" value="obtener numero doc">
          </div>
          <!-- si existe entrada 2 -->
          <h4 class="mt-5">Entrada 2:</h4>
          <div class="form-group pt-4">
            <label for="fullName2">Nombre Completo:</label>
            <input type="text" class="form-control" id="fullName2" value="obtener nombre 2">
          </div>
          <div class="form-group">
            <label for="nrodoc2">Documento de Identidad:</label>
            <input type="text" class="form-control" id="nrodoc2" value="obtener numero doc 2">
          </div>
          
          <div class="form-group">
            <button type="submit" class="btn btn-primary my-4">Comprar entrada</button>
            <a href="<%=request.getContextPath()%>/EntradaController?processing=cancelarEntrada" class="btn btn-danger">Cancelar</a>
          </div>
        </form>
      </div>
    </div>
    <%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
    <script type="text/javascript">
      var fechaEstreno = document.getElementById('fechaEstreno');
      var fechaTotal = fechaEstreno.dataset.estreno;
      var fechaA = fechaTotal.split(" ");
      var fechaB = fechaEstreno.dataset.pri = fechaA[0];
      var fechaC = fechaB.replace("-", "/");
      var fechaD = fechaC.replace("-", "/");
      $("#fecha").text(fechaD);
    </script>
</html>

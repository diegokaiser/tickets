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
    <title>Comprar entrada para: <%=pelicula.getNombre()%>  | Solo Estrenos</title>
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
        <!-- este form NO envia datos a la ddbb, los sesiona y los envia al siguiente form -->
        <form action="<%=request.getContextPath()%>/EntradaController" method="POST">
          <input type="hidden" id="processing" name="processing" value="verificarEntrada">

          <h2>Entradas para:</h2>
          <h4 class="text-center">"<%=pelicula.getNombre()%>"</h4>
          <h4 data-estreno="<%=pelicula.getFechaEstreno()%>" id="fechaEstreno" class="text-center">Estreno el <span id="fecha"></span></h4>
          <!-- Si se estrena en varios cines -->
          <div class="form-group mt-5">
            <label for="idCompra">Elegir cine:</label>
            <select class="form-control" name="idCompra" id="idCompra">
              <c:forEach var="cine" items="${cines}">                                
                <option value="${cine.idCine}">${cine.nombreCine}</option>
              </c:forEach>
            </select>
          </div>
          <!-- y si se proyecta en más de una sala -->
          <div class="form-group">
            <label for="idSala">Elegir sala</label>
            <select class="form-control" name="idSala" id="idSala">
              <!-- aqui necesitamos tener el id del padre, osea el  idCine -->
              <c:choose>
                <c:when test="${cine.idCine == sala.idCine}">
                  <c:forEach var="sala" items="${salas}">                                
                    <option value="${sala.idSala}">Sala ${sala.numero}</option>
                  </c:forEach>
                </c:when>
                <c:otherwise></c:otherwise>
              </c:choose>              
            </select>
          </div>
          <div class="form-group pt-4">
            <label for="numeroEntradas">Numero Entradas</label>
            <input type="number" class="form-control" id="numeroEntradas">
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary my-4">Comprar entrada</button>
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
  </body>
</html>

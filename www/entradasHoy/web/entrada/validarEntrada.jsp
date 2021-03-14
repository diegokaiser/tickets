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
          <p class="text-center my-4">Por favor, valida los datos para tus entradas:</p>
          <table class="table table-striped table-dark">
            <tbody class="text-white">
              <tr>
                <td>Cine:</td>
                <td ><%= request.getAttribute("idCine") %></td>
              </tr>
              <tr>
                <td>Nombre:</td>
                <td><%=session.getAttribute("nombre")%></td>
              </tr>
              <tr>
                <td>Apellido:</td>
                <td><%=session.getAttribute("apellido")%></td>
              </tr>
              <tr>
                 <td>Tipo de documento</td>
                 <c:set var = "tDocumento"  value = "<%=session.getAttribute("tipoDocumento")%>"/>
                  <c:choose>
                  <c:when test="${tDocumento==1}">
                  <td>DNI</td>  
                  </c:when>    
                  <c:otherwise>
                   <td>Pasaporte</td>
                  </c:otherwise>
              </c:choose>
              </tr>
              

              <tr>
                 <td>Numero de documento</td>
                <td><%=session.getAttribute("numeroDocumento")%></td>
              </tr>              
              <tr>
                <td>Entradas:</td>
                <td><%= request.getAttribute("numeroEntradas") %></td>
              </tr>
            </tbody>
          </table>
          <p class="text-center my-4">Si todos los datos son correctos, procede con la compra de tus entradas</p>
          <a href="<%=request.getContextPath()%>/entrada/comprarEntrada.jsp" class="btn btn-primary my-4">Proceder con la compra</a>
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

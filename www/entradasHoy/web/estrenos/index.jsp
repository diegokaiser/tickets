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
    <div class="content">
      <%@ include file="../WEB-INF/jspf/web/header.jsp" %>

      <div class="banner-destacado">
        <div class="img">
          <img src="<%=request.getContextPath()%>/RESOURCES/images/<%=pelicula.getPortadaDestacada()%>" alt="<%=pelicula.getNombre()%>">
        </div>
        <div class="contenido">

          <div class="titulo">
            <h2><%=pelicula.getNombre()%></h2>
          </div>
          <div class="timing">
            <span><%=pelicula.getDuracion()%></span>
          </div>
          <div class="descripcion">
            <p>
              <%=pelicula.getDescripcion()%>
            </p>
          </div>
          <div class="info">
            <p>
              <strong>Protagonizan: </strong><%=pelicula.getProtagonistas()%>
            </p>
            <p>
              <strong>Género: </strong><%=pelicula.getGenero()%>
            </p>
          </div>
          <div class="cta">
            <c:set var="dato" value="<%=pelicula.getEstado()%>" />
            <c:choose>
              <c:when test="${dato == 1}">
                <a href="<%=request.getContextPath()%>/EntradaController?processing=seleccionarEntrada&idPelicula=<%=pelicula.getIdPelicula()%>" data-id="<%=pelicula.getIdPelicula()%>">
                  <i class="fas fa-play"></i>Comprar entradas
                </a>
              </c:when>
              <c:otherwise>
                <a href="<%=request.getContextPath()%>/EntradaController?processing=crearAviso&idPelicula=<%=pelicula.getIdPelicula()%>" data-id="<%=pelicula.getIdPelicula()%>">
                  <i class="far fa-clock"></i>
                  <!--<strong>Faltan: </strong>-->
                  <span id="fechaEstreno" data-estreno="<%=pelicula.getFechaEstreno()%>" data-pri="" data-sec=""></span>
                </a>
              </c:otherwise>
            </c:choose>            
          </div>
          <div class="playtrailer">
            <a href="<%=pelicula.getTrailer()%>" target="_blank">
              <i class="far fa-play-circle"></i>
              Ver trailer
            </a>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/_script_countdownjs.jsp" %>
    <script type="text/javascript">
      var fechaEstreno = document.getElementById('fechaEstreno');
      var fechaTotal = fechaEstreno.dataset.estreno;
      var fechaA = fechaTotal.split(" ");
      var fechaB = fechaEstreno.dataset.pri = fechaA[0];
      var fechaC = fechaB.replace("-", "/")
      var fechaD = fechaC.replace("-", "/")
      $('#fechaEstreno').countdown(fechaD + ' 23:59:59', function (event) {
        $(this).html(event.strftime('Faltan %d días, %H horas y %M minutos'));
      });
      console.log(fechaD); 
    </script>
</html>

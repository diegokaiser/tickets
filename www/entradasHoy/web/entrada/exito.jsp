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
    <div class="content">
      <%@ include file="../WEB-INF/jspf/web/header.jsp" %>
      <div class="form">
        <form class="pt-5">
          <div class="user-messages pt-5">
            <h2 class="text-center my-2">Gracias por su compra.</h2>
            <p class="text-center text-white mt-3">Recuerda, los códigos de las entradas puden ser reclamadas por cualquier persona, ten cuidado con ellas.</p>
            <p class="text-center text-white mt-3">Código de ticket: <span>181818</span></p>
            <p class="text-center text-white">Código de ticket: <span>171717</span></p>
            <a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-block btn-success my-4"> Gracias!</a>
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

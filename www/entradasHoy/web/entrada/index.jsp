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
        <form action="<%=request.getContextPath()%>/EntradaController" method="POST">
          <input type="hidden" id="processing" name="processing" value="comprarEntrada">
          <h2>Entradas para:</h2>
          <h4><%=pelicula.getNombre()%></h4>
          <label>Entrada 1:</label>
          <div class="form-group pt-4">
            <label for="fullName1">Nombre Completo:</label>
            <input type="text" class="form-control" id="fullName1">
          </div>
          <div class="form-group">
            <label for="tipodoc1">Tipo de Documento de Identidad:</label>
            <select class="form-control" name="tipodoc1" id="tipodoc1">
              <option value="0">Seleccionar</option>
              <option value="1">DNI</option>
              <option value="2">C.E</option>
            </select>
          </div>
          <div class="form-group">
            <label for="nrodoc1">Documento de Identidad:</label>
            <input type="text" class="form-control" id="nrodoc1">
          </div>

          <label>Entrada 2:</label>
          <div class="form-group pt-3">
            <label for="fullName2">Nombre Completo:</label>
            <input type="text" class="form-control" id="fullName2">
          </div>
          <div class="form-group">
            <label for="tipodoc2">Tipo de Documento de Identidad:</label>
            <select class="form-control" name="tipodoc2" id="tipodoc2">
              <option value="0">Seleccionar</option>
              <option value="1">DNI</option>
              <option value="2">C.E</option>
            </select>
          </div>
          <div class="form-group">
            <label for="nrodoc2">Documento de Identidad:</label>
            <input type="text" class="form-control" id="nrodoc2">
          </div>

          <div class="form-group">
            <button type="submit" class="btn btn-primary my-4">Comprar entrada</button>
          </div>
        </form>
      </div>
    </div>
    <%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
    <!--</body>-->
</html>

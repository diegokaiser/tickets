<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String nombre = request.getParameter("nombre");
  String correo = request.getParameter("correo");
  String authcode = request.getParameter("authcode");
%>
<html>
  <head>
    <%@ include file="../WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/styles.jsp" %>
    <title>Hola <%=nombre%>! Necesitamos validar tu correo | Solo Estrenos</title>
  </head>
  <body>
    <div class="bkg_video">
      <video autoplay loop poster="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webp">
        <source src="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webm">
      </video>
    </div>
    <div class="content">
      <%@ include file="../WEB-INF/jspf/web/header_.jsp" %>

      <div class="form" data-code="<%=authcode%>">
        <form action="<%=request.getContextPath()%>/UsuarioController" method="POST">
          <input type="hidden" id="processing" name="processing" value="validarUsuario">
          <div class="form-group pt-5">
            <h4 class="text-white text-center mt-3">¡Hola  <%=nombre%>!</h4>
            <p class="text-center mt-3">Necesitamos validar tu cuenta, por favor ingresa el código de verificación que te enviamos a tu correo (<%=correo%>).</p>
          </div>
          <div class="form-group pt-4">
            <label for="nombre">Código de verificación:</label>
            <input type="text" class="form-control" id="authcode" name="authcode">
          </div>
          <div class="form-group">
            <button id="verificar" type="submit" class="btn btn-primary btn-block my-4">Validar cuenta</button>
          </div>
        </form>
      </div>

    </div>
    <%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
  </body>
</html>


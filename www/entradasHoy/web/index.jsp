<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <%@ include file="WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="WEB-INF/jspf/web/styles.jsp" %>
    <title>Acceso de usuarios | Solo Estrenos</title>
  </head>
  <body>
    <div class="bkg_video">
      <video autoplay loop poster="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webp">
        <source src="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webm">
      </video>
    </div>
    <div class="content">
      <%@ include file="WEB-INF/jspf/web/header.jsp" %>
      <div class="form">
        <form action="<%=request.getContextPath()%>/UsuarioController" method="POST">
          <input type="hidden" id="processing" name="processing" value="login">
          <h2>Accede a tu cuenta</h2>
          <div class="form-group">
            <label for="correo">Usuario</label>
            <input type="text" class="form-control" id="correo" name="correo">
          </div>
          <div class="form-group">
            <label for="contrasena">Contraseña:</label>
            <input type="password" class="form-control" id="contrasena" name="contrasena">
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-success btn-block">Iniciar Sesión</button>
          </div>
          <div class="form-group mt-4">
            <p>Sí no estás registrado, puedes:</p>
          </div>
          <div class="form-group">
            <a href="<%=request.getContextPath()%>/registro/index.jsp" class="btn btn-primary btn-block">Crear cuenta</a>
          </div>
        </form>
      </div>

    </div>
    <%@ include file="WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="WEB-INF/jspf/web/scripts.jsp" %>    
  </body>
</html>
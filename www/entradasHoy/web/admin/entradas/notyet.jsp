<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="WEB-INF/jspf/web/styles.jsp" %>
    <title>Aun no... | Solo Estrenos</title>
  </head>
  <div class="content">
    <%@ include file="../includes/header.jsp" %>

    <div class="banner-destacado">
      <div class="img">
        <img src="<%=request.getContextPath()%>/resources/images/blackwidow_banner-dest.webp" alt="">
      </div>
      <div class="contenido">
        <div class="titulo">
          <!-- debe obtener el titulo de la vista anterior -->
          <h2>Black Widow</h2>
        </div>
        <div class="timing">
          <!-- debe obtener el tiempo de la vista anterior -->
          <span>2hr:22mins</span>
        </div>
        <div class="descripcion">
          <!-- debe obtener la descripción de la vista anterior -->
          <p>
            Al nacer, la Viuda Negra, también conocida como Natasha Romanova, se entrega a la KGB para
            convertirse en su agente definitivo. Cuando la URSS se separa, el gobierno intenta matarla
            mientras la acción se traslada a la actual Nueva York.
          </p>
        </div>
        <div class="cta">
          <!-- enlace a registrarse al newsletter -->
          <a href="#">
            <!-- debe obtener el tiempo restante de la pelicula -->
            <i class="far fa-clock"></i><strong>Faltan: </strong>21 días, 14 horas y 7 minutos
          </a>
        </div>
      </div>
    </div>

    <%@ include file="WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="WEB-INF/jspf/web/scripts.jsp" %>
    <script>
      $(window).on('load', function () {
        app.basics.header();
      });
    </script>
  </body>
</html>

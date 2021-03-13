<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <%@ include file="../WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/styles.jsp" %>
    <title>¡Buena! | Solo Estrenos</title>
  </head>
  <body>
    <div class="bkg_video">
      <video autoplay loop poster="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webp">
        <source src="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webm">       
      </video>
    </div>
    <div class="content">
      <%@ include file="../WEB-INF/jspf/web/header_.jsp" %>
      <div class="container">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-5">
            <h2 class="text-white text-center my-4">¡Genial!</h2>
            <h4  class="text-white text-center mt-3" >Has creado una alerta con éxito.</h4>
          </div>
        </div>
      </div>
    </div>

    <%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
  </body>
</html>

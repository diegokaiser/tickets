<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%@ include file="../WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/styles.jsp" %>
    <title>Comprar entrada para: {pelicula.getNombre()}  | Solo Estrenos</title>
  </head>
  <body>
    <div class="bkg_video">
      <video autoplay loop poster="<%=request.getContextPath()%>/RESOURCES/images/{pelicula.getPortadaDestacada()}">
        <source src="<%=request.getContextPath()%>/RESOURCES/images/bkg_video.webm">
      </video>
    </div>
    <div class="content">
      <%@ include file="../WEB-INF/jspf/web/header.jsp" %>
      <div class="form">
        <form>
          <input type="hidden" id="processing" name="processing" value="validarCompra">
          <h2>Entradas para:</h2>
          <div class="form-group pt-4">
            <label for="card-number">Número de tarjeta:</label>
            <input type="text" class="form-control" id="card-number">
          </div>
          <div class="form-row form-group">
            <div class="col">
              <label for="card-date">Mes/Año:</label>
              <input type="text" class="form-control" id="card-date">
            </div>
            <div class="col">
              <label for="card-cvv">CVV:</label>
              <input type="password" class="form-control" id="card-cvv">
            </div>
          </div>
          <div class="form-group">
            <label for="email">Correo electrónico:</label>
            <input type="text" class="form-control" id="email">
          </div>
          <div class="form-group">
            <a href="<%=request.getContextPath()%>/entrada/exito.jsp" class="btn btn-primary my-4">Pagar {precio}</a>
          </div>
        </form>
      </div>
    </div>
    <%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
  </body>
</html>

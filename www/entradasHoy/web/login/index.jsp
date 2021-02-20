<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String user = request.getParameter("correo");%>
<html>
  <head>
    <%@ include file="../WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/styles.jsp" %>
    <title>Solo Estrenos</title>
  </head>
  <body data-basePath="<%=request.getContextPath()%>">
    <div  class="preloader">
      <div class="preloader-content">
        <div class="logo"></div>
      </div>
    </div>
    <div class="content nobg">
      <%@ include file="../WEB-INF/jspf/web/header.jsp" %>
      <!-- destacado, banner hero -->
      <div class="banner-destacado">
        <c:forEach var="s" items="${screen}">
        <div class="img">
          <img src="<%=request.getContextPath()%>/RESOURCES/images/${s.portadaDestacada}" alt="">
        </div>
        <div class="contenido">
          <div class="titulo">
            <h2>${s.nombre}</h2>
          </div>
          <div class="timing">
            <span>${s.duracion}</span>
          </div>
          <div class="descripcion">
            <p>
              ${s.descripcion}
            </p>
          </div>
          <div class="info">
            <p>
              <strong>Protagonizan: </strong>${s.protagonistas}
            </p>
            <p>
              <strong>Género: </strong>${s.genero}
            </p>
          </div>
          <div class="cta">
            <a href="<%=request.getContextPath()%>/PeliculaController?processing=getPelicula&idPelicula=${s.idPelicula}" data-id="${s.idPelicula}"><i class="fas fa-play"></i>Comprar entradas</a>
          </div>
          <div class="playtrailer">
            <a href="${s.trailer}" target="_blank">
              <i class="far fa-play-circle"></i>
              Ver trailer
            </a>
          </div>
        </div>
        </c:forEach>
      </div>
      <c:set var="dato" value="<%=user%>" />
      <c:choose>
        <c:when test="${not empty dato}">
          <div class="home-grid">
            <div class="container-fluid">
              <div class="row">
                <div class="col">
                  <h3>Últimos estrenos</h3>
                </div>
                <div class="col text-right">
                  <a href="#" class="ver-todos">
                    Ver todos
                  </a>
                </div>
              </div>
              <div class="row">
                <c:forEach var="a" items="${lastest}">
                  <div class="col-sm-12 col-md-6 col-lg-3 pt-4">
                    <div class="home-movie">
                      <div class="img">
                        <img src="<%=request.getContextPath()%>/RESOURCES/images/${a.portada}.jpg" alt="${a.nombre}">
                      </div>
                      <div class="contenido">
                        <div class="titulo">
                          <h4>${a.nombre}</h4>
                        </div>
                        <div class="timing">
                          <span>${a.duracion}</span>
                        </div>
                        <div class="cta">
                          <a href="<%=request.getContextPath()%>/PeliculaController?processing=getPelicula&idPelicula=${a.idPelicula}"
                             data-id="${a.idPelicula}"
                             data-title="${a.nombre}"
                             data-timing="${a.duracion}"
                             data-sinopsis="${a.descripcion}"
                             data-starring="${a.protagonistas}"
                             data-genre="${a.genero}"
                             data-trailer="${a.trailer}">
                            <i class="fas fa-play"></i>Comprar entradas
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>
            <div class="container-fluid">
              <div class="row">
                <div class="col">
                  <h3>Próximos estrenos</h3>
                </div>
                <div class="col text-right">
                  <a href="#" class="ver-todos">
                    Ver todos
                  </a>
                </div>
              </div>
              <div class="row">
                <c:forEach var="b" items="${commingSoon}">
                  <div class="col-sm-12 col-md-6 col-lg-3 pt-4">
                    <div class="home-movie">
                      <div class="img">
                        <img src="<%=request.getContextPath()%>/RESOURCES/images/${b.portada}.jpg" alt="${b.nombre}">
                      </div>
                      <div class="contenido">
                        <div class="titulo">
                          <h4>${b.nombre}</h4>
                        </div>
                        <div class="timing">
                          <span>${b.duracion}</span>
                        </div>
                        <div class="cta">
                          <a href="<%=request.getContextPath()%>/PeliculaController?processing=getPelicula&idPelicula=${b.idPelicula}"
                             data-id="${b.idPelicula}"
                             data-title="${b.nombre}"
                             data-timing="${b.duracion}"
                             data-sinopsis="${b.descripcion}"
                             data-starring="${b.protagonistas}"
                             data-genre="${c.genero}"
                             data-trailer="${b.trailer}">
                            <i class="fas fa-play"></i>Comprar entradas
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>
            <div class="container-fluid">
              <div class="row">
                <div class="col">
                  <h3>Recomendados</h3>
                </div>
                <div class="col text-right">
                  <a href="#" class="ver-todos">
                    Ver todos
                  </a>
                </div>
              </div> 
              <div class="row">
                <c:forEach var="c" items="${recommended}">
                  <div class="col-sm-12 col-md-6 col-lg-3 pt-4">
                    <div class="home-movie">
                      <div class="img">
                        <img src="<%=request.getContextPath()%>/RESOURCES/images/${c.portada}.jpg" alt="${c.nombre}">
                      </div>
                      <div class="contenido">
                        <div class="titulo">
                          <h4>${c.nombre}</h4>
                        </div>
                        <div class="timing">
                          <span>${c.duracion}</span>
                        </div>
                        <div class="cta">
                          <a href="<%=request.getContextPath()%>/PeliculaController?processing=getPelicula&idPelicula=${c.idPelicula}"
                             data-id="${c.idPelicula}"
                             data-title="${c.nombre}"
                             data-timing="${c.duracion}"
                             data-sinopsis="${c.descripcion}"
                             data-starring="${c.protagonistas}"
                             data-genre="${c.genero}"
                             data-trailer="${c.trailer}">
                            <i class="fas fa-play"></i>Comprar entradas
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>
          </div>
        </c:when>
        <c:otherwise>
          <% response.sendRedirect("request.getContextPath()/index.jsp"); %>
        </c:otherwise>
      </c:choose>

    </div>
    <%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
    <script>
      $(window).on('load', function () {
        app.basics.header();
      });
    </script>
  </body>
</html>

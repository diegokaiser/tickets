<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%@ include file="WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="WEB-INF/jspf/web/styles.jsp" %>
    <title>Solo Estrenos</title>
  </head>
  <body data-basePath="<%=request.getContextPath()%>">
    <div  class="preloader">
      <div class="preloader-content">
        <div class="logo"></div>
      </div>
    </div>
    <div class="content nobg">
      <%@ include file="WEB-INF/jspf/web/header.jsp" %>
      <!-- destacado, banner hero -->
      <div class="banner-destacado">
        <div class="img">
          <img src="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webp" alt="">
        </div>
        <div class="contenido">
          <div class="titulo">
            <h2>Black Widow</h2>
          </div>
          <div class="timing">
            <span>2hr:22mins</span>
          </div>
          <div class="descripcion">
            <p>
              Al nacer, la Viuda Negra, también conocida como Natasha Romanova, se entrega a la KGB para
              convertirse en su agente definitivo. Cuando la URSS se separa, el gobierno intenta matarla
              mientras la acción se traslada a la actual Nueva York.
            </p>
          </div>
          <div class="info">
            <p>
              <strong>Protagonizan: </strong>Scarlett Johansson, FlorencePugh, David Harbour, Rachel Weisz
            </p>
            <p>
              <strong>Género: </strong>Ciencia ficción
            </p>
          </div>
          <div class="cta">
            <a href="<%=request.getContextPath()%>/notyet/index.jsp"><i class="fas fa-play"></i>Comprar entradas</a>
          </div>
          <div class="playtrailer">
            <a href="#">
              <i class="far fa-play-circle"></i>
              Ver trailer
            </a>
          </div>
        </div>
      </div>         
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
            <input type="hidden" id="loading" name="loading" value="lastest">
            <c:forEach var="pelicula" items="${sessionScope.pelicula}">
              <div class="col-sm-12 col-md-6 col-lg-3 pt-4">
                <div class="home-movie">
                  <div class="img">
                    <img src="<%=request.getContextPath()%>/RESOURCES/images/${pelicula.portada}" alt="${pelicula.nombre}">
                  </div>
                  <div class="contenido">
                    <div class="titulo">
                      <h4>${pelicula.nombre}</h4>
                    </div>
                    <div class="timing">
                      <span>${pelicula.duracion}</span>
                    </div>
                    <div class="cta">
                      <a href="<%=request.getContextPath()%>/estrenos/index.jsp"
                         data-title="${pelicula.nombre}"
                         data-timing="${pelicula.duracion}"
                         data-sinopsis="${pelicula.descripcion}"
                         data-starring="${pelicula.nombre}"
                         data-genre="}"
                         data-trailer="${pelicula.trailer}">
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
            <input type="hidden" id="loading" name="loading" value="commingSoon">
            <c:forEach var="pelicula" items="${sessionScope.pelicula}">
              <div class="col-sm-12 col-md-6 col-lg-3 pt-4">
                <div class="home-movie">
                  <div class="img">
                    <img src="<%=request.getContextPath()%>/RESOURCES/images/${pelicula.portada}" alt="${pelicula.nombre}">
                  </div>
                  <div class="contenido">
                    <div class="titulo">
                      <h4>${pelicula.nombre}</h4>
                    </div>
                    <div class="timing">
                      <span>${pelicula.duracion}</span>
                    </div>
                    <div class="cta">
                      <a href="<%=request.getContextPath()%>/notyet/index.jsp"
                         data-title="${pelicula.nombre}"
                         data-timing="${pelicula.duracion}"
                         data-sinopsis="${pelicula.descripcion}"
                         data-starring="${pelicula.nombre}"
                         data-genre="}"
                         data-trailer="${pelicula.trailer}">
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
            <input type="hidden" id="loading" name="loading" value="recommended">
            <c:forEach var="pelicula" items="${sessionScope.pelicula}">
              <div class="col-sm-12 col-md-6 col-lg-3 pt-4">
                <div class="home-movie">
                  <div class="img">
                    <img src="<%=request.getContextPath()%>/RESOURCES/images/${pelicula.portada}" alt="${pelicula.nombre}">
                  </div>
                  <div class="contenido">
                    <div class="titulo">
                      <h4>${pelicula.nombre}</h4>
                    </div>
                    <div class="timing">
                      <span>${pelicula.duracion}</span>
                    </div>
                    <div class="cta">
                      <a href="<%=request.getContextPath()%>/estrenos/index.jsp"
                         data-title="${pelicula.nombre}"
                         data-timing="${pelicula.duracion}"
                         data-sinopsis="${pelicula.descripcion}"
                         data-starring="${pelicula.nombre}"
                         data-genre="}"
                         data-trailer="${pelicula.trailer}">
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

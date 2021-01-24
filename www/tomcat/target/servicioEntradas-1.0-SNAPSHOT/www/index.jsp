<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 24/01/2021
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="includes/meta.jsp" %>
    <%@ include file="includes/styles.jsp" %>
    <title>Title</title>
</head>
<body>
    <div class="preloader">
        <div class="preloader-content">
            <div class="logo"></div>
        </div>
    </div>
    <div class="content">
        <!-- destacado, banner hero -->
        <div class="banner-destacado">
            <div class="img">
                <img src="resources/images/blackwidow_banner-dest.webp" alt="">
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
                    <a href="#">Comprar entradas</a>
                </div>
            </div>
            <div class="playtrailer">
                <a href="#">
                    <img src="" alt="">
                    Ver trailer
                </a>
            </div>
        </div>
        <!-- ultimos estrenos -->

        <!-- proximos estrenos -->

        <!-- recomendados -->
    </div>
    <%@ include file="includes/scripts.jsp" %>
</body>
</html>

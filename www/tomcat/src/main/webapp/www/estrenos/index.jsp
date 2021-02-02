<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 25/01/2021
  Time: 08:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../includes/meta.jsp" %>
    <link rel="stylesheet" href="./../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./../../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="./../../resources/fontawesome/css/all.min.css">
    <title>Black Widow | Solo Estrenos</title>
</head>
<body>
<div class="content">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light p-0">
            <a class="navbar-brand" href="">
                <img src="./../../resources/images/logo.svg "alt=""> Solo estrenos
            </a>
            <ul class="navbar-nav ml-auto">
                <li>
                    <a href="index.jsp">Home</a>
                </li>
                <li>
                    <a href="cines/index.jsp">Cines</a>
                </li>
            </ul>
        </nav>
    </header>

    <div class="banner-destacado">
        <div class="img">
            <img src="./../../resources/images/blackwidow_banner-dest.webp" alt="">
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
            <div class="info">
                <p>
                    <strong>Protagonizan: </strong>Scarlett Johansson, FlorencePugh, David Harbour, Rachel Weisz
                </p>
                <p>
                    <strong>Género: </strong>Ciencia ficción
                </p>
            </div>
            <div class="cta">
                <a href="./login/index.jsp"><i class="fas fa-play"></i>Comprar entradas</a>
            </div>
            <div class="playtrailer">
                <a href="#">
                    <i class="far fa-play-circle"></i>
                    Ver trailer
                </a>
            </div>
        </div>
    </div>
</div>
<%@ include file="../includes/footer.jsp" %>
<script src="./../../resources/js/jquery-3.5.1.slim.min.js"></script>
<script src="./../../resources/js/popper.min.js"></script>
<script src="./../../resources/js/bootstrap.min.js"></script>
<script src="./../../resources/js/all.js"></script>
</body>
</html>

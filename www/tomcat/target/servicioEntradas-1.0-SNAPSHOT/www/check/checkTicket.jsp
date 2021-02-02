<%--
  Created by IntelliJ IDEA.
  User: JosueFlores
  Date: 29/01/2021
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../includes/meta.jsp" %>
    <link rel="stylesheet" href="./../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./../../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="./../../resources/fontawesome/css/all.min.css">
    <link rel="stylesheet" href=" ./../../resources/css/StyleJosue.css">
    <title>Mensaje adjuntar | Solo Estrenos</title>
</head>
<body>
    <div class="bkg_video">
        <video playsinline autoplay loop poster="./../../resources/images/blackwidow_banner-dest.webp">
            <source src="./../../resources/images/bkg_video.webm">
        </video>
    </div>
    <div class="content">
        <header>
            <nav class="navbar navbar-expand-lg navbar-light p-0">
                <a class="navbar-brand" href="">
                    <img src="./../../resources/images/logo.svg " alt=""> Solo estrenos
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

        <div class="container">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-5">
                    <h2 class="text-center my-2">Gracias por su compra.</h2>
                    <p class="text-center text-white mt-3">Recuerda, los códigos de las entradas puden ser reclamadas por cualquier persona, ten cuidado con ellas.</p>
                    <p class="text-center text-white mt-3">Código de ticket: <span>181818</span></p>
                    <p class="text-center text-white">Código de ticket: <span>171717</span></p>
                    <button class="btn btn-block btn-success my-4"> Aceptar</button>
                </div>
            </div>
        </div>
    </div>

</body>

<%@ include file="../includes/footer.jsp" %>
<script src="./../../resources/js/jquery-3.5.1.slim.min.js"></script>
<script src="./../../resources/js/popper.min.js"></script>
<script src="./../../resources/js/bootstrap.min.js"></script>
<script src="./../../resources/js/all.js"></script>
</body>
</html>

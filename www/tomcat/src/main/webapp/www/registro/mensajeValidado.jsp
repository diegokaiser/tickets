<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../includes/meta.jsp" %>
    <link rel="stylesheet" href="./../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./../../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="./../../resources/fontawesome/css/all.min.css">
    <link rel="stylesheet" href=" ./../../resources/css/StyleJosue.css">
    <title>¡Validado! | Solo Estrenos</title>
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

    <%--    <div class="form">--%>
    <%--        <form action="">--%>
    <div class="container">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-5">
                <h2 class="text-white text-center my-4">¡Validado!</h2>
                <h4 class="text-white text-center mt-3">Gracias {nombre}, tu cuenta ha sido validada al confirmar que el correo electrónico brindado es real y te pertecene.</h4>
                <h4 class="text-white text-center">Nos comunicaremos contigo cuando la venta al público esté abierta.</h4>
                <p class="text-center my-4">Sólo usaremos tu correo para este aviso. No lo guardaremos para el registro de ventas.</p>
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

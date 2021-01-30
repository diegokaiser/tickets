<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../includes/meta.jsp" %>
    <link rel="stylesheet" href="./../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./../../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="./../../resources/fontawesome/css/all.min.css">
    <link rel="stylesheet" href=" ./../../resources/css/StyleJosue.css">
    <title>¡Anotado! | Solo Estrenos</title>
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
                    <a href="estrenos/index.jsp">Estrenos</a>
                </li>
                <li>
                    <a href="cines/index.jsp">Cines</a>
                </li>
            </ul>
        </nav>
    </header>

    <%--    <div class="form">--%>
    <%--        <form action="">--%>
    <div class="container pb-2">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-5  ">
                <img src="./../../resources/images/logo.svg " alt="">
                <h2 class="my-4 text-white">¡Anotado!</h2>
                <h2 class="text-white">Gracias {nombre}, apenas abramos la venta al público te avisaremos para que puedas comprar tu entrada...junto a todos, todos los demás</h2>
                <h2 class="text-white">Necesitarás validar tu correo electrónico para estar seguros de tu identidad.</h2>


                <p>Sólo usaremos tu correo para este aviso. No lo guardaremos para el registro de ventas.</p>
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

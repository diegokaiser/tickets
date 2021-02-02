<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../includes/meta.jsp" %>
    <link rel="stylesheet" href="./../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./../../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="./../../resources/fontawesome/css/all.min.css">
    <link rel="stylesheet" href=" ./../../resources/css/StyleJosue.css">
    <title>¡Apurate!  | Solo Estrenos</title>
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
                    <h2 class=" text-white text-center my-4">¡Apurate!</h2>
                    <div class="home-movie">
                        <div class="img">
                            <img src="./../../resources/images/blackwidow_banner.jpg" alt="">
                        </div>
                        <div class="contenido">
                            <div class="titulo">
                                <h4>Black Widow</h4>
                            </div>
                            <div class="timing">
                                <span>2hr:22mins</span>
                            </div>
                        </div>
                    </div>

                    <p class="text-white text-center">La venta de entradas está abierta al público.</p>
                    <p class="text-white text-center">Recuerda que puedes comprar dos entradas por persona*</p>

                    <button class="btn btn-block btn-success my-4 ">Comprar una entrada</button>
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

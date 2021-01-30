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
        <%@ include file="../includes/header.jsp" %>
        <div class="container-fluid " style="height: 70px"></div>


        <div class="container pb-5">
            <div class="row justify-content-center align-items-center h-100 pb-5">
                <div class="col-5 pb-5">
                    <img src="./../../resources/images/logo.svg " alt="">
                    <h2 class="my-2 ">Lo sentimos, la compra no ha sido validada.</h2>
                    <p>El archivo del comprobante adjunto no es valido o el plazo de las 24 horas a culminado .</p>
                    <button class="btn btn-block btn-success my-4 "> Aceptar</button>
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

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
    <link rel="stylesheet" href=" ./../../resources/css/StyleJosue.css">
    <title>Mensaje adjuntar | Solo Estrenos</title>
</head>
<body>
<div class="content">
    <%@ include file="../includes/header.jsp" %>
    <div class="container-fluid " style="height: 70px"></div>

    <div class="container pb-5">
        <div class="row justify-content-center align-items-center h-100 pb-5">
            <div class="col-5 pb-5">
                <img src="./../../resources/images/logo.svg " alt="">
                <h2 class="my-2">Gracias por confiar en nosotros, en breve te enviaremos
                    la confirmación.</h2>
                <h2>Juan Garcia</h2>
                <label>Código de compra</label>
                <p>7352376</p>
                <button class="btn btn-block btn-success mt-4 "> Aceptar</button>

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

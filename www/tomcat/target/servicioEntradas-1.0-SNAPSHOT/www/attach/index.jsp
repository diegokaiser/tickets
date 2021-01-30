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


    <div class="container pb-2">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-5  ">
                <img src="./../../resources/images/logo.svg " alt="">
                <h2 class="my-4">Confirmar la compra de tus entradas.</h2>
                <p >Gracias por la compra. Acercate a un agente de banco cercano y cancela tu entrada.
                    Recuerda que tienes un plazo de 24h para poder hacerlo , en caso contrario perderas la
                    reserva.</p>
                <label>Código de compra:</label>
                <p>7352376</p>
                <button class="btn btn-block btn-success "> Adjuntar comprobante</button>

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

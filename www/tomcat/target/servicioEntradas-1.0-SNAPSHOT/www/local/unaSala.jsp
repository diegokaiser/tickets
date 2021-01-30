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
    <title>Sala de Cine | Solo Estrenos</title>
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
                        <a href="variasSalas.jsp">Home</a>
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


        <div class="form">
            <form action="">
                <h1>¡Perfecto!</h1>


                <div class="form-group">
                    <p>Hey <label>Nombre</label>! <br> Ten en cuenta que el estreno se llebara a cabo en: <label>Ubicación - Sala - Cine</label>
                    </p>
                </div>

            </form>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
    <script src="./../../resources/js/jquery-3.5.1.slim.min.js"></script>
    <script src="./../../resources/js/popper.min.js"></script>
    <script src="./../../resources/js/bootstrap.min.js"></script>
    <script src="./../../resources/js/all.js"></script>
</body>
</html>

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
    <title>Acceso de usuarios | Solo Estrenos</title>
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

        <div class="form">
            <form action="">
                <h2>Accede a tu cuenta</h2>
                <div class="form-group pt-4">
                    <label for="name">Nombre:</label>
                    <input type="text" class="form-control" id="name">
                </div>
                <div class="form-group">
                    <label for="lastname">Apellido:</label>
                    <input type="text" class="form-control" id="lastname">
                </div>
                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="recordarme">
                        <label class="form-check-label" for="recordarme">
                            Recordarme
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <p>Sí no estás registrado, puedes:</p>
                </div>
                <div class="form-group">
                    <a href="../registro/index.jsp" class="btn btn-primary btn-block">Crear cuenta</a>
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

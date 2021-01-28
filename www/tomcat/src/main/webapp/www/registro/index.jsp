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
    <title>Registro | Solo Estrenos</title>
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
                        <a href="estrenos/index.jsp">Estrenos</a>
                    </li>
                    <li>
                        <a href="cines/index.jsp">Cines</a>
                    </li>
                </ul>
            </nav>
        </header>
        <div class="form">
            <form action="UsuarioController" method="POST">
                <h2>Registrarse</h2>
                <div class="form-group pt-4">
                    <label for="name">Nombre:</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="lastname">Apellido:</label>
                    <input type="text" class="form-control" id="lastname">
                </div>
                <div class="form-group">
                    <label for="tipodoc">Tipo de Documento de Identidad:</label>
                    <select class="form-control" name="tipodoc" id="tipodoc">
                        <option value="0">Seleccionar</option>
                        <option value="1">DNI</option>
                        <option value="2">C.E</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="nrodoc">Documento de Identidad:</label>
                    <input type="text" class="form-control" id="nrodoc">
                </div>
                <div class="form-group">
                    <label for="email">Correo electrónico:</label>
                    <input type="text" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="text" class="form-control" id="password">
                </div>
                <div class="form-group">
                    <label for="repassword">Confirmar contraseña:</label>
                    <input type="text" class="form-control" id="repassword">
                </div>
                <div class="form-group pt-4">
                    <button type="submit" class="btn btn-primary">Registrarse</button>
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

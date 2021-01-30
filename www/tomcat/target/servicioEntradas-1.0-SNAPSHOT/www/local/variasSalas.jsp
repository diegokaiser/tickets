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
                <h2>Elegir una sala de cine</h2>


                <div class="form-group">
                    <label for="cine">Cine:</label>
                    <select class="form-control" name="cine" id="cine">
                        <option value="0">Seleccionar</option>
                        <option value="1">Cineplanet</option>
                        <option value="2">Cinemark</option>
                        <option value="2">Cinepolis</option>
                        <option value="2">Cinestar</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="lugar">Lugar:</label>
                    <select class="form-control" name="lugar" id="lugar">
                        <option value="0">Seleccionar</option>
                        <option value="1">San Miguel</option>
                        <option value="2">San Isidro</option>
                        <option value="2">Miraflores</option>
                        <option value="2">La Molina</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="hora">Hora:</label>
                    <select class="form-control" name="hora" id="hora">
                        <option value="0">Seleccionar</option>
                        <option value="1">23:40</option>
                        <option value="2">23:55</option>
                    </select>
                </div>



                <div class="form-group pt-4">
                    <button type="submit" class="btn btn-primary">Aceptar</button>
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

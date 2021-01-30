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

    <link rel="stylesheet" href="./../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./../../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="./../../resources/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="./../../resources/css/StyleJosue.css">
    <link rel="stylesheet" href="">
    <title>Confirmación entradas | Solo estrenos</title>
</head>
<body>

    <%@ include file="../includes/header.jsp" %>
    <div class="container-fluid " style="height: 70px"></div>

    <div class="container pb-5">
        <div class="row justify-content-center align-items-center h-auto pb-5">
            <div class="col-5">
                <div class="container ">
                    <div class="row">
                        <div class="col-12 mt-5 pb-2">
                            <h2>Confirmación de entrada</h2>
                        </div>
                        <div class="col-12 col-md-6">
                            <div class="pt-4">
                                <label>Codigo de compra:</label>
                                <p>7352376</p>
                            </div>
                            <div>
                                <label>Nombre:</label>
                                <p>Juanito Garcia</p>
                            </div>
                            <div>
                                <label>Tipo de Documento de Identidad:</label>
                                <p>DNI</p>
                            </div>
                            <div>
                                <label>Documento de Identidad:</label>
                                <p>78597475</p>
                            </div>
                            <div>
                                <label>Pelicula:</label>
                                <p>Spiderman 3</p>
                            </div>
                        </div>

                        <div class="col-12 col-md-6">
                            <div class="pt-0 pt-md-4">
                                <label>Cine:</label>
                                <p>Cineplanet</p>
                                <p>San miguel</p>
                                <p>Av San Miguelito 19</p>
                            </div>
                            <div>
                                <label>Sala:</label>
                                <p>18</p>
                            </div>
                            <div>
                                <label>Numero de entradas:</label>

                                <p>2</p>
                            </div>
                            <div>
                                <label>Total a pagar:</label>
                                <p>S/ 42 </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="pt-4" >
                    <button class="btn btn-success btn-block mb-4">Confirmar</button>
                    <button class="btn btn-block btn-danger mb-5">Cancelar</button>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="../includes/footer.jsp" %>
<script src="./../../resources/js/jquery-3.5.1.slim.min.js"></script>
<script src="./../../resources/js/popper.min.js"></script>
<script src="./../../resources/js/bootstrap.min.js"></script>
<script src="./../../resources/js/all.js"></script>
</body>
</html>






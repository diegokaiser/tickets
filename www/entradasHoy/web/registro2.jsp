<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="WEB-INF/jspf/web/styles.jsp" %>
    <title>Registro | Solo Estrenos</title>
</head>
<body data-path="<%=request.getContextPath()%>">
    <div class="bkg_video">
        <video playsinline autoplay loop poster="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webp">
            <source src="<%=request.getContextPath()%>/RESOURCES/images/bkg_video.webm">
        </video>
    </div>
    <div class="content">
        <%@ include file="WEB-INF/jspf/web/header.jsp" %>

        <div class="form">
            <form action="UsuarioController" method="POST">
                <input type="hidden" id="processing" name="processing" value="registro">
                <h2>Registrarse</h2>
                <div class="form-group pt-4">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre">
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" id="apellido" name="apellido">
                </div>
                <div class="form-group">
                    <label for="tipodoc">Tipo de Documento de Identidad:</label>
                    <select class="form-control" name="tipoDocumento" id="tipodoc">
                        <option value="0">Seleccionar</option>
                        <option value="1">DNI</option>
                        <option value="2">C.E</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="numeroDocumento">Documento de Identidad:</label>
                    <input type="text" class="form-control" id="numeroDocumento" name="numeroDocumento">
                </div>
                <div class="form-group">
                    <label for="correo">Correo electrónico:</label>
                    <input type="text" class="form-control" id="correo" name="correo">
                </div>
                <div class="form-group">
                    <label for="contrasena">Contraseña:</label>
                    <input type="password" class="form-control" id="contrasena" name="contrasena">
                </div>
                <div class="form-group">
                    <label for="recontrasena">Confirmar contraseña:</label>
                    <input type="password" class="form-control" id="recontrasena" name="recontrasena">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block my-4">Registrarse</button>
                </div>
                <div class="form-group mt-4">
                    <p>Sí estás registrado, puedes:</p>
                </div>
                <div class="form-group">
                    <a href="<%=request.getContextPath()%>/login/index.jsp" class="btn btn-success btn-block">Iniciar Sesión</a>
                </div>
            </form>
        </div>
    </div>
    <%@ include file="WEB-INF/jspf/web/footer.jsp" %>
    <%@ include file="WEB-INF/jspf/web/scripts.jsp" %>
</body>
</html>

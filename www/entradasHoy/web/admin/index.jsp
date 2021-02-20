<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/animate.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<%=request.getContextPath()%>/RESOURCES/admin/css/custom.min.css" rel="stylesheet">
</head>
<body class="login">
    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="<%=request.getContextPath()%>/UsuarioController" method="POST">
                    <input type="hidden" id="processing" name="processing" value="loginAdmin">
                    <h1>Entradas hoy</h1>
                    <div>
                        <input type="text" class="form-control" id="correo" name="correo" placeholder="Email" required="" />
                    </div>
                    <div>
                        <input type="password" class="form-control" id="contrasena" name="contrasena" placeholder="Contraseña" required="" />
                    </div>
                    <div>
                        <button type="submit" class="btn btn-success btn-block">Iniciar Sesión</button>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                    </div>
                </form>
            </section>
        </div>
    </div>
</body>
</html>
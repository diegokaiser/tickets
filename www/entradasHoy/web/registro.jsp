<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/meta.jspf" %>
        <title>JSP Page</title>
        <%@include file="WEB-INF/jspf/styles.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <%@include file="WEB-INF/jspf/navegacion.jspf" %>
        <section>
            <div class ="container-fluid">
                <div class="row">
                    <div class="col-lg-6 offset-lg-3">
                        <div class="card">
                            <h5 class="card-header"><i class="fas fa-user-plus"></i> &nbsp;Registro</h5>
                            <div class="card-body">
                                <h5 class="card-title">Registro de Usuario </h5>
                                <form action="UsuarioController" method="POST">
                                    <input type="hidden" id="processing" name="processing" value="registro">
                                    <div class="mb-3">
                                        <label for="txtUsuario" class="form-label"><i class="fas fa-marker"></i>&nbsp;&nbsp;Nombre de Usuario</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" required="" placeholder="Ingresar nombre de usuario">
                                
                                    </div>
                                    <div class="mb-3">
                                        <label for="txtClave" class="form-label"><i class="fas fa-lock"></i>&nbsp;&nbsp;Clave</label>
                                        <input type="password" class="form-control" id="contrasena" name="contrasena">
                                    </div>
                                    <div class="mb-3 form-check">
                                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                        <label class="form-check-label" for="exampleCheck1">Acepto todos los terminos y condiciones</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Registrar</button>
                                </form>
                            </div>
                        </div>
                    </div> 
                </div> 
            </div>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
    </body>
</html>

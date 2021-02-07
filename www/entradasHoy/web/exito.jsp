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
                            <h5 class="card-header">Featured</h5>
                            <div class="card-body">
                                <h5 class="card-title">Special title treatment</h5>
                                <div class="alert alert-info" role="alert">
                                    Se ha agrego correctamente los datos al sistema
                                    Bienvenido
                                </div>
                                <a href="#" class="btn btn-primary">Iniciar Sesión</a>
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

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
                            <div class="card-header">
                                <i class="fas fa-times"></i>&nbsp;&nbsp;  Error 
                            </div>
                            <br>
                            <br>
                            <div class="card-body">
                                <h5 class="card-title">Ha ocurrido el siguiente error</h5>
                                <div class="alert alert-danger" role="alert">
                                   Deberá de completar todos los campos
                                </div>
                                <a href="registro.jsp" class="btn btn-primary">Intentar Registrarse</a>
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

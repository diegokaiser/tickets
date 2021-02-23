<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.miempresa.entidades.Distrito"%>
<%@page import="java.util.List"%>
<% 
  List<Distrito> lista= (List<Distrito>)request.getSession().getAttribute("distritos");
  
//    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");  
 %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
     <a href="<%=request.getContextPath()%>/CineController?processing=listarDistritos" class="btn btn-primary text-left" style="width: 100%;"><i class="fa fa-check"></i>&nbsp;&nbsp;Abrir</a>
                                  <select class="form-select" name="departamento" aria-label="Default select example">
                             <option selected>Open this select menu</option>
                            <% 
                            for (Distrito distrito : lista) {
                            out.print("<option value="+distrito.getNombre()+">"+distrito.getNombre()+"</option>");                  
                            }
                            
                            %>
                        </select>
      <tbody> 
    <c:forEach var="distritos" items="${distritos}">
        <tr>
    <td>${distritos.getNombre}</td>
        </tr>
    </c:forEach>
</tbody>
    
    </body>
</html>

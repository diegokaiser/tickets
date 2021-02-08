<%@page import="com.miempresa.entidades.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
%>
<header>
    <nav class="navbar navbar-expand-lg navbar-light p-0">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">
            <img src="<%=request.getContextPath()%>/RESOURCES/images/logo.svg " alt=""><span>Solo estrenos</span>
        </a>
        <ul class="navbar-nav ml-auto">
            <li>
                <a href="../index.jsp">Home</a>
            </li>
            <li>
                <c:choose>
                    <c:when test="usuario != '' ">
                        ¡Bienvenido <strong><%=usuario.getNombre()%></strong>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=request.getContextPath()%>/registro/index.jsp">Login</a>
                    </c:otherwise>
                </c:choose>
                
            </li>
        </ul>
    </nav>
</header>
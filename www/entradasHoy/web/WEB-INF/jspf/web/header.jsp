<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String userCorreo = request.getParameter("correo");
  String userNombre = request.getParameter("nombre");
  String userApellido = request.getParameter("apellido");
%>
<header>
  <nav class="navbar navbar-expand-lg navbar-light p-0">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">
      <img src="<%=request.getContextPath()%>/RESOURCES/images/logo.svg " alt=""><span>Solo estrenos</span>
    </a>
    <c:set var="dato" value="<%=userCorreo%>" />
    <c:set var="nombre" value="<%=session.getAttribute("nombre")%>" />
    <c:choose>
      <c:when test="${not empty dato}">
        <ul class="navbar-nav ml-auto" data-dato="${dato}">
          <li>
            <p>¡Bienvenido, <%=session.getAttribute("nombre")%> <%=session.getAttribute("apellido")%>!</p>
          </li>
          <li>
            <a data-usercorreo="${dato}" href="<%=request.getContextPath()%>/HomeController?log=out">Logout</a>
          </li>
        </ul>
      </c:when>
      <c:when test="${nombre = null}">
        <ul class="navbar-nav ml-auto" data-dato="${dato}"></ul>
      </c:when> 
      <c:otherwise>
        <ul class="navbar-nav ml-auto" data-dato="${dato}"></ul>
      </c:otherwise>
    </c:choose>
  </nav>
</header>
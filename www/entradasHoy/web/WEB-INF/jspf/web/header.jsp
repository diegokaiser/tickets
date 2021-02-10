<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String userCorreo = request.getParameter("correo");%>
<header>
  <nav class="navbar navbar-expand-lg navbar-light p-0">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">
      <img src="<%=request.getContextPath()%>/RESOURCES/images/logo.svg " alt=""><span>Solo estrenos</span>
    </a>
    <ul class="navbar-nav ml-auto">
      <li>
        <a href="<%=request.getContextPath()%>/index.jsp">Home</a>
      </li>
      <li>
        <c:set var="dato" value="<%=userCorreo%>" />
        <c:choose>
          <c:when test="${empty dato}">
            <a data-usercorreo="${dato}" href="<%=request.getContextPath()%>/login/index.jsp">Login</a>
          </c:when>
          <c:otherwise>
            <a data-usercorreo="${dato}" href="<%=request.getContextPath()%>/HomeController?log=out">Logout</a>
          </c:otherwise>
        </c:choose>
      </li>
    </ul>
  </nav>
</header>
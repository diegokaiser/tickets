<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String userCorreo = request.getParameter("correo");%>
<header>
  <nav class="navbar navbar-expand-lg navbar-light p-0">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">
      <img src="<%=request.getContextPath()%>/RESOURCES/images/logo.svg " alt=""><span>Solo estrenos</span>
    </a>
    <c:set var="dato" value="<%=userCorreo%>" />
    <c:choose>
      <c:when test="${not empty dato}">
      <ul class="navbar-nav ml-auto" data-dato="${dato}">
        <li>
          <a href="<%=request.getContextPath()%>/index.jsp">Home</a>
        </li>
        <li>
          <!--<a data-usercorreo="${dato}" href="<%=request.getContextPath()%>/login/index.jsp">Login</a>-->  
          <a data-usercorreo="${dato}" href="<%=request.getContextPath()%>/HomeController?log=out">Logout</a>
        </li>
      </ul>
      </c:when>
      <c:otherwise>
      </c:otherwise>
    </c:choose>
  </nav>
</header>
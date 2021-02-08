<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../WEB-INF/jspf/web/meta.jsp" %>
    <%@ include file="../WEB-INF/jspf/web/styles.jsp" %>
    <title>¡Ches...! | Solo Estrenos</title>
</head>
<body>
<div class="bkg_video">
    <video playsinline autoplay loop poster="<%=request.getContextPath()%>/RESOURCES/images/blackwidow_banner-dest.webp">
        <source src="<%=request.getContextPath()%>/RESOURCES/images/bkg_video.webm">
    </video>
</div>
<div class="content">
    <%@ include file="../WEB-INF/jspf/web/header.jsp" %>

    <%--    <div class="form">--%>
    <%--        <form action="">--%>
    <div class="container">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-5">
                <h2 class="text-white text-center my-4">¡Ches...!</h2>
                <h4 class="text-white text-center mt-3">Hubo un problema con tus datos.</h4>
                <p class="text-center my-4">Por favor, revisalos e intenta nuevamente.</p>
                <a href="<%=request.getContextPath()%>/registro/index.jsp" class="btn btn-primary btn-block my-4">Intertar nuevamente</a>
            </div>
        </div>
    </div>
</div>



<%@ include file="../WEB-INF/jspf/web/footer.jsp" %>
<%@ include file="../WEB-INF/jspf/web/scripts.jsp" %>
</body>
</html>

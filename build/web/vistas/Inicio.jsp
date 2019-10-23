<%-- 
    Document   : Inicio
    Created on : 22/10/2018, 09:30:06 AM
    Author     : reynel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<% String context = request.getContextPath();%>

<s:if test="#session.usuario.nombreCompleto==null">
    <script>
        window.location.href = "<%=context%>/login";
    </script>
</s:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Shortcut Icon" href="<%=context%>/img/logo.png"> 

        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">

        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>


        <title>DULCERÍA</title>
    </head>
    <body background="<%=context%>/img/inicio2.jpg" style="background-attachment: fixed; background-position: top center; background-repeat: no-repeat;background-size: 100% 100%;">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav mr-auto"> 
                <li class="nav-item">
                    <p class="nav-link active"><s:property value="#session.usuario.nombreCompleto"/></p>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarMarcas">Consultar marcas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarDulces">Consultar dulces</a>
                </li>

            </ul>
            <ul class="navbar-nav">
                <li class="nav-item nav justify-content-end">
                    <a class="nav-link" href="<%=context%>/cerrarSesion">
                        <span class="fa fa-sign-out-alt"></span>
                        Cerrar sesión</a>
                </li>
            </ul>
        </nav>

                        
    </body>
</html>

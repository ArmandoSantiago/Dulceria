<%-- 
    Document   : ModificarMarca
    Created on : 22/10/2018, 09:28:39 AM
    Author     : reynel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
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
    <body>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <p class="nav-link active"><s:property value="#session.usuario.nombreCompleto"/></p>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/inicio">Inicio</a>
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
        </br>

        <div class="container">            
            <div class="mx-auto col-md-12">

                <h1>Modificar Marca</h1>

                <form action="modificarMarca" method="POST">
                    <input type="hidden" name="bean.idMarca" value="<s:property value="bean.idMarca" />"/>
                    <div class="form-group">
                        <label for="nombreMarca">Nombre marca:</label>
                        <input type="text" class="form-control" id="nombreMarca" name="bean.nombreMarca" value="<s:property value="bean.nombreMarca" />" />
                    </div>
                    <div class="form-group">
                        <label for="telefono">Teléfono:</label>
                        <input type="text" class="form-control" id="telefono" name="bean.telefono" value="<s:property value="bean.telefono" />" />
                    </div>
                    <div class="form-group">
                        <label for="direccion">Dirección:</label>
                        <input type="text" class="form-control" id="direccion" name="bean.direccion" value="<s:property value="bean.direccion" />" />
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo electrónico:</label>
                        <input type="text" class="form-control" id="correo" name="bean.correo" value="<s:property value="bean.correo" />" />
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-success" value="Actualizar"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

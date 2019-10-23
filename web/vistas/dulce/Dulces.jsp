<%-- 
    Document   : Dulces
    Created on : 22/10/2018, 09:27:57 AM
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
                    <a class="nav-link" href="<%=context%>/nuevoDulce">Registrar nuevo dulce</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarMarcas">Consultar marcas</a>
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

                <h1>Dulces</h1>

                <table class="table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Sabor</th>
                            <th>Contenido</th>
                            <th>Existencias</th>
                            <th>Marca</th>
                            <th>Tipo dulce</th>
                            <th>Eliminar</th>
                            <th>Modificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listaDulces" status="stat" var="lista">
                            <tr>
                                <td><s:property value="#stat.count" /></td>
                                <td><s:property value="nombreDulce"/></td>
                                <td><s:property value="precio"/></td>
                                <td><s:property value="sabor"/></td>
                                <td><s:property value="contenidoNeto"/></td>
                                <td><s:property value="existencia"/></td>
                                <td><s:property value="marca.nombreMarca"/></td>
                                <td><s:property value="tipo.nombreTipo"/></td>                        
                                <td>
                                    <form action="eliminarDulce" method="POST">
                                        <input type="hidden" name="beanDulce.idDulce" value="<s:property value="idDulce"/>" />                                        
                                        <button type="submit" value="" class="btn btn-danger">
                                            <i class="fa fa-trash"></i>
                                        </button>
                                    </form>
                                </td>
                                <td>
                                    <form action="consultarDulceId" method="POST">
                                        <input type="hidden" name="beanDulce.idDulce" value="<s:property value="idDulce"/>" />
                                        <button type="submit" value="" class="btn btn-warning">
                                            <i class="fa fa-pen-alt"></i>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : ModificarDulce
    Created on : 22/10/2018, 09:27:23 AM
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

                <h1>Modificar Dulce!</h1>
                <form action="#" method="POST">
                    <div class="form-group">
                        <label for="nombreDulce">Nombre dulce:</label>
                        <input type="text" class="form-control" id="nombreDulce" name="beanDulce.nombreDulce" value="<s:property value="beanDulce.nombreDulce" />" />
                    </div>
                    <div class="form-group">
                        <label for="precio">Nombre dulce:</label>
                        <input type="text" class="form-control" id="precio" name="beanDulce.precio" value="<s:property value="beanDulce.precio" />" />
                    </div>
                    <div class="form-group">
                        <label for="sabor">Sabor:</label>
                        <input type="text" class="form-control" id="sabor" name="beanDulce.sabor" value="<s:property value="beanDulce.sabor" />" />
                    </div>
                    <div class="form-group">
                        <label for="contenidoNeto">Contenido neto:</label>
                        <input type="text" class="form-control" id="contenidoNeto" name="beanDulce.contenidoNeto" value="<s:property value="beanDulce.contenidoNeto" />"  />
                    </div>
                    <div class="form-group">
                        <label for="existencia">Existencia:</label>
                        <input type="text" class="form-control" id="existencia" name="beanDulce.existencia" value="<s:property value="beanDulce.existencia" />" />
                    </div>
                    <div class="form-group">
                        <s:set value="beanDulce.marca.idMarca" var="idMarcaBean" />
                        <select class="form-control" name="beanDulce.marca.idMarca">
                            <s:iterator value="listaMarcas" status="stat" var="lista">
                                <s:set value="idMarca" var="idMarcaLista" />

                                <s:if test="%{#idMarcaBean == #idMarcaLista}">
                                    <option value="<s:property value="idMarca"/>" selected="" ><s:property value="nombreMarca" /></option>
                                </s:if>
                                <s:else>
                                    <option value="<s:property value="idMarca"/>"><s:property value="nombreMarca" /></option>
                                </s:else>


                            </s:iterator>
                        </select>
                    </div>

                    <div class="form-group">
                        <s:set value="beanDulce.tipo.idTipoDulce" var="idTipoBean" />
                        <select class="form-control" name="beanDulce.tipo.idTipoDulce">
                            <s:iterator value="listaTipos" status="stat" var="lista">
                                <s:set value="idTipoDulce" var="idTipoLista" />

                                <s:if test="{#idTipoBean == #idTipoLista}">
                                    <option value="<s:property value="idTipoDulce"/>" selected="" ><s:property value="nombreTipo" /></option>
                                </s:if>
                                <s:else>
                                    <option value="<s:property value="idTipoDulce"/>"><s:property value="nombreTipo" /></option>
                                </s:else>                        

                            </s:iterator>
                        </select>
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>

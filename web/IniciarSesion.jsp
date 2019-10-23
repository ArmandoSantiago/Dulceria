<%-- 
    Document   : IniciarSesion
    Created on : 8/11/2018, 03:06:21 PM
    Author     : reynel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<% String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Shortcut Icon" href="<%=context%>/img/logo.png"> 
        
        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">

        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>
        <title>DULCERÍA</title>
    </head>
    <body>    
        </br>
        </br>
        </br>
        <div class="container">           
            <div class="card card-container mx-auto col-md-3">  
                </br>
                <img id="profile-img" class="img-thumbnail" src="<%=context%>/img/avatar-inicio-sesion5.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <p class="profile-name-card"><s:property value="mensaje" /></p>
                <form class="form-signin" action="<%=context%>/iniciarSesion" method="POST">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="text" name="bean.user" id="user" class="form-control" placeholder="Usuario" required autofocus>
                    <input type="password" name="bean.pass" id="pass" class="form-control" placeholder="Contraseña" required>
                    </br>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Iniciar sesión</button>
                </form><!-- /form -->
                <a href="<%=context%>/RecuperarContrasenha.jsp" class="forgot-password">
                    ¿Olvidaste tu contraseña?
                </a>
            </div><!-- /card-container -->
        </div><!-- /container -->
    </body>
</html>

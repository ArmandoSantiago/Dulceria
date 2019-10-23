<%-- 
    Document   : Error
    Created on : 22/10/2018, 12:03:22 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR!</h1>
        <h5>Mensaje: <s:property value="mensaje"/></h5>
    </body>
</html>

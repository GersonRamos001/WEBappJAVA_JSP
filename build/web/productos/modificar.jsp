<%-- 
    Document   : modificar
    Created on : Jan 24, 2023, 3:44:39 PM
    Author     : ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <h1>Modificar Registro</h1>
        
        <form action="ProductosController?accion=actualizar" method="post" autocomplete="off">
            <input id="id" name="id" type="hidden" value="<c:out value="${producto.id}" />" />
            
            <p>
                codigo:
                <input id="codigo" name="codigo" type="text" value="<c:out value="${producto.codigo}" />" />
                
            </p>
            <p>
                Nombre:
                <input id="nombre" name="nombre" type="text" value="<c:out value="${producto.nombre}" />"/>
                
            </p>
            <p>
                Precio:
                <input id="precio" name="precio" type="text" value="<c:out value="${producto.precio}" />"/>
                
            </p>
            <p>
                Existencia:
                <input id="existencia" name="existencia" type="text" value="<c:out value="${producto.existencia}" />"/>
                
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>

<%-- 
    Document   : nuevo
    Created on : Jan 24, 2023, 3:44:21 PM
    Author     : ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen Nuevo</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        
        <form action="ProductosController?accion=insertar" method="post" autocomplete="off">
            
            <p>
                codigo:
                <input id="codigo" name="codigo" type="text"/>
                
            </p>
            <p>
                Nombre:
                <input id="nombre" name="nombre" type="text"/>
                
            </p>
            <p>
                Precio:
                <input id="precio" name="precio" type="text"/>
                
            </p>
            <p>
                Existencia:
                <input id="existencia" name="existencia" type="text"/>
                
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>

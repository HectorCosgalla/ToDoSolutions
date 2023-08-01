<%-- 
    Document   : newtask
    Created on : 1 ago. 2023, 01:05:53
    Author     : Hector Cosgalla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create a new task</title>
    </head>
    <body>
        <h2>Add a new task</h2>
        <form action="./" method="post">
            <p>Title:</p>
            <input type="text" name="title">
            <br/>
            <input type="submit">
        </form>
    </body>
</html>


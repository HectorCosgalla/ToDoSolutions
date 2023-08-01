<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 1 ago. 2023, 00:58:35
    Author     : Hector Cosgalla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to your To Do List!</h1>
        <main>
            <a href="newtask.jsp">New Task</a>
            <div>
                <h3>Things to do:</h3>
                <form action="/taskdone" method="POST">
                    <ul>
                        <li>first <input type="submit" value="Done!" id="1" /></li>
                        <li>second <input type="submit" value="Done!" id="2" /></li>
                        <li>third <input type="submit" value="Done!" id="3" /></li>
                    </ul>
                </form>
            </div>
            <div>
                <h3>Things done!</h3>
                <ul>
                    <li>first</li>
                    <li>second</li>
                    <li>third</li>
                </ul>
            </div>
            <sql:query var="result" dataSource="jdbc/todoapp">
                SELECT * FROM tasks
            </sql:query>
    
            <table border="1">
                <!-- column headers -->
                <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                </c:forEach>
                </tr>
                <!-- column data -->
                <c:forEach var="row" items="${result.rowsByIndex}">
                    <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </main>
    </body>
</html>

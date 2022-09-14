<%--
  Created by IntelliJ IDEA.
  User: rjromero
  Date: 11/09/22
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>List Persons Result</title>
    </head>
    <body>
        <h1>Result!</h1>
        <br>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${persons}" var="person" >
                <tr>
                    <th>${person.id}</th>
                    <td>${person.name} ${person.lastName}</td>
                    <td>${person.email}</td>
                    <td>${person.phone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>

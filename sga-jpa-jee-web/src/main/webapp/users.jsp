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
        <th>Username</th>
        <th>Password</th>
        <th>PersonID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" >
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.person.id}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

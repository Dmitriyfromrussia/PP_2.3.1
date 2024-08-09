<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<h2>All Users</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Email</th>

        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.userId}" /></td>
            <td><c:out value="${user.userName}" /></td>
            <td><c:out value="${user.userAge}" /></td>
            <td><c:out value="${user.userEmail}" /></td>
            <td><a href="${pageContext.request.contextPath}/edit?id=${user.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/delete?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${pageContext.request.contextPath}/add">Add New User</a>
</body>
</html>
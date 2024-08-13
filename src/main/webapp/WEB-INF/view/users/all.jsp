<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>All Users</title>
</head>

<body>
<%--</h2> -- жирный шрифт--%>
<h2>All Users</h2>
<%--br -- пустая строка--%>
<br>
<table border style="accent-color: antiquewhite">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Email</th>
        <th>Sex</th>
    </tr>
    <%--    временная переменная var будет принимать значение каждого юзера из списка userList--%>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userAge}</td>
            <td>${user.userEmail}</td>
            <td>${user.userSex}</td>
            <td><a href="${pageContext.request.contextPath}/users/edit?id=${user.userId}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/users/delete?id=${user.userId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${pageContext.request.contextPath}/users/add">Add new User</a>
</body>
</html>

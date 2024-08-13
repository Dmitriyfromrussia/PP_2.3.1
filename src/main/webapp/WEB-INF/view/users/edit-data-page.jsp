<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h2>Edit User</h2>
<form action="${pageContext.request.contextPath}/users/edit" method="post">
    <input type="hidden" name="id" value="${editUser.userId}"/>
    <label>Name:</label>
    <input type="text" name="name" value="${editUser.userName}"/><br/>
    <label>Surname:</label>
    <input type="text" name="age" value="${editUser.userAge}"/><br/>
    <label>Age:</label>
    <input type="text" name="email" value="${editUser.userEmail}"/><br/>
    <label>Email:</label>
    <input type="text" name="sex" value="${editUser.userSex}"/><br/>
    <input type="submit" value="Сохранить изменения"/>
</form>
</body>
</html>
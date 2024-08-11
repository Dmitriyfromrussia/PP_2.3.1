<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<h2>Заголовок</h2>
<br>
<%--action срабатывает, когда нажимаем на кнопку Ok--%>
<form: form action="saveNewUser" modelAttribute="newUser">
    Name <form:input path="name"/>
    <br>
    Age <form:input path="age"/>
    <br>
    Email <form:input path="Email"/>
    <br>
    <input type="submit" value="Сохранить данные юзера">

</form:>
<body>
$END$
</body>
</html>

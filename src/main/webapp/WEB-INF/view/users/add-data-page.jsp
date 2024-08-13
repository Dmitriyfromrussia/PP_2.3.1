<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
<h2>Add New User</h2>
<form action="${pageContext.request.contextPath}/users/add" method="post">

    <label for="name">Name</label>
    <input type="text" id="name" name="name" placeholder="обязательное значение"/><br/>

    <label>Age:</label>
    <input type="text" name="age"/><br/>

    <label>Email:</label>
    <input type="text" name="email"/><br/>

    <label>Sex:</label>
    <form:select path="sex" >
        <form:option value="Man" label="M"/>
        <form:option value="Woman" label="W"/>
        <form:option value="Human" label="H"/>
    </form:select>
    <br/>

    <input type="submit" value="Add"/>
</form>
</body>
</html>


<%--<label>Sex:</label>--%>
<%--<form:select path="sex" >--%>
<%--    <form:option value="Man" label="M"/>--%>
<%--    <form:option value="Woman" label="W"/>--%>
<%--    <form:option value="Human" label="H"/>--%>
<%--</form:select>--%>
<%--<br/>--%>


<%--<label>Sex</label>--%>
<%--<input type="text" name="sex"/><br/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th></th>
        <th>firstName</th>
        <th>surName</th>
        <th>age</th>
        <th>login</th>
        <th>password</th>
        <th>userType</th>
    </tr>
    </thead>
    <tbody>

    <%-- ${users.size()}--%>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td>${user.age}</td>
        <c:forEach var="cr" items="${user.credentials}">
            <td> ${cr.key}</td>
            <td>${cr.value}</td>
        </c:forEach>
            <td>${user.userType}</td>
        </tr>
    </c:forEach>

    </tbody>
    <a href="/index.jsp" class="c">Create</a>
</table>
</body>
</html>

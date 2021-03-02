<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstName</th>
        <th>secondName</th>
        <th>age</th>
        <th>login</th>
        <th>password</th>
        <th>userType</th>
    </tr>
    </thead>
    <tbody>
    <form action="/user/create" method="GET">
        <tr>
            <td><input type="text" name="firstName" placeholder="firstName"></td>
            <td><input type="text" name="secondName" placeholder="secondName"></td>
            <td><input type="text" name="age" placeholder="age"></td>
            <td><input type="text" name="login" placeholder="login"></td>
            <td><input type="text" name="password" placeholder="password"></td>
            <td><input type="text" name="userType" placeholder="userType"></td>
            <td><input type="submit" value="Create"></td>
        </tr>

        ${pageContext.request.contextPath}
    </form>
    </tbody>
</table>
</body>
</html>

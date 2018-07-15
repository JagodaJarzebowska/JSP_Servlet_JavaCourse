<%--
  Created by IntelliJ IDEA.
  User: jagod
  Date: 14.07.2018
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
        <h1>Hi! please enter your login and password:</h1>
        <form action="/login" method="post">
            <label>Your nick:</label><input type="text" name="nick"/></br>
            <label>Password:</label><input type="password" name="pass"/></br>
            <input type="submit" value="Login"/></br>
        </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jagod
  Date: 14.07.2018
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Twitter</title>
</head>
<body>
    <form action="/register" method="post">
        <label>Your nick:</label><input type="text" name="nick"/></br>
        <label>Email:</label><input type="email" name="email"/></br>
        <label>Password:</label><input type="password" name="pass"/></br>
        <input type="submit" value="Login"/></br>

    </form>
</body>
</html>

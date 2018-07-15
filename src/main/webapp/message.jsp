<%--
  Created by IntelliJ IDEA.
  User: jagod
  Date: 14.07.2018
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Message</title>
</head>
<body>
        <form action="/message" method="post">
            <label>Your message:</label></br>
            <textarea name="message" style="width: 150px; height: 150px" ></textarea>
            <%--<label>Your message:</label><input type="text" name="message"/></br>--%>
             <input type="submit" value="Send"/></br>
        </form>
</body>
</html>

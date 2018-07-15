<%@ page import="com.sda.twitter.repository.UserDb" %>
<%@ page import="com.sda.twitter.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sda.twitter.repository.TwittDb" %>
<%@ page import="com.sda.twitter.model.Twitt" %>
<%@ page import="com.sda.twitter.utils.Utils" %>
<%@ page import="java.util.Optional" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html;" %>
<html>
<head>
    <title>Twitter</title>
</head>
<%
    UserDb userDb = UserDb.getInstance();
    List<User> userList = userDb.getUserList();
    request.setAttribute("userList",userList);

    TwittDb twittDb = TwittDb.getInstance();
    List<Twitt> twittList = twittDb.getTwittList();
    request.setAttribute("twittList",twittList);

    Optional<User> userFromCookies = Utils.getUserFromCookies(request);
    request.setAttribute("userLogged",userFromCookies);
%>

<body>

<div style="text-align: right; width: 100%">
    <c:if test="${userLogged.present}">
    <a href="message.jsp">Send Message</a> /<a href="logout"> Logout</a>
    </c:if>
    <c:if test="${!userLogged.present}">
        <a href="login.jsp">Login</a> / <a href="register.jsp">Register</a>
    </c:if>
</div>




    <h2>Registered Users:</h2>

    <ul>
        <c:forEach var="user" items="${userList}">
            <li>
                Nick: <c:out value="${user.nick}"/>,
                Email: <c:out value="${user.email}"/>
            </li>
        </c:forEach>
    </ul>

    <h2>Message: </h2>

    <ul>
        <c:forEach var="message" items="${twittList}">
            <li>
                Date: <c:out value="${message.date}"/>,
                Message: <c:out value="${message.message}"/>,
                User: <c:out value="${message.user.nick}"/>,
            </li>
        </c:forEach>
    </ul>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>GABINET POLSKI</h1>

<c:forEach items="${user}" var="user">
    <c:out value="${user.login}"/>|<c:out value="${user.firstName}"/>|<c:out value="${user.lastName}"/><br/>
</c:forEach>
</body>
</html>

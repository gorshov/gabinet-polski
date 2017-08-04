<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" class="form-inline" action="/login">
    <div class="form-group">
        <br/>
        <input class="form-control" id="login" name="login" placeholder="Login" type="text"/>
    </div>
    <div class="form-group">
        <br/>
        <input class="form-control" id="password" name="password" placeholder="Password"
               type="password"/>
    </div>
    <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
    <label for="remember_me" class="inline" style="color: white">Remember me</label>

    <div class="form-group">
        <br/>
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
    <br/>
</form>

</body>
</html>

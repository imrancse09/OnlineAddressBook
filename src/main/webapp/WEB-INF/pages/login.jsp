<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div id="login-form">
    <div id="headings"><font size="10">Login<br></font></div>
    <br>
    <form name="login" method="post" action="userPage">
        <input type="hidden" name="pagename" value="login"/>
        <c:if test="${error == true}">
            <div class="error"> Incorrect name or email. Please try again!</div>
        </c:if>
        Username : <input type="text" name="txtName" autofocus="autofocus"> <br />
        Password : <input type="password" name="txtPassword" autofocus="autofocus"> <br />
        <br>
        <input type="submit" value="login" />
    </form>
</div>

</body>
</html>
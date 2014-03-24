<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>VCard Created</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div id="home-menu-ver">
    VCard Created Successfully<br>
    <form action="redirectToCreate" method="GET">
        <input type="submit" value="Create Another VCard"/>
    </form>

    <form action="toUserPage" method="GET">
        <input type="submit" value="User Page"/>
    </form>

    <form action="/loginPage" method="GET">
        <input type="submit" value="logout"/>
    </form>
</div>
</body>
</html>
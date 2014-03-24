<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div id="home-menu-ver">
    <form action="createVCard" method="GET">
        <input type="submit" value="CREATE VCARD" autofocus="autofocus"/>
    </form>

    <form action="showVCard" method="GET">
        <input type="submit" value="SHOW VCARD" autofocus="autofocus"/>
    </form>

    <form action="searchVCard" method="POST">
        <input type="submit" value="SEARCH/UPDATE/DELETE & EXPORT VCARD" autofocus="autofocus"/>
    </form>

    <form action="show" method="GET">
        <input type="submit" value="Import File" autofocus="autofocus"/>
    </form>

    <form action="/loginPage" method="GET">
        <input type="submit" value="logout"/>
    </form>
</div>
</body>
</html>

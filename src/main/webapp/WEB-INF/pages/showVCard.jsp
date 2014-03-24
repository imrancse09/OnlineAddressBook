<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Contacts</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>first name</th>
        <th>last name</th>
        <th>honorific prefix</th>
        <th>Organization</th>
        <th>Title</th>
        <th>Phone Work</th>
        <th>Phone Home</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var = "vCardListVar" items = "${vCardList}">
        <tr>
            <td>${vCardListVar.firstName}</td>
            <td>${vCardListVar.lastName}</td>
            <td>${vCardListVar.honorificPrefix}</td>
            <td>${vCardListVar.organization}</td>
            <td>${vCardListVar.jobTitle}</td>
            <td>${vCardListVar.phoneWork}</td>
            <td>${vCardListVar.phoneHome}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="toUserPage" method="GET">
    <input type="submit" value="User Page"/>
</form>
</body>
</html>


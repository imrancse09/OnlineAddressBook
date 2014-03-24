<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.therap.model.User"%>
<html>
<head>
    <title>${user}</title>
</head>
<body>
<h1>Search VCard Info</h1>

<form method="post" name="search" action="searchResult">
    <table border="0" width="300"  bgcolor="#CDFFFF">
        <tr><td colspan=2 style="font-size:12pt;color:#0000FF;" align="center">
            <h3>Search Form</h3></td></tr>
        <tr><td ><b>Enter First Name</b></td>
            <td>: <input type="text" name="jspFirstName" id="jspFirstName">
            </td></tr>

        <tr><td colspan=2 align="center">
            <input type="submit" name="submit" value="Search"></td></tr>
    </table>
    <br>
    <br>
</form>
    <table border="1">
        Search Result:
        <thead>
        <tr>

            <th>First Name</th>
            <th>Last Name</th>
            <th>Export</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var = "vCardSearchVar" items = "${vCardSearchList}">
        <form action="/downloadFile" method=post>
            <tr>

                <td>${vCardSearchVar.firstName}</td>
                <td>${vCardSearchVar.lastName}</td>
                <td colspan="150">
                    <input type="hidden" name="exportButton" value="${vCardSearchVar.vCardPKey}">
                    <input type="SUBMIT" name="export" value="Export"><input type="SUBMIT" name="update" value="Edit"><input type="SUBMIT" name="delete" value="Delete">
                </td>

            </tr>
        </form>
        </c:forEach>
        </tbody>
    </table>

<form action="toUserPage" method="GET">
    <input type="submit" value="User Page"/>
</form>

</body>
</html>

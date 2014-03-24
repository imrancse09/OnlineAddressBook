<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create New VCard</title>
    <style> .error {
        color: red
    } </style>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div id="headings"><h1 align="center"> New VCard Form </h1></div>
<%--<div id="login-form">--%>
    <form:form method="POST" commandName="vCard" action="submit">
        <br>
        Create New VCard:
        <br>
        <table border="1">
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName"></form:input></td>
                <td><form:errors path="firstName" cssstyle="color: red" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName"></form:input></td>
            </tr>
            <tr>
                <td>Honorific Prefix:</td>
                <td><form:input path="honorificPrefix"></form:input></td>
            </tr>
            <tr>
                <td>Job Title:</td>
                <td><form:input path="jobTitle"></form:input></td>
            </tr>
            <tr>
                <td>Organization:</td>
                <td><form:input path="organization"></form:input></td>
            </tr>
            <tr>
                <td>Photo URL:</td>
                <td><form:input path="photoUrl"></form:input></td>
            </tr>
            <tr>
                <td>Phone Work:</td>
                <td><form:input path="phoneWork"></form:input></td>
            </tr>
            <tr>
                <td>Phone Home:</td>
                <td><form:input path="phoneHome"></form:input></td>
            </tr>
            <tr>
                <td>Post Office Box (Work):</td>
                <td><form:input path="postOfficeBoxWork"></form:input></td>
            </tr>
            <tr>
                <td>House Number (Work):</td>
                <td><form:input path="houseNumberWork"></form:input></td>
            </tr>
            <tr>
                <td>Street (Work):</td>
                <td><form:input path="streetWork"></form:input></td>
            </tr>
            <tr>
                <td>City (Work):</td>
                <td><form:input path="cityWork"></form:input></td>
            </tr>
            <tr>
                <td>State (Work):</td>
                <td><form:input path="stateWork"></form:input></td>
            </tr>
            <tr>
                <td>Postal Code (Work):</td>
                <td><form:input path="postalCodeWork"></form:input></td>
            </tr>
            <tr>
                <td>Country (Work):</td>
                <td><form:input path="countryWork"></form:input></td>
            </tr>

            <tr>
                <td>Post Office Box (Home):</td>
                <td><form:input path="postOfficeBoxHome"></form:input></td>
            </tr>
            <tr>
                <td>House Number (Home):</td>
                <td><form:input path="houseNumberHome"></form:input></td>
            </tr>
            <tr>
                <td>Street (Home):</td>
                <td><form:input path="streetHome"></form:input></td>
            </tr>
            <tr>
                <td>City (Home):</td>
                <td><form:input path="cityHome"></form:input></td>
            </tr>
            <tr>
                <td>State (Home):</td>
                <td><form:input path="stateHome"></form:input></td>
            </tr>
            <tr>
                <td>Postal Code (Home):</td>
                <td><form:input path="postalCodeHome"></form:input></td>
            </tr>
            <tr>
                <td>Country (Home):</td>
                <td><form:input path="countryHome"></form:input></td>
            </tr>
            <tr>
                <td>Preferred Email:</td>
                <td><form:input path="prefEmail"></form:input></td>
            </tr>

        </table>
        <p><input type="submit" value="CREATE" name="button"></p>
    </form:form>
<form action="toUserPage" method="GET">
    <input type="submit" value="User Page"/>
</form>

<%--</div>--%>
</body>
</html>

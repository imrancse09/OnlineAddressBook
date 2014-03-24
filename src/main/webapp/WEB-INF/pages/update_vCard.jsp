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
<form:form method="POST" commandName="vCardById" action="update">
<br>
Create New VCard:
<br>
<table border="1">
    <tr>
        <td>ID:</td>
        <td><form:input path="vCardPKey"></form:input></td>
        <td><form:errors path="vCardPKey" cssstyle="color: red" /></td>
    </tr>
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
    </table>
    <p><input type="submit" value="Update" name="button"></p>
</form:form>
</body>
</html>
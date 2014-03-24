<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Export Contacts</title>
</head>
<body>
<div id="login-form">
    <div id="headings"><font size="10">Login<br></font></div>
    <form name="login" method="post" action="exportContact">
        <input type="hidden" name="pagename" value="login"/>
        <c:if test="${error == true}">
            <div class="error"> No Contact To Export! Any Of The Three Fields Might Be Missing</div>
        </c:if>
        Recipient name : <input type="txt" name="recipientName" autofocus="autofocus"> <br />
        Contact First Name : <input type="txt" name="txtFirstName" autofocus="autofocus"> <br />
        Contact Last Name : <input type="txt" name="txtLastName" autofocus="autofocus"> <br />
        <input type="submit" value="Export Contact" />
    </form>
</div>
</body>
</html>
















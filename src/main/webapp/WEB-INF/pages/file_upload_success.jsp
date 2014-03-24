<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>File Uploaded</title>
</head>
<body>
<h1>File Import</h1>
<p>Following file is uploaded successfully.</p>
<ol>
    <c:forEach items="${files}" var="file">
        <li>${file}</li>
    </c:forEach>
</ol>

<form action="toUserPage" method="GET">
    <input type="submit" value="User Page"/>
</form>
</body>
</html>
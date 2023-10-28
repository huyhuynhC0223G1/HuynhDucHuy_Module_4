<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 6/19/2023
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Configuration email</h1>
<h2> Languages: ${settings.languages}</h2>
<h2> Page Size: ${settings.pageSize}</h2>
<h2> Spams Filter: ${settings.spamsFilter}</h2>
<h2> Signature: ${settings.signature}</h2>
<a href="/update-settings"><input type="submit" value="Edit"></a>
</body>
</html>

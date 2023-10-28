<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 6/15/2023
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="/dictionary/result">
    <input type="text" name="search" placeholder="Enter your word: ">
    <input type="submit" id="submit" value="Search"><br>
    English: ${search}<br>
    Vietnamese: ${result}
</form>
</body>
</html>

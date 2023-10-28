<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 6/16/2023
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<form method="post" action="/condiments/create">
    <input type="checkbox" value="Lettuce" name="condiment">
    <label>Lettuce</label>
    <input type="checkbox" value="Tomato" name="condiment">
    <label>Tomato</label>
    <input type="checkbox" value="Mustard" name="condiment">
    <label>Mustard</label>
    <input type="checkbox" value="Sprouts" name="condiment">
    <label>Sprouts</label>
    <hr>
    <input type="submit" value="Save"><br>
    Sandwich condiments include : ${result}
</form>
</body>
</html>

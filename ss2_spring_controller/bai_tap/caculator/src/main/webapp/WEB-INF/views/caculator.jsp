<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 6/16/2023
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/caculator/calculate">
    <h2>Caculator</h2>
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2" value="${number2}"><br>
    <button type="submit" name="calculate" value="+">Addition(+)</button>
    <button type="submit" name="calculate" value="-">Subtraction(-)</button>
    <button type="submit" name="calculate" value="*">Multiplication(*)</button>
    <button type="submit" name="calculate" value="/">Division(/)</button>
    <br>
    Result : ${result}
</form>
</body>
</html>

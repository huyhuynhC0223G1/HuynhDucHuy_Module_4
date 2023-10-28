<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 6/15/2023
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<form method="post" action="/converter/result">
    <table>
        <tr>
            <td><label>Rate: </label></td>
            <td><input type="text" name="rate" placeholder="RATE" value="23000"></td>
        </tr>
        <tr>
            <td><label>USD: </label></td>
            <td><input type="text" name="usd" placeholder="USD" value="0"></td>
        </tr>
        <tr></tr>
        <td><input type="submit" id="submit" value="Converter"></td>
        </tr>
    </table>
    Result = ${result}
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: TGDD
  Date: 6/19/2023
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form modelAttribute="settings" method="post" action="/update-settings">
    <table>
        <tr>
            <td><form:label path="languages">Languages</form:label></td>
            <td><form:select path="languages" items="${languagesList}"></form:select></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size</form:label></td>
            <td><form:select path="pageSize" items="${pageSizeList}"></form:select></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter</form:label></td>
            <td><form:checkbox path="spamsFilter"></form:checkbox>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:input path="signature"></form:input></td>
        </tr>
    </table>
    <button type="submit">Update</button>
    <button>Cancel</button>
</form:form>
</body>
</html>

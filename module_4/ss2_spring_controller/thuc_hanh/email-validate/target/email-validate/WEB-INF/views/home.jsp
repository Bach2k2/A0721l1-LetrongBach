<%--
  Created by IntelliJ IDEA.
  User: DE
  Date: 18/2/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color: red"> ${message}</h3>
<form method="post" action="/validate">
    <input type="text" name="email" ><br>
    <input type="submit" value="Validate">
</form>
</body>
</html>

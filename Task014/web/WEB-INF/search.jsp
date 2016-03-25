<%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 23.03.2016
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://${searcher}" method="get">
    <input type="text" name="${name}"/>
    <input type="submit" value="Search!"/>
</form>

</body>
</html>

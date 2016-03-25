<%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 23.03.2016
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/process" method="post">
    <div>
        <textarea name="comment"></textarea>
    </div>
    <br>

    <div>
        <select name="oper">
            <option value="characters">
                <p>Number of characters</p>
            </option>
            <option value="words">
                <p>Number of words</p>
            </option>
            <option value="proposals">
                <p>Number of proposals</p>
            </option>
            <option value="paragraphs">
                <p>Number of paragraphs</p>
            </option>
        </select>
    </div>
    <br>

    <div>
        <input type="submit" value="Process">
    </div>
</form>
</body>
</html>

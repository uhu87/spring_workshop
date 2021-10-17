<%--
  Created by IntelliJ IDEA.
  User: uhu_s
  Date: 13.10.2021
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<!--#-->

<form action="post" method="POST">
    <p><input type="text" required placeholder="isbn" name="isbn"></p>
    <p><input type="text" required placeholder="title" name="title"></p>
    <p><input type="text" required placeholder="author" name="author"></p>
    <p><input type="text" required placeholder="publisher" name="publisher"></p>
    <p><input type="text" required placeholder="type" name="type"></p>

    <input type="submit" value="Wyślij">
</form>

</body>
</html>

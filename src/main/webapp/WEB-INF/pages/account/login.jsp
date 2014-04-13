<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: guibin
  Date: 4/13/14
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form id="login" action="login" method="post">
        <label for="username">用户名</label>
        <input id="username" type="text" name="username" />
        <br/>
        <label for="password">密码</label>
        <input id="password" type="password" name="password" />
        <br/>
        <input type="submit">提交</input>
    </form>
</body>
</html>
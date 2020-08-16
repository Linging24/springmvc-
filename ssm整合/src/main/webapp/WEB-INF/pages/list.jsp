<%--
  Created by IntelliJ IDEA.
  User: Linging
  Date: 2020/8/16
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查询所有账户</title>
</head>
<body>

<h1>查询所有账户</h1>

<c:forEach var="account" items="${accounts}">
    <ul>
        <li>${account.name}</li>
        <li>${account.money}</li>
    </ul>
</c:forEach>


</body>
</html>

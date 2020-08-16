<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/account/findAll">测试查询所有</a>
    <br>
    <form action="${pageContext.request.contextPath}/account/saveAccount" method="post">
        账户名: <input type="text" name="name"><br>
        金&emsp;额: <input type="text" name="money"><br>
        <input type="submit" value="保存">
    </form>
</body>
</html>

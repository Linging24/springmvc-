<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>SpringMvc入门案例</title>
  </head>
  <body>
  <%--请求路径加/和不加/的区别：--%>
  <a href="hello/mvc">hello,SpringMvc!入门案例</a> <br>

  <a href="${pageContext.request.contextPath}/hello/getParam?username=张三&password=123">get请求参数绑定</a>  <br>

  <hr>
  <p>post请求参数绑定</p>
  <form action="hello/postParam" method="post">
      用户名:<input type="text" name="username" placeholder="请输入用户名" ><br>
      密&emsp;码:<input type="password" name="password" placeholder="请输入密码"><br>
      <input type="submit" value="提交"><br>
  </form>

  <hr>
  <p>绑定实体类型</p>
  <form action="hello/entityParam" method="post">
    用户名:<input type="text" name="username" placeholder="请输入用户名" ><br>
    密&emsp;码:<input type="password" name="password" placeholder="请输入密码"><br>
    生&emsp;日;<input type="date" name="birthday"><br/>
    <input type="submit" value="提交"><br>
  </form>

  <hr>
  <p>对实体类中的引用对象赋值，Account,List,Map</p>
  <form action="hello/entityParam" method="post">
    用户名:<input type="text" name="username" placeholder="请输入用户名" ><br>
    密&emsp;码:<input type="password" name="password" placeholder="请输入密码"><br>
    生&emsp;日:<input type="date" name="birthday"/><br/>

    账户名:<input type="text" name="account.name" placeholder="实体"><br/>
    金&emsp;额:<input type="text" name="account.money" placeholder="实体"><br/>

    账户名:<input type="text" name="accounts[0].name" placeholder="List"><br/>
    金&emsp;额:<input type="text" name="accounts[0].money" placeholder="List"><br/>

    <%--map中对的对象key=one，value为一个实体，属性有name和money--%>
    账户名:<input type="text" name="map['one'].name" placeholder="Map"><br/>
    金&emsp;额:<input type="text" name="map['one'].money" placeholder="Map"><br/>

    <input type="submit" value="提交"><br>
  </form>

  <hr>
  <p>testRequestBody</p>
  <form action="hello/testRequestBody" method="post">
    用户名:<input type="text" name="username" placeholder="请输入用户名" ><br>
    密&emsp;码:<input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="提交"><br>
  </form>

  <a href="hello/testPathVariable/10">testPathVariable</a><br>
  <a href="hello/testRequestHeader">testRequestHeader</a><br>
  <a href="hello/testCookieValue">testCookieValue</a><br>
  <a href="hello/testModelAttribute?name=zhangsan">testModelAttribute</a><br>
  <a href="hello/testModelAttribute2?name=zhangsan">testModelAttribute2</a><br>

  <a href="hello/saveSession">saveSession</a><br>
  <a href="hello/getSession">getSession</a><br>
  <a href="hello/delSession">delSession</a><br>









  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>


  </body>
</html>

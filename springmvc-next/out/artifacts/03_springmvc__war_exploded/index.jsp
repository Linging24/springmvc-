<%--
  Created by IntelliJ IDEA.
  User: Linging
  Date: 2020/8/16
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <p>同步上传文件</p>
    <form action="upload/testUpload" method="post" enctype="multipart/form-data">
      <input type="file" name="upload"><br>
      <input type="submit" value="上传">
    </form>

    <hr>
    <p>异步上传文件</p>
    <form id="formData" method="post" enctype="multipart/form-data">
      <input type="file" name="upload"><br>
      <input id="sub" type="button" value="上传">
    </form>


    <hr>
    <p>异步上传文件,且表单有其他数据</p>
    <form id="formData2" method="post" enctype="multipart/form-data">
      编&emsp;号:<input type="text" name="id"><br>
      账户名:<input type="text" name="name"><br>
      金&emsp;额:<input type="text" name="money"><br>
      <input type="file" name="upload"><br>
      <input id="sub2" type="button" value="上传">
    </form>


    <hr>
    <p>异步上传多个文件,且表单有其他数据</p>
    <form id="formData3" method="post" enctype="multipart/form-data">
      编&emsp;号:<input type="text" name="id"><br>
      账户名:<input type="text" name="name"><br>
      金&emsp;额:<input type="text" name="money"><br>
      <input type="file" name="upload" multiple="multiple"><br>
      <input id="sub3" type="button" value="上传">
    </form>



  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="js/util.js"></script>
  <script>

    $(function () {
      //异步上传文件
      $("#sub").click(function () {
        var file = new FormData($("#formData")[0]);
        $.post({
          url:'upload/testUpload',
          contentType:false,  //jQuery不要去处理发送的数据
          processData:false,  //jQuery不要去处理发送的数据
          cache:false,        //不缓存
          dataType:'json',    //返回类型json
          data:file,          //文件数据
          success:function (data) {
            console.log(data);
          }
        });
      });

      //异步上传文件，带表单参数
      $("#sub2").click(function () {
        //将form表单转换为FormData对象
        var data = new FormData(document.querySelector("#formData2"));
        $.post({
          url:'upload/testUpload2',
          contentType:false,  //jQuery不要去设置Content-Type请求头
          processData:false,  //jQuery不要去处理发送的数据
          cache:false,        //不缓存
          dataType:'json',    //返回类型json
          data:data,          //表单数据
          success:function (data) {
            console.log(data);
          },
          error:function (error) {
            console.log(error);
          }
        });
      });



      //异步上传多个文件，带表单参数
      $("#sub3").click(function () {
        //将form表单转换为FormData对象
        var data = new FormData(document.querySelector("#formData3"));
        $.post({
          url:'upload/testUpload3',
          contentType:false,  //jQuery不要去设置Content-Type请求头
          processData:false,  //jQuery不要去处理发送的数据
          cache:false,        //不缓存
          dataType:'json',    //返回类型json
          data:data,          //表单数据
          success:function (data) {
            console.log(data);
          },
          error:function (error) {
            console.log(error);
          }
        });
      });

    });
  </script>

  </body>
</html>

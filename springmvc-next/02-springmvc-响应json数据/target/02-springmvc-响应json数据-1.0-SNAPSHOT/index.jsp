<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <button id="myBtn" type="button">测试发送ajax请求</button>
    <button id="myBtn2" type="button">测试发送ajax2请求</button>
    <br>

    <form id="form-test" method="post" enctype="multipart/form-data">
        id:<input type="text" name="id" placeholder="请输入id"><br>
        账户名:<input type="text" name="name" placeholder="请输入用户名"><br>
        金&emsp;额:<input type="password" name="money" placeholder="请输入密码"><br>
        <input type="button" value="提交" id="sub"><br>
    </form>



    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
    <script>
        $(function () {
            //不能序列化文件
            // $("#sub").click(function () {
            //     $.post({
            //        url:'ajax/testAjax',
            //        contentType:'application/json;charset=UTF-8',
            //        data:formToJson($("#form-test").serializeArray()),
            //        dataType:'json',
            //        type:'post',
            //        success:function (data) {
            //            console.log(data);
            //        }
            //    });
            // });

            $("#sub").click(function () {
                var data = new FormData(document.querySelector("#form-test"));
                $.post({
                   url:'ajax/testAjax',
                   contentType:false,
                   cache: false,//由于信息涉及到隐私,禁止浏览器将数据缓存(根据需求使用)
                   processData:false, //告诉jQuery不要去处理发送的数据
                   dataType:'json',
                   data:data,
                   success:function (res) {
                       console.log(res);
                   }
               });
            });




            $("#myBtn").click(function () {
                $.ajax({
                    url:'ajax/testAjax',
                    contentType:'application/json;charset=UTF-8',
                    data:'{"id":1,"name":"张三","money":1000}',
                    dataType:'json',
                    type:'post',
                    success:function (data) {
                        console.log(data);
                    }
                })
            });

            $("#myBtn2").click(function () {
                $.post({
                    url:'ajax/testAjax',
                    contentType:'application/json;charset=UTF-8',
                    data:'{"id":1,"name":"张三","money":1000}',
                    dataType:'json',
                    success:function (data) {
                        console.log(data);
                    }
                });
            });

        });
    </script>
</body>
</html>

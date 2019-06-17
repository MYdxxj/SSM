<%--
  Created by IntelliJ IDEA.
  User: 52817
  Date: 2019/3/15
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>产品管理系统注册</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .formCenter {
            margin: 100px 300px 100px 320px; /*上右下左*/
            /*  border: 1px solid red;*/
            height: 500px;
            text-align: center;
        }

        .head {
            text-align: center;
            font-family: 楷体;
            font-weight: bold;
        }

        div {
            margin-top: 10px;
            padding: 10px;
        }

        .formInput {
            border-radius: 20px;
            width: 30%;
        }

        .footer {
            text-align: center;
            font-size: 12px;
        }

        small {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>

<form action="/user/tologin" method="post" class="form-inline formCenter">
    <div class="head">
        <h1><img src="<%=basePath%>static/assets/i/favicon.png" style="margin-left: 20px">
            产品管理系统</h1>
        <h3><u>注册</u></h3><br>
    </div>

    <br class="form-inline">
    手机号：<input type="text" id="username" class="form-control formInput" name="username" placeholder="请输入手机号"/><br/>
    <small id="user"></small>
    </div>
    <div class="form-inline">
        密码：<input type="password" id="password" name="password" class="form-control formInput"
                  placeholder="请输入密码"/><br/>
        <small id="pwd"></small>
    </div>
    <div class="form-inline">
        重复密码：<input type="password" id="password2" name="password2" class="form-control formInput"
                    placeholder="请再次输入密码"><br/>
        <small id="pwd2"></small>
    </div>
    <div class="form-inline">
      性别：<input type="radio" name="sex" class="radio"value="男">男 &emsp;
        <input type="radio" name="sex" class="radio" value="女">女

    </div>
    <div><input type="button" value="注册" id="subitBtn" class="btn btn-success formInput"/></div>
    <small id="error"></small>

    </div>
</form>
<div class="footer">
    <p>Yang &copy; 杨小姣2019.毕业作品 - Collect from 贵州师范学院</p>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    /*  $(function () {
         /!* $("#subitBtn").attr("disabled","disabled");*!/
          $("form").reset();
      });*/
    $("#username").blur(function () {
        if ($("#username").val().trim() == null || $("#username").val().trim() == '') {
            $("#user").html("请输入手机号!");
        } else {
            $("#user").html("");
        }
    });
    $("#subitBtn").click(function () {
        var username = $("#username").val().trim();
        var password = $("#password").val().trim();
        var password2 = $("#password2").val().trim();
        if (username != '' & password != '' & password2 != '') {
            if (password === password2) {
                $("form").submit();
                alert("注册成功");
            } else {
                $("#error").html("两次密码不一致，请重新输入！");
            }
        } else {
            $("#error").html("输入不能为空!");
        }
    });
</script>
</body>

</html>

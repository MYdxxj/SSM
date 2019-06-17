<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">

<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>系统登录</title>
<link href="<%=basePath%>../static/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all"/>
<link href="<%=basePath%>static/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="<%=basePath%>../static/js/jquery1.42.min.js"></script>
 <script type="text/javascript" src="<%=basePath%>../static/js/jquery.SuperSlide.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>../static/js/Validform_v5.3.2_min.js"></script>--%>

<script>
    $(function () {
        if ('${error}' != null || '${error}' != "") {
            $("#error-box").html('${error}');
        }
        $(".i-text").focus(function () {
            $(this).addClass('h-light');
        });

        $(".i-text").focusout(function () {
            $(this).removeClass('h-light');
        });

        $("#username").focus(function () {
            var username = $(this).val();
            if (username == '输入账号/手机号') {
                $(this).val('');
            }
        });

        $("#username").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入账号/手机号');
            }
        });
        $("#password").focus(function () {
            var username = $(this).val();
            if (username == '输入密码') {
                $(this).val('');
            }
        });


        $("#yzm").focus(function () {
            var username = $(this).val();
            if (username == '输入验证码') {
                $(this).val('');
            }
        });

        $("#yzm").focusout(function () {
            var username = $(this).val();
            if (username == '') {
                $(this).val('输入验证码');
            }
        });

    });
</script>

<style>
    .aa:link {
        color: #F6BC63;
        text-decoration: underline;
    }

    .aa:visited {
        color: #0000FF;
        text-decoration: none;
    }

    .aa:hover {
        color: #FF00FF;
        text-decoration: none;
    }

    .aa:active {
        color: #D200D2;
        text-decoration: none;
    }
</style>
</head>

<body>


<div class="header" style="margin-top: 0;">

    <div style="float: left"><h1 class="headerLogo"><a title="产品管理系统" target="_blank" href="#"><img alt="logo"
                                                                                                    style="float: left;"
                                                                                                    src="/static/images/logo.gif"></a>
    </h1>
    </div>
    <div style="float: right;margin-top:15px ;"><h1><font
            style="float: right;font-family: 新宋体; text-align: center;color: #407CC6;"><i>只要还有明天，今天就永远是起跑线。——<tt>致毕业的我们</tt></i></font>
    </h1></div>
    <%--<div class="headerNav" style="border: 1px solid red;">
        <a target="_blank" href="#">企业官网</a>
        <a target="_blank" href="#">关于我们</a>
        <a target="_blank" href="#">开发团队</a>
        <a target="_blank" href="#">意见反馈</a>
        <a target="_blank" href="#">帮助</a>
    </div>--%>
</div>

<div class="banner">

    <div class="login-aside">
        <div id="o-box-up"></div>
        <div id="o-box-down" style="table-layout:fixed;">
            <form class="registerform" action="login" method="post">
                <div style="width: 240px;color: white;">
                    <center><h3>产品管理系统登陆</h3></center>
                    <hr>
                </div>
                <div class="fm-item">
                    <label for="username" class="form-label" style="float: left;">用户名：&emsp;&emsp;&emsp;<div
                            class="error-box form-label" id="error-box" style="float: right;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                    </div>
                    </label>
                    <div><input type="text" value="输入账号/手机号" maxlength="100" id="username" name="username" class="i-text"
                                datatype="s6-18" errormsg="用户名至少6个字符,最多18个字符！"><%--ajaxurl="demo/valid.jsp"--%>
                    </div>
                    <div class="ui-form-explain"></div>
                </div>

                <div class="fm-item">
                    <label for="password" class="form-label">登陆密码：</label>
                    <input type="password" value="" maxlength="100" id="password" name="password" class="i-text"
                           datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！">
                    <div class="ui-form-explain"></div>
                </div>
                <div class="fm-item pos-r">
                    <label for="yzm" class="form-label">验证码:</label>
                    <input type="text" value="输入验证码" maxlength="100" id="yzm" name="yzm" class="i-text yzm"
                           nullmsg="请输入验证码！">
                    <div class="ui-form-explain">
                        <img src="<%=basePath%>/getVerifyCode" alt="" width="100" height="25" class="yzm-img"
                             style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">
                    </div>
                </div>
                <div class="fm-item">
                    <label for="submit" class="form-label"></label>
                    <input type="submit" value="" tabindex="4" id="submit" class="btn-login"><br>
                    <div class="ui-form-explain"></div>
                </div>
                <br>
                <div class="fm-item" style="float: right;margin-right: 60px;">
                    <%--<a href="#"target="_blank" class="aa" >忘记密码</a>&emsp;&emsp;--%>
                    <a href="/register" target="_blank" class="aa">注册</a>
                    <div class="ui-form-explain"></div>
                </div>
                <%-- <div class="fm-item">
                     <label for="send-btn" class="form-label"></label>
                     <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login">
                     <div class="ui-form-explain"></div>
                 </div>--%>
            </form>
        </div>

    </div>

    <div class="bd" id="bd">
        <ul>
            <li style="background:url(../static/themes/School1.jpg) #CCE1F3 center 0 no-repeat;"><%--<a target="_blank"
                                                                                                    href="#"></a>--%></li>
            <li style="background:url(../static/themes/School2.jpg ) #BCE0FF center 0 no-repeat;"><%--<a target="_blank"
                                                                                                     href="#"></a>--%></li>
        </ul>
    </div>

  <%--  <div class="hd" style="border: 1px solid red;"><ul></ul></div>--%>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
    <p>Yang &copy; 杨小姣2019.毕业作品 - Collect from 贵州师范学院</p>
</div>
</body>
</html>

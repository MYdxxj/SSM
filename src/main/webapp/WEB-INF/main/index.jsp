<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html class="no-js">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Product Manager</title>
    <meta name="description" content="这是一个 user 页面">
    <meta name="keywords" content="user">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="<%=basePath%>../static/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>../static/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="<%=basePath%>../static/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>../static/assets/css/admin.css">
    <style type="text/css">
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，产品管理系统 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <img src="<%=basePath%>../static/assets/i/favicon.png" style="margin-left: 20px"><strong style="margin-left: 10px">产品管理系统</strong>
        <small>-杨小姣</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li><a href="javascript:;"><span
                    class="am-badge am-badge-warning"><span id="showTimeLabel">YYYY-MM-DD xx:xx:xx</span> </span></a></li>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span>${user.userName} <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="javascript:void(0);"onclick="openModal();" data-toggle="modal"><span class="am-icon-user"></span> 资料</a></li>
                    <li><a href="javascript:void(0);"onclick="openPassword();"><span class="am-icon-cog"></span> 修改密码</a></li>
                    <li><a href="<%=basePath%>doLogout"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="javascript:;" id="fullscreen"><span class="am-icon-arrows-alt"></span> <span
                    class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main" style="float:left">
    <!-- sidebar start -->
    <div class="admin-sidebar">
        <ul class="am-list admin-sidebar-list" id="list">
            <li><a href="/first" target="right"><span class="am-icon-home"></span> 首页</a></li>
            <li class="admin-parent">
                <shiro:hasPermission name="root">
                    <a class="am-cf" data-am-collapse="{target: '#system'}" target="right"><span
                            class="am-icon-hdd-o"></span> 系统管理 <span
                            class="am-icon-angle-down am-fr am-margin-right"></span></a>
                </shiro:hasPermission>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="system">
                    <shiro:hasPermission name="/role/pageList">
                        <li><a href="/role/pageList"  target="right"><span
                                class="am-icon-user"></span>角色管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/user/pageList">
                        <li><a href="/user/pageList" target="right"><span
                                class="am-icon-puzzle-piece"></span>用户管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/menu/pageList">
                        <li><a href="/menu/pageList" target="right"><span class="am-icon-th"></span>菜单管理</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
            <li class="admin-parent">
                <shiro:hasPermission name="root">
                    <a class="am-cf" data-am-collapse="{target: '#product'}" target="right"><span
                            class="am-icon-folder-open"></span> 产品管理 <span
                            class="am-icon-angle-down am-fr am-margin-right"></span></a>
                </shiro:hasPermission>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="product">
                    <shiro:hasPermission name="/productPrice/pageList">
                        <li><a href="/productPrice/pageList" target="right"><span
                                class="am-icon-align-center"></span>产品报价单</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/order/pageList">
                        <li><a href="/order/pageList" target="right"><span
                                class="am-icon-align-center"></span>用户订单管理</a>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/order/personOrder">
                        <li><a href="/order/personOrder" target="right"><span
                                class="am-icon-align-center"></span>个人订单</a>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/activity/pageList">
                        <li><a href="/activity/pageList" target="right"><span
                                class="am-icon-align-center"></span>活动测试</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>

            <li class="admin-parent">
                <shiro:hasPermission name="root">
                    <a class="am-cf" data-am-collapse="{target: '#collection'}" target="right"><span
                            class="am-icon-life-saver"></span> 信息搜集 <span
                            class="am-icon-angle-down am-fr am-margin-right"></span></a>
                </shiro:hasPermission>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collection">
                    <shiro:hasPermission name="/userMsg/pageList">
                        <li><a href="<%=basePath%>/userMsg/pageList" target="right"><span
                                class="am-icon-calendar"></span>
                            用户信息搜集<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/productCollect/pageList">
                        <li><a href="<%=basePath%>/productCollect/pageList" target="right"><span
                                class="am-icon-calendar"></span> 产品信息搜集</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
            <li class="admin-parent">
                <shiro:hasPermission name="root">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}" target="right"><span
                            class="am-icon-headphones"></span> 售后管理 <span
                            class="am-icon-angle-down am-fr am-margin-right"></span></a>
                </shiro:hasPermission>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                    <%-- <li><a href="<%=basePath%>/user" class="am-cf" target="right"><span class="am-icon-check"></span>
                         个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
                     <li><a href="<%=basePath%>/help" target="right"><span class="am-icon-puzzle-piece"></span> 帮助页</a>
                     </li>
                     <li><a href="<%=basePath%>/log" target="right"><span class="am-icon-calendar"></span> 系统日志</a></li>
                     <li><a href="<%=basePath%>/unfound" target="right"><span class="am-icon-bug"></span> 404</a></li>--%>
                    <shiro:hasPermission name="/feedback/pageList">
                        <li><a href="<%=basePath%>/feedback/pageList" target="right"><span
                                class="am-icon-send"></span>
                            反馈表管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/afterSales/pageList">
                        <li><a href="<%=basePath%>/afterSales/pageList" target="right"><span class="am-icon-eye"></span>
                            售后服务查看</a>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/afterSales/personOrder">
                        <li><a href="<%=basePath%>/afterSales/personOrder" target="right"><span class="am-icon-phone"></span> 个人订单售后</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="/technology">
                        <li><a href="<%=basePath%>/technology" target="right"><span class="am-icon-wrench"></span> 技术服务管理</a></li>
                    </shiro:hasPermission>
                </ul>
            </li>
            <%-- <li><a href="<%=basePath%>/table" target="right"><span class="am-icon-table"></span> 表格</a></li>--%>
            <li><a href="<%=basePath%>doLogout"><span class="am-icon-sign-out"></span> 注销</a></li>
        </ul>

        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-bookmark"></span> 公告</p>
                <p>时光静好，与君语；细水流年，与君同。—— 杨小姣</p>
            </div>
        </div>

        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-tag"></span> wiki</p>
                <p>Welcome to the YangXiaoJiao product manager!</p>
            </div>
        </div>
    </div>
</div>
<div style="border: 1px solid white">
    <div id="rightPart" style="margin-top:0px;height:750px;width:82%;float: right;margin-right: 10px;">
        <iframe scrolling="no" rameborder="0"
                src="<%=basePath%>/first" name="right" width="100%"
                height="100%"></iframe>
        <footer>
            <hr>
            <p class="am-padding-left" style="text-align: center"> © 2019 Graduate, Inc. Licensed under GZNC college.</p>
        </footer>
    </div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="openPassword">
    <div class="am-modal-dialog" style="padding: 5px;">
        <div class="am-modal-bd">
            <i> 修改密码</i>
        </div>
        <form action="#" method="post">
            <input type="hidden" id="userId" name="userId" value="${user.userId}"/>
            <div class="am-form-group" style="margin-top: 10px">
                <label for="password" class="am-form-label">原始密码:</label>&emsp;
                <input type="password" id="password" name="password" placeholder="请输入6~12位密码" /><br>
                <small>若没有设置密码，则初始密码为123456</small>
            </div>
            <div class="am-form-group" style="margin-top: 5px">
                <label for="newPassword" class="am-form-label">新密码&emsp;:</label>&emsp;
                <input type="password" id="newPassword" name="newPassword"  placeholder="请输入6~12位密码"/>
            </div>
            <div class="am-form-group" style="margin-top: 5px">
                <label for="surePassword" class="am-form-label">确认密码:</label>&emsp;
                <input type="password" id="surePassword" name="surePassword" placeholder="请重复新密码"/>
            </div>
            <font id="error"></font>
            <center>
                <input type="button" id="submitPassword" class="am-btn am-btn-active" style="background-color: #0b6fa2" value="保存"/>
                <input type="button" class="am-modal-btn" id="close" data-dismiss="modal" style="background-color: #f7f7f7;margin-left: 10px; " value="取消"/>
            </center>
            <%--<div class="am-modal-footer">
                <span class="am-modal-btn">关闭</span>
            </div>--%>
        </form>

    </div>
</div>
<jsp:include page="person.jsp" flush="true"/>
<script src="<%=basePath%>../static/assets/js/jquery.min.js"></script>
<script src="<%=basePath%>../static/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>../static/assets/js/app.js"></script>
<script type="text/javascript">
    /*显示时间*/
    function showLocalTime() {
        getLoaclTime();
        var t1 = window.setInterval('getLoaclTime()', 1000);
    }

    function getLoaclTime(){
        var nt = new Date();
        var yy = nt.getFullYear();
        var mm = nt.getMonth()+1;
        var dd = nt.getDate();
        var h = nt.getHours();
        var m = nt.getMinutes();
        var s = nt.getSeconds();
        $("#showTimeLabel").text(
            yy + "-" + mm + "-" + dd + " " + h + ":" + m + ":" + s);
    }
    $(function() {
        showLocalTime();
    });
    function openModal(){
        $('#my-alert').modal();
    }
    function openPassword(){
        $("#openPassword").modal();
    }
    $("#close").click(function () {
        $("form")[0].reset();
    });
    $("#submitPassword").click(function(){
        var password = $("#password").val().trim();
        var newPassword = $("#newPassword").val().trim();
        var surePassword = $("#surePassword").val().trim();
        if(password!="" & newPassword!="" & surePassword !=""){
            if(password==='${user.password}'){
                if(newPassword>5 & newPassword.length < 13){
                    if(surePassword === newPassword){
                        $.ajax({
                            url:"user/setPassword",
                            datatype:"json",
                            data:{"userId":$("#userId").val(),"newPassword":newPassword},
                            success:function(data){
                                $("#error").html(data);
                            },
                            error:function(){
                                alert("数据发生异常");
                            }
                        });
                    }else{
                        $("#error").html("两次密码输入不一致");
                    }

                }else{
                    $("#error").html("新密码格式错误")
                }

            }else{
                $("#error").html("旧密码输入错误");
            }
        }else{
            $("#error").html("输入不能为空");
        }

    });

    $("#list li a").click(function () {
        // $("#123").css("z-index");
        if ($(this).children('span').last().attr("class") === "am-icon-angle-down am-fr am-margin-right") {
            /* $(this).parent("li").children("ul").css({ display: "none"});*/
            $(this).children('span').last().removeAttr("class");
            $(this).children('span').last().attr("class", "am-icon-angle-right am-fr am-margin-right");

        } else if ($(this).children('span').last().attr("class") === "am-icon-angle-right am-fr am-margin-right") {
            /* $(this).parent("li").children("ul").css({ display: "block"});*/
            $(this).children('span').last().removeAttr("class");
            $(this).children('span').last().attr("class", 'am-icon-angle-down am-fr am-margin-right');

        }
    });
    $("ul li ul li a").click(function () {
        $(this).css("background-color", "#0E90D2");
    });
    $("ul li ul li a").blur(function () {

        $("li a").css("background-color", "#FFFFFF");
    });

    //进入全屏
    $("#fullscreen").click(function () {
        var de = document.documentElement;
        if (de.requestFullscreen) {
            de.requestFullscreen();
        } else if (de.mozRequestFullScreen) {
            de.mozRequestFullScreen();
        } else if (de.webkitRequestFullScreen) {
            de.webkitRequestFullScreen();
        }
    });
</script>

</body>
</html>

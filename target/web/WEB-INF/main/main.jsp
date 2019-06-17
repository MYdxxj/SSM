<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>" />
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0"style="size: 18px" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1" style="size: 18px"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2" style="size: 18px"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="<%=basePath%>../static/themes/android-wallpaper-artistic-asphalt-799443.jpg" alt="..." style="width: 100%;height: 750px">
            <div class="carousel-caption">
                <h3>网络时代已经到来</h3>
                <p>你，还在等什么</p>
            </div>
        </div>
        <div class="item">
            <img src="<%=basePath%>../static/themes/accessories-business-camera-62689.jpg" alt="..."style="width: 100%;height: 750px">
            <div class="carousel-caption">
                <h3>生活的美好，源于不断地追求</h3>
                <p>做一个有追求的人</p>
            </div>
        </div>
        <div class="item">
            <img src="<%=basePath%>../static/themes/pexels-photo-1005638.jpeg" alt="..."style="width: 100%;height: 750px" >
            <div class="carousel-caption">
                <h3>欢迎来到产品管理系统</h3>
                <p>制作人： 杨小姣</p>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>

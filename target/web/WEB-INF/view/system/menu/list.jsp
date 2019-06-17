<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html class="no-js">
<head>
    <base href="<%=basePath%>" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze后台管理系统模板HTML首页 - cssmoban</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="<%=basePath%>../static/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>../static/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="<%=basePath%>../static/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>../static/assets/css/admin.css">
    <style>
    .font{
        color: red;
    }
    </style>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">角色</strong> / <small>操作模块</small></div>
            <%--<a class="btn btn-default" href="javascript:void(0)" onclick="newMenu();" role="button" data-toggle='modal' data-target='#myModal' style="margin-left: 30px"><span class="glyphicon glyphicon-plus"></span>新增菜单</a>--%>
            &emsp;<button type="button" class="btn btn-default" id="checkall">
            <span class="icon-check"></span> 全选
            </button>&emsp;<input type="button" class="btn btn-danger" onclick="deleteAllMenu()"
            value="批量删除">
        </div>
    <div class="col-lg-5">
        <div class="input-group">
            <span class="input-group-addon glyphicon glyphicon-search"></span>
            <input type="text" class="form-control" name="findMenu" placeholder="Search for menu by name">
            <span class="input-group-btn">
            <button class="btn btn-default" type="button" id="btnRole">Go!</button>
            </span>
        </div>
    </div>
    <br><br>

    </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table">
                    <thead>
                    <tr>
                        <th style="width: 1%">菜单ID</th><th style="width: 1%">菜单父Id</th><th style="width: 1%">菜单名称</th><th style="width: 1%">描述</th><th style="width: 1%">菜单地址</th><th style="width: 1%">管理</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${menuList}" var="menu">
                        <tr>
                        <td><input type="checkbox" name="menuIds" value="${menu.menuId }"/>${menu.menuId }</td>
                        <td>${menu.menuPid }</td>
                        <td>${menu.menuName }</td>
                        <td>${menu.menuDesc }</td>
                        <td>${menu.menuUrl }</td>
                        <td><a class="btn btn-danger"
                        href="javascript:void(0)" onclick="deleteMenu('${menu.menuId}')"><span  class='am-icon-trash '></span>删除</a>&emsp;
                        <a class="btn btn-info" onclick="updateMenu('${menu.menuId }','${menu.menuName}','${menu.menuPid}','${menu.menuDesc}','${menu.menuUrl}')"
                        href='javascript:void(0)' id="updateMenu" data-toggle="modal" data-target="#myModal"
                        style='cursor:pointer'><span class="glyphicon glyphicon-pencil"></span>修改</a>
                        <%--<a class="btn btn-warning" onclick="newSon('${menu.menuId }')"
                        href='javascript:void(0)' id="newSon" data-toggle="modal" data-target="#myModal"
                        style='cursor:pointer'><span class="glyphicon glyphicon-equalizer"></span>子菜单</a>--%></td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
                <div align="center">
                <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=1">首页</a>
                <c:choose>
                    <c:when test="${page.pageNow - 1 > 0}">
                        <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=${page.pageNow - 1}">上一页</a>
                    </c:when>
                    <c:when test="${page.pageNow - 1 <= 0}">
                        <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=1">上一页</a>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${page.totalPageCount==0}">
                        <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=${page.pageNow}">下一页</a>
                    </c:when>
                    <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                        <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=${page.pageNow + 1}">下一页</a>
                    </c:when>
                    <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                        <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=${page.totalPageCount}">下一页</a>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${page.totalPageCount==0}">
                        <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=${page.pageNow}">尾页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/menu/pageList?pageNow=${page.totalPageCount}">尾页</a>
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
        <jsp:include page="add.jsp" flush="true"/>
     <%--   <jsp:include page="update.jsp" flush="true"/>--%>
    </div>
    <!-- content end -->

</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("td").css("text-align","center");
    $("th").css("text-align","center");
    function deleteMenu(menuId){
        if(confirm("删除后不可恢复，您确定要删除吗？")){
            if(menuId!=null){
                window.location.href='menu/delete?menuId='+menuId;
            }
        }

    }
 /*   function newSon(menuId){ }*/
    function updateMenu(menuId,menuName,menuPid,menuDesc,menuUrl){
    $("#error").html("");
        $("#form")[0].reset();
        /*$("#menuPid").removeAttr("disabled");*/
        $("#myModalLabel").html("修改菜单信息");
        $("#menuId").val(menuId);
        $("#menuPid").val(menuPid);
        $("#menuName").val(menuName);
        $("#menuDesc").val(menuDesc);
        $("#menuUrl").val(menuUrl);
        $("#form").attr("action","/menu/update");

    }
    function Save(){
    var menuPid = $("#menuPid").val().trim();
    var menuName = $("#menuName").val().trim();
    if(menuPid!=''& menuName!=''){
        $("#form").submit();
    }else{
        $("#error").html("必填项不能为空");
    }

    }
    function newMenu(){
        $("#myModalLabel").html("新增菜单");
        $("#form").attr("action","/menu/newMenu");
      /*  $("#menuPid").attr("value","root");
        $("#menuPid").attr("disabled","disabled");*/
        $("#form")[0].reset();
    }
    $("#btnRole").click(function(){
        var value = $(" input[name='findMenu']").val();
        var info = ""
        $.ajax({
            url:"menu/likeSearch",
            type:"get",
            data: {"menuInput":value},
            success:function(data){
            var menuList=eval(data);
            console.log(menuList);
            for (var i = 0; i <menuList.length ; i++) {
            info += "<tr><td>"+menuList[i].menuId+"</td><td>"+menuList[i].menuName+"</td>"+
            "<td>"+menuList[i].menuPid+"</td><td>"+menuList[i].menuDesc+"</td><td>"+menuList[i].menuUrl+"</td>" +
            "</td><td><a class='btn btn-danger' onclick='deleteMenu("+menuList[i].menuId+")' href='javascript:void(0)' style='cursor:pointer'><span  class='am-icon-trash '></span>删除</a>&nbsp;" +
            "<a class='btn btn-info' onclick='updateMenu(\""+menuList[i].menuId+"\",\""+menuList[i].menuName+"\",\""+menuList[i].menuPid+"\",\""+menuList[i].menuDesc+"\",\""+menuList[i].menuUrl+"\")'" +
            " href='javascript:void(0)'id='updateMenu' data-toggle='modal' data-target='#myModal' style='cursor:pointer'><span  class='glyphicon glyphicon-pencil '></span>修改</a></td></tr>";
            }
            $("#tbody").html(info);
            }
        });
    });

    $("#checkall").click(function() {
    $("input[name='menuIds']").each(function() {
    if (this.checked) {
    this.checked = false;
    } else {
    this.checked = true;
    }
    });
    })

        function deleteAllMenu() {
    if(confirm("批量删除后将不可恢复，你确定要进行此操作吗？")){

    text = $("input:checkbox[name='menuIds']:checked").map(function(index,elem) {
    return $(elem).val();
    }).get().join(',');
    window.location.href='menu/deleteAll?text=' + text;
    }
    }
</script>
</body>
</html>

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
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze后台管理系统模板HTML首页 - cssmoban</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="<%=basePath%>../static/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>../static/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户</strong> /
                <small>操作模块</small>
            </div>
            <a class="btn btn-default" href="javascript:void(0)" onclick="newUser();" role="button" data-toggle='modal'
               data-target='#myModal' style="margin-left: 30px"><span class="glyphicon glyphicon-plus"></span>新增用户</a>
            &emsp;<button type="button" class="btn btn-default" id="checkall">
            <span class="icon-check"></span> 全选
        </button>&emsp;<input type="button" class="btn btn-danger" onclick="deleteAllUser()"
                              value="批量删除">
        </div>
        <%--<form action="user/likeSearch" method="post">--%>
        <div class="col-lg-5">
            <div class="input-group">
                <span class="input-group-addon glyphicon glyphicon-search"></span>
                <input type="text" class="form-control" name="findUser" placeholder="Search for user by userName">
                <span class="input-group-btn">
            <button class="btn btn-default" type="button" id="btnRole">Go!</button>
            </span>
            </div>
        </div>
        <%--</form>--%>
        <br><br>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>登录名</th>
                        <th>用户名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>生日</th>
                        <th>联系电话</th>
                        <th>创建时间</th>
                        <th>管理</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${userList}" var="user">

                        <tr>
                            <td><input type="checkbox" name="userIds" value="${user.userId }"/>${user.userId }</td>
                            <td>${user.loginName }</td>
                            <td>${user.userName }</td>
                            <td>${user.userSex }</td>
                            <td>${user.userAge }</td>
                            <td><fmt:formatDate value="${user.userBirthday}"
                                                pattern="yyyy-MM-dd "/></td>
                            <td>${user.userPhone }</td>
                            <td><fmt:formatDate value="${user.createTime}"
                                                pattern="yyyy-MM-dd hh:mm:ss"/></td>
                            <td><a class="btn btn-danger"
                                   href="javascript:void(0)"onclick="deleteUser('${user.userId}')"><span
                                    class="am-icon-trash "></span>删除</a>&nbsp;&nbsp;
                                <a class="btn btn-info"
                                   onclick="updateUser('${user.userId}','${user.loginName}','${user.userName}','${user.userSex}','${user.userAge}','${user.userPhone}','${user.userBirthday}')"
                                   href='javascript:void(0)' id="updateUser" data-toggle="modal" data-target="#myModal"
                                   style='cursor:pointer'><span class="glyphicon glyphicon-pencil"></span>修改</a>&nbsp;&nbsp;
                                <a class="btn btn-default"
                                   href="<%=basePath%>userRole/getUserRole?userId=${user.userId}"><span
                                        class="glyphicon glyphicon-user"></span>分配角色</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div align="center">
                    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                    ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/user/pageList?pageNow=1">首页</a>
                    <c:choose>
                        <c:when test="${page.pageNow - 1 > 0}">
                            <a href="${pageContext.request.contextPath}/user/pageList?pageNow=${page.pageNow - 1}">上一页</a>
                        </c:when>
                        <c:when test="${page.pageNow - 1 <= 0}">
                            <a href="${pageContext.request.contextPath}/user/pageList?pageNow=1">上一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/user/pageList?pageNow=${page.pageNow}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/user/pageList?pageNow=${page.pageNow + 1}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/user/pageList?pageNow=${page.totalPageCount}">下一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/user/pageList?pageNow=${page.pageNow}">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/user/pageList?pageNow=${page.totalPageCount}">尾页</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <jsp:include page="add.jsp" flush="true"/>
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
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    function deleteUser(userId) {
        if(confirm("删除后不可恢复，您确定要删除吗？")){
            if (userId != null) {
                window.location.href = 'user/delete?userId=' + userId;
            }
        }
    }

    function userRole(userId) {
        if (userId != null) {
            window.location.href = 'userRole/getUserRole?userId=' + userId;
        }
    }

    function updateUser(userId, loginName, userName, userSex, userAge, userPhone, userBirthday) {
        $("#error").html("");
        userBirthday = new Date(userBirthday).Format("yyyy-MM-dd");
        $("#formi")[0].reset();
        $("#loginName").val(loginName);
        $("#myModalLabel").html("修改用户信息");
        $("#userId").val(userId);
        $("#userName").val(userName);
        $("#sex").val(userSex);
        $("#userPhone").val(userPhone);
        $("#userBirthday").val(userBirthday);
       /* $("#userAge").val(userAge);*/
        $("#userBirthday").attr("disabled", "disabled");
        $("#formi").attr("action", "/user/update");
    }
    function Save() {
        var userName = $("#userName").val().trim();
        var sex = $("#sex").val().trim();
        var loginName = $("#loginName").val().trim();
        var userBirthday = $("#userBirthday").val().trim();

        if(loginName!='' & userName!='' & sex != ''& userBirthday!=''& loginName!=''){
            $("#formi").submit();
        }else{
            $("#error").html("必填项不能空");
        }

    }

    function newUser() {
        $("#myModalLabel").html("新增用户");
        $("#formi").attr("action", "/user/newUser");
        $("#userBirthday").removeAttr("disabled");
        $("#formi")[0].reset();
    }
    $("#btnRole").click(function(){
        /*var value = $(" input[ name='findUser' ] ").val();*/
        var value = $(" input[name='findUser']").val();
        var info = ""
        $.ajax({
            url:"user/likeSearch",
            type:"get",
            data: {"userInput":value},
            datatype:"json",
            success:function(data){
                var userList=eval(data);
                console.log(userList);
                for (var i = 0; i <userList.length ; i++) {
                    info += "<tr><td>"+userList[i].userId+"</td><td>"+userList[i].userName+"</td>"+
                        "<td>"+userList[i].loginName+"</td><td>"+userList[i].userSex+"</td><td>"+userList[i].userAge+"</td><td>"+new Date(userList[i].userBirthday).Format("yyyy-MM-dd")+"</td><td>"+userList[i].userPhone+"</td>" +
                        "<td>"+new Date(userList[i].createTime).Format("yyyy-MM-dd hh:mm:ss")+
                        "</td><td><a class='btn btn-info' onclick='deleteUser("+userList[i].userId+")' href='javascript:void(0)' style='cursor:pointer'><span  class='am-icon-trash '></span>删除</a>&nbsp;" +
                        "&emsp;<a  class='btn btn-danger' onclick='updateUser(\""+userList[i].userId+"\",\""+userList[i].loginName+"\",\""+userList[i].userName+"\",\""+userList[i].userSex+"\",\""+userList[i].userAge+"\",\""+userList[i].userPhone+"\",\""+new Date(userList[i].userBirthday).Format("yyyy-MM-dd")+ "\")'" +
                        " href='javascript:void(0)'id='updateUser' data-toggle='modal' data-target='#myModal' style='cursor:pointer'><span  class='glyphicon glyphicon-pencil '></span>修改</a>" +
                        "&emsp;<a class='btn btn-default' onclick='userRole(\""+userList[i].userId+"\")'><span  class='glyphicon glyphicon-user'></span>角色分配</a></td></tr>";
                }
                $("#tbody").html(info);
            }
        });
    });

    $("#checkall").click(function() {
        $("input[name='userIds']").each(function() {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function deleteAllUser() {
        if(confirm("批量删除后将不可恢复，你确定要进行此操作吗？")){

            text = $("input:checkbox[name='userIds']:checked").map(function(index,elem) {
                return $(elem).val();
            }).get().join(',');
            window.location.href='user/deleteAll?text=' + text;
        }
    }

</script>
</body>
</html>

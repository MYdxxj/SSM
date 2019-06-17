<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .centerMenu{
            border: 3px solid #A5C261;
            height:450px;
            width: 800px;
           /* margin-top: 8%;*/
            margin-left:17%;
            border-radius:20px;
            padding: 20px;
            overflow:auto;
        }
        body{
            background-color: transparent;
        }
        label{
            font-size:18px;
        }
    </style>
<body>
<center style="margin-top: 2%;"><font color="red" size="10" style="font-style: italic">用户分配角色</font></center>
<div class="centerMenu">
    <form action="<%=basePath%>userRole/saveUserRole" method="post">
        <input type="hidden" name="userId" value="${user.userId}">
        <div class="panel-head" id="add">
            <h3><center><span class="glyphicon glyphicon-user"></span>&nbsp;角色：
                <font color="red">${user.userName}</font></center> </h3>

            <hr><label>现有角色：</label>
            <c:forEach items="${userRoles}" var="userRole">
                ${userRole.roleName } &emsp;
            </c:forEach>
            ${noUser}
        </div>
        <div>
            <label>重新分配角色：</label><br>
            <c:forEach items="${roles }" var="r">
            <input type="checkbox" name="roleIds" value="${r.roleId }"
                   style="width: auto;margin-left: 17%;height: 25px;width:25px" id="${r.roleId }"><font size="4">${r.roleName }</font><br>
            </c:forEach>
        </div>

        <div class="form-group">
            <div class="label">
                <label></label>
            </div>
            <div class="field">
                <center><button class="btn btn-success" type="submit">
                    提交</button></center>
            </div>
        </div>
    </form>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
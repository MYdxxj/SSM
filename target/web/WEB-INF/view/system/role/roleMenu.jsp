<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .center {
            border: 3px solid #A5C261;
            height: 450px;
            width: 800px;
            /* margin-top: 8%;*/
            margin-left: 17%;
            border-radius: 20px;
            padding: 20px;
            overflow: auto;
        }

        body {
            background-color: transparent;
        }

        label {
            font-size: 18px;
        }
    </style>
<body>
<center style="margin-top: 2%;"><font color="red" size="10" style="font-style: italic">角色分配菜单</font></center>
<div class="center">
    <form action="<%=basePath%>roleMenu/saveRoleMenu" method="post">
        <input type="hidden" name="roleId" value="${role.roleId}">
        <div class="panel-head" id="add">
            <h3>
                <center><span class="glyphicon glyphicon-user"></span>&nbsp;角色：
                    <font color="red">${role.roleName}</font></center>
            </h3>

            <hr>
            <label>现有菜单：</label>
            <c:forEach items="${roleMenus}" var="roleMenu">
                ${roleMenu.menuName } &emsp;
            </c:forEach>
            ${noMenu}
        </div>
        <div>
            <label>重新分配菜单：</label><br>
            <c:forEach items="${menus }" var="m">
                <input type="checkbox" name="menuIds" value="${m.menuId  }"
                       style="width: auto;margin-left: 17%;height: 25px;width:25px" id="${m.menuId  }"><font
                    size="4">${m.menuName  }</font><br>
            </c:forEach>
        </div>

        <div class="form-group">
            <div class="label">
                <label></label>
            </div>
            <div class="field">
                <center>
                    <button class="btn btn-success" type="submit">
                        提交
                    </button>
                  <%--  <button class="btn" onclick="cancel();">
                        取消
                    </button>--%>
                </center>
            </div>
        </div>
    </form>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<%--<script type="text/javascript">
    function cancel() {
        window.location.href='/role/pageList';
    }
</script>--%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
    <style>.font{color:red;}</style>
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">反馈</strong> /
                <small>操作模块</small>
                &emsp;<button type="button" class="btn btn-default" id="checkall">
                    <span class="icon-check"></span> 全选
                </button>&emsp;<input type="button" class="btn btn-danger" onclick="deleteAllFeedback()"
                                      value="批量删除">
            </div>
            <%--<a class="btn btn-default" href="javascript:void(0)" onclick="newOrder();" role="button" data-toggle='modal'
               data-target='#myModal' style="margin-left: 30px"><span class="glyphicon glyphicon-plus"></span>新增反馈</a>--%>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table">
                    <thead>
                    <tr>
                        <th>用户姓名</th>
                        <th>用户性别</th>
                        <th>用户联系方式</th>
                        <th>产品名称</th>
                        <th>产品购买日期</th>
                        <th>产品问题描述</th>
                        <th>处理状态</th>
                        <th>创建时间</th>
                        <th>管理</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${orderFeedbacks}" var="feedback">

                        <tr>
                            <td ><input type="checkbox" name="feedbackIds" value="${feedback. feedbackId }"/>${feedback.userName }</td>
                            <td > ${feedback.userSex  }</td>
                            <td >${feedback.userContact  }</td>
                            <td >${feedback.productName  }</td>
                            <td >${feedback.productBuydate }</td>
                            <td >${feedback.productProblem }</td>
                            <td >${feedback.handleStatus }</td>
                            <td ><fmt:formatDate value="${feedback.feedbackCreatetime }"
                                                 pattern="yyyy-MM-dd hh:mm:ss" /></td>
                            <td><a class="btn btn-danger"
                                   href="javascript:void(0)"onclick="deleteFeedback('${feedback. feedbackId}')"><span
                                    class="am-icon-trash "></span>删除</a>&nbsp;&nbsp;
                                <c:forEach items="${roles}" var="role">
                                    <c:if test="${role.roleName =='user'}">
                                        <a class="btn btn-info"
                                           onclick="handle('${feedback. feedbackId }')"
                                           href='javascript:void(0)' id="handle" data-toggle="modal" data-target="#myModal"
                                           style='cursor:pointer'><span class="glyphicon glyphicon-wrench"></span>处理</a>&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${role.roleName =='manager' || role.roleName == 'admin'}">
                                        <a class="btn btn-success"
                                           onclick="solved('${feedback. feedbackId }')"
                                           href='javascript:void(0)' id="solved"
                                           style='cursor:pointer'><span class="glyphicon glyphicon-hand-left"></span>已解决</a>
                                    </c:if>
                                </c:forEach>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div align="center">
                    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                    ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=1">首页</a>
                    <c:choose>
                        <c:when test="${page.pageNow - 1 > 0}">
                            <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=${page.pageNow - 1}">上一页</a>
                        </c:when>
                        <c:when test="${page.pageNow - 1 <= 0}">
                            <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=1">上一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=${page.pageNow}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=${page.pageNow + 1}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=${page.totalPageCount}">下一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=${page.pageNow}">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/feedback/pageList?pageNow=${page.totalPageCount}">尾页</a>
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

    function deleteFeedback(feedbackId) {
        if(confirm("删除后不可恢复，您确定要删除吗？")){
            if (feedbackId != null) {
                window.location.href = 'feedback/delete?feedbackId=' + feedbackId;
            }
        }
    }
    function handle(feedbackId) {
        $("#formi")[0].reset();
        $("#feedbackId").val(feedbackId);
        $("#myModalLabel").html("处理反馈问题");
        $("#formi").attr("action", "/feedback/handle");
    }
    function solved(feedbackId){
      if(confirm("您确定已解决该用户的问题了吗？")){
          window.location.href = 'feedback/solved?feedbackId='+feedbackId;
      }
    }
    function Save() {
        $("#formi").submit();
    }
    $("#checkall").click(function() {
        $("input[name='feedbackIds']").each(function() {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function deleteAllFeedback() {
        if(confirm("批量删除后将不可恢复，你确定要进行此操作吗？")){

            text = $("input:checkbox[name='feedbackIds']:checked").map(function(index,elem) {
                return $(elem).val();
            }).get().join(',');
            window.location.href='feedback/deleteAll?text=' + text;
        }
    }
</script>
</body>
</html>

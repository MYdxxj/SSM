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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">订单</strong> /
                <small>操作模块</small>
                &emsp;<button type="button" class="btn btn-default" id="checkall">
                    <span class="icon-check"></span> 全选
                </button>&emsp;<input type="button" class="btn btn-danger" onclick="deleteAllOrder()"
                                      value="批量删除">
            </div>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table">
                    <thead>
                    <tr>
                        <th>订单ID</th>
                        <th>订单类型</th>
                        <th>订单状态</th>
                        <th>用户ID</th>
                        <th>所购物品</th>
                        <th>订单总价</th>
                        <th>创建时间</th>
                        <th>管理</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${orderList}" var="order">

                        <tr>
                            <td><input type="checkbox" name="orderIds" value="${order.orderId}"/>${order.orderId }</td>
                            <td>${order.orderType }</td>
                            <td>${order.orderState }</td>
                            <td>${order.userId }</td>
                            <td>${order.orderDesc }</td>
                            <td>${order.orderTotal }</td>
                            <td><fmt:formatDate value="${order.orderCreatetime}"
                                                pattern="yyyy-MM-dd hh:mm:ss" /></td>
                            <td><a class="btn btn-danger"
                                   href="javascript:void(0)"onclick="deleteOrder('${order.orderId}')"><span
                                    class="am-icon-trash "></span>删除</a>&nbsp;&nbsp;
                                <a class="btn btn-info"
                                   onclick="updateOrder('${order.orderId }','${order.orderType}','${order.orderState}','${order.userId}','${order.orderDesc }','${order.orderTotal}')"
                                   href='javascript:void(0)' id="updateOrder" data-toggle="modal" data-target="#myModal"
                                   style='cursor:pointer'><span class="glyphicon glyphicon-pencil"></span>修改</a>&nbsp;&nbsp;
                                <c:if test="${order.orderState== '已付款（未收货）'}">
                                <a class="btn btn-warning"
                                   href="javascript:void(0)"onclick="refund('${order.orderId}')"><span
                                        class="glyphicon glyphicon-repeat "></span>退款</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div align="center">
                    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                    ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/order/pageList?pageNow=1">首页</a>
                    <c:choose>
                        <c:when test="${page.pageNow - 1 > 0}">
                            <a href="${pageContext.request.contextPath}/order/pageList?pageNow=${page.pageNow - 1}">上一页</a>
                        </c:when>
                        <c:when test="${page.pageNow - 1 <= 0}">
                            <a href="${pageContext.request.contextPath}/order/pageList?pageNow=1">上一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/order/pageList?pageNow=${page.pageNow}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/order/pageList?pageNow=${page.pageNow + 1}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/order/pageList?pageNow=${page.totalPageCount}">下一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/order/pageList?pageNow=${page.pageNow}">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/order/pageList?pageNow=${page.totalPageCount}">尾页</a>
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

    function deleteOrder(orderId) {
        if(confirm("删除后不可恢复，您确定要删除吗？")){
            if (userId != null) {
                window.location.href = 'order/delete?orderId=' + orderId;
            }
        }
    }
    function refund(orderId) {
        if(confirm("您确定退款吗，退款后12小时后将为您处理")){
            if (orderId != null) {
                window.location.href = 'order/refund?orderId=' + orderId;
            }
        }
    }
    function updateOrder(orderId, orderType, orderState, userId,orderDesc, orderTotal) {
        $("#error").html("");
        $("#formi")[0].reset();
        $("#orderId").val(orderId);
        $("#myModalLabel").html("修改订单信息");
        $("#orderType").val(orderType);
        $("#orderState").val(orderState);
        $("#userId").val(userId);
        $("#orderDesc").val(orderDesc);
        $("#orderTotal").val(orderTotal);
        $("#formi").attr("action", "/order/update");
    }

    function Save() {
        var orderType = $("#orderType").val().trim();
        var orderState = $("#orderState").val().trim();
        var userId = $("#userId").val().trim();
        var orderTotal = $("#orderTotal").val().trim();
        if(orderType !='' & orderState !='' & userId !='' & orderTotal!=''){
            $("#formi").submit();
        }else{
            $("#error").html("必填项不能为空");
        }

    }

    function newOrder() {
        $("#myModalLabel").html("新增订单");
        $("#formi").attr("action", "/order/newOrder");
        $("#formi")[0].reset();
    }
    $("#checkall").click(function() {
        $("input[name='orderIds']").each(function() {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function deleteAllOrder() {
        if(confirm("批量删除后将不可恢复，你确定要进行此操作吗？")){

            text = $("input:checkbox[name='orderIds']:checked").map(function(index,elem) {
                return $(elem).val();
            }).get().join(',');
            window.location.href='order/deleteAll?text=' + text;
        }
    }
</script>
</body>
</html>

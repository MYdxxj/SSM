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
        * {
            padding: 0;
            margin: 0;
        }

        .comment {
            font-size: 40px;
            color: #D1A41A;
        }
        .comment li {
            float: left;
            cursor: pointer;
        }

        ul {
            list-style: none;
        }
    </style>
</head>
<style>
    .font{
        color: red;
    }
</style>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人订单</strong> /
                <small>操作模块</small>
                &emsp;<button type="button" class="btn btn-default" id="checkall">
                    <span class="icon-check"></span> 全选
                </button>&emsp;<input type="button" class="btn btn-danger" onclick="deleteAllPersonOrder()"
                                      value="批量删除">
            </div>
            <%--<a class="btn btn-default" href="javascript:void(0)" onclick="newActivity();" role="button" data-toggle='modal'
               data-target='#myModal' style="margin-left: 30px"><span class="glyphicon glyphicon-plus"></span>新增活动</a>--%>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table">
                    <thead>
                    <tr>
                    <th>订单编号</th>
                    <th>订单类型</th>
                    <th>订单状态</th>
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
                            <td>${order.orderDesc }</td>
                            <td>${order.orderTotal }</td>
                            <td><fmt:formatDate value="${order.orderCreatetime}"
                                                pattern="yyyy-MM-dd hh:mm:ss" /></td>
                            <td><a class="btn btn-danger"
                                   href="javascript:void(0)"onclick="deleteOrder('${order.orderId}')"><span
                                    class="am-icon-trash "></span>删除</a>&nbsp;&nbsp;
                                <c:if test="${order.orderState=='已付款（未收货）' }">
                                    <a class="btn btn-warning"
                                       href="javascript:void(0)"onclick="refund('${order.orderId}')"><span
                                            class="glyphicon glyphicon-repeat "></span>退款</a>
                                </c:if>
                                <c:if test="${order.orderState=='已付款（已收货）' }">
                                    <a class="btn btn-warning" style="background-color: palegreen;" data-toggle="modal" data-target="#myModal"
                                       href="javascript:void(0);" onclick="orderAccess('${order.orderId}')" id="userAssess"><span
                                            class="glyphicon glyphicon-hand-up "></span>评价</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div align="center">
                    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                    ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=1">首页</a>
                    <c:choose>
                        <c:when test="${page.pageNow - 1 > 0}">
                            <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=${page.pageNow - 1}">上一页</a>
                        </c:when>
                        <c:when test="${page.pageNow - 1 <= 0}">
                            <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=1">上一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=${page.pageNow}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=${page.pageNow + 1}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=${page.totalPageCount}">下一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=${page.pageNow}">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/order/personOrder?pageNow=${page.totalPageCount}">尾页</a>
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
    function deleteActivity(activityId) {
        if(confirm("删除后不可恢复，您确定要删除吗？")){
            if (activityId != null) {
                window.location.href = 'activity/delete?activityId=' + activityId;
            }
        }
    }
    function refund(orderId) {
        if(confirm("您确定退款吗，退款后12小时后将为您处理")){
            if (orderId != null) {
                window.location.href = 'order/userRefund?orderId=' + orderId;
            }
        }
    }
    function orderAccess(orderId){
        $("#acc")[0].reset();
        $("#orderId").val(orderId);
    }

    /*五星评价*/
    $(document).ready(function(){
        var shixin = "★";
        var kongxin = "☆";
        /*var flag = false;//没有点击*/
        $("li").mouseenter(function(){
            /*$(this).text(shixin).prevAll().text(shixin);
            $(this).nextAll().text(kongxin);*/
            $(this).text(shixin).prevAll().text(shixin).end().nextAll().text(kongxin);
        });
        $(".comment").mouseleave(function(){
            /* if(!flag){
                 $("li").text(kongxin);
             }*/
            $("li").text(kongxin);
            $(".clicked").text(shixin).prevAll().text(shixin);
        });
        $("li").on("click",function(){
            /* $(this).text(shixin).prevAll().text(shixin);
             $(this).nextAll().text(kongxin);
             flag = true;*/
            $(this).addClass("clicked").siblings().removeClass("clicked");
        });
    });
    /*上传相片*/
    var pictureUrl=''
    function ProcessFile(e) {
        var file = document.getElementById('file').files[0];
        if (file) {
            var reader = new FileReader();
            reader.onload = function (event) {
                var txt = event.target.result;

                var img = document.createElement("img");
                img.src = txt;//将图片base64字符串赋值给img的src
                // console.log(txt);
                document.getElementById("result").appendChild(img);
            };
        }
        reader.readAsDataURL(file);
        pictureUrl += file.name +",";
    }

    function contentLoaded() {
        document.getElementById('file').addEventListener('change',
            ProcessFile, false);
    }

    window.addEventListener("DOMContentLoaded", contentLoaded, false);
    /*end*/
    var sum;
    $("ul li").click(function () {
        sum = $(this).val();
    });

    function Save() {
        var access = $("#access").val().trim();
        if(access !='' & access.length <=200){
            $("#myModal").modal('hide');
            $("#error").html("");
        /*    $("#userAssess").removeAttr("data-toggle");*/
            $("#userAssess").removeAttr("data-target");
            $("#userAssess").attr("disabled","disabled");
            $.ajax({
                url:"order/createSales",
                type:"post",
                datatype:"text",
                data:{"orderId":$("#orderId").val(),"pictureUrl":pictureUrl,
                    "sum":sum,"access":access
                },
                error:function(){
                    alert("数据异常");
                }
            });
        }else{
            $("#error").html("文字评价不能为空并且不能超过200字");
        }

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

    function deleteAllPersonOrder() {
        if(confirm("批量删除后将不可恢复，你确定要进行此操作吗？")){

            text = $("input:checkbox[name='orderIds']:checked").map(function(index,elem) {
                return $(elem).val();
            }).get().join(',');
            window.location.href='order/deleteAllPerson?text=' + text;
        }
    }
</script>
</body>
</html>

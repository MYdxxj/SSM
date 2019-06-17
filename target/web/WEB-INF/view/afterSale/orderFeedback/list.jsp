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
<style>
   #first th td{
       width: 200px;
   }
    #table td{
        width: 200px;
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人订单售后</strong> /
                <small>操作模块</small>
                &emsp;<button type="button" class="btn btn-default" id="checkall">
                    <span class="icon-check"></span> 全选
                </button>&emsp;<input type="button" class="btn btn-danger" onclick="deleteAllOrderFeedback()"
                                      value="批量删除">
            </div>
            <%--<a class="btn btn-default" href="javascript:void(0)" onclick="newActivity();" role="button" data-toggle='modal'
               data-target='#myModal' style="margin-left: 30px"><span class="glyphicon glyphicon-plus"></span>新增活动</a>--%>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table" id="first" style="height: 50px;margin-bottom: 0px;">
                    <thead>
                    <tr>
                        <%--<th width="160px">订单编号</th>
                        <th>图片</th>
                        <th style="padding-left: 110px;width: 450px;">创建时间</th>
                        <th style="width: 340px;padding-left: 45px;">服务描述</th>
                        <th >管理</th>--%>
                            <th>订单编号</th>
                            <th>图片</th>
                            <th>创建时间</th>
                            <th>服务描述</th>
                            <th>管理</th>
                    </tr>
                    </thead>
                </table>
                <div style="height:450px; overflow-y: scroll;margin-top: 0px;">
                    <table class="am-table am-table-bd am-table-striped admin-content-table" id="table">
                        <tbody id="tbody" >
                        <c:forEach items="${afterSalesList}" var="aftersales">

                            <tr>
                                <td><input type="checkbox" name="afterSalesIds" value="${aftersales.afterSalesId }"/>${aftersales.orderInformation}</td>
                                <td>${aftersales.waiterId}</td>
                                <td><fmt:formatDate
                                        value="${aftersales.afterSalesCreateTime}"
                                        pattern="yyyy-MM-dd hh:mm:ss" /></td>
                                <td>${aftersales.afterSalesDsc }</td>
                                <td><a class="btn btn-danger"
                                       href="javascript:void(0)"onclick="deleteAferSales('${aftersales.afterSalesId}')"><span
                                        class="am-icon-trash "></span>删除</a>&nbsp;&nbsp;
                                    <a class="btn btn-default" href="javascript:void(0);" onclick="userFeedback('${aftersales.afterSalesId}');"data-toggle="modal" data-target="#myModal"><span class="am-icon-send"></span>反馈</a>
                                </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- content end -->
    <jsp:include page="add.jsp" flush="true"/>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("#first td").css("text-align","center");
    $("#table td").css("text-align","center");
    $("#first th").css("text-align","center");
    $("#table th").css("text-align","center");
    function deleteAferSales(afterSalesId) {
        if(confirm("删除后不可恢复，您确定要删除吗？")){
            if (afterSalesId != null) {
                window.location.href = 'afterSales/deletePersonOrder?afterSalesId=' + afterSalesId;
            }
        }
    }
    function userFeedback(afterSalesId){
        $("#formi")[0].reset();
        $("#afterSalesId").val(afterSalesId);
    }
   function Save() {
        alert("反馈成功，请前往反馈管理中查看详情");
       $("#formi").submit();
   }
    $("#checkall").click(function() {
        $("input[name='afterSalesIds']").each(function() {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function deleteAllOrderFeedback() {
        if(confirm("批量删除后将不可恢复，你确定要进行此操作吗？")){

            text = $("input:checkbox[name='afterSalesIds']:checked").map(function(index,elem) {
                return $(elem).val();
            }).get().join(',');
            window.location.href='afterSales/deleteAllPersonOrder?text=' + text;
        }
    }
</script>
</body>
</html>

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
    <style>.font{color: red;}</style>
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">产品报价</strong> /
                <small>操作模块</small>
            </div>
            <a class="btn btn-default" href="javascript:void(0)" onclick="newProductPrice();" role="button" data-toggle='modal'
               data-target='#myModal' style="margin-left: 30px"><span class="glyphicon glyphicon-plus"></span>新增产品报价单</a>
            &emsp;<button type="button" class="btn btn-default" id="checkall">
            <span class="icon-check"></span> 全选
        </button>&emsp;<input type="button" class="btn btn-danger" onclick="deleteAllProductPrice()"
                              value="批量删除">
        </div>
        <div class="col-lg-5">
            <div class="input-group">
                <span class="input-group-addon glyphicon glyphicon-search"></span>
                <input type="text" class="form-control" name="findProductPrice" placeholder="Search for Product by Name">
                <span class="input-group-btn">
                <button class="btn btn-default" type="button" id="btnProductPrice">Go!</button>
                </span>
            </div>
        </div>
        <br/><br/>
    </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table">
                    <thead>
                    <tr>
                        <th>商品ID</th>
                        <th>商品名称</th>
                        <th>商品型号</th>
                        <th>商品进价</th>
                        <th>商品售价</th>
                        <th>商品来源</th>
                        <th>商品描述</th>
                        <th>创建时间</th>
                        <th>管理</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${productPrices}" var="PriceList">

                        <tr>
                            <td><input type="checkbox" name="priceListIds" value="${PriceList.priceListId }"/>${PriceList.priceListId }</td>
                            <td>${PriceList.productPriceName }</td>
                            <td>${PriceList.productListDesc }</td>
                            <td>${PriceList.productUnitPrice }</td>
                            <td>${PriceList.productSellingPrice}</td>
                            <td>${PriceList.productSourceCompany }</td>
                            <td>${PriceList.productRemark}</td>
                            <td><fmt:formatDate value="${PriceList.productListCreatetime}"
                                                pattern="yyyy-MM-dd hh:mm:ss" /></td>
                            <td><a class="btn btn-danger"
                                   href="javascript:void(0)"onclick="deleteProductPrice('${PriceList.priceListId}')"><span
                                    class="am-icon-trash "></span>删除</a>&nbsp;&nbsp;
                                <a class="btn btn-info"
                                   onclick="updateProductPrice('${PriceList.priceListId}','${PriceList.productPriceName }','${PriceList.productListDesc}','${PriceList.productUnitPrice}','${PriceList.productSellingPrice}','${PriceList.productSourceCompany }','${PriceList.productRemark}')"
                                   href='javascript:void(0)' id="updateProductPrice" data-toggle="modal" data-target="#myModal"
                                   style='cursor:pointer'><span class="glyphicon glyphicon-pencil"></span>修改</a>&nbsp;&nbsp;
                                <a class="btn btn-success"
                                   href="javascript:void(0)"onclick="purchase('${PriceList.priceListId}','${PriceList.productSellingPrice}');" data-toggle="modal" data-target="#purchase"><span
                                        class="glyphicon glyphicon-ok "></span>立即购买</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div align="center">
                    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                    ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=1">首页</a>
                    <c:choose>
                        <c:when test="${page.pageNow - 1 > 0}">
                            <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=${page.pageNow - 1}">上一页</a>
                        </c:when>
                        <c:when test="${page.pageNow - 1 <= 0}">
                            <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=1">上一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=${page.pageNow}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=${page.pageNow + 1}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=${page.totalPageCount}">下一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=${page.pageNow}">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/productPrice/pageList?pageNow=${page.totalPageCount}">尾页</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <jsp:include page="add.jsp" flush="true"/>
        <jsp:include page="purchase.jsp" flush="true"/>
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

    function deleteProductPrice(priceListId) {
        if(confirm("删除后不可恢复，您确定要删除吗？")){
            if (priceListId != null) {
                window.location.href = 'productPrice/delete?priceListId=' + priceListId;
            }
        }
    }
    function purchase(priceListId,productSellingPrice) {
        $("#form")[0].reset();
        $("#priceId").val(priceListId);
        $("#price").val(productSellingPrice);
    }
    function updateProductPrice(priceListId, productPriceName, productListDesc, productUnitPrice, productSellingPrice,productSourceCompany,productRemark) {
       $("#error").html("");
        $("#formi")[0].reset();
        $("#priceListId").val(priceListId);
        $("#myModalLabel").html("修改产品定价");
        $("#productPriceName").val(productPriceName);
        $("#productPriceName").attr("disabled","disabled");
        $("#productListDesc").val(productListDesc);
        $("#productListDesc").attr("disabled","disabled");
        $("#productUnitPrice").val(productUnitPrice);
        $("#productSellingPrice").val(productSellingPrice);
        $("#productSourceCompany").val(productSourceCompany);
        $("#productRemark").val(productRemark);
        $("#formi").attr("action", "/productPrice/update");
    }

    function Save() {
        var productPriceName = $("#productPriceName").val().trim();
        var productListDesc = $("#productListDesc").val().trim();
        var productUnitPrice = $("#productUnitPrice").val().trim();
        var productSellingPrice = $("#productSellingPrice").val().trim();
        var productSourceCompany = $("#productSourceCompany").val().trim();
        if(productPriceName!='' & productListDesc != '' & productUnitPrice !='' & productSellingPrice != '' & productSourceCompany!=''){
            $("#formi").submit();
        }else{
            $("#error").html("必填项不能为空");
        }
    }

    function newProductPrice() {
        $("#myModalLabel").html("新增产品定价");
        $("#formi").attr("action", "/productPrice/newProductPrice");
        $("#formi")[0].reset();
    }
    $("#btnProductPrice").click(function(){
        var value = $(" input[name='findProductPrice']").val();
        var info = ""
        $.ajax({
            url:"productPrice/likeSearch",
            type:"get",
            data: {"productInput":value},
            datatype:"json",
            success:function(data){
                var productPrices=eval(data);
                for (var i = 0; i <productPrices.length ; i++) {
                    info += "<tr><td>"+productPrices[i].priceListId+"</td><td>"+productPrices[i].productPriceName+"</td>"+
                        "<td>"+productPrices[i].productListDesc+"</td><td>"+productPrices[i].productUnitPrice+"</td><td>"+productPrices[i].productSellingPrice+"</td><td>"+productPrices[i].productSourceCompany+"</td><td>"+productPrices[i].productRemark+"</td>" +
                        "<td>"+new Date(productPrices[i].productListCreatetime).Format("yyyy-MM-dd hh:mm:ss")+
                        "</td><td><a class='btn btn-info' onclick='deleteProductPrice("+productPrices[i].priceListId+")' href='javascript:void(0)' style='cursor:pointer'><span  class='am-icon-trash '></span>删除</a>&nbsp;" +
                        "&emsp;<a  class='btn btn-danger' onclick='updateProductPrice(\""+productPrices[i].priceListId+"\",\""+productPrices[i].productPriceName+"\",\""+productPrices[i].productListDesc+"\",\""+productPrices[i].productUnitPrice+"\",\""+productPrices[i].productSellingPrice+"\",\""+productPrices[i].productSourceCompany+"\",\""+productPrices[i].productRemark+ "\")'" +
                        " href='javascript:void(0)'id='updateProductPrice' data-toggle='modal' data-target='#myModal' style='cursor:pointer'><span  class='glyphicon glyphicon-pencil '></span>修改</a></td></tr>";
                }
                $("#tbody").html(info);
            }
        });
    });
    function add(){
        var sum  = parseInt($("#number").val())+1;
        if(sum>=16){}else{$("#number").val(sum);}

    }
    function reduce(){
        var red  = parseInt($("#number").val())-1;
        if(red<=0){}else{$("#number").val(red);}
    }
    $("#numberSumit").click(function () {
        alert("购买成功，请前往用户订单管理查看");
        $("#form").submit();
    });

    $("#checkall").click(function() {
        $("input[name='priceListIds']").each(function() {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function deleteAllProductPrice() {
        if(confirm("批量删除后将不可恢复，你确定要进行此操作吗？")){

            text = $("input:checkbox[name='priceListIds']:checked").map(function(index,elem) {
                return $(elem).val();
            }).get().join(',');
            window.location.href='productPrice/deleteAll?text=' + text;
        }
    }
</script>
</body>
</html>

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
    <style>.font{color:red;}</style>
    <script type="text/javascript">
        /*二级联动*/
        var citys=new Array(
            new Array("密云区","延庆区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区 ","通州区","顺义区","昌平区","大兴区","怀柔区","平谷区","东城区","西城区"),
            new Array("滨海新区","和平区","河北区","河东区","河西区","南开区","红桥区","东丽区","西青区","津南区","北辰区","武清区","宝坻区","静海区","宁河区","蓟州区"),
            new Array("黄浦区","徐汇区","长宁区","静安区","普陀区","虹口区","杨浦区","宝山区","闵行区","嘉定区","浦东新区","松江区","金山区","青浦区","奉贤区","崇明区"),
            new Array("渝中区","江北区","沙坪坝区","九龙坡区","南岸区","北碚区","渝北区","巴南区","万州区","涪陵区","永川区","璧山区","大足区","綦江区","江津区","合川区","黔江区","长寿区","南川区","铜梁区","潼南区","荣昌区","开州区","梁平区","武隆区。"),
            new Array("石家庄市","唐山市","秦皇岛市","邯郸市","邢台市","保定市","张家口市","承德市","沧州市","廊坊市","衡水市"),
            new Array("太原市","大同市","阳泉市","长治市","晋城市","朔州市","晋中市","运城市","忻州市","临汾市","吕梁市"),
            new Array("沈阳市","大连市","鞍山市","抚顺市","本溪市","丹东市","锦州市","营口市","阜新市","辽阳市","盘锦市","铁岭市","朝阳市","葫芦岛市"),
            new Array("长春市","吉林市","四平市","辽源市","通化市","白山市","松原市","白城市"),
            new Array("哈尔滨市","齐齐哈尔市","牡丹江市","佳木斯市","七台河市","大庆市","黑河市","绥化市","伊春市","鹤岗市","双鸭山市","鸡西市"),
            new Array("常州市","徐州市","南京市","淮安市","南通市","宿迁市","无锡市","扬州市","盐城市","苏州市","泰州市","镇江市","连云港市"),
            new Array("杭州市","湖州市","嘉兴市","金华市","丽水市","宁波市","衢州市","绍兴市","台州市","温州市","舟山市"),
            new Array("合肥市","芜湖市","蚌埠市","淮南市","淮北市","黄山市","铜陵市","安庆市","桐城市","滁州市","天长市","明光市","阜阳市","界首市六安市","亳州市","池州市。 省级直辖县级市：界首市","桐城市","天长市","明光市","宁国市"),
            new Array("福州市","龙岩市","南平市","宁德市","莆田市","泉州市","三明市","厦门市","漳州市"),
            new Array("南昌市","赣州市","吉安市","萍乡市","宜春市","新余市","景德镇市","抚州市","九江市","上饶市","鹰潭市"),
            new Array("济南市","青岛市","淄博市","枣庄市","东营市","烟台市","潍坊市","济宁市","泰安市","威海市","日照市","滨州市","德州市","聊城市","临沂市","菏泽市","莱芜市"),
            new Array("郑州市","开封市","洛阳市","平顶山市","焦作市","鹤壁市","新乡市 ","安阳市","濮阳市","许昌市","漯河市","三门峡市","南阳市","商丘市","信阳市","周口市","驻马店市","济源市"),
            new Array("武汉市","黄冈市","黄石市","十堰市","宜昌市","襄阳市","鄂州市","荆门市","孝感市","荆州市","咸宁市","随州市"),
            new Array("长沙市","株洲市","湘潭市","衡阳市","邵阳市","岳阳市","常德市","张家界市","益阳市","郴州市","永州市","怀化市","娄底市"),
            new Array("广州市（副省级城市）","深圳市（副省级城市）","佛山市","东莞市","中山市","珠海市","江门市","肇庆市","惠州市","汕头市","潮州市","揭阳市","汕尾市","湛江市","茂名市","阳江市","韶关市","清远市","云浮市","梅州市","河源市"),
            new Array("海口市","三亚市"," 三沙市 ","儋州市"),
            new Array("成都市","自贡市","攀枝花市","泸州市"," 德阳市","绵阳市","广元市","遂宁市"," 内江市","乐山市","南充市"," 宜宾市"," 广安市","达州市","眉山市","雅安市"," 巴中市","资阳市"),
            new Array("贵阳市","遵义市","安顺市","黔南苗族布依族自治州 ","黔东南苗族侗族自治州 ","铜仁市 ","毕节市 ","六盘水市 ","黔西南苗族布依族自治州"),
            new Array("昆明市","曲靖市","昭通市","玉溪市","楚雄州","红河州","文山州","普洱市","版纳州","大理州","保山市","德宏州","丽江市","怒江州","迪庆州","临沧市"),
            new Array("榆林市","延安市","铜川市","渭南市","宝鸡市","西安市","安康市","汉中市","咸阳市"),
            new Array("兰州市","嘉峪关市","金昌市","白银市","天水市","酒泉市","张掖市","武威市","定西市","陇南市","平凉市","庆阳市","宁夏回族自治州","甘南藏族自治州"),
            new Array("西宁市，格尔木市，德令哈市"),
            new Array("台北市","新北市","桃园市","台中市","台南市","高雄市"),
            new Array("呼和浩特市","包头市","乌海市","赤峰市","通辽市","鄂尔多斯市","呼伦贝尔市","巴彦淖尔市","乌兰察布市"),
            new Array("南宁市","柳州市","桂林市","梧州市","北海市","防城港市","钦州市","贵港市","玉林市","百色市","贺州市","河池市","来宾市","崇左市"),
            new Array("拉萨市","日喀则市","昌都市","林芝市","山南市","那曲市"),
            new Array("银川市","石嘴山市","吴忠市","固原市","中卫市"),
            new Array("乌鲁木齐市","克拉玛依市","吐鲁番市","哈密市"),
            new Array("香港"),
            new Array("澳门")
        );
        function scity(pname,cname){
            var province=['北京市','天津市','上海市','重庆市','河北省','山西省','辽宁省','吉林省','黑龙江省','江苏省','浙江省','安徽省','福建省','江西省','山东省','河南省','湖北省','湖南省','广东省','海南省','四川省','贵州省','云南省','陕西省','甘肃省','青海省','台湾省','内蒙古自治区','广西壮族自治区','西藏自治区','宁夏回族自治区','新疆维吾尔自治区','香港特别行政区','澳门特别行政区'];
            /*document.write('<select id="pro" onchange="selectc(this)" name="'+pname+'">');*/
            document.write('<select id="pro" onchange="selectc(this)" name="pro">');
            document.write('<option value="">--选择省份--</option>')
            for(var i=0;i<province.length;i++){
                document.write('<option value="'+province[i]+'">'+province[i]+'</option>');
            }
            document.write('</select>');
           /* document.write('<select id="city" name="'+cname+'">');*/
            document.write('<select id="city" name="city">');
            document.write('<option value="">--选择城市--</option>');
            document.write('</select>');
            selectc(document.getElementById("pro"));
        }
        function selectc(pobj){
            var index=pobj.selectedIndex-1;
            var cobj=document.getElementById("city");
            cobj.innerHTML='';
            if(index>=0){
                for(var i=0;i<citys[index].length;i++){
                    var option=document.createElement("option");
                    var text=citys[index][i];
                    option.value=text;
                    option.innerHTML=text;
                    cobj.appendChild(option);
                }
            }else{
                var option=document.createElement("option");
                option.value="";
                option.innerHTML="--选择城市--";
                cobj.appendChild(option);
            }
        }
    </script>
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
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户信息收集</strong> /
                <small>操作模块</small>
            </div>
           <%-- <a class="btn btn-default" href="javascript:void(0)" onclick="newUserMsg();" role="button" data-toggle='modal'
               data-target='#myModal' style="margin-left: 30px"><span class="glyphicon glyphicon-plus"></span>新增用户信息收集</a>--%>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <table class="am-table am-table-bd am-table-striped admin-content-table">
                    <thead>
                    <tr>
                        <th>用户编号</th>
                        <th>用户年龄</th>
                        <th>用户性别</th>
                        <th>用户邮件</th>
                        <th>用户电话</th>
                        <th>用户地址</th>
                        <th>用户产品爱好</th>
                        <th>管理</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${userMsgList}" var="u">

                        <tr>
                            <td>${u.userId}</td>
                            <td>${u.userAge }</td>
                            <td>${u.userSex}</td>
                            <td>${u.userEmail}</td>
                            <td>${u.userPhone}</td>
                            <td>${u.userAddr}</td>
                            <td>${u.userProHobby}</td>
                            <td><%--<a class="btn btn-danger"
                                   href="javascript:void(0)"onclick="deleteUserMsg('${u.userMsgId}')"><span
                                    class="am-icon-trash "></span>删除</a>--%>
                                <a class="btn btn-info"
                                   onclick="updateUserMsg('${u.userMsgId}','${u.userAge}','${u.userSex}','${u.userEmail}','${u.userPhone}','${u.userAddr}','${u.userProHobby}')"
                                   href='javascript:void(0)' id="updateUserMsg" data-toggle="modal" data-target="#myModal"
                                   style='cursor:pointer'><span class="glyphicon glyphicon-pencil"></span>修改</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div align="center">
                    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
                    ${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=1">首页</a>
                    <c:choose>
                        <c:when test="${page.pageNow - 1 > 0}">
                            <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=${page.pageNow - 1}">上一页</a>
                        </c:when>
                        <c:when test="${page.pageNow - 1 <= 0}">
                            <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=1">上一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=${page.pageNow}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=${page.pageNow + 1}">下一页</a>
                        </c:when>
                        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=${page.totalPageCount}">下一页</a>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page.totalPageCount==0}">
                            <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=${page.pageNow}">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/userMsg/pageList?pageNow=${page.totalPageCount}">尾页</a>
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
<%--<script src="<%=basePath%>../staticjs/china.js"></script>--%>
<script type="text/javascript">
    $("td").css("text-align","center");
    $("th").css("text-align","center");
    function userMsgRole(userMsgId) {
        if (userMsgId != null) {
            window.location.href = 'userMsg/getUserMsg?userMsgId=' + userMsgId;
        }
    }

    function updateUserMsg(userMsgId, userAge, userSex, userEmail, userPhone, userAddr, userProHobby) {
        $("#error").html("");
        $("#formi")[0].reset();
        $("#userMsgId").val(userMsgId);
        $("#myModalLabel").html("修改用户信息收集");
        $("#userAge").val(userAge);
        $("#userSex").val(userSex);
        $("#userEmail").val(userEmail);
        $("#userPhone").val(userPhone);
        /*$("#userAddr").val(userAddr);*/
      /*  var array = userAddr.split(",");
        $("#pro").val(array[0].trim());
        c(array[1].trim());*/
        /*$("#city").val(array[1].trim());*/
        $("#userProHobby").val(userProHobby);
        $("#formi").attr("action", "/userMsg/update");
    }

    function Save() {
        var userAge = $("#userAge").val().trim();
        var userSex = $("#userSex").val().trim();
        var userEmail = $("#userEmail").val().trim();
        var userPhone = $("#userPhone").val().trim();
       /* var userAddr = $("#userAddr").val().trim();*/
        var province = $("#pro").val().trim();
        var city = $("#city").val().trim();
        if(userAge!='' &userSex !='' & userEmail !='' & userPhone !='' & province !="" & city !=''){
            $("#formi").submit();
        }else{
            $("#error").html("必填项不能为空");
        }
    }

</script>
</body>
</html>

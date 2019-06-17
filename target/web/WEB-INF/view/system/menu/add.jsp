    <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--
          Created by IntelliJ IDEA.
          User: Administrator
          Date: 2019/1/19
          Time: 17:56
          To change this template use File | Settings | File Templates.
        --%>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
        </div>
        <div class="modal-body">
        <form class="am-form am-form-horizontal" method="post" id="form" action="">
        <input type="hidden" id="menuId" name="menuId"/>
        <div class="am-form-group">
                <label for="menuName" class="am-u-sm-3 am-form-label">菜单名称 / Name</label>
                <div class="am-u-sm-9">
            <input type="text" id="menuName"name="menuName" placeholder="菜单描述 / Menu Name"><font class="font">*</font>
                </div>
        </div>

        <div class="am-form-group">
                <label for="menuPid" class="am-u-sm-3 am-form-label">父级菜单 / Parent</label>
                <div class="am-u-sm-9">
                       <%-- <input type="email" id="menuPid" name="menuPid"placeholder="输入父及菜单 / Parent Menu">--%>
                    <select id="menuPid" name="menuPid" scrolling="auto">
                            <option value="">---请选择父级菜单---</option>
                            <option>root</option>
                            <c:forEach items="${menus}" var="menu">
                                    <c:if test="${menu.menuPid=='root'}">
                                            <option value="${menu.menuId}">${menu.menuName}</option>
                                    </c:if>
                            </c:forEach>
                    </select><font class="font">*</font>
                </div>

        </div>

        <div class="am-form-group">
        <label for="menuDesc" class="am-u-sm-3 am-form-label">菜单描述 / Describe</label>
        <div class="am-u-sm-9">
        <input type="email" id="menuDesc" name="menuDesc"placeholder="输入菜单的描述 / Describe">
        </div>
        </div>

        <div class="am-form-group">
        <label for="menuUrl" class="am-u-sm-3 am-form-label">菜单地址 / Address</label>
        <div class="am-u-sm-9">
        <input type="email" id="menuUrl" name="menuUrl"placeholder="输入菜单地址 / Address">
        </div>
        </div>

        </form>
        </div>
        <div class="modal-footer">
            <center> <font class="font"id="error"></font>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="save" onclick="Save();">Save changes</button></center>
        </div>
        </div>
        </div>
        </div>
        <%--end model--%>


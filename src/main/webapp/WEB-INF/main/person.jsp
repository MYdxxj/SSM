<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog" style="padding: 5px;">
        <div class="am-modal-bd">
            个人资料
        </div>
        <form action="/user/update" method="post">
            <input type="hidden" id="userId" name="userId" value="${user.userId}"/>
            <div class="am-form-group" style="margin-top: 10px">
                <label for="loginName" class="am-form-label">登录名:</label>&emsp;
                <input type="text" id="loginName"disabled="disabled" name="loginName" value="${user.loginName}">
            </div>
            <div class="am-form-group" style="margin-top: 5px">
                <label for="userName" class="am-form-label">姓&emsp;名:</label>&emsp;
                <input type="text" id="userName"name="userName" value="${user.userName}">
            </div>
            <div class="am-form-group" style="margin-top: 5px">
                <label for="userSex" class="am-form-label">姓&emsp;别:</label>&emsp;
                <input type="text" id="userSex"name="userSex" value="${user.userSex}">
            </div>
            <div class="am-form-group" style="margin-top: 5px">
                <label for="userBirthday" class="am-form-label">生&emsp;日:</label>&emsp;
                <input type="date" style="width: 180px" id="userBirthday"name="userBirthday"value="<fmt:formatDate value="${user.userBirthday}"
                                                                                                             pattern="yyyy-MM-dd"/>">
            <div class="am-form-group" style="margin-top: 5px">
                <label for="userPhone" class="am-form-label">手机号:</label>&emsp;
                <input type="text" id="userPhone"name="userPhone" value="${user.userPhone}">
            </div>
            <center>
                <input type="submit" class="am-btn am-btn-active" data-dismiss="modal"style="background-color: #0b6fa2" value="保存"/>
                <input type="button" class="am-modal-btn" data-dismiss="modal" style="background-color: #f7f7f7;margin-left: 10px; " value="取消"/>
            </center>
            <%--<div class="am-modal-footer">
                <span class="am-modal-btn">关闭</span>
            </div>--%>
        </form>

    </div>
</div>
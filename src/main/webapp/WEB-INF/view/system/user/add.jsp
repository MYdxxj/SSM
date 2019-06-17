<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
                <form class="am-form am-form-horizontal" method="post" id="formi" action="">
                    <input type="hidden" id="userId" name="userId"/>
                    <div class="am-form-group">
                        <label for="loginName" class="am-u-sm-3 am-form-label">登录名 / Name</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="loginName"name="loginName" placeholder="姓名 / Name"><font class="font">*</font>
                            <small>输入登录名。</small>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="userName" class="am-u-sm-3 am-form-label">真实姓名 / Name</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="userName"name="userName" placeholder="姓名 / Name"><font class="font">*</font>
                            <small>输入真实名字，让我们记住你。</small>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="sex" class="am-u-sm-3 am-form-label">性别 / Sex</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="sex" name="sex"placeholder="输入您的性别 / Sex"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="userPhone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="userPhone" name="userPhone"placeholder="输入您的电话号码 / Telephone">
                        </div>
                    </div>



                    <div class="am-form-group">
                        <label for="userBirthday" class="am-u-sm-3 am-form-label">生日 / Birthday</label>
                        <div class="am-u-sm-9">
                            <input type="date" id="userBirthday" name="userBirthday"  placeholder="输入您的生日 / Birthday"><font class="font">*</font>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <center>
                &emsp;<font class="font" id="error"></font>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save" onclick="Save();">Save changes</button>
                </center>
            </div>
        </div>
    </div>
</div>
<%--end model--%>


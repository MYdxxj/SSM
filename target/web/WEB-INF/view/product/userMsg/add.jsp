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
                    <input type="hidden" id="userMsgId" name="userMsgId"/>
                    <div class="am-form-group">
                        <label for="userAge" class="am-u-sm-3 am-form-label">用户年龄 / Age</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="userAge"name="userAge" placeholder="用户年龄 / Age"><font class="font">*</font>
                            <small>输入用户年龄。</small>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="userSex" class="am-u-sm-3 am-form-label">用户性别 / Sex</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="userSex"name="userSex" placeholder="用户性别 / Sex"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="userEmail" class="am-u-sm-3 am-form-label">邮件 / Email</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="userEmail" name="userEmail"placeholder="输入您的邮件 / Email"><font class="font">*</font>
                            <small>让我们更懂你...</small>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="userPhone" class="am-u-sm-3 am-form-label">电话 / Phone</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="userPhone" name="userPhone"placeholder="输入您的电话 / Phone"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="userAddr" class="am-u-sm-3 am-form-label">地址 / Address</label>
                        <div class="am-u-sm-9" id="userAddr">
                            <script>scity('p','c');</script>
                           <%-- <input type="email" id="userAddr" name="userAddr"placeholder="输入您的地址 / Address">--%><font class="font">*</font>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="userProHobby" class="am-u-sm-3 am-form-label">产品爱好 / Hobby</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="userProHobby" name="userProHobby"  placeholder="输入您的产品爱好 / Hobby">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <center>
                    <font class="font" id="error"></font>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="save" onclick="Save();">Save changes</button>
                </center>
            </div>
        </div>
    </div>
</div>
<%--end model--%>


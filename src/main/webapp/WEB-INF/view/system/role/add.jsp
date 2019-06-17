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
                    <input type="hidden" id="roleId" name="roleId"/>
                    <div class="am-form-group">
                        <label for="roleName" class="am-u-sm-3 am-form-label">角色名称 / Name</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="roleName"name="roleName" placeholder="角色名称 / Name"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="roleDesc" class="am-u-sm-3 am-form-label">角色描述 / Describe</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="roleDesc" name="roleDesc"placeholder="描述角色 / Describe"></label><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="State" class="am-u-sm-3 am-form-label">角色状态 / State</label>
                        <div class="am-u-sm-9" id="State">
                           <%-- <input type="email" id="roleState" name="roleState"placeholder="角色状态 / State">--%>
                               <label class="am-btn am-btn-default am-btn-xs">
                                   <input type="radio" name="roleState" id="option1"value="启用"> 启用
                               </label>
                               <label class="am-btn am-btn-default am-btn-xs">
                                   <input type="radio" name="roleState" id="option3" value="禁用"> 禁用

                        </div>
                    </div>
                    <%--<div class="am-form-group">
                        <label for="roleDesc" class="am-u-sm-3 am-form-label">角色权限 / authority</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="authority" name="authority"placeholder="角色权限 / authority">
                        </div>
                    </div>--%>
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


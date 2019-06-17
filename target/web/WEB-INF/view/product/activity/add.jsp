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
                    <input type="hidden" id="activityId" name="activityId"/>
                    <div class="am-form-group">
                        <label for="activityName" class="am-u-sm-3 am-form-label">活动名称 / Activity Name</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="activityName"name="activityName" placeholder="请输入活动名称 / Avtivity Name"><font class="font">*</font>
                            <small>输入活动名称。</small>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="activityType" class="am-u-sm-3 am-form-label">活动类型 / Type</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="activityType"name="activityType" placeholder="请输入活动类型 / Type"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="activityStatus" class="am-u-sm-3 am-form-label">状态 / Status</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="activityStatus" name="activityStatus"placeholder="请输入状态 / Status"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="activityDescription" class="am-u-sm-3 am-form-label">活动描述 / Description</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="activityDescription" name="activityDescription"placeholder="请输入活动描述 / Description">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="activityTime" class="am-u-sm-3 am-form-label">活动时间 / Activity Time</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="activityTime" name="activityTime"placeholder="请输入活动时间 / Activity Time"><font class="font">*</font>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <center>
                    <font class="font"id="error"></font>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="save" onclick="Save();">Save changes</button>
                </center>
            </div>
        </div>
    </div>
</div>
<%--end model--%>


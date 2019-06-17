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
                    <input type="hidden" id="feedbackId" name="feedbackId"/>
                    <div class="am-form-group">
                        <label>谢谢您的反馈，我们近期与您联系，请保持畅通！</label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save" onclick="Save();">提交反馈</button>
            </div>
        </div>
    </div>
</div>
<%--end model--%>


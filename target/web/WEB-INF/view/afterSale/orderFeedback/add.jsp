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
                <h4 class="modal-title" id="myModalLabel">产品反馈</h4>
            </div>
            <div class="modal-body">
                <form class="am-form am-form-horizontal" method="post" id="formi" action="feedback/userFeedback">
                    <input type="hidden" id="afterSalesId" name="afterSalesId"/>
                    <div class="am-form-group">
                        <label>请写下该产品所存现在的问题</label>
                        <textarea id="question" name="question"placeholder="请输入1~200字"></textarea>
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


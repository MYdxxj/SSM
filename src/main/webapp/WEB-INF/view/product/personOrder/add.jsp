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
                <form class="am-form am-form-horizontal" method="post" id="acc" action="">
                    <input type="hidden" id="orderId" name="orderId"/>
                    <div class="am-form-group">
                        <label for="stare" class="am-u-sm-3 am-form-label">五星评价</label>
                        <div class="am-u-sm-9">
                               <ul class="comment" id="stare"name="stare">
                                   <li value="1">☆</li>
                                   <li value="2">☆</li>
                                   <li value="3">☆</li>
                                   <li value="4">☆</li>
                                   <li value="5">☆</li>
                               </ul>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="file" class="am-u-sm-3 am-form-label">上传相片 / Photo</label>
                        <div class="am-u-sm-9">
                            <input type="file" id="file" name="file"/>
                            <div id="result"></div>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="access" class="am-u-sm-3 am-form-label">文字评价 / Access</label>
                        <div class="am-u-sm-9">
                            <textarea id="access" name="access"placeholder="请输入1~200字"></textarea>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <center>
                    <font class="font"id="error"></font>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary"  id="save" onclick="Save();">Save changes</button>
                </center>
            </div>
        </div>
    </div>
</div>
<%--end model--%>


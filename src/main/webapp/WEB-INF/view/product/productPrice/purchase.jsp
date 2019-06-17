<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/19
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<!-- Modal -->
<div class="modal fade" id="purchase" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">产品购买</h4>
            </div>
            <div class="modal-body">
                <form class="am-form am-form-horizontal" method="post" id="form" action="/order/purchase">
                    <input type="hidden" id="priceId" name="priceId"/>
                    <input type="hidden" id="price" name="price"/>
                    <div class="am-form-group">
                        <label for="number" class="am-u-sm-3 am-form-label">购买数量:</label>
                        <div class="am-u-sm-2" style="float: left;">
                            <input type="text" name="number" id="number" value="1" oninput="value=value.replace(/[^\d]/g,'')">
                        </div>
                        <div style="float: left;">
                            <div class="btn" style="height: 20px;width:20px;" onclick="add();"><span class="glyphicon glyphicon-plus"></span></div>
                            <div class="btn" style="height: 20px;width:20px;" onclick="reduce();"><span class="glyphicon glyphicon-minus"></span></div>

                        </div>
                        <font class="font" id="msg">&emsp;&emsp;注意：只能输入1~15数字</font>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <center>
                    <button type="button" class="btn btn-primary" id="numberSumit">购买</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </center>
            </div>
        </div>
    </div>
</div>
<%--end model--%>


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
                    <input type="hidden" id="afterSalesId"name="afterSalesId" placeholder="请输入服务编号 / Service">
                    <div class="am-form-group">
                        <label for="orderInformation" class="am-u-sm-3 am-form-label">订单编号 / Order</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="orderInformation"name="orderInformation" placeholder="请输入订单编号 / Order"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="waiterId" class="am-u-sm-3 am-form-label">客服编号 / Client</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="waiterId" name="waiterId"placeholder="客服编号 / Client"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="afterSalesDsc" class="am-u-sm-3 am-form-label">服务描述 / Desc</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="afterSalesDsc" name="afterSalesDsc"placeholder="服务描述 / Desc">
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


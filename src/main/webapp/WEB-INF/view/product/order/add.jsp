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
                    <input type="hidden" id="orderId" name="orderId"/>
                    <div class="am-form-group">
                        <label for="orderType" class="am-u-sm-3 am-form-label">订单类型 / Order type</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="orderType"name="orderType" placeholder="请输入订单类型 / Order type"><font class="font">*</font>
                            <small>输入订单类型。</small>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="orderState" class="am-u-sm-3 am-form-label">订单状态 / State</label>
                        <div class="am-u-sm-9">
                            <select id="orderState"name="orderState" >
                                <option>退款中</option>
                                <option>已付款（未收货）</option>
                                <option>已付款（已收货）</option>
                                <option>未付款</option>
                            </select> <font class="font">*</font>
                        </div>

                    </div>

                    <div class="am-form-group">
                        <label for="userId" class="am-u-sm-3 am-form-label">用户ID / Sex</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="userId" name="userId"placeholder="用户ID / user"><font class="font">*</font>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="orderDesc" class="am-u-sm-3 am-form-label">所购物品 / Purchase</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="orderDesc" name="orderDesc"placeholder="所购物品 / Purchase"><font class="font">*</font>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="orderTotal" class="am-u-sm-3 am-form-label">订单总价 / Sum</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="orderTotal" name="orderTotal"placeholder="订单总价 / Total"><font class="font">*</font>
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


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
                    <input type="hidden" id="priceListId" name="priceListId"/>
                    <div class="am-form-group">
                        <label for="productPriceName" class="am-u-sm-3 am-form-label">商品名称 / Product Name</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="productPriceName" data-validate="required:请输入商品名称" name="productPriceName" placeholder="请输入商品名称 / Product Name"><font class="font">*</font>
                            <small>输入商品名称。</small>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="productListDesc" class="am-u-sm-3 am-form-label">商品型号 / Model</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="productListDesc"name="productListDesc" placeholder="请输入商品型号 / Model"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="productUnitPrice" class="am-u-sm-3 am-form-label">产品进价 / Price</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="productUnitPrice" name="productUnitPrice"placeholder="产品进价 / Price"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="productSellingPrice" class="am-u-sm-3 am-form-label">商品售价 / Selling Price</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="productSellingPrice" name="productSellingPrice"placeholder="商品售价 / Selling Price"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="productSourceCompany" class="am-u-sm-3 am-form-label">商品来源 / Source</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="productSourceCompany" name="productSourceCompany"placeholder="商品来源 / Source"><font class="font">*</font>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="productRemark" class="am-u-sm-3 am-form-label">商品描述 / Description</label>
                        <div class="am-u-sm-9">
                            <input type="email" id="productRemark" name="productRemark"placeholder="商品描述 / Description">
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


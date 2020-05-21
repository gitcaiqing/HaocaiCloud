<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 用户详细模态框内容 -->
<div class="modal-dialog modal-lg" role="document">
  <div class="modal-content">
    <div class="modal-header">
      	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      	<h4 class="modal-title" id="myModalLabel">用户详细</h4>
    </div>
    <div class="modal-body">
    	<!-- 详情内容 -->
      	<form class="form-horizontal  form-p0" action="">
      		<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">用户类型：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${user.utype eq '0' ? '管理员':'普通用户' }"/>
				</div>
			</div>
      		<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">用户名：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${user.username }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">真实姓名：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${user.realname }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">年龄：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${user.age }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">手机号：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${user.mobile }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">邮件地址：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${user.email }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">创建时间：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value='<fmt:formatDate value="${user.credate }" pattern="yyyy-MM-dd HH:mm:ss"/>'/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">更新时间：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value='<fmt:formatDate value="${user.upddate }" pattern="yyyy-MM-dd HH:mm:ss"/>'/>
				</div>
			</div>
   			<!-- <div class="form-group" style="display:block">
				<label class="col-sm-3 control-label"><span class="req">*</span>头部引导语：</label>
				<div class="col-sm-9">
					<textarea rows="5" class="form-control"  required="required"  id="guide" maxlength="200" name="guide" ></textarea>
				</div>
			</div> -->
		</form>
    </div>
    <div class="modal-footer">
    	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
   		<!-- <button class="btn btn-primary">保存</button> -->
 	</div>
 </div>
</div>
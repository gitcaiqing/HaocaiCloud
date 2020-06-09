<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 用户详细模态框内容 -->
<div class="modal-dialog modal-lg" role="document">
  <div class="modal-content">
    <div class="modal-header">
      	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      	<h4 class="modal-title" id="myModalLabel">现场项目详细</h4>
    </div>
    <div class="modal-body">
    	<!-- 详情内容 -->
      	<form class="form-horizontal  form-p0" action="">
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">工单ID：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.workId }"/>
				</div>
			</div>
      		<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">项目类型：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.projectType eq 'CTSERVER' ? 'CTSERVER':'KMAPSERVER' }"/>
				</div>
			</div>
      		<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">项目标题：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.title }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">沟通群：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.communicationGroup }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">现场对接人：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.dockingPeople }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">部署状态：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.deploymentStatus eq 'START' ? '部署开始':'部署完成' }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">验收状态：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.acceptanceStatus eq 'ACCEPTED' ? '已验收': ( project.acceptanceStatus eq 'UNSEND' ? '未发送验收报告':'已发送验收报告' ) }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value="${project.memo }"/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">创建时间：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value='<fmt:formatDate value="${project.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/>'/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">更新时间：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value='<fmt:formatDate value="${project.updatedTime }" pattern="yyyy-MM-dd HH:mm:ss"/>'/>
				</div>
			</div>
			<div class="form-group" style="display:block">
				<label class="col-sm-3 control-label">完成时间：</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" class="form-control" value='<fmt:formatDate value="${project.completeTime }" pattern="yyyy-MM-dd HH:mm:ss"/>'/>
				</div>
			</div>
			<%--<div class="form-group" style="display:block">
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
			</div>--%>
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
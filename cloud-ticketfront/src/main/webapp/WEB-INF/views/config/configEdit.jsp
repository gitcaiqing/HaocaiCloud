<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />

<!-- 用户详细模态框内容 -->
<div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">用户${empty user ? '新增':'修改' }</h4>
        </div>
        <div class="modal-body">
            <!-- 详情内容 -->
            <form class="form-horizontal form-p0" enctype="multipart/form-data" action="" id="myEditform" method="post">
                <input name="id" type="hidden" value="${user.id }">
                <div class="form-group">
                    <label class="col-sm-3 control-label">项目类型：</label>
                    <div class="col-sm-9">
                        <select class="form-control" id="projectType" name="utype">
                            <option value="-1">请选择项目类型</option>
                            <option value="CTSERVER" <c:if test="${config.projectType eq 'CTSERVER' }">selected="selected"</c:if>>CT_SERVER </option>
                            <%--<option value="KMAPSERVER" <c:if test="${config.projectType eq 'KMAPSERVER' }">selected="selected"</c:if>>KMAP_SERVER </option>--%>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">项目类型：</label>
                    <div class="col-sm-9">
                        <select class="form-control" id="projectVersion" name="utype">
                            <option value="-1">请选择项目类型</option>
                            <option value="CTSERVER2.7.0" <c:if test="${config.projectVersion eq 'CTSERVER2.7.0' }">selected="selected"</c:if>>CTSERVER2.7.0 </option>
                            <option value="CTSERVER2.7.1" <c:if test="${config.projectVersion eq 'CTSERVER2.7.1' }">selected="selected"</c:if>>CTSERVER2.7.1 </option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">配置类型：</label>
                    <div class="col-sm-9">
                        <select class="form-control" id="configType" name="configType">
                            <option value="-1">请选择配置类型</option>
                            <option value="usermng-server" <c:if test="${config.configType eq 'CTSERVER2.7.0' }">selected="selected"</c:if>>usermng-server </option>
                            <option value="search-server" <c:if test="${config.configType eq 'CTSERVER2.7.1' }">selected="selected"</c:if>>search-server </option>
                            <option value="storage-server" <c:if test="${config.configType eq 'CTSERVER2.7.1' }">selected="selected"</c:if>>storage-server </option>
                            <option value="ws-server" <c:if test="${config.configType eq 'CTSERVER2.7.1' }">selected="selected"</c:if>>ws-server </option>
                            <option value="ct-server-web" <c:if test="${config.configType eq 'ct-server-web' }">selected="selected"</c:if>>ct-server-web </option>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label">配置文件地址：</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="projectUrl" id="projectUrl" value="${config.projectUrl }"/>
                    </div>
                </div>
                <%--<div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label">真实姓名：</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="realname" id="realname" value="${user.realname }"/>
                    </div>
                </div>
                <div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label">年龄：</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="age" id="age" value="${user.age }"/>
                    </div>
                </div>
                <div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label">手机号：</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mobile" id="mobile" value="${user.mobile }"/>
                    </div>
                </div>
                <div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label">邮件地址：</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="email" id="email" value="${user.email }"/>
                    </div>
                </div>--%>
                <div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label" for="inputFile">配置文件</label>
                    <div class="col-sm-9">
                        <input type="file" id="inputFile" name="file" id="file">
                    </div>

                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            <button class="btn btn-primary" onclick="onSaveOrUpdate()">保存</button>
        </div>
    </div>
</div>
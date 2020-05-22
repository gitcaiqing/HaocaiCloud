<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- 用户详细模态框内容 -->
<div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">用户${empty user ? '新增':'修改' }</h4>
        </div>
        <div class="modal-body">
            <!-- 详情内容 -->
            <form class="form-horizontal form-p0" action="" id="myEditform" method="post">
                <input type="hidden" name="id" value="${config.id }">
                <input type="hidden" name="configName" id="configName" value="${config.configName }">
                <input type="hidden" name="configUrl" id="configUrl" value="${config.configUrl }">
                <%--<input type="hidden" name="configContent" id="configContent" value="${config.configContent }">--%>
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
                    <label class="col-sm-3 control-label">项目版本：</label>
                    <div class="col-sm-9">
                        <select class="form-control" id="projectVersion" name="utype">
                            <option value="-1">请选择项目版本</option>
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
                <%--<div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label">配置文件地址：</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="projectUrl" id="projectUrl" value="${config.projectUrl }"/>
                    </div>
                </div>--%>
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
                <%--<div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label" for="file">配置文件</label>
                    <div class="col-sm-9">
                        <input type="file" id="file" multiple="multiple" name="file" id="file">
                    </div>

                </div>--%>
                <div class="form-group" style="display:block">
                    <label class="col-sm-3 control-label" for="file-pic">配置文件</label>
                    <div class="col-sm-9">
                        <input id="file-pic" name="file" type="file" value="上传" multiple/>
                        <p class="help-block">支持jpg、jpeg、png、gif,txt,"docx","zip","xlsx"格式，大小没限制</p>
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
<script>
    $('#file-pic').fileinput({
        //初始化上传文件框
        language: "zh",//配置语言
        showUpload : true, //显示整体上传的按钮
        showRemove : true,//显示整体删除的按钮
        uploadAsync: true,//默认异步上传
        uploadLabel: "上传",//设置整体上传按钮的汉字
        removeLabel: "移除",//设置整体删除按钮的汉字
        uploadClass: "btn btn-primary",//设置上传按钮样式
        showCaption: true,//是否显示标题
        dropZoneEnabled: false,//是否显示拖拽区域
        uploadUrl: '/om/file/uploadFile',//这个是配置上传调取的后台地址，本项目是SSM搭建的
        maxFileSize : 9999,//文件大小限制
        maxFileCount: 9,//允许最大上传数，可以多个，
        enctype: 'multipart/form-data',
        allowedFileExtensions : ["jpg", "png","gif","docx","zip","xlsx","txt","json"],/*上传文件格式限制*/
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        showBrowse: true,
        browseOnZoneClick: true,
        slugCallback : function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
    });

    //异步上传返回结果处理
    $("#file-pic").on("fileuploaded", function (event, data, previewId, index) {
        console.log("event:"+event);
        console.log("data:"+data);
        console.log("previewId:"+previewId);
        console.log("index:"+index);
        var response = data.response;
        console.log("response.fileName:"+response.fileName);
        console.log("response.fileUrl:"+response.fileUrl);
        console.log("response.fileContent:"+response.fileContent);
        $("#configName").val(response.fileName);
        $("#configUrl").val(response.fileUrl);
        //$("#configContent").val(response.fileContent);

    });

</script>
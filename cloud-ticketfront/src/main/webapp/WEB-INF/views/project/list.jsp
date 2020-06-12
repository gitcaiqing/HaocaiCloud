<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>部署现场管理列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<meta name="keywords" content="" />
<%@ include file="/common/common.jsp"%>

</head>
<body>
<div class="page-container">
	<!--/content-inner-->
	<div class="left-content">
		<div class="mother-grid-inner">
			<!-- 头部start -->
			<%@include file="/common/header.jsp" %>
			<!-- 头部end -->

			<!-- 导航条start -->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${base }/ssm/home">主页</a><i class="fa fa-angle-right"></i>现场项目列表</li>
			</ol>
			<!-- 导航条end -->

			<!-- 查询 -->
			<div class="grid-form1">
				<form class="form-inline" id="myform">
					<div class="form-group">
						<input style="width: 126px" type="text" class="form-control" id="workId" name="workId" value="${project.workId}" placeholder="工单ID">
					</div>

					<div class="form-group">
						<input style="width: 126px" type="text" class="form-control" id="title" name="title" value="${project.workId}" placeholder="标题">
					</div>


					<div class="form-group">

						<select class="form-control" id="projectType" name="projectType">
							<option value="">请选择项目类型</option>
							<option value="CTSERVER" <c:if test="${project.projectType eq 'CTSERVER' }">selected="selected"</c:if>>CTSERVER </option>
							<option value="KMAPSERVER" <c:if test="${project.projectType eq 'KMAPSERVER' }">selected="selected"</c:if>>KMAPSERVER </option>
						</select>

					</div>

					<%--<div class="form-group">
						<input type="text" class="form-control" id="title" name="title" value="${project.title}" placeholder="项目标题">
					</div>--%>


					<div class="form-group">

						<select class="form-control" id="deploymentStatus" name="deploymentStatus">
							<option value="">请选择部署状态</option>
							<option value="START" <c:if test="${project.deploymentStatus eq 'START' }">selected="selected"</c:if>>部署开始 </option>
							<option value="END" <c:if test="${project.deploymentStatus eq 'END' }">selected="selected"</c:if>>部署完成 </option>
						</select>

					</div>
					
					<div class="form-group">
						<select class="form-control" id="acceptanceStatus" name="acceptanceStatus">
							<option value="">请选择验收状态</option>
							<option value="UNSEND" <c:if test="${project.acceptanceStatus eq 'UNSEND' }">selected="selected"</c:if>>未提供验收报告 </option>
							<option value="SENDED" <c:if test="${project.acceptanceStatus eq 'SENDED' }">selected="selected"</c:if>>已提供验收报告 </option>
							<option value="ACCEPTED" <c:if test="${project.acceptanceStatus eq 'ACCEPTED' }">selected="selected"</c:if>>已验收 </option>
						</select>
					</div>

					<div class="form-group" style="height: 34px; width: 164px;">
						<%--<label>选择日期：</label>--%>
						<!--指定 date标记-->
						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" name="createdTimeStart" placeholder="请选择创建开始时间"/>
							<span class="input-group-addon">
                    			<span class="glyphicon glyphicon-calendar"></span>
                			</span>
						</div>
					</div>

					<div class="form-group" style="height: 34px; width: 164px;">
						<%--<label>选择日期：</label>--%>
						<!--指定 date标记-->
						<div class='input-group date' id='datetimepicker2'>
							<input type='text' class="form-control" name="createdTimeEnd" placeholder="请选择创建结束时间"/>
							<span class="input-group-addon">
                    			<span class="glyphicon glyphicon-calendar"></span>
                			</span>
						</div>
					</div>

					<div class="form-group" style="height: 34px; width: 164px;">
						<%--<label>选择日期：</label>--%>
						<!--指定 date标记-->
						<div class='input-group date' id='datetimepicker3'>
							<input type='text' class="form-control" name="completeTimeStart" placeholder="请选择完成开始时间"/>
							<span class="input-group-addon">
                    			<span class="glyphicon glyphicon-calendar"></span>
                			</span>
						</div>
					</div>

					<div class="form-group" style="height: 34px; width: 164px;">
						<%--<label>选择日期：</label>--%>
						<!--指定 date标记-->
						<div class='input-group date' id='datetimepicker4'>
							<input type='text' class="form-control" name="completeTimeEnd" placeholder="请选择完成结束时间"/>
							<span class="input-group-addon">
                    			<span class="glyphicon glyphicon-calendar"></span>
                			</span>
						</div>
					</div>

					<%--<div class="form-group">
						<label>选择日期+时间：</label>
						<!--指定 date标记-->
						<div class='input-group date' id='datetimepicker2'>
							<input type='text' class="form-control" />
							<span class="input-group-addon">
                    			<span class="glyphicon glyphicon-calendar"></span>
                			</span>
						</div>
					</div>--%>

					<button id="btn_search" onclick="onSearch()" type="button" class="btn btn-success" style="margin-left:10px;margin-right:10px;">
						<span class="fa fa-search" aria-hidden="true" class="btn-icon-space"></span> 查询
					</button>
					<button id="btn_add" onclick="onEdit()" type="button" class="btn btn-primary">
						<span class="fa fa-plus" aria-hidden="true" class="btn-icon-space"></span> 新增
					</button>
				</form>
			</div>

			<!-- 列表start -->
			<table id="table"></table>
			<!-- 列表end -->

			<div id="container" style="height: 500px"></div>

			<!--copy rights start -->
			<%@include file="/common/copyright.jsp" %>
			<!--copy rights end -->
		</div>
	</div>

<!-- 菜单start -->
<%@include file="/common/menu.jsp" %>
<!-- 菜单end -->
<div class="clearfix"></div></div>

<!-- 用户详细模态框 -->
<div class="modal fade bs-example-modal-lg"  id="myDetailModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"></div>

<!-- 用户新增或修改模态框 -->
<div class="modal fade bs-example-modal-lg"  id="myEditModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"></div>


<!--js -->
<script src="${base }/static/js/jquery.nicescroll.js"></script>
<script src="${base }/static/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${base }/static/js/bootstrap.min.js"></script>

<script type="application/javascript">
	var base = '${base}';
</script>


<script type="application/javascript">
	$(function () {
		$('#datetimepicker1').datetimepicker({
			/*format: 'YYYY-MM-DD HH:mm:ss',*/
			format: 'YYYY-MM-DD',
			locale: moment.locale('zh-cn')
		});
		$('#datetimepicker2').datetimepicker({
			format: 'YYYY-MM-DD',
			locale: moment.locale('zh-cn')
		});
		$('#datetimepicker3').datetimepicker({
			format: 'YYYY-MM-DD',
			locale: moment.locale('zh-cn')
		});
		$('#datetimepicker4').datetimepicker({
			format: 'YYYY-MM-DD',
			locale: moment.locale('zh-cn')
		});
	});
</script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-gl/dist/echarts-gl.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-stat/dist/ecStat.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/dist/extension/dataTool.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/map/js/china.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/map/js/world.js"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=p9kWy4jObql032zVF6Df3kGXDfeuZSGi&__ec_v__=20245944"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/dist/extension/bmap.min.js"></script>

<script src="${base }/static/js_haocai/omProject.js"></script>
<script src="${base}/static/module/layer-v2.4/layer/layer.js"></script>

<script type="text/javascript">




</script>

</body>
</html>
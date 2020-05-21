<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>用户列表</title>
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
				<li class="breadcrumb-item"><a href="${base }/ssm/home">主页</a><i class="fa fa-angle-right"></i>用户列表</li>
			</ol>
			<!-- 导航条end -->

			<!-- 查询 -->
			<div class="grid-form1">
				<form class="form-inline" id="myform">
					<div class="form-group">
						<input type="text" class="form-control" id="projectType" name="username" placeholder="用户名">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="realname" name="realname" placeholder="真实姓名">
					</div>
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
<div class="modal fade bs-example-modal-lg"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"></div>

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
<script src="${base }/static/js_haocai/omConfig.js"></script>
</body>
</html>
$(function(){
	initTable();
	getChartData();
});

/**
 * 获取分页数据
 */
function initTable(){
	//根据url或分页数据，返回的格式如：
	/*var data = {
		    "page": 1,
		    "rows": [
		        {"id":1,"username": "lisi","realname": "456","age": "12","utype": 0},
				{"id":2,"username": "lisi2","realname": "456","age": "12","utype": 1}
		    ],
		    "total": 2
	};*/
	$("#table").bootstrapTable({
		url: base+"/om/project/listProject",

		//请求方式get,修改tomcat编码格式为UTF-8,参数带中文可能出现乱码
		//<Connector connectionTimeout="20000" port="7079" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
		method:"get",
		//请求方式post,解决了中文乱码，可能会接收不到参数，需要指定contentType:"application/x-www-form-urlencoded"
		//method: "post",
		//contentType:"application/x-www-form-urlencoded",

		datatype:"json",
		striped: true,//设置为 true 会有隔行变色效果
		pagination: true, //分页showToggle: "true",//是否显示 切换试图（table/card）按钮
		/* showColumns: "true",//是否显示 内容列下拉框 */
		pageNumber: 1,//如果设置了分页，首页页码
		// showPaginationSwitch:true,//是否显示 数据条数选择框
		pageSize: 10,//如果设置了分页，页面数据条数
		pageList: [10, 20, 50,100],	//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
		paginationPreText: '<<',//指定分页条中上一页按钮的图标或文字,这里是<
		paginationNextText: '>>',//指定分页条中下一页按钮的图标或文字,这里是>
		// singleSelect: false,//设置True 将禁止多选
		search: false, //显示搜索框
		data_local: "zh-US",//表格汉化
		sidePagination: "server", //服务端处理分页
		sortable: true,//是否启用排序
		sortOrder: "desc",//排序方式
		queryParams: function (params) {//自定义查询参数和分页参数，传给后台
			var temp = $("#myform").serializeJsonObject();
			temp.start = params.offset;//从数据库第几条记录开始
			temp.pageSize = params.limit;//从数据库第几条记录开始
			temp.sort = params.sort;  //排序列名
			temp.order = params.order; //排位命令（desc，asc）
			return temp;
			/* return {//这里的params是table提供的
                start: params.offset,//从数据库第几条记录开始
                pageSize: params.limit//找多少条
            }; */
		},
		idField: "id",//指定主键列
		columns: [
			//表的列名,json数据中rows数组中的属性名,水平居中
			{title: '序号',align: 'center', width: '4%',
				formatter: function (value, row, index) {
					//var options = $table.bootstrapTable('getOptions');
					//return options.pageSize * (options.pageNumber - 1) + index + 1;
					return index+1;
				},
				/* cellStyle:{
                    css:{"background-color":"red"}
                } */
			},
			{title: '工单ID',field: 'workId',align: 'center', width: '4%',},
			{title: '项目类型',field: 'projectType',align: 'center', width: '7%',
				formatter: function (value, row, index) {
					return (row.projectType != null && row.projectType != '') ? row.projectType : "-";
				}
			},
			{title: '项目标题',field: 'title',align: 'left',  width: '15%',
				cellStyle: formatTableUnit,formatter: paramsMatter},
			/*{title: '项目标题',field: 'title',align: 'center',
				formatter: function (value, row, index) {
					//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
					if(row.title.length > 10 ){
						var span = document.createElement('span');
						span.setAttribute('title',value);
						span.innerHTML = value;
						//span.outerHTML = value;
						//return span.outerHTML;
						return row.title.substr(0,9) + "...";
					}
					return row.title;
				}
			},*/
			/*{title: '项目沟通群',field: 'communicationGroup',align: 'center'},*/
			/*{title: '现场对接人',field: 'dockingPeople',align: 'center'},*/
			{title: '部署状态',field: 'deploymentStatus',align: 'left', width: '9%',
				formatter: function (value, row, index) {
					console.log("row.deploymentStatus:"+row.deploymentStatus);
					//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
					//return row.deploymentStatus == 'START' ? "部署开始" : "部署结束";
					var span=document.createElement('span');
					var realValue = '部署完成';
					var color = 'green';
					//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
					if(row.deploymentStatus == 'START'){
						realValue = '部署开始';
						color = 'red';
					}else if(row.deploymentStatus == null || row.deploymentStatus == ''){
						realValue = '-';
						color = '';
					}
					span.setAttribute('style',"color:"+color);
					span.innerHTML = realValue;
					return span.outerHTML;
					//return "已验收";
				}
			},
			{title: '验收状态',field: 'acceptanceStatus',align: 'left', width: '12%',

				formatter: function (value, row, index) {
					var span=document.createElement('span');
					var realValue = '已验收';
					var color = 'green';
					//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
					if(row.acceptanceStatus == 'UNSEND'){
						realValue = '未提供验收报告';
						color = 'red';
					}else if(row.acceptanceStatus == 'SENDED'){
						realValue = '已提供验收报告';
						color = '#5bc0de';
					}else if(row.acceptanceStatus == null || row.acceptanceStatus == ''){
						realValue = '-';
						color = '';
					}
					span.setAttribute('style',"color:"+color);
					span.innerHTML = realValue;
					return span.outerHTML;
					//return "已验收";
				}
			},
			{title: '创建时间',field: 'createdTime',align: 'center', width: '12.5%'},
			{title: '完成时间',field: 'completeTime',align: 'center', width: '12.5%'},
			//{title: '部署内容',field: 'packUrl',align: 'center'},
			/*{title: '是否有效',field: 'urlExpired', align: 'center',
                formatter: function (value, row, index) {
                    //自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
                    return row.urlExpired == 'A' ? "有效" : "过期";
                }
            },*/
			{title: '操作',field: 'id',align: 'center', width: '25%',
				formatter: function (value, row, index) {
					return [
						'<button type="button" onclick="onDetail(\''+row.id+'\')" class="btn btn-info" style="margin-right:10px;"><span class="fa fa-eye" aria-hidden="true" class="btn-icon-space"></span> 详细</button>',
						'<button type="button" onclick="onEdit(\''+row.id+'\')" class="btn btn-warning" style="margin-right:10px;"><span class="fa fa-edit" aria-hidden="true" class="btn-icon-space"></span> 修改</button>',
						'<button type="button" onclick="onDelete(\''+row.id+'\')" class="btn btn-danger" style="margin-right:10px;"><span class="fa fa-minus-circle" aria-hidden="true" class="btn-icon-space"></span> 删除</button>'
					].join('');
				}
			}
		],
		onLoadSuccess: function () {
			console.log("加载成功");
		},
		onLoadError: function () {
			console.log("加载失败");
		},
	});
}
function paramsMatter(value,row,index) {
	var span=document.createElement('span');
	span.setAttribute('title',value);
	if(row.title.length > 15 ){
		span.innerHTML = value.substr(0,14) + "...";
	}else if(row.title == null || row.title == '' ){
		span.innerHTML = "-";
	}else{
		span.innerHTML = value;
	}
	return span.outerHTML;
}

function formatTableUnit(value, row, index) {
	return {
		css: {
			"white-space": 'nowrap',
			"text-overflow": 'ellipsis',
			"overflow": 'hidden'
		}
	}
}
	
/**
 * 查询
 */
function onSearch(){
	$('#table').bootstrapTable('refreshOptions',{pageNumber:1,pageSize:10});
	getChartData();
}
/**
 * 详细
 */
function onDetail(id){
	$('#myDetailModal').modal();
	$('#myDetailModal').load(base+"/om/project/getProjectById/"+id);
}

/**
 * 新增或修改
 * @param id
 * @returns
 */
function onEdit(id){
	$('#myEditModal').modal();
	$('#myEditModal').load(base+"/om/project/edit?id="+(id == undefined ? 0 : id) );
}

/**
 * 删除
 * @param id
 * @returns
 */
function onDelete(id){
	//询问框
	layer.confirm('确定删除？', {
		btn: ['确定','取消'] //按钮
	}, function(){
		//执行删除操作
		layer.close(layer.index);
		$.post(base+"/om/project/deleteById/"+id,function(data){
			if(data.status == 200){
				layer.open({
					type: 1,
					offset: "auto", //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
					content: '<div style="padding: 20px 100px;">删除成功</div>',
					shade: 0, //不显示遮罩
					time:2000,
					end: function () {
						onSearch();
					}
				});
			}else{
				layer.open({
			        type: 1,
			        offset: "auto", //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
			        content: '<div style="padding: 20px 100px;">'+ data.message +'</div>',
			        shade: 0, //不显示遮罩
			        time:2000,
			    });
				
			}
		})
	}, function(){
	  //执行取消操作
	});
	
}

function onSaveOrUpdate(){
	var formObject = {};
	var data = $("#myEditform").serializeArray();
	$.each(data,function(i,item){
		formObject[item.name] = item.value
	});
	$.ajax({
		url:base+"/om/project/saveOrUpdate",
		type:"POST",
		data:JSON.stringify(formObject),
		//data:$("#for").serializeArray(),
		contentType: "application/json;charset=UTF-8",
		success:function(data){
			if(data.status == 200){
				$('#myEditModal').modal("hide");
				onSearch();
			}else{
				layer.open({
			        type: 1,
			        offset: "auto", //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
			        content: '<div style="padding: 20px 100px;">'+ data.msg +'</div>',
			        //,btn: '关闭全部'
			        btnAlign: 'c', //按钮居中
			        shade: 0, //不显示遮罩
			        time:2000,
			        //yes: function(){
			         // layer.closeAll();
			        //}
			    });
			}
		}
	})
}

//自定义函数处理queryParams的批量增加
$.fn.serializeJsonObject = function () {
    var json = {};
    var form = this.serializeArray();
    $.each(form, function () {
        if (json[this.name]) {
            if (!json[this.name].push) {
                json[this.name] = [json[this.name]];
            }
            json[this.name].push();
        } else {
            json[this.name] = this.value || '';
        }
    });
    return json;
}

function getChartData(){
	$.ajax({
		url:base+"/om/project/getChartData",
		type:"GET",
		data: $("#myform").serializeJsonObject(),
		success:function(data){
			console.log(data);

			var totals = data.result.totals;
			var deals = data.result.deals;
			var dealings = data.result.dealings;
			console.log("totals:"+totals);
			console.log("deals:"+deals);
			console.log("dealings:"+dealings);
			var dom = document.getElementById("container");
			var myChart = echarts.init(dom);
			var app = {};
			option = null;


			app.config = {
				verticalAlign: 'middle',
				position: 'top',
				distance: 25,
			};


			var labelOption = {
				show: true,
				position: app.config.position,
				distance: app.config.distance,
				verticalAlign: app.config.verticalAlign,
				formatter: '{c}',
				fontSize: 16,
				rich: {
					name: {
						textBorderColor: '#fff'
					}
				}
			};

			option = {
				color: ['#003366', '#59cd89', '#e5323e'],
				tooltip: {
					trigger: 'axis',
					axisPointer: {
						type: 'shadow'
					}
				},
				legend: {
					data: ['申请总数', '部署完成', '部署中']
				},
				xAxis: [
					{
						type: 'category',
						axisTick: {show: false},
						data: ['Ct-Server', 'Kmap-Server']
					}
				],
				yAxis: [
					{
						type: 'value'
					}
				],
				series: [
					{
						name: '申请总数',
						type: 'bar',
						barGap: 0,
						label: labelOption,
						data: totals
					},
					{
						name: '部署完成',
						type: 'bar',
						label: labelOption,
						data: deals
					},
					{
						name: '部署中',
						type: 'bar',
						label: labelOption,
						data: dealings
					}
				]
			};;
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}
		}


	})
}
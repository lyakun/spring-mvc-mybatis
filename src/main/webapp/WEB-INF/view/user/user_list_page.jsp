<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.js"></script>
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.css" rel="stylesheet" />
</head>
<body>
<div class="col-md-12">
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-primary" onclick="addUser()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_delete" type="button" class="btn btn-warning" onclick="delProductAll()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="tb_userList" border="1"class="table table-striped table-borderedtable-condensed"></table>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#tb_userList').bootstrapTable({
		    url: '<%=request.getContextPath()%>/user/getUserList.gang',         //请求后台的URL（*）
		    contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//这里我就加了个 utf-8
		    method: 'post',                      //请求方式（*）
		    toolbar: '#toolbar',                //工具按钮用哪个容器
		    striped: true,                      //是否显示行间隔色
		    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		    pagination: true,                   //是否显示分页（*）
		    sortable: false,                     //是否启用排序
		    sortOrder: "asc",                   //排序方式
			sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
			pageNumber:1,                       //初始化加载第一页，默认第一页
			pageSize:5,                       //每页的记录行数（*）
			pageList: [5, 25, 50, 100],   
		    search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		    strictSearch: true,
		    showColumns: true,                  //是否显示所有的列
		    showRefresh: true,                  //是否显示刷新按钮
		    minimumCountColumns: 2,             //最少允许的列数
		    clickToSelect: true,                //是否启用点击选中行
		    height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		    uniqueId: "id",                     //每一行的唯一标识，一般为主键列
		    showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		    cardView: false,                    //是否显示详细视图
		    dataType:"json",
		    detailView: false,                   //是否显示父子表
		    rowStyle: function (row, index) {
		        //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
		        var strclass = "";
		        if (row.stock <= row.stockWarn) {
		            strclass = 'danger';//还有一个active
		        }
		        else {
		        	strclass ='success';
		        }
		        return { classes: strclass }
		    },
		    columns: [{
		        checkbox: true
		    },{
		        field: 'userName',
		        title: '用户姓名',
		    }, {
		        field: 'userSex',
		        title: '用户性别',
		        formatter:function(value,row,index){
		        	if(value==0){
		        		return "男";
		        	}else{
						return '女';
		        	}
					
				}
		    },{
		        field: 'loggerName',
		        title: '用户登录名称'
		    },{
		        field: 'userPhone',
		        title: '用户手机号'
		    },{
		        field: 'userEime',
		        title: '用户邮箱'
		    },{
		        field: 'userImg',
		        title: '用户个人头像',
		        formatter:function(value,row,index){
					return '<img src="<%=request.getContextPath()%>/'+value+'" width="100px" class="img-circle"/>';
					
				}
		    },{
		        field: 'userBir',
		        title: '用户生日',
		    },{
		        field: 'userId',
		        title: '操作',
		        formatter:function(value,row,index){
					return '<input type="button" value="修改" onclick="updateUser(\''+value+'\')" class="btn btn-warning"/> <input type="button" value="删除" onclick="deleteUser(\''+value+'\')" class="btn btn-warning"/>'
					+'<input type="button" value="赋角色" onclick="updateUserRole(\''+value+'\')" class="btn btn-warning"/>';
				}
		    }]
		});
})
	function addUser(){
		location.href="<%=request.getContextPath()%>/user/toUserAddPage.gang";
	}
	function deleteUser(id){
		$.ajax({
			url:"<%=request.getContextPath()%>/user/deleteUserByUserId.gang",
			dateType:"json",
			type:"post",
			data:{"userId":id},
			async:false,
			success:function(data){
				$("#tb_userList").bootstrapTable('refresh');
			},error:function(){
				alert("操作失败");
			}
		})
	}
	function updateUser(id){
		location.href="<%=request.getContextPath()%>/user/toupdateUserPage.gang?userId="+id;
	}
	function updateUserRole(id){
		location.href="<%=request.getContextPath()%>/user/toupdateUserRolePageByUserId.gang?userId="+id;
	}
</script>
</html>
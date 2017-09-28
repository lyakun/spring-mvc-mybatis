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
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/locale/bootstrap-table-zh-CN.js"></script>

</head>
<body>
	<div class="col-md-12">
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-primary" onclick="addRole()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
		</div>
		<table id="tb_roleList" border="1"class="table table-striped table-borderedtable-condensed"></table>
	</div>
</body>
<script type="text/javascript">
	function addRole(){
		location.href="<%=request.getContextPath()%>/role/addRolePage.gang";
	}
	$(function(){
		chaxun();
	})
	function chaxun(){
	$('#tb_roleList').bootstrapTable({
        url: '<%=request.getContextPath()%>/role/getRoleList.gang',         //请求后台的URL（*）
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
        columns: [{
            checkbox: true
        },{
            field: 'roleId',
            title: '角色编号'
        }, {
            field: 'roleName',
            title: '角色名称'
        }, {
            field: 'roleContext',
            title: '角色描述'
        },{
            field: 'roleId',
            title: '编辑',
            formatter:function(value,row,index){
            	return '<input type="button" value="修改" onclick="updateRole(\''+value+'\')" class="btn btn-warning"/> <input type="button" value="删除" onclick="deleteRole(\''+value+'\')" class="btn btn-warning"/>'
            			+'<input type="button" value="赋权限" onclick="updateRoleMenu(\''+value+'\')" class="btn btn-warning"/>';
			}
        }]
    });
	}
	
	function updateRoleMenu(id){
		location.href="<%=request.getContextPath()%>/user/toupdateRolePageByUserId.gang?userId="+id;
	}
	/* function deleteRole(id){
		$.ajax({
			url:"",
			type:"post",
			dateType:"json",
			data:{"roleId":id},
			success:function(data){
				$("#tb_roleList").bootstrapTable('refresh');
			},error:function{
				alert("删除失败");
			}
		})
	} */
</script>
</html>
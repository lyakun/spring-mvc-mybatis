<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章展示页面</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.js"></script>
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/bootstrap-table.min.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-table-master/src/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-bootbox/bootbox.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-bootbox/bootbox.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/js/fileinput.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/js/locales/zh.js"></script>
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/css/fileinput.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/moment-with-locales.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<div class="panel panel-info">
	 	<div class="panel-heading">查询条件</div>
	 	 <div class="panel-body">
	 	 	<form class="form-horizontal" role="form" id="productFormId" method="post">
            	<div class="form-group">
                          <label class="col-sm-2 control-label" for="articleName">产品名</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="articleNameEache" name="articleName" type="text" placeholder="请输入标题名称"/>
                          </div>
                 </div>
		         <div class="clearfix form-actions" style="text-align:center">
								
						<button class="btn btn-primary" type="button" onclick="articleEache()">
							<i class="glyphicon glyphicon-ok"></i>
										查询
						</button>
						<button class="btn btn-default" type="reset">
										<i class="glyphicon glyphicon-refresh"></i>
										重置
						</button>
								
				</div>
			</form>
	 	 </div>
	 </div>
	
	<div class="col-md-12">
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-primary" onclick="addArticle()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_delete" type="button" class="btn btn-warning" onclick="delArticleAll()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="tb_articleList" border="1"class="table table-striped table-borderedtable-condensed"></table>
	</div>
</body>
<script type="text/javascript">
	function delArticleAll(){
		var ids=$('#tb_articleList').bootstrapTable('getSelections');
		var id="";
		for (var i = 0; i < ids.length; i++) {
			id+=","+ids[i].articleId;
		}
		id=id.substr(1);
		$.ajax({
			url:"<%=request.getContextPath()%>/article/deleteArticleByArray.gang",
			dateType:"json",
			type:"post",
			data:{"ids":id},
			async:false,
			success:function(data){
				$("#tb_articleList").bootstrapTable('refresh');
			},error:function(){
				alert("操作失败");
			}
		})
	} 
	function articleEache(){
		$('#tb_articleList').bootstrapTable('refresh',{
			query:{
				articleName:$("#articleNameEache").val(),
			}
		}
		)
	}
	function addArticle(){
		location.href="<%=request.getContextPath()%>/article/addArticlePage.gang";
	}
$(function(){
	chaxun();
})
function chaxun(){
	$('#tb_articleList').bootstrapTable({
        url: '<%=request.getContextPath()%>/article/getArticleList.gang',         //请求后台的URL（*）
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
        }, {
            field:'articleName',
            title: '文章标题',
            formatter:function(value,row,index){
				return "<a href='<%=request.getContextPath()%>/article/toArticle.gang?articleId="+row.articleId+"'>"+value+"</a>";
			}
        },{
            field: 'articleCreateDateTime',
            title: '文章创建时间',
        },{
            field: 'founder',
            title: '创建人',
        }, {
            field:'articleId',
            title: '操作',
            formatter:function(value,row,index){
				return "<input type='button' onclick='delArticle(\""+value+"\")' value='删除' class='btn btn-info'/><input type='button' onclick='xiuArticle(\""+value+"\")' value='修改' class='btn btn-warning'/>"
						+"<input type='button' onclick='draftArticle(\""+value+"\")' value='草稿' class='btn btn-info'/>";
			}
        }
        ]
    });
}
	function delArticle(id){
		$.ajax({
			url:"<%=request.getContextPath()%>/article/deleteArticleById.gang",
			dateType:"json",
			type:"post",
			data:{"articleId":id},
			success:function(data){
				$("#tb_articleList").bootstrapTable('refresh');
			},error:function(){
				alert("操作失败");
			}
		})
	}
	function xiuArticle(id){
		location.href="<%=request.getContextPath()%>/article/toupdateArticleById.gang?articleId="+id;
	}
	function draftArticle(id){
		location.href="<%=request.getContextPath()%>/article/draftArticle.gang?articleId="+id;
	}
</script>
</html>
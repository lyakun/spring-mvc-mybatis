<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告页面</title>
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
<div class="col-md-12">
<div class="panel panel-info">
<div class="panel-heading">查询条件</div>
	 	 <div class="panel-body">
	 	 	<form class="form-horizontal" role="form" id="noticeFormId" method="post">
            	 <div class="form-group">
                     <label class="col-sm-2 control-label" for="noticeName">公告名称</label>
                     <div class="col-sm-4">
                        <input class="form-control" id="noticeNameEache" name="noticeName" type="text" placeholder="请输入公告名称"/>
                     </div>
                      <label class="col-sm-2 control-label" for="noticeName">公告审核状态</label>
                     <div class="col-sm-4">
                        <select id="noticeValidatorStatus" name="noticeValidatorStatus" class="form-control">
					    		<option value="">-请选择-</option>
					    		<option value="0">待审核</option>
					    		<option value="1">审核通过</option>
					    		<option value="2">审核未通过</option>
			    		</select>
                     </div>
                 </div>
                
                <div class="form-group">
                     <label class="col-sm-2 control-label" for="noticeName">公告状态</label>
                     <div class="col-sm-4">
                        <select  id="noticeStatusEache" name="noticeStatus" class="form-control">
					    		<option value="">-请选择-</option>
					    		<option value="0">停用</option>
					    		<option value="1">正常</option>
			    		</select>
                     </div>
                 </div>
		         <div class="clearfix form-actions" style="text-align:center">
								
						<button class="btn btn-primary" type="button" onclick="noticeEache()">
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
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-primary" onclick="addNotice()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_delete" type="button" class="btn btn-warning" onclick="delNoticeAll()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button id="btn_delete" type="button" class="btn btn-success" onclick="exportXml()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>导出Xml
			</button>
		</div>
		<table id="tb_noticeList" border="1"class="table table-striped table-borderedtable-condensed"></table>
	</div>
</body>
<script type="text/javascript">
	function exportXml(){
		var propductForm=document.getElementById("noticeFormId");
		propductForm.action="<%=request.getContextPath()%>/notice/exportXml.gang";
		propductForm.submit();
	}
	function noticeEache(){
		$("#tb_noticeList").bootstrapTable('refresh',{
			query:{
				noticeName:$("#noticeNameEache").val(),
				noticeValidatorStatus:$("noticeValidatorStatusEache").val(),
				noticeStatus:$("#noticeStatusEache").val()
			}
		});
	}
	function addNotice(){
		location.href="<%=request.getContextPath()%>/notice/getAddNoticePage.gang";
	}
	$(function(){
		chaxun();
	})
	function chaxun(){
		$('#tb_noticeList').bootstrapTable({
	        url: '<%=request.getContextPath()%>/notice/getNoticeList.gang',         //请求后台的URL（*）
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
	            field:'noticeName',
	            title: '公告标题',
	            formatter:function(value,row,index){
					return "<a href='<%=request.getContextPath()%>/notice/toNoticeAllPage.gang?noticeId="+row.noticeId+"'>"+value+"</a>";
				}
	        },{
	            field: 'noticeValidatorStatus',
	            title: '公告审核状态',
	            formatter:function(value,row,index){
	            	if(value==1){
						return "审核通过";
	            	}else if(value==0){
	            		return "待审核";
	            	}else{
	            		return "审核未通过";
	            	}
				}
	        },{
	            field: 'noticeStatus',
	            title: '公告状态',
	            formatter:function(value,row,index){
	            	if(value==0){
	            		return "停用";
	            	}
	            	if(value==1){
						return '正常';
	            	}
				}
	        }, {
	            field:'noticeId',
	            title: '操作',
	            formatter:function(value,row,index){
					if(row.noticeValidatorStatus==1&&row.noticeStatus==1){
						return '<input type="button" value="停用" onclick="butongguo(\''+row.noticeId+'\')" class="btn btn-warning"/>';
					}
					if(row.noticeStatus==0||row.noticeValidatorStatus==2){
						return '<input type="button" value="删除"  class="btn btn-info"/>';
					}
					if(row.noticeStatus==1&&row.noticeValidatorStatus==0){
						return "<input type='button' onclick='updateNoticeYes(\""+row.noticeId+"\")' value='通过' class='btn btn-info'/>"+
						"<input type='button' onclick='updateNtoiceNo(\""+row.noticeId+"\")' value='未通过' class='btn btn-warning'/>";
					}
				}
	        }
	        ]
	    });
	}
	function updateNoticeYes(id){
		$.ajax({
			url:"<%=request.getContextPath()%>/notice/updateNoticeYes.gang",
			dateType:"json",
			type:"post",
			data:{"noticeId":id},
			success:function(data){
				$("#tb_noticeList").bootstrapTable('refresh');
			},error:function(){
				alert("通过失败");
			}
		})
	}
	function updateNtoiceNo(id){
		$.ajax({
			url:"<%=request.getContextPath()%>/notice/updateNoticeNo.gang",
			dateType:"json",
			type:"post",
			data:{"noticeId":id},
			success:function(data){
				$("#tb_noticeList").bootstrapTable('refresh');
			},error:function(){
				alert("未通过失败");
			}
		})
	}
	function butongguo(id){
		$.ajax({
			url:"<%=request.getContextPath()%>/notice/updateNoticeStatus.gang",
			dateType:"json",
			type:"post",
			data:{"noticeId":id},
			success:function(data){
				$("#tb_noticeList").bootstrapTable('refresh');
			},error:function(){
				alert("停用失败");
			}
		})
	}
	function delNoticeAll(){
		var ids=$('#tb_noticeList').bootstrapTable('getSelections');
		var id="";
		for (var i = 0; i < ids.length; i++) {
			id+=","+ids[i].noticeId;
		}
		id=id.substr(1);
		$.post("<%=request.getContextPath()%>/notice/deleteNoticeAll.gang",
				{"ids":id},
				function (data){
					$("#tb_noticeList").bootstrapTable('refresh');
				}
			  )
	}
</script>
</html>
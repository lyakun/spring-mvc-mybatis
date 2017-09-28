<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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

<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/ichech/skins/all.css"rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/ichech/icheck.min.js"></script>

<body>
   
	 <div class="panel panel-info">
	 	<div class="panel-heading">查询条件</div>
	 	 <div class="panel-body">
	 	 	<form class="form-horizontal" role="form" id="productFormId" method="post">
            	<div class="form-group">
                          <label class="col-sm-2 control-label" for="productName">产品名</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="productNameEache" name="productName" type="text" placeholder="请输入产品名"/>
                          </div>
                          <label class="col-sm-2 control-label">产品价格</label>
                          <div class="col-sm-4">
                             <div class="input-group">
								<input type="number" class="input-sm form-control" id="minPrice"  name="minPrice" value="0"/>
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-transfer"></i>
								</span>
								<input type="number" class="input-sm form-control" id="maxPrice"  name="maxPrice" value="0"/>
							</div>
                          </div>
                 </div>
                 <div class="form-group">
                          <label class="col-sm-2 control-label" for="productName">产品品牌</label>
                          <div class="col-sm-4">
		                             <select id="brandSelectId" name="brand.brandId" class="form-control">
							    		<option value="">-请选择-</option>
							    		<c:forEach items="${brandList}" var="l">
							    			<option value="${l.brandId}" ${product.brand.brandId==l.brandId?"selected":""}>${l.brandName}</option>
							    		</c:forEach>
			    					</select>
                          </div>
                          <label class="col-sm-2 control-label">产品库存</label>
                          <div class="col-sm-4">
                             <div class="input-group">
								<input type="number" class="input-sm form-control" id="minStock"  name="minStock" value="0"/>
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-transfer"></i>
								</span>
								<input type="number" class="input-sm form-control" id="maxStock"  name="maxStock" value="0"/>
							</div>
                          </div>
                 </div>
                 <div class="form-group">
                          <label class="col-sm-2 control-label" for="createtime">创建时间</label>
                          <div class="col-sm-4">
                            <div class="input-group" >
								<input type="text" class="form-control" id="minCreatetime"  name="minCreatetime" />
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-transfer"></i>
								</span>
								<input type="text"class="form-control" id="maxCreatetime"  name="maxCreatetime"  />
							</div>
                          </div>
                          <label class="col-sm-2 control-label">修改时间</label>
                          <div class="col-sm-4">
                             <div class="input-group">
								<input type="text" class="input-sm form-control" id="minUpdatetime"  name="minUpdatetime" />
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-transfer"></i>
								</span>
								<input type="text" class="input-sm form-control" id="maxUpdatetime"  name="maxUpdatetime" />
							</div>
                          </div>
                 </div>
                  <div class="form-group">
                          <label class="col-sm-2 control-label" for="createtime">排序</label>
                          <div class="col-sm-4">
                            <select id="sort" name="sort" class="form-control">
					    		<option value="createtime">创建时间</option>
					    		<option value="productPrice">产品价格</option>
					    		<option value="updatetime">修改时间</option>
					    		<option value="stock">产品库存</option>
					    		<option value="stockWarn">警告库存</option>
			    			</select>
                          </div>
                           <label class="col-sm-2 control-label" for="createtime">排序方式</label>
                          <div class="col-sm-4">
                           	<input type="radio" name="sortBy" value="asc" checked>
             				<label>由底到高</label>
             				<input type="radio" name="sortBy" value="desc">
             				<label>由高到底</label>
                          </div>
                  </div>
		         <div class="clearfix form-actions" style="text-align:center">
								
						<button class="btn btn-primary" type="button" onclick="productEache()">
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
		<shiro:hasPermission name="product:insert">
			<button id="btn_add" type="button" class="btn btn-primary" onclick="addProduct()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="product:deletes">
			<button id="btn_delete" type="button" class="btn btn-warning" onclick="delProductAll()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="product:insert">
			<button id="btn_delete" type="button" class="btn btn-success" onclick="updateAllProduct()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量修改图片
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="product:excel">
			<button id="btn_delete" type="button" class="btn btn-success" onclick="exportExcel()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>导出Excel
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="product:xml">
			<button id="btn_delete" type="button" class="btn btn-success" onclick="exportXml()">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>导出Xml
			</button>
		</shiro:hasPermission>
		</div>
			<input id="excel_id" type="file" name="excel" value="导入Excel"/>
		<table id="tb_productList" border="1"class="table table-striped table-borderedtable-condensed"></table>
	</div>
</body>
<script type="text/javascript">
	function exportXml(){
		var propductForm=document.getElementById("productFormId");
		propductForm.action="<%=request.getContextPath()%>/product/exportXml.gang";
		propductForm.submit();
	}
	function updateAllProduct(){
		var ids=$('#tb_productList').bootstrapTable('getSelections');
		var id="";
		for (var i = 0; i < ids.length; i++) {
			id+=","+ids[i].productId;
		}
		id=id.substr(1);
		location.href="<%=request.getContextPath()%>/product/toupdateProductImgById.gang?id="+id;
	}
		$(function(){
			   $('#excel_id').fileinput({
				   language: 'zh', //设置语言
			        uploadUrl:"<%=request.getContextPath()%>/product/inportExcel.gang", //上传的地址
			        allowedFileExtensions: ['xls','xlsx'],//接收的文件后缀
			        showUpload: true, //是否显示上传按钮
			        showCaption: false,//是否显示标题
			        uploadAsync:true,
			        browseClass: "btn btn-primary", //按钮样式     
			        dropZoneEnabled: false,//是否显示拖拽区域
			        //minImageWidth: 50, //图片的最小宽度
			        //minImageHeight: 50,//图片的最小高度
			        //maxImageWidth: 1000,//图片的最大宽度
			        //maxImageHeight: 1000,//图片的最大高度
			        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
			        //minFileCount: 0,
			        maxFileCount: 10, //表示允许同时上传的最大文件个数
			        enctype: 'multipart/form-data',
			        validateInitialCount:true,
			        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
			        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			        previewFileIconSettings: {
			            'doc': '<i class="fa fa-file-word-o text-primary"></i>',
			            'xls': '<i class="fa fa-file-excel-o text-success"></i>',
			            'ppt': '<i class="fa fa-file-powerpoint-o text-danger"></i>',
			            'jpg': '<i class="fa fa-file-photo-o text-warning"></i>',
			            'pdf': '<i class="fa fa-file-pdf-o text-danger"></i>',
			            'zip': '<i class="fa fa-file-archive-o text-muted"></i>',
			        },
			        previewFileExtSettings: {
			            'doc': function(ext) {
			                return ext.match(/(doc|docx)$/i);
			            },
			            'xls': function(ext) {
			                return ext.match(/(xls|xlsx)$/i);
			            },
			            'ppt': function(ext) {
			                return ext.match(/(ppt|pptx)$/i);
			            }
			        }
			    }).on("fileuploaded", function (event, data, previewId, index){
			    	if(data.response.stats=="sucess"){
			    		location.href="<%=request.getContextPath()%>/product/getProductPage.gang";
			    	}
			 })
			});
	function exportExcel(){
		location.href="<%=request.getContextPath()%>/product/exportExcel.gang?brand.brandId="+$('#brandSelectId').val();
	}
	function productEache(){
		$("#tb_productList").bootstrapTable("refresh",{
			query:{
				"productName":$("#productNameEache").val(),
				"productPriceMin":$("#productPriceMinEache").val(),
				"productPriceMax":$("#prodcutPriceMaxEache").val(),
				"brand.brandId":$("#brandSelectId").val(),
				"minCreatetime":$("#minCreatetime").val(),
				"maxCreatetime":$("#maxCreatetime").val(),
				"minUpdatetime":$("#minUpdatetime").val(),
				"maxUpdatetime":$("#maxUpdatetime").val(),
				"minStock":$("#minStock").val(),
				"maxStock":$("#maxStock").val(),
				"sort":$("#sort").val(),
				"sortBy":$("input[name='sortBy']:checked").val(),
				 
			}
		})
	}
	function addProduct(){
		location.href="<%=request.getContextPath()%>/product/getProductAddPage.gang";
	}
	$(function(){
		chaxun();
		$("input[name='sortBy']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%'
          })
	})
		function chaxun(){
		$('#tb_productList').bootstrapTable({
            url: '<%=request.getContextPath()%>/product/getProductList.gang',         //请求后台的URL（*）
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
                field: 'productId',
                title: '产品编号'
            }, {
                field: 'productName',
                title: '产品名称'
            }, {
                field: 'productPrice',
                title: '产品价格'
            },{
                field: 'brand.brandName',
                title: '产品品牌'
            },{
                field: 'stock',
                title: '产品库存'
            },{
                field: 'stockWarn',
                title: '警告库存'
            },{
                field: 'productId',
                title: '操作',
                formatter:function(value,row,index){
					return "<input type='button' onclick='delProduct(\""+value+"\")' value='删除' class='btn btn-info'/><input type='button' onclick='xiuProduct(\""+value+"\")' value='修改' class='btn btn-warning'/>"+
					"<input type='button' onclick='showProductImgAll(\""+value+"\")' value='查看产品相册' class='btn btn-warning'/>";
				}
            },{
                field: 'productImg',
                title: '产品图片',
                formatter:function(value,row,index){
					return '<img src="<%=request.getContextPath()%>/'+value+'" width="100px" class="img-circle"/>';
				}
            }]
        });
		}
	function xiuProduct(id){
		location.href="<%=request.getContextPath()%>/product/toupdateProductById.gang?id="+id;
	}
	function delProduct(id){
		bootbox.confirm({
			title:"警告",
			message:"确定删除吗?",
			callback: function(result) {  
				if(result){
					$.post("<%=request.getContextPath()%>/product/deleteProductById.gang",
							{"id":id},
							function(data){
								$('#tb_productList').bootstrapTable('refresh');
							}
					)
				}
	        },
	        buttons: {  
	            confirm: {  
	                label: '<span class="glyphicon glyphicon-ok"></span>确认',  
	                className: 'btn-primary'  
	            },  
	            cancel: {  
	                label: '<span class="glyphicon glyphicon-remove"></span>取消',  
	                className: 'btn-info'  
	            }  
	        }, 
		})
	}
	function delProductAll(){
		var ids=$('#tb_productList').bootstrapTable('getSelections');
		var id="";
		for (var i = 0; i < ids.length; i++) {
			id+=","+ids[i].productId;
		}
		id=id.substr(1);
		bootbox.confirm({
			title:"警告",
			message:"确定删除吗?",
			callback: function(result) {  
				if(result){
					$.post("<%=request.getContextPath()%>/product/deleteAllProductByIds.gang",
						{"id":id},
						function(data){
							$("#tb_productList").bootstrapTable("refresh");
						}
						)
					}
			},
	        buttons: {  
	            confirm: {  
	                label: '<span class="glyphicon glyphicon-ok"></span>确认',  
	                className: 'btn-primary'  
	            },  
	            cancel: {  
	                label: '<span class="glyphicon glyphicon-remove"></span>取消',  
	                className: 'btn-info'  
	            }  
       		 } 
		})
	}
	function showProductImgAll(id){
		bootbox.dialog({
            message:getDivUrl("<%=request.getContextPath()%>/product/getshowProductImgAllPageById.gang?id="+id),  
            title: "产品相册",  
            buttons: {  
                Cancel: {  
                    label: "取消",  
                    className: "btn-default",  
                    callback: function () {  
                       
                    }  
                }  
                , OK: {  
                    label: "保存",  
                    className: "btn-primary",  
                    callback: function () { 
                    	/* ids=ids.substr(1);
                    	$("#imgUrlArrayId").val(ids); */
                   	
                    }  
                }  
            }  
        });
	}
	function getDivUrl(url){
			var fan_page="";
			 $.ajax({
	    		  url:url,
	    		  type:"post",
	    		  dateType:"text",
	    		  async:false,
	    		  success:function(data){
	    			 fan_page=data;
	    		  },error:function(){
	    			  alert("操作失败");
	    		  }
	    	  })
	    	  return fan_page;
		}
</script>
<script type="text/javascript">
$(function () {
	datepiceker();
});
function datepiceker(){
	$('#minCreatetime').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: 'zh-CN',
        showClear: true,
    });
    $('#maxCreatetime').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: 'zh-CN',
        showClear: true,
    });
    
    $('#minUpdatetime').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: 'zh-CN',
        showClear: true,
    });
    $('#maxUpdatetime').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: 'zh-CN',
        showClear: true,
    });
}
    </script>
</html>
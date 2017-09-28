<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/js/fileinput.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/js/locales/zh.js"></script>
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/css/fileinput.min.css" rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/zh_CN.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/bootstrapValidator.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/kindeditor/plugins/code/prettify.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/kindeditor/themes/default/default.css">

<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/plugins/code/prettify.js"></script>

<title>修改页面</title>
</head>
<body>
	<form id="update_product_from" class="form-horizontal" action="<%=request.getContextPath()%>/product/updateProductById.gang" method="post">
		
		<!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#product" aria-controls="home" role="tab" data-toggle="tab">产品普通信息</a></li>
    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">产品详情</a></li>
    <li role="presentation"><a href="#imgFile" aria-controls="profile" role="tab" data-toggle="tab">产品子图</a></li>
  </ul>
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="product">
		<input type="hidden" value="${product.productId}" name="productId"/>
	  <div class="form-group">
	    <label for="inputEmail3" class="col-sm-2 control-label">产品名称</label>
	    <div class="col-sm-6">
	      <input type="text" value="${product.productName}"class="form-control" id="inputEmail3" placeholder="产品名称" name="productName">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputPassword3" class="col-sm-2 control-label">产品价格</label>
	    <div class="col-sm-6">
	      <input type="text" value="${product.productPrice}" class="form-control" id="inputPassword3" placeholder="产品价格" name="productPrice">
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="inputPassword3" class="col-sm-2 control-label">产品品牌</label>
	    <div class="col-sm-6">
	    	<select id="brandSelectId" name="brand.brandId" class="form-control">
	    		<option>-请选择-</option>
	    		<c:forEach items="${brandList}" var="l">
	    			<option value="${l.brandId}" ${product.brand.brandId==l.brandId?"selected":""}>${l.brandName}</option>
	    		</c:forEach>
	    	</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputPassword3" class="col-sm-2 control-label">产品库存</label>
	    <div class="col-sm-6">
	    	<input type="text" class="form-control" id="stock" placeholder="产品库存" name="stock" value="${product.stock}">
	    </div>
	  </div>
	   <div class="form-group">
	  	<label for="inputPassword3" class="col-sm-2 control-label">产品图片</label>
		<div class="col-md-6">
        	<input type="file" name="imgfile" id="update_txt_file"  class="file-loading" />
        	<input type="hidden" name="productImg" id="update_productImgId" value="${product.productImg}"/>
        </div>
	  </div>
	 </div>
	 <div role="tabpanel" class="tab-pane" id="profile">
	  <textarea name="desc.productDesc" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;">${product.desc.productDesc}</textarea>
	 </div>
	 <div role="tabpanel" class="tab-pane" id="imgFile">
		   <div class="form-group">
		  	<label for="inputPassword3" class="col-sm-2 control-label">产品相册</label>
			<div class="col-md-6">
	        	<input type="file" name="imgfile" id="update_imgUrlArray_file"  class="file-loading" multiple/>
	        	<input type="hidden" name="imgUrlArray" id="update_imgUrlArray" />
	        </div>
		  </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <div class="checkbox">
	        <label>
	      <button type="submit" class="btn btn-primary">
	      	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存修改
	      </button>
	      <button type="reset" class="btn btn-default">
	      	<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>重置
	      </button>
	        </label>
	      </div>
	    </div>
	  </div>
	 </div>
	</form>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $('#update_product_from').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	productName: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    regexp: {
                        regexp: /^[\u4E00-\u9FA5]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    },
                }
            },
            productPrice:{
            	validators:{
            		notEmpty:{
            			message:"不能为空"
            		},regexp:{
            			regexp:/^[0-9]+(.[0-9]{1,3})?$/,
            			message:"只能是数字"
            		}
            	}
            }
        } 
    });
});
</script>
<script type="text/javascript">
$(function(){
	$('#update_txt_file').fileinput({
		   	initialPreview:[
		   	'<%=request.getContextPath()%>/${product.productImg}',
		   	],
		   	initialPreviewConfig:[
		   	   {showDelete:true}            
		   	],
		   	initialPreviewAsData:true,
	        language: 'zh', //设置语言
	        uploadUrl:"<%=request.getContextPath()%>/product/uplodProductImg.gang", //上传的地址
	        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
	        showUpload: true, //是否显示上传按钮
	        showCaption: false,//是否显示标题
	        overwriteInitial:false,//是否覆盖预览值
	        uploadAsync:true,
	        browseClass: "btn btn-primary", //按钮样式     
	        maxFileCount: 10, //表示允许同时上传的最大文件个数
	        enctype: 'multipart/form-data',
	        validateInitialCount:true,
	        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
	        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	    }).on("fileuploaded", function (event, data, previewId, index){
			$("#update_productImgId").val(data.response.img);
	 })
	 var array = new Array();  
     var preConfigList = new Array();
		<c:forEach items="${list}" var="t">  
			array.push("<%=request.getContextPath()%>/${t.imgUrl}"); 
			preConfigList.push({
 				url: '<%=request.getContextPath()%>/product/deleteFile.gang', // 删除url
 				extra: {'id':${t.imgId}}
 				});
     	</c:forEach> 
     var imgallurl="";
	 $('#update_imgUrlArray_file').fileinput({
		   	initialPreview:array,
		   	initialPreviewConfig:preConfigList,
		   	initialPreviewAsData:true,
	        language: 'zh', //设置语言
	        uploadUrl:"<%=request.getContextPath()%>/product/uplodProductImg.gang", //上传的地址
	        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
	        showUpload: true, //是否显示上传按钮
	        showCaption: false,//是否显示标题
	        showUploadedThumbs:true,
	        overwriteInitial:false,//是否覆盖预览值
	        uploadAsync:true,
	        browseClass: "btn btn-primary", //按钮样式     
	        maxFileCount: 10, //表示允许同时上传的最大文件个数
	        enctype: 'multipart/form-data',
	        validateInitialCount:true,
	        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
	        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	    }).on("fileuploaded", function (event, data, previewId, index){
	    	imgallurl+=","+data.response.img;
			$("#update_imgUrlArray").val(imgallurl.substr(1));
	 });
	})
</script>
<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="desc.productDesc"]', {
				cssPath : '<%=request.getContextPath()%>/kindeditor/plugins/code/prettify.css',
				uploadJson : '<%=request.getContextPath()%>/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '<%=request.getContextPath()%>/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</html>
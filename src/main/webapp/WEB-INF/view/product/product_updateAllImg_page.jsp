<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>批量修改产品主图</title>
</head>
<body>
	<form id="update_product_from" class="form-horizontal" action="<%=request.getContextPath()%>/product/updateProductAllById.gang" method="post">
		<c:forEach items="${list}" var="l">
	     	<div class="form-group">
			  	<label for="inputPassword3" class="col-sm-2 control-label">产品相册</label>
			  	<input type="hidden" value="${l.productId}" name="productId"/>
				<div class="col-md-6">
		        	<input type="file" name="imgfile" id="update_imgUrlArray_file_${l.productId}"  class="file-loading"/>
		        	<input type="hidden" name="imgUrlArray" id="update_imgUrlArray_${l.productId}" />
		        </div>
	        </div>
        </c:forEach>
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
	</form>
</body>
<script type="text/javascript">
	$(function(){
		<c:forEach items="${list}" var="l">
		$('#update_imgUrlArray_file_${l.productId}').fileinput({
			initialPreview:[
			  '<%=request.getContextPath()%>/${l.productImg}' 
			],
			 initialPreviewAsData:true,
	        language: 'zh', //设置语言
	        uploadUrl:"<%=request.getContextPath()%>/product/uplodProductImg.gang", //上传的地址
	        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
	        showUpload: true, //是否显示上传按钮
	        showCaption: false,//是否显示标题
	        uploadAsync:true,
	        browseClass: "btn btn-primary", //按钮样式     
	        //dropZoneEnabled: false,//是否显示拖拽区域
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
	    }).on("fileuploaded", function (event, data, previewId, index){
			$("#update_imgUrlArray_${l.productId}").val(data.response.img);
	 })
	 </c:forEach>
	})
</script>
</html>
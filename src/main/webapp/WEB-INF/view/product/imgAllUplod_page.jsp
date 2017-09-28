<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="form-group">
	
		  	<label for="inputPassword3" class="col-sm-2 control-label">产品图册</label>
		   <div class="col-md-10">
		       	<input type="file" name="imgfile" id="img_all_id"  class="file-loading"  multiple />
		   </div>
	
   	</div>
</body>
<script type="text/javascript">
$(function(){
	$('#img_all_id').fileinput({
	    language: 'zh', //设置语言
	    uploadUrl:"<%=request.getContextPath()%>/product/uplodProductImg.gang", //上传的地址
	    allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
	    maxFileCount: 100,
	    enctype: 'multipart/form-data',
	    showUpload: true, //是否显示上传按钮
	    showCaption: false,//是否显示标题
	    browseClass: "btn btn-primary", //按钮样式             
	    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
	    msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	}).on("fileuploaded", function (event, data, previewId, index){
		ids+=","+data.response.img;
	})
})
</script>
</html>
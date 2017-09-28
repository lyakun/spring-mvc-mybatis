<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-bootbox/bootbox.js"></script>
</head>
<body>
	<form class="form-horizontal" action="<%=request.getContextPath()%>/brand/insertBrand.gang" method="post">
	  <div id="brandId">
		 <button type="button" class="btn btn-default" onclick="addBrand()">
		     <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>增加
		 </button>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">品牌名称</label>
		    <div class="col-sm-6">
		      <input type="text" class="form-control" id="inputEmail3" placeholder="品牌名称" name="brandName">
		    </div>
		  </div>
		  <div class="form-group">
		  	<label for="inputPassword3" class="col-sm-2 control-label">品牌图片</label>
			<div class="col-md-6">
	        	<input type="file" name="imgfile" id="imgId"  class="file-loading" />
	        	<input type="hidden" name="brandImg" id="brand_img_id"/>
	        </div>
		  </div>
		  
		  </div>
	  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <div class="checkbox">
		        <label>
		      <button type="submit" class="btn btn-primary">
		      	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
		      </button>
		      <button type="reset" class="btn btn-default">
		      	<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>重置
		      </button>
		        </label>
		      </div>
		    </div>
		 </div>
	</form>
	
	<div style="display:none;" id="addbrandId">
		<div>
		 <button type="button" class="btn btn-default" onclick="delBrand(this)">
		      	<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
		 </button>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">品牌名称</label>
		    <div class="col-sm-6">
		      <input type="text" class="form-control" id="inputEmail3" placeholder="品牌名称" name="brandName">
		    </div>
		  </div>
		  <div class="form-group">
		  	<label for="inputPassword3" class="col-sm-2 control-label">品牌图片</label>
			<div class="col-md-6">
	        	<input type="file" name="imgfile" id="addimgId#flag#"  class="file-loading" />
	        	<input type="hidden" name="brandImg" id="brand_img_id#flag#"/>
	        </div>
		  </div>
		  </div>
		  </div>
</body>	
<script type="text/javascript">
	var count=1;
	function delBrand(obj){
		$(obj).parent().remove();
	}
	function addBrand(){
		$("#brandId").after($("#addbrandId").html().replace(/#flag#/g,count));
		chushihua(count);
		count++;
	}
	$(function(){
		   $('#imgId').fileinput({
		     language: 'zh', //设置语言
		     uploadUrl:"<%=request.getContextPath()%>/brand/uplodBrandImg.gang", //上传的地址
		     allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
	         maxFileCount: 100,
	         enctype: 'multipart/form-data',
	         showUpload: true, //是否显示上传按钮
	         showCaption: false,//是否显示标题
	         browseClass: "btn btn-primary", //按钮样式             
	         previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
	         msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		    }).on("fileuploaded", function (event, data, previewId, index){
		    	$("#brand_img_id").val(data.response.img);
		 })
	});
	function chushihua(count){
		   $('#addimgId'+count).fileinput({
		     language: 'zh', //设置语言
		     uploadUrl:"<%=request.getContextPath()%>/brand/uplodBrandImg.do", //上传的地址
		     allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
	         maxFileCount: 100,
	         enctype: 'multipart/form-data',
	         showUpload: true, //是否显示上传按钮
	         showCaption: false,//是否显示标题
	         browseClass: "btn btn-primary", //按钮样式             
	         previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
	         msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		    }).on("fileuploaded", function (event, data, previewId, index){
		    	$("#brand_img_id"+count).val(data.response.img);
		 })
	};
</script>
</html>
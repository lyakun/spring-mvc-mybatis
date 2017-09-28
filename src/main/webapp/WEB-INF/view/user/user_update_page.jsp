<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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

</head>
<body>
<form id="add_user_from" class="form-horizontal" action="<%=request.getContextPath()%>/user/updateUser.gang" method="post">
 <input type="hidden" name="userId" value="${user.userId}"/>
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="product">
    	  <div class="form-group">
		    <label for="userName" class="col-sm-2 control-label">用户姓名</label>
		    <div class="col-sm-6">
	     	 <input type="text" class="form-control"  value="${user.userName}" name="userName">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="userSex" class="col-sm-2 control-label">用户性别</label>
	    <div class="col-sm-6">
	      <input type="radio" name="userSex" value="0" ${user.userSex==0?"checked":""}>男
	      <input type="radio"  name="userSex" value="1" ${user.userSex==1?"checked":""}>女
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="loggerName" class="col-sm-2 control-label">用户登录名称</label>
	    <div class="col-sm-6">
	    	 <input type="text" class="form-control" name="loggerName" value="${user.loggerName}">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="userPass" class="col-sm-2 control-label">用户密码</label>
		<div class="col-md-6">
        	<input type="password" name="userPassWord" class="form-control" value="${user.userPassWord}"/>
        </div>
      </div>
	  <div class="form-group">
	    <label for="userPhone" class="col-sm-2 control-label">用户手机号</label>
	    <div class="col-sm-6">
	    	<input type="text" class="form-control"  value="${user.userPhone}" name="userPhone">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="userEime" class="col-sm-2 control-label">用户邮箱</label>
	    <div class="col-sm-6">
	    	<input type="text" class="form-control" value="${user.userEime}" name="userEime">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="userBir" class="col-sm-2 control-label">用户生日</label>
		<div class="col-md-6">
        	<input type="text" name="userBir"  class="form-control" value='<fmt:formatDate value="${user.userBir}" pattern="yyyy-MM-dd"/>'/>
        </div>
      </div>
       <div class="form-group">
	  	<label for="userImg" class="col-sm-2 control-label">用户头像</label>
	  	<div class="col-md-6">
			<input type="file" name="imgfile" id="update_txt_file"  class="file-loading" />
	        <input type="hidden" name="userImg" id="userImg"/>
	     </div>
      </div>
        </div>
      </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">
	      	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
	      </button>
	      <button type="reset" class="btn btn-default">
	      	<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>重置
	      </button>
	      </div>
	    </div>
</form>
</body>
<script type="text/javascript">
	$(function(){
		$('#update_txt_file').fileinput({
		   	initialPreview:[
		   	'<%=request.getContextPath()%>/${user.userImg}',
		   	],
		   	initialPreviewConfig:[
		   	   {showDelete:true}            
		   	],
		   	initialPreviewAsData:true,
	        language: 'zh', //设置语言
	        uploadUrl:"<%=request.getContextPath()%>/user/uplodUserImg.gang", //上传的地址
	        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
	        showUpload: true, //是否显示上传按钮
	        showCaption: false,//是否显示标题
	        overwriteInitial:true,//是否覆盖预览值
	        uploadAsync:true,
	        browseClass: "btn btn-primary", //按钮样式     
	        maxFileCount: 10, //表示允许同时上传的最大文件个数
	        enctype: 'multipart/form-data',
	        validateInitialCount:true,
	        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
	        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	    }).on("fileuploaded", function (event, data, previewId, index){
	    	$("#userImg").val(data.response.img);
	 })
	})
</script>
</html>
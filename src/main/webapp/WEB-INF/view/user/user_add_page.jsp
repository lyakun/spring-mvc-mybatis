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
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/js/fileinput.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/js/locales/zh.js"></script>
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-fileinput-master/css/fileinput.min.css" rel="stylesheet" />

<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/zh_CN.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrapvalidator/bootstrapValidator.min.css">
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/moment-with-locales.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script> 
</head>
<body>
	<form id="add_user_from" class="form-horizontal" action="<%=request.getContextPath()%>/user/insertUser.gang" method="post">
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="product">
    	  <div class="form-group">
	    <label for="userName" class="col-sm-2 control-label">用户姓名</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control"  placeholder="用户姓名" name="userName">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="userSex" class="col-sm-2 control-label">用户性别</label>
	    <div class="col-sm-6">
	      <input type="radio" name="userSex" value="0">男
	      <input type="radio"  name="userSex" value="1">女
	    </div>
	  </div>
	   <div class="form-group">
	    <label for="loggerName" class="col-sm-2 control-label">用户登录名称</label>
	    <div class="col-sm-6">
	    	 <input type="text" class="form-control" name="loggerName"  placeholder="用户登录名称">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="userPass" class="col-sm-2 control-label">用户密码</label>
		<div class="col-md-6">
        	<input type="password" name="userPassWord" class="form-control" placeholder="用户密码"/>
        </div>
      </div>
	  <div class="form-group">
	    <label for="userPhone" class="col-sm-2 control-label">用户手机号</label>
	    <div class="col-sm-6">
	    	<input type="text" class="form-control"  placeholder="用户手机号" name="userPhone">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="userEime" class="col-sm-2 control-label">用户邮箱</label>
	    <div class="col-sm-6">
	    	<input type="text" class="form-control"  placeholder="用户邮箱" name="userEime">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="userBir" class="col-sm-2 control-label">用户生日</label>
		<div class="col-md-6">
        	<input type="text" name="userBir"  class="form-control" id="userBir"/>
        </div>
      </div>
      <div class="form-group">
	  	<label for="userImg" class="col-sm-2 control-label">用户头像</label>
	  	<div class="col-md-6">
			<input type="file" name="imgfile" id="txt_file"  class="file-loading" />
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
		   $('#txt_file').fileinput({
		        language: 'zh', //设置语言
		        uploadUrl:"<%=request.getContextPath()%>/user/uplodUserImg.gang", //上传的地址
		        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
	            maxFileCount: 100,
	            enctype: 'multipart/form-data',
	            showUpload: true, //是否显示上传按钮
	            showCaption: false,//是否显示标题
	            browseClass: "btn btn-primary", //按钮样式             
	            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
	            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		    }).on("fileuploaded", function (event, data, previewId, index){
		    	$("#userImg").val(data.response.img);
		 })
		});
</script>
<script type="text/javascript">
$(document).ready(function() {
    $('#add_user_from').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	userName: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    regexp: {
                        regexp: /^[\u4E00-\u9FA5]+$/,
                        message: '用户名只能是汉字'
                    },
                }
            },loggerName: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名由数字字母下划线和.组成'
                    },
                }
            },
            userPassWord:{
            	validators:{
            		notEmpty:{
            			message:"不能为空"
            		},regexp:{
            			regexp:/^[0-9]+$/,
            			message:"只能是数字"
            		}
            	}
            },userPhone:{
            	validators:{
            		notEmpty:{
            			message:"不能为空"
            		},stringLength: {
                        min: 11,
                        max: 11,
                        message: '请输入11位手机号码'
                    },
                    regexp: {
                        regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                        message: '请输入正确的手机号码'
                    }
            	}
            },
            userEime:{
            	validators:{
            		notEmpty:{
            			message:"不能为空"
            		},emailAddress: {
                        message: '邮箱地址格式有误'
                    }
            	}
            }
        } 
    });
});
</script>
<script type="text/javascript">
$(function () {
	datepiceker();
});
function datepiceker(){
	$('#userBir').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: 'zh-CN',
        showClear: true,
    });
}
</script>
</html>
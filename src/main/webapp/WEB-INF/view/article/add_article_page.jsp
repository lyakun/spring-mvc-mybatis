<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章增加页面</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/kindeditor/plugins/code/prettify.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/kindeditor/themes/default/default.css">
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/moment-with-locales.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/plugins/code/prettify.js"></script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/article/addArticle.gang" method="post" id="addArticleForm">
	 <div class="form-group">
	    <label for="inputEmail3" class="col-sm-1 control-label">文章标题:</label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="articleName">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="articleCreateDateTime" class="col-sm-1 control-label">创建时间:</label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="articleCreateDateTime" id="articleCreateDateTime">
	    </div>
	</div>
	<div class="form-group">
	    <label for="founder" class="col-sm-1 control-label">创建人:</label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="founder">
	    </div>
	  </div>
	<div  class="col-sm-12">
		<textarea name="articleContext" cols="100" rows="8" style="width:1200px;height:200px;visibility:hidden;"></textarea>
	</div>
	 <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-primary">
		      	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
		      </button>
		      <button type="submit" class="btn btn-primary">
		      	<span class="glyphicon glyphicon-plus" aria-hidden="true" type="button" onclick="addDraft()"></span>保存到草稿
		      </button>
		      <button type="reset" class="btn btn-default">
		      	<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>重置
		      </button>
	        </div>
	 </div>
	</form>
</body>
<script type="text/javascript">
	function addDraft(){
		$.ajax({
			url:"<%=request.getContextPath()%>/article/articleDraft.gang",
			type:"post",
			dateType:"json",
			data:$("#addArticleForm").serialize(),
			success:function(data){
				location.href="<%=request.getContextPath()%>/article/getArticlePage.gang";
			},error:function(){
				alert("存为草稿失败");
			}
		})
	}
</script>
<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="articleContext"]', {
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
<script type="text/javascript">
$(function () {
	datepiceker();
});
function datepiceker(){
	$('#articleCreateDateTime').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: 'zh-CN',
        showClear: true,
    });
}
</script>
</html>
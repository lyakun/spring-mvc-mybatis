<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>${notice.noticeName}</title>
</head>
<body>
	<table>
		<tr align="center">
			<th></th>
			<th></th>
			<th>${notice.noticeName}</th>
			<th></th>
		</tr>
		<tr>
			<td>${notice.noticeContext}</td>
		</tr>
		<tr align="center">
			<td>
				<button id="btn_add" type="button" class="btn btn-primary" onclick="updateDesc()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>编辑
				</button>
				<button id="btn_delete" type="button" class="btn btn-warning" onclick="delDesc()">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function updateDesc(){
		location.href="<%=request.getContextPath()%>/notice/toupdateNotice.gang?noticeId=${notice.noticeId}";		
	}
</script>
</html>
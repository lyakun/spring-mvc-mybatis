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
</head>
<body>
	<table>
		<tr align="center">
			<th></th>
			<th></th>
			<th>${article.articleName}</th>
			<th></th>
		</tr>
		<tr>
			<td>${article.articleContext}</td>
		</tr>
		<tr align="center">
			<td>
				<button id="btn_add" type="button" class="btn btn-primary" onclick="updateArticle()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true">编辑</span>
				</button>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function updateArticle(){
		location.href="<%=request.getContextPath()%>/article/toupdateArticleById.gang?articleId=${article.articleId}";		
	}
</script>
</html>
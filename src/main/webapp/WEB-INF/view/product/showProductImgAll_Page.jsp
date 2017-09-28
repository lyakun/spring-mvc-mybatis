<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="l">
	 <div class="col-sm-6 col-md-4">
	    <div class="thumbnail">
		<img src="<%=request.getContextPath()%>/${l.imgUrl}" width="100px"/>      <div class="caption">
	        <p><button class="btn btn-primary" type="button" onclick="downFile('${l.imgId}')">下载</button><input name="img" type="checkbox" value="${l.imgId}"/></p>
	      </div>
	    </div>
  	 </div>
	</c:forEach>
	<button type="button" onclick="zipDown()" class="btn btn-primary">打包下载</button>
</body>
<script type="text/javascript">
	function zipDown(){
		var id="";
		$("input[name='img']:checked").each(function(){
			id+=","+$(this).val();
		})
		id=id.substr(1);
		location.href="<%=request.getContextPath()%>/product/downFileZip.gang?id="+id;
	}
	function downFile(id){
		location.href="<%=request.getContextPath()%>/product/downFileById.gang?id="+id;
	}
</script>
</html>
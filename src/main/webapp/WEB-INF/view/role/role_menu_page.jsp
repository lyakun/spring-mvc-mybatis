<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-treeview-master/src/js/bootstrap-treeview.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-treeview-master/src/css/bootstrap-treeview.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-addtabs/bootstrap.addtabs.min.js"></script>
<link href="<%=request.getContextPath()%>/static/js/bootstrap-3.3.7-dist/bootstrap-addtabs/bootstrap.addtabs.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div class='row'>
			<div id="tree"></div>                  				
	</div>
<input type="hidden" value="${userId}" id="userId"/>
</body>
<script type="text/javascript">
	function getTree() {
		var shu="";
		 $.ajax({
			 url:"<%=request.getContextPath()%>/menu/getTreeAllList.gang",
			 type:"post",
			 dateType:"json",
			 data:{"id":$("#userId").val()},
			 async:false,
			 success:function(data){
				 shu=JSON.stringify(data);
			 },error:function(){
				 alert("树获取错误");
			 }
		 })
		 return shu;
	}
	
	var nodeCheckedSilent = false;  
	function nodeChecked (event, node){  
	    if(nodeCheckedSilent){  
	        return;  
	    }  
	    nodeCheckedSilent = true;  
	    checkAllParent(node);  
	    checkAllSon(node);  
	    nodeCheckedSilent = false;  
	}  
	  
	var nodeUncheckedSilent = false;  
	function nodeUnchecked  (event, node){  
	    if(nodeUncheckedSilent)  
	        return;  
	    nodeUncheckedSilent = true;  
	    uncheckAllParent(node);  
	    uncheckAllSon(node);  
	    nodeUncheckedSilent = false;  
	}  
	function checkAllParent(node){  
	    $('#tree').treeview('checkNode',node.nodeId,{silent:true});  
	    var parentNode = $('#tree').treeview('getParent',node.nodeId);  
	    if(!("id" in parentNode)){  
	        return;  
	    }else{  
	        checkAllParent(parentNode);  
	    }  
	}  
	//取消全部父节点  
	function uncheckAllParent(node){  
	    $('#tree').treeview('uncheckNode',node.nodeId,{silent:true});  
	    var siblings = $('#tree').treeview('getSiblings', node.nodeId);  
	    var parentNode = $('#tree').treeview('getParent',node.nodeId);  
	    if(!("id" in parentNode)) {  
	        return;  
	    }  
	    var isAllUnchecked = true;  //是否全部没选中  
	    for(var i in siblings){  
	        if(siblings[i].state.checked){  
	            isAllUnchecked=false;  
	            break;  
	        }  
	    }  
	    if(isAllUnchecked){  
	        uncheckAllParent(parentNode);  
	    }  
	  
	}  

	//级联选中所有子节点  
	function checkAllSon(node){  
	    $('#tree').treeview('checkNode',node.nodeId,{silent:true});  
	    if(node.nodes!=null&&node.nodes.length>0){  
	        for(var i in node.nodes){  
	            checkAllSon(node.nodes[i]);  
	        }  
	    }  
	}  
	//级联取消所有子节点  
	function uncheckAllSon(node){  
	    $('#tree').treeview('uncheckNode',node.nodeId,{silent:true});  
	    if(node.nodes!=null&&node.nodes.length>0){  
	        for(var i in node.nodes){  
	            uncheckAllSon(node.nodes[i]);  
	        }  
	    }  
	}
	$('#tree').treeview({  
	    showCheckbox:true,  
	    data:getTree(),  
	    multiSelect: true,
	    onNodeChecked:nodeChecked ,  
	    onNodeUnchecked:nodeUnchecked  
	}); 
</script>
</html>
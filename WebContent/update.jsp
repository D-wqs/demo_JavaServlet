<%@page import="demo.pojo.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- 引入 Bootstrap -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="./jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="./bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-md-4 col-lg-4">
			
			</div>
			<%
				Message m=(Message)request.getAttribute("message");
			%>
			<div class="col-sm-4 col-md-4 col-lg-4 well">
				<form action="${pageContext.request.contextPath}/update.do">
					<input type="hidden" name="id" value="<%=m.getId()%>">
					 <div class="form-group">
					    <label for="name">名称</label>
					    <input type="text" class="form-control" name="info" value="<%=m.getInfo()%>">
					  </div>
					  <div class="form-group">
					    <label for="name">组号</label>
					    <input type="text" class="form-control" name="num" value="<%=m.getNum()%>">
					  </div>
					  <button type="submit" class="btn btn-default">提交</button>
				</form>
			</div>
			<div class="col-sm-4 col-md-4 col-lg-4">
				
			</div>
		</div>
	</div>
	
</body>
</html>
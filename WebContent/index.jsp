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
<hr>
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-3 col-lg-3 well">
			<a href="${pageContext.request.contextPath}/add.jsp">
			<button type="button" class="btn btn-default">增加</button>
			</a>
			<hr>
			<%
			//获取绑定在request中数据
			List<Message> list1=(List)request.getAttribute("list1");
			for(int i=0;i<list1.size();i++){																	
				Message m1 = list1.get(i);
			%>
			<ul class="list-group">
			    <li class="list-group-item">
				    <%=m1.getInfo() %>
				    <span style="color:red ; background-color:red" class="badge"><a href="${pageContext.request.contextPath}/delete.do?id=<%=m1.getId() %>">删除</a></span>
				    <span style="color:red;background-color:green" class="badge"><a href="${pageContext.request.contextPath}/load.do?id=<%=m1.getId() %>">修改</a></span>
			    </li>
			</ul>
			<%} %>
			</div>
			<div class="col-sm-1 col-md-1 col-lg-1"></div>
			<div class="col-sm-3 col-md-3 col-lg-3 well">
			<a href="${pageContext.request.contextPath}/add.jsp">
			<button type="button" class="btn btn-default">增加</button>
			</a>
			<hr>
			<%
			//获取绑定在request中数据
			List<Message> list2=(List)request.getAttribute("list2");
			for(int i=0;i<list2.size();i++){																	
				Message m2 = list2.get(i);
			%>
			<ul class="list-group">
			    <li class="list-group-item">
			    <%=m2.getInfo() %>
			    <span style="color:red ; background-color:red" class="badge"><a href="${pageContext.request.contextPath}/delete.do?id=<%=m2.getId() %>">删除</a></span>
				    <span style="color:red;background-color:green" class="badge"><a href="${pageContext.request.contextPath}/load.do?id=<%=m2.getId() %>">修改</a></span>
			    </li>
			</ul>
			<%} %>
			</div>
			<div class="col-sm-1 col-md-1 col-lg-1"></div>
			<div class="col-sm-3 col-md-3 col-lg-3 well">
			<a href="${pageContext.request.contextPath}/add.jsp">
			<button type="button" class="btn btn-default">增加</button>
			</a>
			<hr>
			<%
			//获取绑定在request中数据
			List<Message> list3=(List)request.getAttribute("list3");
			for(int i=0;i<list3.size();i++){																	
				Message m3 = list3.get(i);
			%>
			<ul class="list-group">
			    <li class="list-group-item">
			    <%=m3.getInfo() %>
			    <span style="color:red ; background-color:red" class="badge"><a href="${pageContext.request.contextPath}/delete.do?id=<%=m3.getId() %>">删除</a></span>
				    <span style="color:red;background-color:green" class="badge"><a href="${pageContext.request.contextPath}/load.do?id=<%=m3.getId() %>">修改</a></span>
			    </li>
			</ul>
			<%} %>
			</div>
		</div>
	</div>
	
</body>
</html>
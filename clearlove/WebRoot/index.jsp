<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
   <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="/n.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<body>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="/n.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	</body>
   <%--bootstrap 配置--%>
    <link rel="stylesheet" href="/n.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="/n.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="/n.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

</head>

  
  <body>
  <div class="container-fluid">
	<div class="row-fluid">
		<div class="span6">
		</div>
		<div class="span4">
			<form class="form-search form-inline">
				<input class="input-medium search-query" type="text" /> <button type="submit" class="btn">查找</button>
			</form>
		</div>
		<div class="span2">
			 <button class="btn" type="button">按钮</button>
		</div>
	</div>
</div>
    
  </body>
</html>

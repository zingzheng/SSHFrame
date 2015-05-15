<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登山包</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1 align="center"><s:text name="welcome" /></h1>
    
    <center> 
    	<s:actionerror/>
        <s:form action="login" namespace="/" method="post">
        	<s:token></s:token>
    		<s:textfield name="user.username" key="username"></s:textfield>
    		<s:password name="user.pwd" key="password"></s:password>
    		<s:submit key="submit"></s:submit>
    	</s:form>
    	 <s:a href="r_gotoRegist"><s:text name="regist" /></s:a>
    </center>
     
  </body>
</html>

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
    
    <title><s:text name="regist" /></title>
    
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
     <h1 align="center"><s:text name="regist" /></h1>
    
    <center> 
    	<s:actionerror/>
        <s:form action="regist" namespace="/" method="post">
        	<s:token></s:token>
    		<s:textfield name="user.username" key="username"></s:textfield>
    		<s:password name="user.pwd" key="password"></s:password>
    		<s:password name="repwd" key="repwd"></s:password>
    		<s:textfield name="user.realname" key="realname"></s:textfield>
    		<s:textfield name="user.grade" key="grade"></s:textfield>
    		<s:textfield name="user.invitaCode" key="invitaCode"></s:textfield>
    		<s:submit key="regist"></s:submit>
    	</s:form>
    	 <s:a href="r_gotoLogin"><s:text name="back" /></s:a>
    </center>
  </body>
</html>

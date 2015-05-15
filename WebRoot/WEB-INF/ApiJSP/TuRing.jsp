<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="../CommonJSP/CommonHead.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>图灵机器人</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body onload="textarea1.scrollTop=textarea1.scrollHeight">
  <center>
  	<s:form action="turing" namespace="/" method="post">
  		<s:textarea name="msgSend" id="textarea1" readonly="true" cols="40" rows="20" ></s:textarea>
  		<s:textarea name="msgReceive" cols="40" rows="5"></s:textarea>
    	<s:submit value="提交"></s:submit>
  	</s:form>
  	
  	<br/><br/><br/>
    <s:a href="redirect_gotoMain">>>主页</s:a>
    </center>
  </center>		
  </body>
</html>

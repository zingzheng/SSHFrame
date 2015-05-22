<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="../CommonJSP/CommonHead.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改文件</title>
    
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
    <h1 align="center">修改文件</h1>
    
    
    	
    <center>
    	<s:actionmessage/>
    	<s:actionerror/>
    	<s:form action="updateFile" namespace="/" method="post">
    		<s:token></s:token>
    		<s:hidden name="fileInfo.id" value="%{fileInfo.id}"></s:hidden>
    		<s:textfield name="fileInfo.fileName" label="文件名" value="%{fileInfo.fileName}" ></s:textfield>
    		<s:select name="fileInfo.grade" list="#{'0':'共享','1':'私有'}" label="属性" headerKey="%{fileInfo.grade}"></s:select>
    		<s:submit key="submit"></s:submit>
    	
    	</s:form>
    
    
   
    
    <br/><br/><br/>
    <s:if test="#session.userSession.grade==0">
    <s:a href="listAllFile.action">>>管理全部文件</s:a>
    </s:if>
    
    <br/><br/><br/>
    <s:a href="listFile.action">>>我的网盘</s:a>
    
    <br/><br/><br/>
    <s:a href="redirect_gotoMain">>>主页</s:a>
    
    </center>
    
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../CommonJSP/CommonHead.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>文件管理</title>
    
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
    <h1 align="center">文件管理</h1>
    
    
    	<s:actionerror/>
    <center>
    <table>
    	<tr>
    		<td>id</td>
    		<td>文件名</td>
    		<td>上传时间</td>
    		<td>下载次数</td>
    		<td>属性</td>
    		<td>上传者</td>
    		<td>下载</td>
    		<td>修改</td>
    		<td>删除</td>
    	</tr>
    	
    	<s:iterator value="#request.files" id="file">
    	<tr>
    		<td><s:property value="#file.id"/></td>
    		<td><s:property value="#file.fileName"/></td>
    		<td><s:property value="#file.uploadDate"/></td>
    		<td><s:property value="#file.downloadTimes"/></td>
    		<td>
    			<s:if test="#file.grade==1">私有</s:if>
    			<s:if test="#file.grade==0">公开</s:if>
    		</td>
    		<td><s:property value="#file.userInfo.username"/></td>
    		<td><s:a href="downloadFile.action?fileInfo.id=%{#file.id}">下载</s:a></td>
    		<td><s:a href="updateFilePre.action?fileInfo.id=%{#file.id}">修改</s:a></td>
    		<td><s:a href="delFile.action?fileInfo.id=%{#file.id}&flag=1">删除</s:a></td>
    	</tr>
    	
    	
    	</s:iterator>
    </table>
    <br/><br/>
   
  	
    <s:text name="page"></s:text>:
    <s:property value="%{page.pageCurrent}"/>/<s:property value="%{page.pageSum}"/>
   	<br/>
   	
   	<s:if test="%{page.PageCurrent!=1}">
   		<a href="listAllFile.action?page.pageGoto=${page.pageCurrent-1}">
			<s:text name="prepage"/>
		</a>
   	</s:if>
   	
    <c:forEach begin="1" end="${page.pageSum}" var="i">
   		<c:if test="${page.pageCurrent==i}">
			[${i}]
   		</c:if>
   		<c:if test="${page.pageCurrent!=i}">
			<a href="listAllFile.action?page.pageGoto=${i}">[${i}]</a>
   		</c:if>    	
    </c:forEach>
    
     <s:if test="%{page.PageCurrent!=page.pageSum}">
   		<a href="listAllFile.action?page.pageGoto=${page.pageCurrent+1}">
   			<s:text name="nextpage"/>
   		</a>
   	</s:if>
   	
   	
   	<br/><br/><br/>
    <s:a href="listFile">>>返回我的网盘</s:a>
    
   	
    <br/><br/><br/>
    <s:a href="redirect_gotoMain">>>主页</s:a>
    </center>
     
  </body>
</html>

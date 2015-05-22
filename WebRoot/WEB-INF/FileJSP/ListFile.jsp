<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../CommonJSP/CommonHead.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>我的网盘</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	function addMore()
	{
		var td = document.getElementById("more");
    	var br = document.createElement("br");
   		var input = document.createElement("input");
   		var select = document.createElement("select");
    	var button = document.createElement("input");
    
    	input.type = "file";
    	input.name="file";
    	
    	var d = [{t:"共享",v:"0"},{t:"私有",v:"1"}];
    	select.name="grade";
    	for(var i in d){
    		var option = new Option(d[i].t,d[i].v);
    		select.options.add(option);
    	}
    	
    	button.type="button";
    	button.value="取消添加";
    	
    	button.onclick = function()
    	{
        	td.removeChild(br);
        	td.removeChild(input);
        	td.removeChild(select);
        	td.removeChild(button);
        }
    
    	td.appendChild(br);
    	td.appendChild(input);
    	td.appendChild(select);
    	td.appendChild(button);
	}	
	</script>
	
	
	
  </head>
  
<body>
    <h1 align="center">我的网盘</h1>
    
    
    	<s:actionerror/>
    <center>
    <table>
    	<tr>
    		<td>id</td>
    		<td>文件名</td>
    		<td>上传时间</td>
    		<td>下载次数</td>
    		<td>属性</td>
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
    			<s:if test="#file.grade==0">共享</s:if>
    		</td>
    		<td><s:a href="downloadFile.action?fileInfo.id=%{#file.id}">下载</s:a></td>
    		<td><s:a href="updateFilePre.action?fileInfo.id=%{#file.id}">修改</s:a></td>
    		<td><s:a href="delFile.action?fileInfo.id=%{#file.id}">删除</s:a></td>
    	</tr>
    	
    	
    	</s:iterator>
    </table>
    <br/><br/>
   
  	
    <s:text name="page"></s:text>:
    <s:property value="%{page.pageCurrent}"/>/<s:property value="%{page.pageSum}"/>
   	<br/>
   	
   	<s:if test="%{page.PageCurrent!=1}">
   		<a href="listFile.action?page.pageGoto=${page.pageCurrent-1}">
			<s:text name="prepage"/>
		</a>
   	</s:if>
   	
    <c:forEach begin="1" end="${page.pageSum}" var="i">
   		<c:if test="${page.pageCurrent==i}">
			[${i}]
   		</c:if>
   		<c:if test="${page.pageCurrent!=i}">
			<a href="listFile.action?page.pageGoto=${i}">[${i}]</a>
   		</c:if>    	
    </c:forEach>
    
     <s:if test="%{page.PageCurrent!=page.pageSum}">
   		<a href="listFile.action?page.pageGoto=${page.pageCurrent+1}">
   			<s:text name="nextpage"/>
   		</a>
   	</s:if>
   	
   	<br/><br/>
   	<s:form action="uploadFile" namespace="/" method="post" enctype="multipart/form-data" theme="simple">
   		<table border="1">
   		<tr>
   			<td>
   				上传文件: 
   			</td>
   			
   			<td id="more">	
   				<s:file name="file"/><select name="grade">
   					<option value="0">共享</option>
   					<option value="1">私有</option>
   				</select><input type="button" value="继续添加" onclick="addMore()" />
   			</td>
   			
   		</tr>
   		</table>
   		<s:submit value="提交"></s:submit>
   	
   	</s:form>
   	
   	
   	<br/><br/><br/>
    <s:a href="listPublicFile">>>更多共享资源</s:a>
    
    <s:if test="#session.userSession.grade==0">
    <br/><br/><br/>
    <s:a href="listAllFile">>>管理全部文件</s:a>
   	</s:if>
   	
    <br/><br/><br/>
    <s:a href="redirect_gotoMain">>>主页</s:a>
    </center>
     
  </body>
</html>
